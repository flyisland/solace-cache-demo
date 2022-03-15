package com.solace.demo.smf.cacheclient;

import com.solacesystems.common.config.Version;
import com.solacesystems.jcsmp.BytesXMLMessage;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPRuntime;
import com.solacesystems.jcsmp.JCSMPSession;
import com.solacesystems.jcsmp.SessionEventArgs;
import com.solacesystems.jcsmp.SessionEventHandler;
import com.solacesystems.jcsmp.XMLMessageListener;

public abstract class BaseApp {
	protected JCSMPSession session = null;
	protected Conf conf = new Conf();

	public BaseApp() {
		Version v = JCSMPRuntime.onlyInstance().getVersion();
		System.out.printf("JCSMP %s\n", v.getSwVersion());
		System.out.println("===================================================");
	}

	protected JCSMPProperties buildJSCMPProperties() {
		JCSMPProperties properties = new JCSMPProperties();
		properties.setProperty(JCSMPProperties.HOST, conf.host);
		properties.setProperty(JCSMPProperties.VPN_NAME, conf.vpn);
		properties.setProperty(JCSMPProperties.USERNAME, conf.user);
		properties.setProperty(JCSMPProperties.PASSWORD, conf.pwd);

		return properties;
	}

	protected void printRxMessage(BytesXMLMessage msg) {
		System.out.printf(msg.dump());
	}

	protected class PrintingMessageHandler implements XMLMessageListener {
		public PrintingMessageHandler() {
		}

		public void onException(JCSMPException exception) {
			System.err.println("Error occurred, printout follows.");
			exception.printStackTrace();
		}

		public void onReceive(BytesXMLMessage msg) {
			printRxMessage(msg);
		}
	}

	public class PrintingSessionEventHandler implements SessionEventHandler {
		public void handleEvent(SessionEventArgs event) {
			System.out.printf("Received Session Event %s with info %s\n", event.getEvent(), event.getInfo());
		}
	}
}
