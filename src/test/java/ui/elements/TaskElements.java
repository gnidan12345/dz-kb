package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskElements {

    public SelenideElement closeTaskLink() {
        return $x("//a[text()='Close this task']");
    }

    public SelenideElement buttonCloseTaskConfirm() {
        return $x("//button[@id='modal-confirm-button']");
    }

    public SelenideElement alertTaskIsClosed() {
        return $x("//div[text()='Task closed successfully.']");
    }

    public SelenideElement addCommentLink() {
        return $x("//a[text()='Add a comment']");
    }

    public SelenideElement textareaComment() {
        return $x("//div[@id ='modal-overlay']//child::textarea");
    }

    public SelenideElement buttonSaveComment() {
        return $x("//div[@id ='modal-overlay']//child::button");
    }

    public SelenideElement commentBlock() {
        return $x("//p");
    }

}
