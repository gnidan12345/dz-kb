package api.tests;

import api.models.Result;
import api.models.TaskDetails;
import api.steps.TaskApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TaskApiTests {
    @Test

    public void checkTasksList() {
        TaskApiSteps taskApiSteps = new TaskApiSteps();
        Result<List<TaskDetails>> taskDetailsinfo = taskApiSteps.getAlltasks(122);
        Assert.assertTrue(taskDetailsinfo.getResult().size() > 0, "Project request doesn't contain tasks");
        System.out.println(taskDetailsinfo.getResult().get(0).getId());

    }


    @Test
    public void getTask() {

        TaskApiSteps taskApiSteps = new TaskApiSteps();
        System.out.println(taskApiSteps.getTask(104));

    }


    @Test
    public void getTaskByReference() {

        TaskApiSteps taskApiSteps = new TaskApiSteps();
        System.out.println(taskApiSteps.getTaskByReference(122, "ref1"));

    }


    @Test
    public void createTask() {

        TaskApiSteps taskApiSteps = new TaskApiSteps();
        taskApiSteps.createTask("testTask", 122);

    }
}
