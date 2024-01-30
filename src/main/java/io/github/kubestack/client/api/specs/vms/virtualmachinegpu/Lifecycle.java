/**
 * Copyright (2024, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs.vms.virtualmachinegpu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.kubestack.core.annotations.ClassDescriber;
import io.github.kubestack.core.annotations.FunctionDescriber;
import io.github.kubestack.core.annotations.ParameterDescriber;
import io.github.kubestack.core.utils.AnnotationUtils;
import io.github.kubestack.core.utils.RegExpUtils;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.1.0
 * @since 2024.01.30
 * 
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ClassDescriber(value = "VirtualMachineGPU", desc = "虚拟机GPU资源")
public class Lifecycle {

}
