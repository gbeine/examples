package de.gbeine.java.hamcrest.matcher;

import java.util.Collection;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsCollectionContaining;

import de.gbeine.java.hamcrest.Element;

public class ElementMatcher extends TypeSafeMatcher<Element> {

    private final String expectedName;
    private final String expectedValue;

    @Override
    public void describeTo(final Description pDescription) {
        pDescription.appendText("Element ").appendValue(this.expectedName);
    }

    @Override
    protected boolean matchesSafely(final Element pElement) {
        return
            this.expectedName.equals(pElement.getName()) &&
            (null == this.expectedValue || this.expectedValue.equals(pElement.getValue()));
    }

    @Factory
    public static ElementMatcher elementIs(final String pName, final String pValue) {
        return new ElementMatcher(pName, pValue);
    }

    @Factory
    public static ElementMatcher elementIs(final String pName) {
        return new ElementMatcher(pName);
    }

    @Factory
    public static Matcher<Iterable<Element>> hasItems(final Collection<ElementMatcher> elementMatchers) {
        return IsCollectionContaining.hasItems(elementMatchers.toArray( new ElementMatcher[0] ));
    }

    private ElementMatcher(final String pName, final String pValue) {
        this.expectedName = pName;
        this.expectedValue = pValue;
    }

    private ElementMatcher(final String pName) {
        this(pName, null);
    }

}
