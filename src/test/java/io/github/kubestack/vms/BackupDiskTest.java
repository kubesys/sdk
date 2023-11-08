package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinedisk.Lifecycle;

public class BackupDiskTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachineDisks()
                .backupDisk("e8c9b41664584253afa43592d5efeafb", "vm.node22", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.BackupDisk getBackupVM() {
        Lifecycle.BackupDisk backupDisk = new Lifecycle.BackupDisk();
        backupDisk.setDomain("cloudinitbackup5555");
        backupDisk.setPool("migratepoolnodepool22");
        backupDisk.setVersion("diskbackup123");
        backupDisk.setFull(true);
//        backupDisk.setRemote("133.133.135.30");
//        backupDisk.setPort("21");
//        backupDisk.setUsername("ftpuser");
//        backupDisk.setPassword("ftpuser");
        return backupDisk;
    }
}
