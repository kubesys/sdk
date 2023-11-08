package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle;

public class BackupVMTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .backupVM("wintest", "vm.node22", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.BackupVM getBackupVM() {
        Lifecycle.BackupVM backupVM = new Lifecycle.BackupVM();
        backupVM.setPool("migratepoolnodepool22");
        backupVM.setVersion("backup1");
        backupVM.setAll(true);
        backupVM.setFull(true);
//        backupVM.setRemote("133.133.135.30");
//        backupVM.setPort("21");
//        backupVM.setUsername("ftpuser");
//        backupVM.setPassword("ftpuser");
        return backupVM;
    }
}
