package com.xceptance.loadtest.posters.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.xceptance.loadtest.api.util.Action;

/**
 * Contains everything doable on all page types.
 * 
 * @author rschwietzke
 */
public class GeneralPage 
{
	public static void search(final String phrase, final String expectedCount)
	{
		Action.run("Search", () ->
		{
			// enter phrase
			$("#header-search-form .form-control").sendKeys(phrase);

			// send search, this is our page load
			$("#header-search-button").click();

			// verify count
			$("#total-product-count").should(Condition.exactText(expectedCount));
		});
	}

    public static void switchToUs()
    {
        Action.run("SwitchToUS", () ->
        {
            $("#show-locale-menu").hover();
            $("#locale-menu [href*='US']").click();

            // verify count
            $("#show-locale-menu").should(Condition.exactText("en-US"));
        });
    }

    public static void switchToDe()
    {
        Action.run("SwitchToDE", () ->
        {

            $("#show-locale-menu").hover();
            $("#locale-menu [href*='DE']").click();

            // verify count
            $("#show-locale-menu").should(Condition.exactText("de-DE"));
        });
    }
}
