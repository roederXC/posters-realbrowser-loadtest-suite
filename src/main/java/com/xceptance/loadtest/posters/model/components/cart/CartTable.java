package com.xceptance.loadtest.posters.model.components.cart;

import com.codeborne.selenide.*;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Context;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Cart table on cart page with a bundle of helpers and actions.
 *
 * @author Xceptance Software Technologies
 */
public class CartTable implements SelenideComponent
{
    public static final String LOCATOR = "#cart-overview-table";

    public static final String ITEMS_LOCATOR = "tr.js-cart-product";


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

    public void validateHasItems()
    {
        locate().$(ITEMS_LOCATOR).should(Condition.exist);
    }

    public void validateHasNoItems()
    {
        locate().$(ITEMS_LOCATOR).shouldNot(Condition.exist);
    }

    public boolean hasItems()
    {
        return locate().$(ITEMS_LOCATOR).exists();
    }

    public void validateItemWithSkuExists(String sku)
    {
        $("button.btn-remove-product[data-id*='" + sku + "']").should(exist);
    }

    public void validateItemWithSkuNotExists(String sku)
    {
        $("button.btn-remove-product[data-id*='" + sku + "']").shouldNot(exist);
    }

    public ElementsCollection getItems()
    {
        return locate().$$(ITEMS_LOCATOR);
    }

    /**
     * Removes the given item from cart in cart table.
     * 
     * @param lineItem
     */
    public void removeItem(SelenideElement lineItem)
    {
        String sku = lineItem.$("button.btn-remove-product[data-id]").getAttribute("data-id");
        clickRemoveItem(lineItem);
        confirmRemove();

        validateItemWithSkuNotExists(sku);
    }

    private void clickRemoveItem(SelenideElement lineItem)
    {
        Context.startAction("ClickRemoveLineItem");
        lineItem.$("button.btn-remove-product[data-id]").should(exist).scrollTo().shouldBe(visible).click();
    }

    private void confirmRemove()
    {
        Context.startAction("ConfirmRemoveLineItem");
        $("#button-delete").should(exist).scrollTo().shouldBe(visible).click();
    }
}
