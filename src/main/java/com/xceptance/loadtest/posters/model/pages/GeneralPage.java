package com.xceptance.loadtest.posters.model.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.xceptance.loadtest.api.pages.PageInterface;
import com.xceptance.loadtest.api.util.Action;
import com.xceptance.loadtest.posters.model.components.general.Footer;
import com.xceptance.loadtest.posters.model.components.general.LocaleSwitcher;
import com.xceptance.loadtest.posters.model.components.general.MiniCart;
import com.xceptance.loadtest.posters.model.components.general.Navigation;
import com.xceptance.loadtest.posters.model.components.general.SearchBar;
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

    public SearchBar searchBar = new SearchBar();

    public Navigation navigation = new Navigation();

    public LocaleSwitcher localeSwitcher = new LocaleSwitcher();

    public Footer footer = new Footer();

    @Override
    public void validate()
    {
        miniCart.validate();
        user.validate();
        searchBar.validate();
        navigation.validate();
        footer.validate();
        localeSwitcher.validate();
    }

    @Override
    public boolean is()
    {
        return miniCart.exists() && user.exists() && searchBar.exists() && navigation.exists() && localeSwitcher
                .exists() && footer.exists();
    }
}
