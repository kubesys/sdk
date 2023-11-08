/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.impl.vms;

import java.util.regex.Pattern;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineDiskImage;
import io.github.kubestack.client.api.specs.vms.VirtualMachineDiskImageSpec;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle.CreateDiskImage;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle.CreateDiskImageFromDisk;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle.DeleteDiskImage;
import io.github.kubestack.client.impl.AbstractImpl;
import io.github.kubestack.core.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022/10/22
 **/
public class VirtualMachineDiskImageImpl extends AbstractImpl<VirtualMachineDiskImage, VirtualMachineDiskImageSpec> {


	public VirtualMachineDiskImageImpl(KubeStackClient client, String kind) {
		super(client, kind);
	}

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	@Override
	public VirtualMachineDiskImage getModel() {
		return new VirtualMachineDiskImage();
	}

	@Override
	public VirtualMachineDiskImageSpec getSpec() {
		return new VirtualMachineDiskImageSpec();
	}


	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/

	public boolean createDiskImageFromDisk(String name, CreateDiskImageFromDisk createDiskImageFromDisk) throws Exception {
		return createDiskImageFromDisk(name, null, createDiskImageFromDisk, null);
	}

	public boolean createDiskImageFromDisk(String name, String nodeName, CreateDiskImageFromDisk createDiskImageFromDisk) throws Exception {
		return createDiskImageFromDisk(name, nodeName, createDiskImageFromDisk, null);
	}

	public boolean createDiskImageFromDisk(String name, CreateDiskImageFromDisk createDiskImageFromDisk, String eventId) throws Exception {
		return createDiskImageFromDisk(name, null, createDiskImageFromDisk, eventId);
	}

	public boolean createDiskImageFromDisk(String name, String nodeName,CreateDiskImageFromDisk createDiskImageFromDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDiskImageFromDisk)));
	}

	public boolean createDiskImage(String name, CreateDiskImage createDiskImage) throws Exception {
		return createDiskImage(name, null, createDiskImage, null);
	}

	public boolean createDiskImage(String name, String nodeName, CreateDiskImage createDiskImage) throws Exception {
		return createDiskImage(name, nodeName, createDiskImage, null);
	}

	public boolean createDiskImage(String name, CreateDiskImage createDiskImage, String eventId) throws Exception {
		return createDiskImage(name, null, createDiskImage, eventId);
	}

	public boolean createDiskImage(String name, String nodeName,CreateDiskImage createDiskImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDiskImage)));
	}

	public boolean deleteDiskImage(String name, DeleteDiskImage deleteDiskImage) throws Exception {
		return deleteDiskImage(name, deleteDiskImage, null);
	}

	public boolean deleteDiskImage(String name, DeleteDiskImage deleteDiskImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteDiskImage);
	}

	public boolean deleteDiskImage(String name, String nodeName, DeleteDiskImage deleteDiskImage) throws Exception {
		updateHost(name, nodeName);
		return deleteDiskImage(name, deleteDiskImage, null);
	}

	public boolean deleteDiskImage(String name, String nodeName, DeleteDiskImage deleteDiskImage, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteDiskImage(name, deleteDiskImage, eventId);
	}

	@Override
	protected Class<?> getModelClass() {
		return VirtualMachineDiskImage.class;
	}
}
