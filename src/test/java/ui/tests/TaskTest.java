package ui.tests;

import api.models.Result;
import api.steps.ProjectApiSteps;
import api.steps.ProjectPermissionApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.steps.BoardPage;
import ui.steps.LoginPage;
import ui.steps.TaskPage;


public class TaskTest extends BaseTest {

    Faker faker = new Faker();
    private String USERNAME = faker.name().username();

    private String projectName = faker.name().title();

    private static final String PASSWORD = "myTestPassword";

    private String contenet = faker.letterify("ashuidsgfi", true);

    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    ProjectPermissionApiSteps projectPermissionApiSteps = new ProjectPermissionApiSteps();

    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private Integer userId;
    private Integer projectId;
    private Integer taskId;
    private String role;


    private boolean hasPermission;



    @BeforeTest
    public void prepareDataForTest() {
        userId = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));

        System.out.println(userId);

        projectId = Integer.valueOf(projectApiSteps.createProject(projectName));

        System.out.println(projectId);

        System.out.println(projectPermissionApiSteps.createProjectPermission(projectId, userId, role));


    }

    @Test
    public void createTask() {


        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();


        BoardPage boardPage = new BoardPage();

        boardPage.createTask(userId, projectId);
        System.out.println(USERNAME);
        System.out.println(taskId);


    }

    @Test
    public void closeTask() {

        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();

        taskId = Integer.valueOf(taskApiSteps.createTask("newTask", projectId));
        System.out.println(taskId);


        new TaskPage()

                .deleteTask(taskId);

    }


}