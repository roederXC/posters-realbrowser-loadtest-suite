package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.Component;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

/**
 * Footer component.
 *
 * @author Xceptance Software Technologies
 */
public class Footer implements Component
{
    @Override
    public SelenideElement locate()
    {
        return $("#footer");
    }

    @Override
    public void validateComponent()
    {
        locate().should(Condition.exist);
    }
}
