/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_005_VM_GetByName_GetHostIPTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		String nodeName = client.virtualMachines().get("dockerhub2").getMetadata().getLabels().get("host");
		System.out.println(client.nodes().get(nodeName).getMetadata().getAnnotations().get("THISIP"));
	}
	
}
