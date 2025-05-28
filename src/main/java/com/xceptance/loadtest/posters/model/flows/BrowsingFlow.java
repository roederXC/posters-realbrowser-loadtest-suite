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
    GeneralPage page = new GeneralPage();

    @Override
    public void run()
    {
        int plannedRounds = Context.configuration().browseCategoriesFlow.value;

        // Execute catalog rounds
        for (int currentRound = 1; currentRound <= plannedRounds; currentRound++)
        {
            // Opens a category or a top category depending on the probability configured in
            // project.properties
            if (Context.configuration().topCategoryBrowsing.random())
            {
                page = page.navigation.clickTopCategory();
            }
            else
            {
                page = page.navigation.clickCategory();
            }
            
            // If there are more products on more pages, we try to paginate, based on
            // probability configured in project.properties
            ((CategoryPage) page).paging();
        }
    }
}