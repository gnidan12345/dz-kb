package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.MainElements;
import ui.elements.ProjectElements;

public class ProjectPage extends ProjectElements {

    public ProjectPage assertProjectContent(){
       projectContentSidebar().shouldBe(Condition.visible);
          return this;
    }







}
