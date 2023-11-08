/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinedisksnapshot.Lifecycle.DeleteDiskExternalSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteDiskExternalSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskSnapshots()
				.deleteDiskExternalSnapshot("vmbackuptestdisk1.1", get());
		System.out.println(successful);
	}
	
	public static DeleteDiskExternalSnapshot get() {
		DeleteDiskExternalSnapshot deleteDiskExternalSnapshot = new DeleteDiskExternalSnapshot();
		deleteDiskExternalSnapshot.setPool("61024b305b5c463b80bceee066077079");
		deleteDiskExternalSnapshot.setType("nfs");
		deleteDiskExternalSnapshot.setVol("vmbackuptestdisk1");
		deleteDiskExternalSnapshot.setDomain("vmbackuptest");
		return deleteDiskExternalSnapshot;
	}
}
