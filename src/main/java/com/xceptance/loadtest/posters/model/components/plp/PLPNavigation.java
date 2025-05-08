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
public class PLPNavigation implements SelenideComponent
{
    public static final String LOCATOR = "#pagination-bottom";

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

    public ElementsCollection getAvailablePageLinks()
    {
        return locate().$$(".page-item:not(.disabled) .page-link:not(.active)");
    }

    public SelenideElement getRandomAvailablePageLink()
    {
        SelenideElement pagelink = SelenideUtil.chooseRandomly(getAvailablePageLinks(), 1);

        return pagelink;
    }
}
