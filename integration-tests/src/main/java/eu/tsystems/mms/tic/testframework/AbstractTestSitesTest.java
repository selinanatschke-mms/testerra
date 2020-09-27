/*
 * Testerra
 *
 * (C) 2020, Eric Kubenka, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
 *
 * Deutsche Telekom AG and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package eu.tsystems.mms.tic.testframework;

import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.core.server.Server;
import eu.tsystems.mms.tic.testframework.core.testpage.TestPage;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.pageobjects.PageObjectFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinderFactory;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.UiElementFinder;
import eu.tsystems.mms.tic.testframework.testing.PageFactoryProvider;
import eu.tsystems.mms.tic.testframework.testing.UiElementFinderProvider;
import eu.tsystems.mms.tic.testframework.utils.FileUtils;
import java.lang.reflect.Method;
import java.net.BindException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Abstract test class for tests based on static test site resources
 */
public abstract class AbstractTestSitesTest extends AbstractWebDriverTest implements Loggable, PageFactoryProvider, UiElementFinderProvider {
    private UiElementFinder uiElementFinder;
    protected static Server server = new Server(FileUtils.getResourceFile("testsites"));

    @BeforeTest(alwaysRun = true)
    public void setUp() throws Exception {

        System.setProperty(UiElement.Properties.ELEMENT_TIMEOUT_SECONDS.toString(), "3");
        log().info("Set " + UiElement.Properties.ELEMENT_TIMEOUT_SECONDS.toString() + "=" + UiElement.Properties.ELEMENT_TIMEOUT_SECONDS.asString());

        try {
            server.start(80);
        } catch (BindException e) {
            log().warn("Use already running WebServer: " + e.getMessage());
        }
    }

    @BeforeMethod()
    public void visitTestPage(Method method) {
        visitTestPage(getWebDriver());
    }

    /**
     * Open a custom Webdriver session with the default test page.
     *
     * @param driver {@link WebDriver} Current webDriver Instance
     */
    public synchronized void visitTestPage(WebDriver driver) {
        visitTestPage(driver, getTestPage());
    }

    /**
     * Open a custom Webdriver session with the default test page.
     *
     * @param driver   {@link WebDriver} Current Instance
     * @param testPage {@link TestPage} page to open
     */
    public synchronized void visitTestPage(WebDriver driver, TestPage testPage) {
        if (!driver.getCurrentUrl().contains(testPage.getPath())) {
            String baseUrl = String.format("http://localhost:%d/%s", server.getPort(), testPage.getPath());
            driver.get(baseUrl);
        }
    }

    protected TestPage getTestPage() {
        return TestPage.INPUT_TEST_PAGE;
    }

    @Override
    public PageObjectFactory getPageFactory() {
        return Testerra.injector.getInstance(PageObjectFactory.class);
    }

    @Override
    public UiElementFinder getUiElementFinder() {
        if (uiElementFinder == null) {
            UiElementFinderFactory factory = Testerra.injector.getInstance(UiElementFinderFactory.class);
            uiElementFinder = factory.createWithWebDriver(getWebDriver());
        }
        return uiElementFinder;
    }
}
