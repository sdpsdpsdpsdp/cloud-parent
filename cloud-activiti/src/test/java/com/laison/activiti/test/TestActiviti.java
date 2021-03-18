package com.laison.activiti.test;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @Desc
 * @Author sdp
 * @Date 2021/3/1 11:08
 */
public class TestActiviti {
    @Test
    public void createTables() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);

        //部署的服务
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("bpmn/leave.bpmn")
                .addClasspathResource("bpmn/leave.png")
                .name("出差申请")
                .deploy();
        System.out.println(deployment.getName() + "," + deployment.getId() + "," + deployment.getKey() + "," + deployment.getDeploymentTime());
    }

    @Test
    public void start() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("myLeave");
        System.out.println(processInstance.getId() + "," + processInstance.getName());
    }

    @Test
    public void query() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().list();
        for (Task task : list) {
            System.out.println(task.getId() + "," + task.getName() + "," + task.getAssignee());
        }
    }

    @Test
    public void complete() {
        String taskId = "12504";
        String userId = "财务";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        taskService.setAssignee(taskId, userId);
        taskService.complete(taskId);
    }

    @Test
    public void history() {
        String processId = "5001";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<HistoricTaskInstance> list1 = processEngine.getHistoryService().createHistoricTaskInstanceQuery().processInstanceId(processId).orderByTaskCreateTime().asc().list();
        for (HistoricTaskInstance task:list1) {
            System.out.println(task.getId()+","+task.getName()+","+task.getAssignee()+","+task.getEndTime());
        }

        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("");
        processEngine.getRepositoryService().createDeployment()
                .addZipInputStream(new ZipInputStream(resourceAsStream))
                .deploy();
    }


    //资源文件下载
    //方案1 使用activiti提供的api,来下载资源文件
    //方案2 从数据库下载文件，使用jdbc对blob类型，clob类型数据读取出来，保存到文件目录
    //解决io操作：commons-io.jar
    @Test
    public void getDeployment(){

    }
}
