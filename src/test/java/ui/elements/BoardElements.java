package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BoardElements {

    public SelenideElement taskBacklog() {
        return $x("(//div[@class='board-add-icon'])[1]");
    }

    public SelenideElement taskTitle() {
        return $x("//*[@id='form-title']");
    }

    public SelenideElement submitTaskButton() {
        return $x("//button[@type='submit']");
    }



}
