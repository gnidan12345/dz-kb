package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.CreateProject;
import api.models.args.projects.ProjectDetails;
import api.models.args.projects.ProjectId;
import io.restassured.response.Response;

import java.util.List;

import static api.methods.Projects.CREATE_PROJECT;
import static api.methods.Projects.REMOVE_PROJECT;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps {

    public String createProject(String name) {
        CreateProject args = CreateProject.builder()
                .name(name)
                .build();


        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_PROJECT)
                .build();


        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);

        Result result = response.as(Result.class);
        response.prettyPrint();

        response.then().statusCode(200);
        return result.getResult().toString();

    }

    public boolean deleteProject(Integer projectid) {
        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectId((projectid)))
                .method(REMOVE_PROJECT)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.prettyPrint();
        response.then().statusCode(200);
        return (boolean) response.as(Result.class).getResult();




    }


}
