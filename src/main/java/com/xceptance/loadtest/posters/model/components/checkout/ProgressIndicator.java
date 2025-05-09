package com.xceptance.loadtest.posters.model.components.checkout;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;

import static com.codeborne.selenide.Selenide.$;

/**
 * Progress Indicator Bar component in Checkout.
 *
 * @author Xceptance Software Technologies
 */
public class ProgressIndicator implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#checkout-progress-indicator");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public void validateStep(int step)
    {
        locate().$(".progress-indicator.progress-" + String.valueOf(step)).should(Condition.exist);
    }
}
