package com.xceptance.loadtest.posters.model.components.cart;

import com.codeborne.selenide.*;
import com.xceptance.loadtest.api.components.SelenideComponent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

/**
 * Cart table on cart page.
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
        $("input[name='remove-item'][data-pid*='" + sku + "']").should(exist);
    }

    public void validateItemWithSkuNotExists(String sku)
    {
        $("input[name='remove-item'][data-pid*='" + sku + "']").shouldNot(exist);
    }

    public SelenideElement getLineItemsOptions()
    {
        return locate().$(".cart-items-options");
    }

    public ElementsCollection getItems()
    {
        return locate().$$(ITEMS_LOCATOR);
    }


//    public void clickRemoveItem(SelenideElement lineItem)
//    {
//        String sku = lineItem.should(exist).getAttribute("data-pid");
//
//        Context.get().startAction("ClickRemoveLineItem");
//        lineItem.$(".c-product-info__remove-product").should(exist).scrollTo().shouldBe(visible).click();
//
//        modalDialog.confirm();
//
//        validateItemWithSkuNotExists(sku);
//    }
//
//    public boolean updateItem(SelenideElement lineItem, Integer globalMaxQty)
//    {
//        String currQtyStr = lineItem.$(".c-product-quantity__input").should(exist).scrollTo().shouldBe(visible).getAttribute("value");
//        String maxQtyStr = lineItem.$(".c-product-quantity__input").getAttribute("data-max-orderable-qty");
//        String dataUnitStr = lineItem.$(".c-product-quantity__input").getAttribute("data-unit");
//
//        if(currQtyStr == null || maxQtyStr == null || dataUnitStr == null)
//        {
//            // Can not update element, missing information
//            return false;
//        }
//
//        int currQty, dataUnit;
//        double maxQty;
//        try
//        {
//            currQty = Integer.parseInt(currQtyStr);
//            maxQty = Double.parseDouble(maxQtyStr);
//            dataUnit = Integer.parseInt(dataUnitStr);
//        }
//        catch (NumberFormatException nfe)
//        {
//            // Ignored
//            return false;
//        }
//
//        // Adhere to global max quantity limit if defined
//        if(globalMaxQty != null)
//        {
//            maxQty = Math.min(maxQty, globalMaxQty);
//        }
//
//        // Note:
//        // - We can NOT decrease the quantity to zero.
//        // - There is a max quantity amount we need to consider.
//        // - There are data units we need to consider, e.g. quantity needs to be changed in steps of X.
//        // - We assume the currently selected quantity adheres to the given data unit.
//
//        boolean decrease = (currQty > dataUnit) && XltRandom.nextBoolean();
//
//        if(!decrease && (maxQty - currQty) < dataUnit)
//        {
//            // Cannot increase
//            return false;
//        }
//
//        int newQty;
//        if(decrease)
//        {
//            int factor = Math.max(1, (int)Math.floor((double)currQty / dataUnit));
//            newQty = currQty - XltRandom.nextInt(1, factor) * dataUnit;
//        }
//        else
//        {
//            int factor = Math.max(1, (int)Math.floor((maxQty - currQty) / dataUnit));
//            newQty = currQty + XltRandom.nextInt(1, factor) * dataUnit;
//        }
//
//        Context.get().startAction((decrease ? "Decrease" : "Increase") + "LineItemQuantity" /*+ newQty*/);
//        lineItem.$(".c-product-quantity__input").setValue(
//                SetValueOptions.withText(String.valueOf(newQty)).usingMethod(SetValueMethod.JS));
//
//        // Note: We can not validate the change, because the value does only update after a page reload
//
//        return true;
//    }
}
