/*
 * Copyright (2024, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;


/**
 * @author wuheng@iscas.ac.cn
 * @since  2024/01/30
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_026_VMGPU_ListAllTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		System.out.println(client.virtualMachineGPUs().list());
	}
	
}
