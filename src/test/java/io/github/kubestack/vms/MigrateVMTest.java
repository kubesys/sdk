/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.fabric8.kubernetes.api.model.NodeCondition;
import io.fabric8.kubernetes.api.model.NodeStatus;
import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.k8s.Node;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class MigrateVMTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		String vmName = "openeuler";
		String nodeName = client.virtualMachines().get(vmName).getMetadata().getLabels().get("host");
		String nodeIp = client.nodes().get(nodeName).getMetadata().getAnnotations().get("THISIP");
		List<String> migrateNodes = getMigrateNodes();
		// 替换成前端选IP的逻辑
		String migrateNodeIp = "";
		for (String migrateNode : migrateNodes) {
			if (!migrateNode.equals(nodeIp)) {
				migrateNodeIp = migrateNode;
			}
		}
		boolean successful = client.virtualMachines()
				.migrateVM(vmName, migrateVM(migrateNodeIp));
		System.out.println(successful);
	}

	public static Lifecycle.MigrateVM migrateVM(String migrateNodeIp) throws Exception {

		Lifecycle.MigrateVM migrateVM = new Lifecycle.MigrateVM();
		migrateVM.setIp(migrateNodeIp);
//		migrateVM.setOffline(true);
		return migrateVM;
	}

	public static List<String> getMigrateNodes() throws Exception {
		KubeStackClient client = AbstractTest.getClient();
		List<String> migrateNodes = new ArrayList<String>();
		for (Node no : client.nodes().list()) {
			if (no.getMetadata().getLabels().containsKey("doslab/virt.tool.centos") || no.getMetadata().getLabels().containsKey("doslab/virt.tool.ubuntu")){
				String nodeIp = no.getMetadata().getAnnotations().get("THISIP");
				NodeStatus nodeStatus = no.getStatus();
				List<NodeCondition> nodeStatusConditions = nodeStatus.getConditions();
//				System.out.println(nodeStatusConditions.toString().contains("reason=NodeStatusUnknown"));
				if (!nodeIp.isEmpty() && !nodeStatusConditions.toString().contains("reason=NodeStatusUnknown")) {
					migrateNodes.add(nodeIp);
				}
			}
		}
		return migrateNodes;
	}
}
