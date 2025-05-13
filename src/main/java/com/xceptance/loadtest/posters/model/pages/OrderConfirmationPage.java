package com.xceptance.loadtest.posters.model.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.xceptance.loadtest.posters.model.components.checkout.ProgressIndicator;


/**
 * Representation of the checkout page.
 *
 * @author Xceptance Software Technologies
 */
public class OrderConfirmationPage extends GeneralPage
{
    public ProgressIndicator progressIndicator = new ProgressIndicator();

    public static final String LOCATOR = "#confirmation-row";

    @Override
    public void validate()
    {
        super.validate();
        progressIndicator.validate();
        Selenide.$(LOCATOR).should(Condition.exist);
    }

    @Override
    public boolean is()
    {
        return progressIndicator.exists() && $(LOCATOR).exists();
    }
}
