/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.impl.vms;

import java.util.regex.Pattern;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineNetwork;
import io.github.kubestack.client.api.specs.vms.VirtualMachineNetworkSpec;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.BindPortVlan;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.CreateAddress;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.CreateBridge;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.CreateSwitch;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.DelBridgeVlan;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.DeleteAddress;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.DeleteBridge;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.DeleteSwitch;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.ModifyAddress;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.ModifySwitch;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.SetBridgeVlan;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.UnbindPortVlan;
import io.github.kubestack.client.impl.AbstractImpl;
import io.github.kubestack.core.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
@SuppressWarnings("deprecation")
public class VirtualMachineNetworkImpl extends AbstractImpl<VirtualMachineNetwork, VirtualMachineNetworkSpec> {

	public VirtualMachineNetworkImpl(KubeStackClient client, String kind) {
		super(client, kind);
	}

	@Override
	public VirtualMachineNetwork getModel() {
		return new VirtualMachineNetwork();
	}

	@Override
	public VirtualMachineNetworkSpec getSpec() {
		return new VirtualMachineNetworkSpec();
	}
	
	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	
	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/

	public boolean createBridge(String name, CreateBridge createBridge) throws Exception {
		return createBridge(name, null, createBridge, null);
	}

	public boolean createBridge(String name, String nodeName, CreateBridge createBridge) throws Exception {
		return createBridge(name, nodeName, createBridge, null);
	}

	public boolean createBridge(String name, CreateBridge createBridge, String eventId) throws Exception {
		return createBridge(name, null, createBridge, eventId);
	}

