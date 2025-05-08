package com.xceptance.loadtest.posters.model.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.util.Action;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.components.plp.PLPNavigation;
import com.xceptance.loadtest.posters.model.components.plp.ProductGrid;

/**
 * Does things on a search result page
 * 
 * @author Xceptance Software Technologies
 *
 */
public class ProductListingPage extends GeneralPage
{
    public ProductGrid productgrid = new ProductGrid();

    public PLPNavigation plpNavigation = new PLPNavigation();

    public ProductDetailPage clickProduct()
	{
        ProductDetailPage pdp = new ProductDetailPage();

        Action.run("ClickProduct", () ->
        {
            SelenideElement productLink = productgrid.getRandomProductLink();

            productLink.should(Condition.exist).scrollTo().shouldBe(Condition.visible);

            productLink.click();

            pdp.validate();
        });

        return pdp;
	}

    public void paging()
    {
        if (plpNavigation.exists() && Context.configuration().displayMoreProbability.random())
        {
            plpNavigation.getRandomAvailablePageLink().scrollTo().shouldBe(Condition.visible).click();
        }
    }

    @Override
    public void validate()
    {
        super.validate();
        productgrid.validate();
    }

    @Override
    public boolean is()
    {
        super.is();
        return productgrid.exists();
    }
}
