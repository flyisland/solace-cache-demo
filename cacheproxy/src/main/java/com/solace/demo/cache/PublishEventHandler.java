package com.solace.demo.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPStreamingPublishCorrelatingEventHandler;

public class PublishEventHandler implements JCSMPStreamingPublishCorrelatingEventHandler {
    @Override
    public void handleErrorEx(Object messageID, JCSMPException cause, long timestamp) {
        System.out.println("Error occurred for message: " + messageID);
        cause.printStackTrace();
    }

    @Override
    public void responseReceivedEx(Object messageID) {
        // Not Called - only errors are reported.
    }
}