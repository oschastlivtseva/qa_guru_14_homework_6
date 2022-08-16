package guru.qa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @Test
    void clickMenuItemTest() {
        String menuItem = "Pricing";
        String menuSubItem = "Compare plans";
        String headersValue = "Choose the plan that’s right for you";

        // open main page
        open("https://github.com");

        // hover over menu item
        SelenideElement menuItemWithDropdown = $$(".HeaderMenu-summary").findBy(text(menuItem));
        menuItemWithDropdown.hover();

        // click on menu sub item
        menuItemWithDropdown.sibling(0).$(byText(menuSubItem)).click();

        // check the header of new opened page
        $(withTagAndText("h1", headersValue)).shouldBe(visible);
    }
}
