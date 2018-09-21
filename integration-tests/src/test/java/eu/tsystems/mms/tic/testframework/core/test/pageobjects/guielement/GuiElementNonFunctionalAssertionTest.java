/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann <p.lehmann@t-systems.com>
 *     pele <p.lehmann@t-systems.com>
 */
package eu.tsystems.mms.tic.testframework.core.test.pageobjects.guielement;

import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.layout.Layout;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by matz on 03.11.2015.
 */
public abstract class GuiElementNonFunctionalAssertionTest extends GuiElementWaiterTest {

    @Test
    public void testT1_GuiElement_NonFunctionalAssertLayout() throws Exception {
        GuiElement e1 = getGuiElementBy(By.id("1"));
        GuiElement e2 = getGuiElementBy(By.id("11"));
        boolean exceptionWasThrown = false;
        try {
            e1.nonFunctionalAssert.assertLayout(Layout.inner().sameRight(e2, 0));
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT2_GuiElement_nonFunctionalAssertIsPresent() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsPresent();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT3N_GuiElement_nonFunctionalAssertIsNotPresent() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsNotPresent();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT4_GuiElement_nonFunctionalAssertIsPresentFast() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsPresentFast();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT5N_GuiElement_nonFunctionalAssertIsNotPresentFast() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsNotPresentFast();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT6_GuiElement_nonFunctionalAssertIsDisplayed() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsDisplayed();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT7N_GuiElement_nonFunctionalAssertIsNotDisplayed() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsNotDisplayed();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT8_GuiElement_nonFunctionalAssertIsDisplayedFromWebElement() {
        boolean exceptionWasThrown = false;
        try {
           getDisplayedElement().nonFunctionalAssert.assertIsDisplayedFromWebElement();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT9N_GuiElement_nonFunctionalAssertIsNotDisplayedFromWebElement() {
        boolean exceptionWasThrown = false;
        try {
            getDisplayedElement().nonFunctionalAssert.assertIsNotDisplayedFromWebElement();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT10_GuiElement_nonFunctionalAssertIsSelectable() {
        boolean exceptionWasThrown = false;
        try {
            getSelectableElement().nonFunctionalAssert.assertIsSelectable();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT11N_GuiElement_nonFunctionalAssertIsNotSelectable() {
        boolean exceptionWasThrown = false;
        try {
            getSelectableElement().nonFunctionalAssert.assertIsNotSelectable();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT12_GuiElement_nonFunctionalAssertIsSelected() {
        boolean exceptionWasThrown = false;
        try {
            GuiElement g = getSelectableElement();
            g.select(true);
            g.nonFunctionalAssert.assertIsSelected();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT13N_GuiElement_nonFunctionalAssertIsNotSelected() {
        boolean exceptionWasThrown = false;
        try {
            GuiElement g = getSelectableElement();
            g.select(true);
            g.nonFunctionalAssert.assertIsNotSelected();
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT14_GuiElement_nonFunctionalAssertText() {
        boolean exceptionWasThrown = false;
        try {
             getElementWithText().nonFunctionalAssert.assertText("Open again");
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT15N_GuiElement_nonFunctionalAssertText() {
        boolean exceptionWasThrown = false;
        try {
            getElementWithText().nonFunctionalAssert.assertText("Peter");
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT16_GuiElement_nonFunctionalContainsText() {
        boolean exceptionWasThrown = false;
        try {
            getElementWithText().nonFunctionalAssert.assertContainsText("Open");
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT17N_GuiElement_nonFunctionalContainsText() {
        boolean exceptionWasThrown = false;
        try {
            getElementWithText().nonFunctionalAssert.assertContainsText("Pete");
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }

    @Test
    public void testT18_GuiElement_nonFunctionalAssertAttributeIsPresent() {
        boolean exceptionWasThrown = false;
        try {
            getElementWithAttribute().nonFunctionalAssert.assertContainsText("Open");
        } catch (AssertionError e) {
            exceptionWasThrown = true;
            logger.error("Thrown Error", e);
        }
        Assert.assertFalse(exceptionWasThrown, "Assertion is thrown");
    }
}