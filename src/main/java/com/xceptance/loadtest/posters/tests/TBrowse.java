package com.xceptance.loadtest.posters.tests;

import com.xceptance.loadtest.api.tests.LoadTestCase;
import com.xceptance.loadtest.posters.model.pages.CategoryPage;
import com.xceptance.loadtest.posters.model.pages.Homepage;
import com.xceptance.loadtest.posters.model.pages.ProductDetailPage;

public class TBrowse extends LoadTestCase
{
	/**
	 * Just execute a search and check the result as well as see a 
	 * product. It uses a test data file.
	 */
    public void test()
    {
    	// loads the homepage, data needed is taking from the properties automatically
    	// using the Context as well as the attached configuration.
        Homepage homepage = new Homepage();
        homepage.open();
    	
        CategoryPage topCategoryPage = homepage.navigation.clickTopCategory();

        CategoryPage categoryPage = topCategoryPage.navigation.clickCategory();

        categoryPage.clickProduct();
    }
}
