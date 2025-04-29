package com.xceptance.loadtest.api.components;

import com.codeborne.selenide.SelenideElement;

/**
 * Interface for components accessed through Selenide.
 * <p>
 * Components are part of pages and provide the required functionality needed by
 * the page.
 *
 * @author Xceptance Software Technologies
 */
public interface SelenideComponent extends Component
{
    @Override
    default boolean exists()
    {
        return locate().exists();
    }

    /**
     * Locates the component at the current page.
     *
     * @return A SelenideElement representing the component
     */
    SelenideElement locate();

    /**
     * Validates existence of the component at the current page.
     * </p>
     * Will break if existence validation fails.
     */
    void validate();
}
