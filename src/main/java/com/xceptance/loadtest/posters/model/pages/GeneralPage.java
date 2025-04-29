package com.xceptance.loadtest.posters.model.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.xceptance.loadtest.api.pages.PageInterface;
import com.xceptance.loadtest.api.util.Action;
import com.xceptance.loadtest.posters.model.components.general.Footer;
import com.xceptance.loadtest.posters.model.components.general.MiniCart;
import com.xceptance.loadtest.posters.model.components.general.Navigation;
import com.xceptance.loadtest.posters.model.components.general.User;

/**
 * Contains everything doable on general page types.
 * 
 * @author Xceptance Software Technologies
 */
public class GeneralPage implements PageInterface
{
    public MiniCart miniCart = new MiniCart();

    public User user = new User();

    public Navigation navigation = new Navigation();

    public Footer footer = new Footer();

    @Override
    public void validate()
    {
        miniCart.validateComponent();
        user.validateComponent();
        navigation.validateComponent();
        footer.validateComponent();
    }

    @Override
    public boolean is()
    {
        return miniCart.exists() && user.exists() && navigation.exists() && footer.exists();
    }

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
