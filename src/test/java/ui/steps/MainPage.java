package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.MainElements;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends MainElements {
     private String projectTitle = "testproject";

    public MainPage openLoginPage() {
        open("");
        return new MainPage();
    }

    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }


    public MainPage clickNewProject(){
        createProjectButton().click();
        return this;
    }

    public MainPage assertModalNewProject(){
        formHeading().shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage fillFormNewProject(String projectTitle){
        projectName().sendKeys(projectTitle);
        submitButton().click();
        return new ProjectPage();

    }
}
