package com.solace.demo.smf.cacheclient;

import java.util.concurrent.CountDownLatch;

import com.solacesystems.jcsmp.CacheLiveDataAction;
import com.solacesystems.jcsmp.CacheRequestResult;
import com.solacesystems.jcsmp.CacheSession;
import com.solacesystems.jcsmp.CacheSessionProperties;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPFactory;
import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPStreamingPublishCorrelatingEventHandler;
import com.solacesystems.jcsmp.Topic;
import com.solacesystems.jcsmp.XMLMessageConsumer;
import com.solacesystems.jcsmp.XMLMessageProducer;
import com.solacesystems.jcsmp.statistics.StatType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends BaseApp {
    protected static final Logger logger = LoggerFactory.getLogger(App.class);
    CacheSession cacheSession = null;
    XMLMessageProducer prod = null;
    XMLMessageConsumer cons = null;
    private CountDownLatch latch = new CountDownLatch(1);

    public class PubCallback implements JCSMPStreamingPublishCorrelatingEventHandler {
        @Override
        public void handleErrorEx(Object messageID, JCSMPException cause, long timestamp) {
            logger.error("Error occurred for message: " + messageID);
            cause.printStackTrace();
        }

        @Override
        public void responseReceivedEx(Object messageID) {
            // Not Called - only errors are reported.
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run(args);
    }

    private void run(String[] args) {

        conf.parse(args);
        JCSMPProperties properties = buildJSCMPProperties();

        try {
            session = JCSMPFactory.onlyInstance().createSession(properties);
            session.connect();

            prod = session.getMessageProducer(new PubCallback());
            cons = session.getMessageConsumer(new PrintingMessageHandler());
            cons.start();
            Topic topic = JCSMPFactory.onlyInstance().createTopic(conf.topic);

            // https://docs.solace.com/API-Developer-Online-Ref-Documentation/java/com/solacesystems/jcsmp/CacheSessionProperties.html
            CacheSessionProperties cacheProps = new CacheSessionProperties("DemoCache", 1, 0, 10000);
            cacheSession = session.createCacheSession(cacheProps);

            // Perform the cache request.
            // https://docs.solace.com/API-Developer-Online-Ref-Documentation/java/com/solacesystems/jcsmp/CacheSession.html#sendCacheRequest-java.lang.Long-com.solacesystems.jcsmp.Topic-boolean-com.solacesystems.jcsmp.CacheLiveDataAction-
            CacheRequestResult result = cacheSession.sendCacheRequest(1L, topic, true, CacheLiveDataAction.FLOW_THRU);
            logger.info("Cache Request=" + result + ", Cached Messages Received=" +
                    session.getSessionStats().getStat(StatType.CACHED_MSGS_RECVED));
            latch.await();
        } catch (JCSMPException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                logger.debug("close Session");
                session.closeSession();
            }
        }
    }
}
