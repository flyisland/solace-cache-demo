package com.solace.demo.smf.cacheclient;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Conf {
	@Parameter(names = "--help", help = true, description = "Show usage information")
	private boolean help;

	@Parameter(names = "-h", description = "HOST[:PORT], Appliance IP address [:port, omit for default]", required = true, order = 0)
	public String host;

	@Parameter(names = "-u", description = "user[@vpn]  Client username and optionally VPN name", order = 20)
	public String user = "default";
	public String vpn = "default";

	@Parameter(names = "-w", description = "Authentication password", order = 21)
	public String pwd = "default";

	@Parameter(names = "-t", description = "Topic to subscribe", required = true, order = 30)
	public String topic;

	public void parse(String[] args) {
		JCommander jc = JCommander.newBuilder().addObject(this).build();
		try {
			jc.parse(args);

			if (help) {
				jc.usage();
				System.exit(0);
			}

			String[] uv = user.split("@");
			user = uv[0];
			if (uv.length > 1) {
				vpn = uv[1];
			}

		} catch (ParameterException e) {
			e.printStackTrace();
			jc.usage();
			System.exit(-1);
		}
	}
}
