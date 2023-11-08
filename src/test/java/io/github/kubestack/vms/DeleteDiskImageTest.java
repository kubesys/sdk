/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle.DeleteDiskImage;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteDiskImageTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskImages()
				.deleteDiskImage("sdkimage2", get());
		System.out.println(successful);
	}

	protected static DeleteDiskImage get() {
		DeleteDiskImage delteDiskImage = new DeleteDiskImage();
		delteDiskImage.setSourcePool("poolhub111-image");
		return delteDiskImage;
	}
	
}
