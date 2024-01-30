/**
 * Copyright (2024, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs.vms.virtualmachinegpu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.kubestack.core.annotations.ClassDescriber;
import io.github.kubestack.core.annotations.FunctionDescriber;
import io.github.kubestack.core.annotations.ParameterDescriber;
import io.github.kubestack.core.utils.AnnotationUtils;
import io.github.kubestack.core.utils.RegExpUtils;

import javax.validation.constraints.Pattern;

/**
 * @author  wuheng@iscas.ac.cn
 * 
 * @version 2.1.0
 * @since   2024.01.30
 * 
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ClassDescriber(value = "VirtualMachineSnapshot", desc = "虚拟机/云盘快照")
public class GPU {

	protected String id;

	protected String type;

	protected String subsystem;

	protected String flags;

	protected String capabilities;

	protected String kernelDriverInUse;

	protected String kernelModules;

	protected String inUse;

	protected String useMode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(String capabilities) {
		this.capabilities = capabilities;
	}

	public String getKernelDriverInUse() {
		return kernelDriverInUse;
	}

	public void setKernelDriverInUse(String kernelDriverInUse) {
		this.kernelDriverInUse = kernelDriverInUse;
	}

	public String getKernelModules() {
		return kernelModules;
	}

	public void setKernelModules(String kernelModules) {
		this.kernelModules = kernelModules;
	}

	public String getInUse() {
		return inUse;
	}

	public void setInUse(String inUse) {
		this.inUse = inUse;
	}

	public String getUseMode() {
		return useMode;
	}

	public void setUseMode(String useMode) {
		this.useMode = useMode;
	}
}
