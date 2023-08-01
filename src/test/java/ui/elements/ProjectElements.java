package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectElements {

    public SelenideElement projectContentSidebar() {
        return $x("//div[@class='sidebar-content']");
    }

    public SelenideElement taskModalHeading() {
        return $x("//h2[contains (text(),'New task')]");
    }


}
