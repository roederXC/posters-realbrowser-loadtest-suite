package com.xceptance.loadtest.posters.model.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Representation of the homepage.
 *
 * @author Xceptance Software Technologies
 */
public class ProductDetailPage extends GeneralPage
{
    public static final String LOCATOR = "#main #add-to-cart-form";

    public static final String ADD_TO_CART_LOCATOR = "#btn-add-to-cart";

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

        // Check if product is available
        final SelenideElement addToCartButton = $(LOCATOR).$(ADD_TO_CART_LOCATOR);
        if (!addToCartButton.exists() || !addToCartButton.isEnabled())
        {
            return false;
        }

        // Bring add to cart button into view
        addToCartButton.should(exist).scrollIntoView(true).shouldBe(visible);

        // Click add to cart button
//        Context.get().startAction("ClickAddToCart" +
//                (StringUtils.isNotBlank(Context.get().testData.largeCartTargetItemCount) ? "#" + Context.get().testData.largeCartTargetItemCount : ""));
//        addToCartButton.click();

        // There is a new (?) confirmation message now, but it gets removed because a page load happens
        // Validate product was added to cart
        //$(LOCATOR).$(".alert-success").as("Toast success message").should(exist).shouldBe(visible);

        return true;
    }
}
