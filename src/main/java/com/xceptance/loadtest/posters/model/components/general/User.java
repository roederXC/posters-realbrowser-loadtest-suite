package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;

import static com.codeborne.selenide.Selenide.$;

/**
 * User (menu) component.
 *
 * @author Xceptance Software Technologies
 */
public class User implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#show-user-menu");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }
}
