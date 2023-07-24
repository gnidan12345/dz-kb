package ui.tests;

import api.models.UserInfo;
import com.github.javafaker.Faker;
import dataproviders.TestDataProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import api.steps.UserApiSteps;
import ui.steps.LoginPage;
import ui.steps.MainPage;


public class LoginTests extends BaseTest {
    Faker faker = new Faker();
    private String USERNAME = faker.name().username();

    private static final String PASSWORD = "myTestPassword";

    UserApiSteps userApiSteps = new UserApiSteps();
    private Integer userId;

    @BeforeMethod(groups = "newUser")
    public void prepareDataForTest() {
        userId = Integer.valueOf(userApiSteps.createUser(USERNAME, PASSWORD));
        System.out.println(userId);
    }


    @Test(groups = "newUser")

    public void loginByNewUser() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();
    }

    @Description("performing login with not valid users")
    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class, groups = "UserDataTests")
    public void loginWithNotValidUsers(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.userField().sendKeys(username);
        loginPage.passwordField().sendKeys(password);
        loginPage.submitButton().click();
        loginPage.errorMessage();
    }


    @AfterMethod
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}
