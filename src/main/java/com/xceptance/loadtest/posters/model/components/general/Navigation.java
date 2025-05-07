package com.xceptance.loadtest.posters.model.components.general;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.xceptance.loadtest.api.components.SelenideComponent;
import com.xceptance.loadtest.api.util.Action;
import com.xceptance.loadtest.api.util.SelenideUtil;
import com.xceptance.loadtest.posters.model.pages.CategoryPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Navigation component (i.e. menu bar with categories).
 *
 * @author Xceptance Software Technologies
 */
public class Navigation implements SelenideComponent
{
    @Override
    public SelenideElement locate()
    {
        return $("#header-categories");
    }

    @Override
    public void validate()
    {
        locate().should(Condition.exist);
    }

    public CategoryPage clickTopCategory()
    {
        CategoryPage topCategoryPage = new CategoryPage();

        Action.run("ClickTopCategory", () ->
        {
            ElementsCollection topCategories = $(locate()).$$("li.nav-item.dropdown");

            SelenideUtil.chooseRandomly(topCategories, 1).click();

            topCategoryPage.validate();
        });

        return topCategoryPage;
    }

    public CategoryPage clickCategory()
    {
        CategoryPage categoryPage = new CategoryPage();

        Action.run("ClickCategory", () ->
        {
            ElementsCollection topCategories = $(locate()).$$("li.nav-item.dropdown");

            SelenideElement topCategory = SelenideUtil.chooseRandomly(topCategories, 1);

            topCategory.hover();

            ElementsCollection categories = $(topCategory).$$("ul.dropdown-menu > li");

            SelenideUtil.chooseRandomly(categories, 1).click();

            categoryPage.validate();
        });

        return categoryPage;
    }
}
