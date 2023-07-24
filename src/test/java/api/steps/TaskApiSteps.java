package api.steps;

import api.models.*;
import api.models.args.BodyArgs;
import api.models.args.projects.CreateProject;
import api.models.args.projects.CreateTasks;
import api.models.args.projects.GetTaskByReference;
import api.models.args.projects.ProjectId;
import api.models.args.users.UserId;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;

import static api.methods.Projects.CREATE_PROJECT;
import static api.methods.Tasks.*;
import static api.methods.Users.GET_USER;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class TaskApiSteps extends BaseApiSteps {

    public Result<List<TaskDetails>> getAlltasks(Integer projectid) {
        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new ProjectId(projectid))
                .method(GET_ALL_TASKS)
                .build();


        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return response.as(new TypeRef<Result<List<TaskDetails>>>() {
        });

    }

    public String getTask(Integer taskid) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new TaskID(taskid))
                .method(GET_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        Result result = response.as(Result.class);
        response.prettyPrint();
        return result.getResult().toString();
    }


    public String getTaskByReference(Integer projectid, String reference) {

        GetTaskByReference args = GetTaskByReference.builder()
                .project_id(projectid)
                .reference(reference)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(GET_TASK_BY_REFERENCE)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        Result result = response.as(Result.class);
        response.prettyPrint();
        return result.getResult().toString();
    }


    public String createTask(String title, Integer projectid) {

        CreateTasks args = CreateTasks.builder()
                .title(title)
                .project_id(projectid)
                .build();


        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);

        Result result = response.as(Result.class);
        response.prettyPrint();
        return result.getResult().toString();

    }
}
