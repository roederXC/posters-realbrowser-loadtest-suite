package com.xceptance.loadtest.posters.model.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.util.Action;
import com.xceptance.loadtest.posters.model.components.plp.ProductGrid;

/**
 * Does things on a search result page
 * 
 * @author Xceptance Software Technologies
 *
 */
public class ProductListingPage extends GeneralPage
{
    public static final String LOCATOR = "#product-overview";

    public ProductGrid productgrid = new ProductGrid();

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
