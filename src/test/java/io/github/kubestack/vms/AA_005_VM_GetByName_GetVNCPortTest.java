/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import java.util.ArrayList;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Domain.Devices.Graphics;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_005_VM_GetByName_GetVNCPortTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		ArrayList<Graphics> graphicsArray = client.virtualMachines().get("dockerhub2").getSpec().getDomain().getDevices().getGraphics();
		String port = "-1";
		for (int i=0;i<graphicsArray.size();i++) {
			Graphics g = graphicsArray.get(i);
			if (g.get_type().equals("vnc")) {
				port = g.get_port();
			}
			else {
				continue;
			}
		}
		
		System.out.println(port);
	}
	
}
