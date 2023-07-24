package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainElements {
    public SelenideElement mainSection() {
        return $("#main");
    }

    public SelenideElement createProjectButton() {
        return $x("(//a[@href='/project/create'])[2]");
    }

    public SelenideElement formHeading() {
        return $x("//h2[text() = 'New project']");
    }

    public SelenideElement projectName() {
        return $x("//*[@id='form-name']");
    }

    public SelenideElement submitButton() {
        return $x("//button[@type='submit']");
    }


}