	public boolean createBridge(String name, String nodeName,CreateBridge createBridge, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createBridge)));
	}

	public boolean deleteBridge(String name, DeleteBridge deleteBridge) throws Exception {
		return deleteBridge(name, deleteBridge, null);
	}

	public boolean deleteBridge(String name, DeleteBridge deleteBridge, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteBridge);
	}

	public boolean deleteBridge(String name, String nodeName, DeleteBridge deleteBridge) throws Exception {
		updateHost(name, nodeName);
		return deleteBridge(name, deleteBridge, null);
	}

	public boolean deleteBridge(String name, String nodeName, DeleteBridge deleteBridge, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteBridge(name, deleteBridge, eventId);
	}

	public boolean setBridgeVlan(String name, SetBridgeVlan setBridgeVlan) throws Exception {
		return setBridgeVlan(name, setBridgeVlan, null);
	}

	public boolean setBridgeVlan(String name, SetBridgeVlan setBridgeVlan, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), setBridgeVlan);
	}

	public boolean setBridgeVlan(String name, String nodeName, SetBridgeVlan setBridgeVlan) throws Exception {
		updateHost(name, nodeName);
		return setBridgeVlan(name, setBridgeVlan, null);
	}

	public boolean setBridgeVlan(String name, String nodeName, SetBridgeVlan setBridgeVlan, String eventId) throws Exception {
		updateHost(name, nodeName);
		return setBridgeVlan(name, setBridgeVlan, eventId);
	}

	public boolean delBridgeVlan(String name, DelBridgeVlan delBridgeVlan) throws Exception {
		return delBridgeVlan(name, delBridgeVlan, null);
	}

	public boolean delBridgeVlan(String name, DelBridgeVlan delBridgeVlan, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), delBridgeVlan);
	}

	public boolean delBridgeVlan(String name, String nodeName, DelBridgeVlan delBridgeVlan) throws Exception {
		updateHost(name, nodeName);
		return delBridgeVlan(name, delBridgeVlan, null);
	}

	public boolean delBridgeVlan(String name, String nodeName, DelBridgeVlan delBridgeVlan, String eventId) throws Exception {
		updateHost(name, nodeName);
		return delBridgeVlan(name, delBridgeVlan, eventId);
	}

	public boolean bindPortVlan(String name, BindPortVlan bindPortVlan) throws Exception {
		return bindPortVlan(name, bindPortVlan, null);
	}

	public boolean bindPortVlan(String name, BindPortVlan bindPortVlan, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), bindPortVlan);
	}

	public boolean bindPortVlan(String name, String nodeName, BindPortVlan bindPortVlan) throws Exception {
		updateHost(name, nodeName);
		return bindPortVlan(name, bindPortVlan, null);
	}

	public boolean bindPortVlan(String name, String nodeName, BindPortVlan bindPortVlan, String eventId) throws Exception {
		updateHost(name, nodeName);
		return bindPortVlan(name, bindPortVlan, eventId);
	}

	public boolean unbindPortVlan(String name, UnbindPortVlan unbindPortVlan) throws Exception {
		return unbindPortVlan(name, unbindPortVlan, null);
	}

	public boolean unbindPortVlan(String name, UnbindPortVlan unbindPortVlan, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unbindPortVlan);
	}

	public boolean unbindPortVlan(String name, String nodeName, UnbindPortVlan unbindPortVlan) throws Exception {
		updateHost(name, nodeName);
		return unbindPortVlan(name, unbindPortVlan, null);
	}

	public boolean unbindPortVlan(String name, String nodeName, UnbindPortVlan unbindPortVlan, String eventId) throws Exception {
		updateHost(name, nodeName);
		return unbindPortVlan(name, unbindPortVlan, eventId);
	}

	public boolean createSwitch(String name, CreateSwitch createSwitch) throws Exception {
		return createSwitch(name, null, createSwitch, null);
	}

	public boolean createSwitch(String name, String nodeName, CreateSwitch createSwitch) throws Exception {
		return createSwitch(name, nodeName, createSwitch, null);
	}

	public boolean createSwitch(String name, CreateSwitch createSwitch, String eventId) throws Exception {
		return createSwitch(name, null, createSwitch, eventId);
	}

	public boolean createSwitch(String name, String nodeName,CreateSwitch createSwitch, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createSwitch)));
	}

	public boolean deleteSwitch(String name, DeleteSwitch deleteSwitch) throws Exception {
		return deleteSwitch(name, deleteSwitch, null);
	}

	public boolean deleteSwitch(String name, DeleteSwitch deleteSwitch, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteSwitch);
	}

	public boolean deleteSwitch(String name, String nodeName, DeleteSwitch deleteSwitch) throws Exception {
		updateHost(name, nodeName);
		return deleteSwitch(name, deleteSwitch, null);
	}

	public boolean deleteSwitch(String name, String nodeName, DeleteSwitch deleteSwitch, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteSwitch(name, deleteSwitch, eventId);
	}

	public boolean modifySwitch(String name, ModifySwitch modifySwitch) throws Exception {
		return modifySwitch(name, modifySwitch, null);
	}

	public boolean modifySwitch(String name, ModifySwitch modifySwitch, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), modifySwitch);
	}

	public boolean modifySwitch(String name, String nodeName, ModifySwitch modifySwitch) throws Exception {
		updateHost(name, nodeName);
		return modifySwitch(name, modifySwitch, null);
	}

	public boolean modifySwitch(String name, String nodeName, ModifySwitch modifySwitch, String eventId) throws Exception {
		updateHost(name, nodeName);
		return modifySwitch(name, modifySwitch, eventId);
	}

	public boolean createAddress(String name, CreateAddress createAddress) throws Exception {
		return createAddress(name, null, createAddress, null);
	}

	public boolean createAddress(String name, String nodeName, CreateAddress createAddress) throws Exception {
		return createAddress(name, nodeName, createAddress, null);
	}

	public boolean createAddress(String name, CreateAddress createAddress, String eventId) throws Exception {
		return createAddress(name, null, createAddress, eventId);
	}

	public boolean createAddress(String name, String nodeName,CreateAddress createAddress, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAddress)));
	}

	public boolean deleteAddress(String name, DeleteAddress deleteAddress) throws Exception {
		return deleteAddress(name, deleteAddress, null);
	}

	public boolean deleteAddress(String name, DeleteAddress deleteAddress, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteAddress);
	}

	public boolean deleteAddress(String name, String nodeName, DeleteAddress deleteAddress) throws Exception {
		updateHost(name, nodeName);
		return deleteAddress(name, deleteAddress, null);
	}

	public boolean deleteAddress(String name, String nodeName, DeleteAddress deleteAddress, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteAddress(name, deleteAddress, eventId);
	}

	public boolean modifyAddress(String name, ModifyAddress modifyAddress) throws Exception {
		return modifyAddress(name, modifyAddress, null);
	}

	public boolean modifyAddress(String name, ModifyAddress modifyAddress, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), modifyAddress);
	}

	public boolean modifyAddress(String name, String nodeName, ModifyAddress modifyAddress) throws Exception {
		updateHost(name, nodeName);
		return modifyAddress(name, modifyAddress, null);
	}

	public boolean modifyAddress(String name, String nodeName, ModifyAddress modifyAddress, String eventId) throws Exception {
		updateHost(name, nodeName);
		return modifyAddress(name, modifyAddress, eventId);
	}

	@Override
	protected Class<?> getModelClass() {
		return VirtualMachineNetwork.class;
	}

}
