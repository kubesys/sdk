package io.github.kubestack.client.api.specs.openstack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.fabric8.kubernetes.api.model.Status;
import io.github.kubestack.client.api.specs.KubeStackSpec;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Domain;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description OpenstackServer Json
 * @Date 2023/2/7 14:47
 * @Author guohao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
// todo not extends from kubeStack
public class OpenstackServerSpec extends KubeStackSpec {
    protected Domain domain;
    protected Lifecycle lifecycle;

    protected String id;
    protected Status status;
    protected SecretRef secretRef;

    public OpenstackServerSpec() {}

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SecretRef getSecretRef() {
        return secretRef;
    }

    public void setSecretRef(SecretRef secretRef) {
        this.secretRef = secretRef;
    }
}
