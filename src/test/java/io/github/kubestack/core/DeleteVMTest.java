/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.core;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.DeleteVM;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class DeleteVMTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.deleteVM("650646e8c17a49d0b83c1c797811e085", 
						new DeleteVM(), "eventid-delete");
		System.out.println(successful);
	}
	
}
