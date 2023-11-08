package io.github.kubestack.openstack;

import io.github.kubestack.client.KubeStackClient;

/**
 * @Description
 * @Date 2023/2/16 9:11
 * @Author guohao
 **/
public class AA_001_VM_GetAPIVersionTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
        System.out.println(client.openstackServers().getAPIVersion());
    }
}
