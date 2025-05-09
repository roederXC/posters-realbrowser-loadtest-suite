package com.xceptance.loadtest.posters.model.components.checkout;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;

import static com.codeborne.selenide.Selenide.$;

/**
 * Address Form component in Checkout with all related actions.
 *
 * @author Xceptance Software Technologies
 */
public class AddressForm implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#form-add-del-addr");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

//  public void fillJobName()
//  {
//      Context.get().startAction("CheckoutFillJobName", "JS");
//      $("#job").should(exist).sendKeys("Job Name " + RandomStringUtils.randomAlphabetic(5));
//  }
//
//  public void fillPONumber()
//  {
//      Context.get().startAction("CheckoutFillPONumber");
//      $("#po").should(exist).sendKeys("PO Number " + RandomStringUtils.randomAlphabetic(5));
//  }
//
//  public void fillContactInformation(String fullName, String mobilePhoneNumber)
//  {
//      $("#full-name").should(exist).scrollTo().shouldBe(visible).sendKeys(fullName);
//      $("#phone-guest").should(exist).sendKeys(mobilePhoneNumber);
//
//      // Screenshot
//      Context.get().startAction("CheckoutFillContactInformation", "JS");
//  }
}
