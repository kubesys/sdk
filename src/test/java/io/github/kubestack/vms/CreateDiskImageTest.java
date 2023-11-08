/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle.CreateDiskImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateDiskImageTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskImages()
				.createDiskImage("sdkimage1", "vm.node131", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskImage get() {
		CreateDiskImage createDiskImage = new CreateDiskImage();
		// Only support file in "/var/lib/libvirt/" or its sub-dirs
		createDiskImage.setImageType("qcow2");
		createDiskImage.setSource("/var/lib/libvirt/poolhub111/diskhub111/diskhub111");
		createDiskImage.setTargetPool("poolhub111-image");
		return createDiskImage;
	}
}
