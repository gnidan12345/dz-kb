package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.BoardElements;
import ui.elements.ProjectElements;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class BoardPage extends BoardElements {


    public BoardPage createTask(Integer userid, Integer projectid) {
        open("http://localhost/board/" + projectid);
        taskBacklog().click();
        taskTitle().sendKeys("task444");
        submitTaskButton().click();
        return this;
    }



}


