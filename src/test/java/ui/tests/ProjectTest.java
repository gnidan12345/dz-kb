package ui.tests;

import api.models.args.projects.ProjectDetails;
import com.github.javafaker.Faker;
import dataproviders.TestDataProvider;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.steps.LoginPage;
import ui.steps.MainPage;
import ui.steps.ProjectPage;
import utils.DBReader;

public class ProjectTest extends BaseTest {



     private static final String USERNAME = "admin";
     private static final String PASSWORD = "admin";

    @Test
    public void createNewProject(){

        Faker faker = new Faker();
        String projectName = faker.name().title();


        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();

        new MainPage()
                .assertMainSectionIsOpened()
                .clickNewProject()
                .assertModalNewProject()
                .fillFormNewProject(projectName);
        System.out.println(projectName);


        new ProjectPage()
                .assertProjectContent();

    }

    @Description("selecting all properties from database")
    @Test(dataProvider = "projectsDB", dataProviderClass = TestDataProvider.class)
        public void checkListProjectsFromDB(Integer id, String name){
//        System.out.println(DBReader.getPropertiesFromDB().get(0));
    }

    @Description("selecting first project and updating it")
    @Test(dataProvider = "firstprojectsDB", dataProviderClass = TestDataProvider.class)
    public void checkFirsrtProjectFromDB(Integer id, String name){
        Faker faker = new Faker();
        String projectNameUpdated = faker.name().title();
        System.out.println(DBReader.getSelectedProjectFromDB());
        DBReader.updateProjectname(122, projectNameUpdated);
        System.out.println(projectNameUpdated);

    }
}
