/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.core.generators.vms;

import io.github.kubestack.client.api.models.vms.VirtualMachine;
import io.github.kubestack.client.api.models.vms.VirtualMachineDisk;
import io.github.kubestack.client.api.models.vms.VirtualMachineDiskImage;
import io.github.kubestack.client.api.models.vms.VirtualMachineDiskSnapshot;
import io.github.kubestack.client.api.models.vms.VirtualMachineImage;
import io.github.kubestack.client.api.models.vms.VirtualMachineNetwork;
import io.github.kubestack.client.api.models.vms.VirtualMachinePool;
import io.github.kubestack.client.api.models.vms.VirtualMachineSnapshot;
import io.github.kubestack.client.impl.AbstractImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineDiskImageImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineDiskImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineDiskSnapshotImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineImageImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineNetworkImpl;
import io.github.kubestack.client.impl.vms.VirtualMachinePoolImpl;
import io.github.kubestack.client.impl.vms.VirtualMachineSnapshotImpl;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/3
 *
 * generating methods for the subclass of <code>AbstractImpl<code>, such as <code>VirtualMachineImpl<code>,
 * <code>VirtualMachinePoolImpl<code>, and so one 
 */
public class ImplGenerator {

	public static String generate(Object obj) throws Exception {
		StringBuffer sb = new StringBuffer();
		AbstractImpl<?, ?> impl = (AbstractImpl<?, ?>) obj;
		for (String cmd : impl.getSupportCmds()) {
			if (cmd.startsWith("create") && !cmd.startsWith("createDiskSnapshot")) {
				sb.append("\tpublic boolean " + cmd +"(String name, " 
									+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, null, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, nodeName, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, null, " + cmd + ", eventId);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName," 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\tPattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);\n");
				sb.append("\t\tif (!pattern.matcher(name).matches()) {\n");
				sb.append("\t\t\tthrow new IllegalArgumentException(\"the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.\");\n");
				sb.append("\t\t}\n");
				sb.append("\t\treturn create(getModel(), createMetadata(name, nodeName, eventId), \r\n" + 
						"				createSpec(nodeName, createLifecycle(" + cmd + ")));\n");
				sb.append("\t}\n\n");
				
			} else if (cmd.startsWith("delete")) {
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
	
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\tPattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);\n");
				sb.append("\t\tif (!pattern.matcher(name).matches()) {\n");
				sb.append("\t\t\tthrow new IllegalArgumentException(\"the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.\");\n");
				sb.append("\t\t}\n");
				sb.append("\t\treturn delete(name, updateMetadata(name, eventId), " + cmd + ");\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\tupdateHost(name, nodeName);\n");
				sb.append("\t\treturn " + cmd + "(name, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName, " 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\tupdateHost(name, nodeName);\n");
				sb.append("\t\treturn " + cmd + "(name, " + cmd + ", eventId);\n");
				sb.append("\t}\n\n");
			} else {
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
	
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\tPattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);\n");
				sb.append("\t\tif (!pattern.matcher(name).matches()) {\n");
				sb.append("\t\t\tthrow new IllegalArgumentException(\"the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.\");\n");
				sb.append("\t\t}\n");
				sb.append("\t\treturn update(name, updateMetadata(name, eventId), " + cmd + ");\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\tupdateHost(name, nodeName);\n");
				sb.append("\t\treturn " + cmd + "(name, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName, " 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\tupdateHost(name, nodeName);\n");
				sb.append("\t\treturn " + cmd + "(name, " + cmd + ", eventId);\n");
				sb.append("\t}\n\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(generate(new VirtualMachineDiskImpl(null, VirtualMachineDisk.class.getSimpleName())));
		System.out.println(generate(new VirtualMachineDiskSnapshotImpl(null, VirtualMachineDiskSnapshot.class.getSimpleName())));
		System.out.println(generate(new VirtualMachineImpl(null, VirtualMachine.class.getSimpleName())));
		System.out.println(generate(new VirtualMachinePoolImpl(null, VirtualMachinePool.class.getSimpleName())));
		System.out.println(generate(new VirtualMachineImageImpl(null, VirtualMachineImage.class.getSimpleName())));
		System.out.println(generate(new VirtualMachineSnapshotImpl(null, VirtualMachineSnapshot.class.getSimpleName())));
		System.out.println(generate(new VirtualMachineNetworkImpl(null, VirtualMachineNetwork.class.getSimpleName())));
		System.out.println(generate(new VirtualMachineDiskImageImpl(null, VirtualMachineDiskImage.class.getSimpleName())));
	}
	
	public static String getClassName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
