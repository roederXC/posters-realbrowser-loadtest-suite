package com.xceptance.loadtest.posters.model.pages;

import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.util.Context;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import org.junit.Assert;

/**
 * Representation of the homepage.
 *
 * @author Xceptance Software Technologies
 */
public class ProductDetailPage extends GeneralPage
{
    public static final String LOCATOR = "#main #add-to-cart-form";

    public static final String ADD_TO_CART_LOCATOR = "a[id='btn-add-to-cart']";

    @Override
    public void validate()
    {
        super.validate();

        $(LOCATOR).should(exist);

        $("h3[id='product-detail-form-name'").should(exist);
    }

    @Override
    public boolean is()
    {
        return super.is() && $(LOCATOR).exists();
    }

    public boolean addToCart()
    {
        // We check the total product count in mini Cart
        int productCountBefore = miniCart.getTotalQuantity();

        // Check if product is available
        final SelenideElement addToCartButton = $(LOCATOR).$(ADD_TO_CART_LOCATOR);
        if (!addToCartButton.exists() || !addToCartButton.isEnabled())
        {
            return false;
        }

        // Click add to cart button
        Context.startAction("ClickAddToCart");
        // Bring add to cart button into view
        addToCartButton.should(exist).scrollIntoView(true).shouldBe(visible);
        // Click the Add to Cart button
        addToCartButton.click();

        // We check if new product count is higher then before and to avoid issiues caused by delays we wait for a change first
        miniCart.getTotalQuantityElement().shouldNotHave(text(productCountBefore + ""));
        Assert.assertTrue("The number of products in cart has not increased.", productCountBefore < miniCart.getTotalQuantity());

        return true;
    }
}
