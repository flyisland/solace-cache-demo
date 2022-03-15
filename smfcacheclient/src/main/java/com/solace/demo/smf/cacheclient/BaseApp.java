package com.solace.demo.smf.cacheclient;

import com.solacesystems.jcsmp.JCSMPProperties;
import com.solacesystems.jcsmp.JCSMPSession;

public abstract class BaseApp {
	protected JCSMPSession session = null;
	protected Conf conf = new Conf();

	protected JCSMPProperties buildJSCMPProperties() {
		JCSMPProperties properties = new JCSMPProperties();
		properties.setProperty(JCSMPProperties.HOST, conf.host);
		properties.setProperty(JCSMPProperties.VPN_NAME, conf.vpn);
		properties.setProperty(JCSMPProperties.USERNAME, conf.user);
		properties.setProperty(JCSMPProperties.PASSWORD, conf.pwd);

		return properties;
	}
}
