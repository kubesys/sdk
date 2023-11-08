/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinedisk.Lifecycle.DeleteCloudInitUserDataImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteCloudInitUserDataImageTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.deleteCloudInitUserDataImage("cloudinit1", get());
		System.out.println(successful);
	}
	
	public static DeleteCloudInitUserDataImage get() {
		DeleteCloudInitUserDataImage deleteDisk = new DeleteCloudInitUserDataImage();
		deleteDisk.setPool("migratepoolnodepool22");
		return deleteDisk;
	}
}
