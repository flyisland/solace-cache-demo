package com.solace.demo.smf.cacheclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPFactory;
import com.solacesystems.jcsmp.JCSMPException;

public class App extends BaseApp {
    protected static final Logger logger = LoggerFactory.getLogger(App.class);

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
        } catch (JCSMPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (session != null) {
                logger.debug("close Session");
                session.closeSession();
            }
        }
    }
}
