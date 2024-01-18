/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import java.util.ArrayList;
import java.util.List;

import io.fabric8.kubernetes.api.model.NodeCondition;
import io.fabric8.kubernetes.api.model.NodeStatus;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.k8s.Node;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_Node_GetAllMigrate_Test {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
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
		for (String migrateNode : migrateNodes){
			System.out.println(migrateNode);
		}
	}
	
}
