package io.github.kubestack.openstack;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Date 2023/2/9 10:43
 * @Author guohao
 **/
public class AA_002_VM_CreateServerWithNetworkTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        Lifecycle.CreateServer createServer = get();
        boolean successful = client.openstackServers().createServer("test-create-sdk", get(), getSecretRef());
        System.out.println(successful);
    }

    public static Lifecycle.CreateServer get() {
        Lifecycle.CreateServer createServer = new Lifecycle.CreateServer();
        Lifecycle.CreateServer.Opts createOpts = createServer.getOpts();

        createOpts.setName("test-create-network");
        createOpts.setImageRef("952b386b-6f30-46f6-b019-f522b157aa3a");
        createOpts.setFlavorRef("3");

        Lifecycle.CreateServer.Opts.NovaNetworkCreate netwrok =
            new Lifecycle.CreateServer.Opts().NewNovaNetworkCreate();
        netwrok.setUUID("a3176333-3df6-480f-af2b-dc5e02ea1aa0");
        netwrok.setTag("test");
        createOpts.setNetworks(new ArrayList<>(Arrays.asList(netwrok)));
        return createServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
