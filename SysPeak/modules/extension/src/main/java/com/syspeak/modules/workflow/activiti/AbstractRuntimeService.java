package com.syspeak.modules.workflow.activiti;

import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Activiti Abstract RuntimeService
 * @company SysPeak (C) Copyright
 * @category AbstractRuntimeService
 * @version 1.0
 * @since 2011-9-13
 * @author JemiZhuu(周士淳)
 */
public abstract class AbstractRuntimeService {
	/**
	 * 根据流程定义ID启动流程实例
	 * @param processDefinitionId
	 * @param businessKey
	 * @param variables
	 * @return
	 */
	public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey,
			Map<String, Object> variables) {
		ProcessInstance instance = runtimeService.startProcessInstanceById(processDefinitionId, businessKey, variables);
		return instance;
	}

	/**
	 * 根据流程定义KEY启动流程实例
	 * @param processDefinitionKey
	 * @param businessKey
	 * @param variables
	 * @return
	 */
	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey,
			Map<String, Object> variables) {
		ProcessInstance instance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey,
				variables);
		return instance;
	}

	private RuntimeService runtimeService;

	@Autowired
	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}
}
