package com.xceptance.loadtest.posters.model.flows;

import com.xceptance.loadtest.api.flow.Flow;
import com.xceptance.loadtest.api.util.Context;
import com.xceptance.loadtest.posters.model.pages.CategoryPage;
import com.xceptance.loadtest.posters.model.pages.GeneralPage;

/**
 * Browses the catalog via categories and executes PLP operations.
 * 
 * @author Xceptance Software Technologies
 */
public class BrowsingFlow implements Flow
{
    GeneralPage page;
    CategoryPage categoryPage;
    
    public BrowsingFlow(GeneralPage page)
    {
        super();
        this.page = page;
    }

    public BrowsingFlow()
    {
        page = new GeneralPage();
    }

    @Override
    public void run()
    {
        int plannedRounds = Context.configuration().browseCategoriesFlow.value;
        int currentRound = 1;

        // Execute catalog rounds
        do
        {
            // opens a category or a top category depending on the probability configured in
            // project.properties
            if (Context.configuration().topCategoryBrowsing.random())
            {
                categoryPage = (CategoryPage) (page = page.navigation.clickTopCategory());
            }
            else
            {
                categoryPage = (CategoryPage) (page = page.navigation.clickCategory());
            }
            
            // If there are more products on more pages, we try to paginate, based on
            // probability configured in project.properties
            categoryPage.paging();
            
            currentRound++;
        }
        while (currentRound <= plannedRounds);
    }
}