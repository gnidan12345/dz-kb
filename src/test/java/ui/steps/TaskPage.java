package ui.steps;

import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.elements.TaskElements;

import static com.codeborne.selenide.Selenide.open;

public class TaskPage extends TaskElements {


    public TaskPage deleteTask(Integer taskid) {
        open("http://localhost/task/" + taskid);
        closeTaskLink().click();
        buttonCloseTaskConfirm().click();
        alertTaskIsClosed().shouldBe(Condition.disappear);
        return this;

    }

    public TaskPage createComment(Integer taskid, String content) {


        open("http://localhost/task/" + taskid);
        addCommentLink().click();
        textareaComment().sendKeys(content);
        buttonSaveComment().click();
        commentBlock().shouldHave(Condition.exactText(content));
        return this;

    }
}
