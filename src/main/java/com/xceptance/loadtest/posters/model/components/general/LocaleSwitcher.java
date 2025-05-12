package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Context;

import static com.codeborne.selenide.Selenide.$;

/**
 * Choose another locale
 *
 * @author Xceptance Software Technologies
 */
public class LocaleSwitcher implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $(".nav-item.dropdown > #show-locale-menu");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public void switchToUs()
    {
        Context.startAction("SwitchToUS");
        locate().hover();
        $("#locale-menu [href*='US']").click();

        // verify active locale
        locate().should(Condition.exactText("en-US"));
    }

    public void switchToDe()
    {
        Context.startAction("SwitchToDE");

        locate().hover();
        $("#locale-menu [href*='DE']").click();

        // verify active locale
        locate().should(Condition.exactText("de-DE"));
    }
}
