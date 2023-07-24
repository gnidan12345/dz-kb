package api.tests;

import api.models.Result;
import api.models.UserInfo;
import api.models.args.users.CreateUser;
import api.steps.UserApiSteps;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;



public class UserApiTests {

    Faker faker = new Faker();
    private String USERNAME = faker.name().username();
    private static final String PASSWORD = "myTestPassword";


    @Test
    public void createUser (){
        UserApiSteps userApiSteps = new UserApiSteps();
        userApiSteps.createUser(USERNAME, PASSWORD);}


    @Test
    public void getUser() {
        UserApiSteps userApiSteps = new UserApiSteps();

        int userid = (Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD)));
        userApiSteps.getUser(1);

    }

    @Test
    public void deleteUser() {
        UserApiSteps userApiSteps = new UserApiSteps();
        int userid = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));
        userApiSteps.deleteUser(userid);
    }

}

