package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.ProjectPermissionApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.steps.BoardPage;
import ui.steps.LoginPage;
import ui.steps.TaskPage;


public class CommentTest extends BaseTest {
    Faker faker = new Faker();
    private String USERNAME = faker.name().username();

    private String projectName = faker.name().title();

    private static final String PASSWORD = "myTestPassword";

    private String contenet = faker.letterify("Lorem Ipsum is simply dummy text of the printing and typesetting industry.", true);

    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    ProjectPermissionApiSteps projectPermissionApiSteps = new ProjectPermissionApiSteps();

    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private Integer userId;
    private Integer projectId;
    private Integer taskId;
    private String role;

    @BeforeTest
    public void prepareDataForTest() {
        userId = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));

        System.out.println(userId);

        projectId = Integer.valueOf(projectApiSteps.createProject(projectName));

        System.out.println(projectId);

        System.out.println(projectPermissionApiSteps.createProjectPermission(projectId, userId, role));

        taskId = Integer.valueOf(taskApiSteps.createTask("newTask", projectId));
        System.out.println(taskId);

    }


    private boolean hasPermission;

    @Test
    public void createNewComment() {

        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();

        new BoardPage()
                .createTask(userId, projectId);

        new TaskPage()
                .createComment(taskId, contenet);
        System.out.println(contenet);
    }


}
