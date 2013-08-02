package de.gbeine.java.hamcrest.matcher;

import static de.gbeine.java.hamcrest.matcher.ElementMatcher.elementIs;
import static de.gbeine.java.hamcrest.matcher.ElementMatcher.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import de.gbeine.java.hamcrest.Element;

public class ListContainmentMatcherTest {

    @Test
    public void testElementMatcher() {
        Element e = new Element("e", "test");

        assertThat(e, elementIs("e"));
    }

    @Test
    public void testListContainsElement() {
        List<Element> elementList = new ArrayList<Element>();
        elementList.add(new Element("el1", "test1"));
        elementList.add(new Element("el2", "test2"));

        List<ElementMatcher> elementMatchers = new ArrayList<ElementMatcher>();
        elementMatchers.add(elementIs("el1"));
        elementMatchers.add(elementIs("el2", "test2"));
        assertThat(elementList, hasItems(elementMatchers));
    }

}
