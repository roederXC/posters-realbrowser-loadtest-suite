package com.xceptance.loadtest.posters.model.pages;

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

        Action.run("ClickCategory", () ->
        {
            productgrid.getRandomProductLink().click();

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
