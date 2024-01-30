/*
 * Copyright (2024, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineGPU;


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
		for (VirtualMachineGPU vmgpu: client.virtualMachineGPUs().list()) {
			System.out.println(vmgpu.getMetadata().getName() + ", " + vmgpu.getSpec().getGpu().getType()+
					", " + vmgpu.getSpec().getGpu().getId() + ", " + vmgpu.getSpec().getGpu().getInUse() +
					", " + vmgpu.getSpec().getGpu().getUseMode() + ", " + vmgpu.getSpec().getGpu().getKernelDriverInUse() +
					", " + vmgpu.getSpec().getNodeName() + ", " + vmgpu.getSpec().getGpu().getKernelModules());
		}
	}
	
}
