package com.xceptance.loadtest.api.pages;

/**
 * Standard methods to identify pages.
 *
 * @author Xceptance Software Technologies
 */
public interface PageInterface
{
    /**
     * Validates the current page and it's type.
     */
    void validate();

    /**
     * Checks if the current page is the expected one, i.e. the one conforming to
     * the page object's type.
     *
     * @return True if it is the expected page, false otherwise.
     */
    boolean is();
}
