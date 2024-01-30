/**
 * Copyright (2024, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.models.vms;

import io.github.kubestack.client.api.specs.vms.VirtualMachineGPUSpec;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.1.0
 * @since   2024.01.30
 * 
 **/
public class VirtualMachineGPU extends VirtualMachineModel {

	protected VirtualMachineGPUSpec spec;

	public VirtualMachineGPUSpec getSpec() {
		return spec;
	}

	public void setSpec(VirtualMachineGPUSpec spec) {
		this.spec = spec;
	}
	
}
