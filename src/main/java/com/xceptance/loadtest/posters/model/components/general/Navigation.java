package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;

import static com.codeborne.selenide.Selenide.$;

/**
 * Navigation component (i.e. menu bar with categories).
 *
 * @author Xceptance Software Technologies
 */
public class Navigation implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#header-navigation-elements");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }
}
