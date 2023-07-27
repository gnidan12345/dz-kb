package api.tests;

import api.models.Result;
import api.models.UserInfo;
import api.models.args.projects.ProjectDetails;
import api.models.args.users.CreateUser;
import api.models.args.users.UserDetails;
import api.models.args.users.UserId;
import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class UserApiTests {

//    private String USERNAME;
//    private String PASSWORD;
    private Integer userId;

    @BeforeMethod
    public void preConditions() {
        Faker faker = new Faker();
        String USERNAME = faker.name().username();
        String PASSWORD = "myTestPassword";
        UserApiSteps userApiSteps = new UserApiSteps();
        int userId = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));

    }


    @Test
    public void checkUserCreated() {
        Faker faker = new Faker();
        String USERNAME = faker.name().username();
        String PASSWORD = "myTestPassword";
        UserApiSteps userApiSteps = new UserApiSteps();
        userApiSteps.createUser(USERNAME, PASSWORD);
        String userInfoResults = userApiSteps.createUser(USERNAME, PASSWORD);

    }

    @Test
    public void getUser() {
        UserApiSteps userApiSteps = new UserApiSteps();
        userApiSteps.getUser(userId);

    }

    @Test
    public void deleteUser() {
        Faker faker = new Faker();
        String USERNAME = faker.name().username();
        String PASSWORD = "myTestPassword";
        UserApiSteps userApiSteps = new UserApiSteps();
        int userid = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));
        userApiSteps.deleteUser(userid);
    }

}

