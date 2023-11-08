/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.ChangeNumberOfCPU;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ChangeNumberOfCPUTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.changeNumberOfCPU("centos", get());
//				.plugDisk("vm003", getPlugCdrom());
		System.out.println(successful);
	}
	
	public static ChangeNumberOfCPU get() {
		ChangeNumberOfCPU cpu = new ChangeNumberOfCPU();
		cpu.setCount("6");
		cpu.setLive(false);
		cpu.setConfig(true);
		cpu.setMaximum(true);
		cpu.setCores("6");
		cpu.setThreads("1");
		cpu.setSockets("1");
		return cpu;
	}
}
