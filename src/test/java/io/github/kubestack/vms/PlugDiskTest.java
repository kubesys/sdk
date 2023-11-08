/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.PlugDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class PlugDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.plugDisk("test123", getPlugDisk());
//				.plugDisk("vm003", getPlugCdrom());
		System.out.println(successful);
	}
	
	public static PlugDisk getPlugDisk() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/var/lib/libvirt/pooltest999/mytest201/mytest201");
		plugDisk.setTarget("vdb");
		plugDisk.setLive(false);
		plugDisk.setConfig(true);
//		plugDisk.setType("cdrom");
		plugDisk.setSubdriver("qcow2");
//		plugDisk.setTotal_bytes_sec("1024000000");
//		plugDisk.setRead_bytes_sec("1024000000");
//		plugDisk.setWrite_bytes_sec("1024000000");
//		plugDisk.setTotal_iops_sec("40000");
//		plugDisk.setRead_iops_sec("40000");
//		plugDisk.setWrite_iops_sec("40000");
		return plugDisk;
	}
	
	public static PlugDisk getPlugBlock() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/dev/disk/by-id/scsi-3600140501a77a674131403caadfc8e4c");
		plugDisk.setTarget("sda");
		plugDisk.setLive(true);
		plugDisk.setConfig(true);
		plugDisk.setType("lun");
		plugDisk.setSgio("unfiltered");
		plugDisk.setSubdriver("raw");
		plugDisk.setTotal_bytes_sec("1024000000");
		plugDisk.setRead_bytes_sec("1024000000");
		plugDisk.setWrite_bytes_sec("1024000000");
		plugDisk.setTargetbus("scsi");
		plugDisk.setSourcetype("block");
//		plugDisk.setTotal_iops_sec("40000");
//		plugDisk.setRead_iops_sec("40000");
//		plugDisk.setWrite_iops_sec("40000");
		return plugDisk;
	}
	
	public static PlugDisk getPlugCdrom() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/var/lib/libvirt/iso/centos7-minimal-1511.iso");
		// Cdrom only support hdX device
		plugDisk.setTarget("hdb");
		// Cdrom/floppy device hotplug isn't supported by Libvirt
		plugDisk.setConfig(true);
		plugDisk.setSubdriver("raw");
		plugDisk.setType("cdrom");
		return plugDisk;
	}
}
