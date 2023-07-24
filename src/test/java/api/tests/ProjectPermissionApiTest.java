package api.tests;

import api.enums.UserRoles;
import api.steps.ProjectPermissionApiSteps;
import org.testng.annotations.Test;

public class ProjectPermissionApiTest {


    private Integer project_id ;
    private Integer user_id;

    private String role = UserRoles.ADMIN.getRole();
    @Test
    public void createProjectPermission() {

        ProjectPermissionApiSteps projectPermissionSteps = new ProjectPermissionApiSteps();
          projectPermissionSteps.createProjectPermission(project_id,user_id, role);



    }

}
