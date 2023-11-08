/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.SetBridgeVlan;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_023_VMNetwork_ModifyVlanTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineNetworks()
				.setBridgeVlan("switch22", get());
		System.out.println(successful);
	}

	public static SetBridgeVlan get() throws Exception {
		SetBridgeVlan set = new SetBridgeVlan();
		set.setName("br-native");
		set.setVlan("22");
		return set;
	}
}
