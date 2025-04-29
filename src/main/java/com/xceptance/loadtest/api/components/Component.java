package com.xceptance.loadtest.api.components;

import org.junit.Assert;

/**
 * Component interface.
 * <p>
 * Components are part of pages and provide the required functionality needed by the page.
 *
 * @author Xceptance Software Technologies
 */
public interface Component
{
    /**
     * Check if this component exists on the page.
     *
     * @return true if this component exists
     */
    boolean exists();

    /**
     * Methods to make stack traces containing the failing component.
     *
     * @param message message to print
     * @param value   value to check
     */
    default void assertTrue(final String message, final boolean value)
    {
        Assert.assertTrue(message, value);
    }

    /**
     * Methods to make stack traces containing the failing component.
     *
     * @param message message to print
     * @param value   value to check
     */
    default void assertFalse(final String message, final boolean value)
    {
        Assert.assertFalse(message, value);
    }
}