/**
 * Copyright (2024, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs.vms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.kubestack.client.api.specs.KubeStackSpec;
import io.github.kubestack.client.api.specs.vms.virtualmachinegpu.GPU;
import io.github.kubestack.client.api.specs.vms.virtualmachinegpu.Lifecycle;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.1.0
 * @since   2024.01.30
 *
 * <p>
 * <code>ExtendedKubernetesClient<code> extends <code>DefaultKubernetesClient<code>
 * to provide the lifecycle of VirtualMachine, VirtualMachinePool, VirtualMachineDisk,
 * VirtualMachineImage, VirtualMachineSnapshot, VirtualMachineNetwork
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VirtualMachineGPUSpec extends KubeStackSpec {

	protected GPU gpu;

	protected Lifecycle lifecycle;

	public VirtualMachineGPUSpec() {

	}

	public GPU getGpu() {
		return gpu;
	}

	public void setGpu(GPU gpu) {
		this.gpu = gpu;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}
}
