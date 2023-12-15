/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class PlugNicTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.plugNIC("cloudinit1", getPlugNICL2bridge());
//				.plugDisk("vm003", getPlugCdrom());
		System.out.println(successful);
	}
	
	public static Lifecycle.PlugNIC getPlugNICL3bridge() {
		Lifecycle.PlugNIC plugNic = new Lifecycle.PlugNIC();
		plugNic.setSource("source=br-int,ip=192.168.5.2,switch=switch22");
		plugNic.setType("l3bridge");
//		plugNic.setMac("7e:0c:b0:ef:6a:04");
		plugNic.setLive(true);
		plugNic.setConfig(true);
		return plugNic;
	}

	public static Lifecycle.PlugNIC getPlugNICL2bridge() {
		Lifecycle.PlugNIC plugNic = new Lifecycle.PlugNIC();
		plugNic.setSource("source=br-bond1");
		plugNic.setType("l2bridge");
		plugNic.setVlan("176");
//		plugNic.setMac("7e:0c:b0:ef:6a:04");
		plugNic.setLive(true);
		plugNic.setConfig(true);
		return plugNic;
	}

	public static Lifecycle.PlugNIC getPlugNICbridge() {
		Lifecycle.PlugNIC plugNic = new Lifecycle.PlugNIC();
		plugNic.setSource("source=virbr0");
		plugNic.setType("bridge");
//		plugNic.setMac("7e:0c:b0:ef:6a:04");
		plugNic.setLive(true);
		plugNic.setConfig(true);
		return plugNic;
	}
	
}
