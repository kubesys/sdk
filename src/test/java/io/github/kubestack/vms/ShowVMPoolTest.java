/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ShowVMPoolTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachinePools()
				.showPool("88145631c61a4a64ac5f08b33942d396", getPool(), "123");
		System.out.println(successful);
	}

	protected static Lifecycle.ShowPool getPool() {
		Lifecycle.ShowPool showPool = new Lifecycle.ShowPool();
		showPool.setType("nfs");
		return showPool;
	}
	
}
