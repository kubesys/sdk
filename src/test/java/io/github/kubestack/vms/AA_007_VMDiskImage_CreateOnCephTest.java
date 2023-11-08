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
public class AA_007_VMDiskImage_CreateOnCephTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskImages()
				.createDiskImage("diskimagetest", "vm.node131", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskImage get() {
		CreateDiskImage createDiskImage = new CreateDiskImage();
		// Only support file in "/var/lib/libvirt/" or its sub-dirs
//		createDiskImage.setSource("/var/lib/libvirt/cstor/076fe6aa813842d3ba141f172e3f8eb6/076fe6aa813842d3ba141f172e3f8eb6/a228752f3be2440e9cd1ececfe6f5783/a228752f3be2440e9cd1ececfe6f5783");
		createDiskImage.setTargetPool("localfs1");
		return createDiskImage;
	}
}
