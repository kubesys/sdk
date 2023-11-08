/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import java.util.ArrayList;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Domain.Devices.Disk;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_005_VM_GetByName_GetAllVMDiskTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		ArrayList<Disk> vmd = client.virtualMachines().get("dockerhub2").getSpec().getDomain().getDevices().getDisk();
		for (int i = 0; i < vmd.size(); i++) {
			Disk d = vmd.get(i);
			if (d.get_device().equals("cdrom")) {
					continue;
			}
			System.out.println(d.getSource().get_file());
		}
	}
	
}
