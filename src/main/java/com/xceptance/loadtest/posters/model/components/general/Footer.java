package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;

/**
 * Footer component.
 *
 * @author Xceptance Software Technologies
 */
public class Footer implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#footer");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }
}
