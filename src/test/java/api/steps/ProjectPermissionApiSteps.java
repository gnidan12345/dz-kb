package api.steps;

import api.enums.UserRoles;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.projects.CreateProjectPermission;
import io.restassured.response.Response;

import static api.methods.ProjectPermission.ADD_PROJECT_USER;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class ProjectPermissionApiSteps extends BaseApiSteps{

    public boolean createProjectPermission(Integer projectid, Integer userid, String role) {


        CreateProjectPermission args = CreateProjectPermission.builder()
                .project_id(projectid)
                .user_id(userid)
                .role(UserRoles.ADMIN.getRole())
                .build();


        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(ADD_PROJECT_USER)
                .build();


        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();

    }
}
