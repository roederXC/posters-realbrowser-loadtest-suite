package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.Component;

import static com.codeborne.selenide.Selenide.$;

/**
 * User (menu) component.
 *
 * @author Xceptance Software Technologies
 */
public class User implements Component
{
    @Override
    public SelenideElement locate()
    {
        return $("#show-user-menu");
    }

    @Override
    public void validateComponent()
    {
        locate().should(Condition.exist);
    }
}
