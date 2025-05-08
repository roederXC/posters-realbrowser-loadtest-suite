package com.xceptance.loadtest.posters.model.components.plp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.SelenideUtil;

import static com.codeborne.selenide.Selenide.$;

/**
 * Product grid component.
 *
 * @author Xceptance Software Technologies
 */
public class ProductGrid implements SelenideComponent
{
    public static final String LOCATOR = "#product-overview";

    @Override
    public SelenideElement locate()
    {
        return $(LOCATOR);
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public ElementsCollection getProductLinks()
    {
        return locate().$$(".card.product-tile > .card-body > a.btn-primary");
    }

    public SelenideElement getRandomProductLink()
    {
        SelenideElement product = SelenideUtil.chooseRandomly(getProductLinks(), 1);

        return product;
    }
}
