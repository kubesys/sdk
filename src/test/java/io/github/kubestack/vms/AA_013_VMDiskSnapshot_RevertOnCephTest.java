/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinedisksnapshot.Lifecycle.RevertDiskExternalSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_013_VMDiskSnapshot_RevertOnCephTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskSnapshots()
				.revertDiskExternalSnapshot("vmbackuptestdisk1.1", get(), "abc");
		System.out.println(successful);
	}

	protected static RevertDiskExternalSnapshot get() {
		RevertDiskExternalSnapshot revertDiskExternalSnapshot = new RevertDiskExternalSnapshot();
		revertDiskExternalSnapshot.setType("ceph");
		revertDiskExternalSnapshot.setPool("61024b305b5c463b80bceee066077079");
		revertDiskExternalSnapshot.setVol("vmbackuptestdisk1");
		revertDiskExternalSnapshot.setFormat("qcow2");
		revertDiskExternalSnapshot.setDomain("vmbackuptest");
		return revertDiskExternalSnapshot;
	}
}
