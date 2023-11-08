/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.fabric8.kubernetes.api.model.Node;
import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class NodeZoneLabelsQuery {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		Map<String, String> labels = new HashMap<String, String>();
		// 可以添加多个标签
		labels.put("zone", "rackA");
		// 得到相同zone的所有机器
//		List<Node> nodes = client.nodes().withLabels(labels).list().getItems();
	}

}
