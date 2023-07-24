package api.tests;

import api.models.BoardInfo;
import api.models.Result;
import api.models.args.projects.ProjectDetails;
import com.github.javafaker.Faker;
import org.testng.Assert;
import api.steps.ProjectApiSteps;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectApiTest {

    private Integer projectid;

    @Test
    public void checkProjectcreated() {
        Faker faker = new Faker();
        String projectName = faker.name().title();
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectApiSteps.createProject(projectName);
        System.out.println(projectName);

    }


    @Test
    public void deleteProject() {
        ProjectApiSteps projectApiSteps = new ProjectApiSteps();
        projectApiSteps.deleteProject(projectid);
    }

}
