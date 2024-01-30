/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.impl.vms;


import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineGPU;
import io.github.kubestack.client.api.specs.vms.VirtualMachineGPUSpec;
import io.github.kubestack.client.api.specs.vms.virtualmachinegpu.Lifecycle;
import io.github.kubestack.client.impl.AbstractImpl;


/**
 * @author  wuheng@iscas.ac.cn
 * 
 * @version 2.1.0
 * @since   2024.01.30
 **/

public class VirtualMachineGPUImpl extends AbstractImpl<VirtualMachineGPU, VirtualMachineGPUSpec> {

	public VirtualMachineGPUImpl(KubeStackClient client, String kind) {
		super(client, kind);
	}

	@Override
	protected Class<?> getModelClass() {
		return VirtualMachineGPU.class;
	}

	@Override
	protected VirtualMachineGPU getModel() {
		return new VirtualMachineGPU();
	}

	@Override
	protected VirtualMachineGPUSpec getSpec() {
		return new VirtualMachineGPUSpec();
	}

	@Override
	protected Object getLifecycle() {
		return new Lifecycle();
	}


}
