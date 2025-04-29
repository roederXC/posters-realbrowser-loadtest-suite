package com.xceptance.loadtest.posters.tests;

import com.xceptance.loadtest.api.tests.LoadTestCase;
import com.xceptance.loadtest.posters.pages.Homepage;

public class TVisit extends LoadTestCase
{
	/**
     * Single click visitor. The visitor opens the homepage and will not do any
     * interaction.
     */
    public void test()
    {
        // Loads the homepage and leave immediately
    	Homepage.open();
    }
}
