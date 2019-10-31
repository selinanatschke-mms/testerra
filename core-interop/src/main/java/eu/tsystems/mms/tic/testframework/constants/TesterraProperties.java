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
 *     jhmr <Johannes.Maresch@t-systems.com>
 *     pele <p.lehmann@t-systems.com>
 */
/*
 * Created on 26.03.2012
 *
 * Copyright(c) 2011 - 2012 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package eu.tsystems.mms.tic.testframework.constants;

import eu.tsystems.mms.tic.testframework.common.Testerra.Properties;

/**
 * Class holding keys of all properties.
 *
 * @todo Move these Properties to {@link Properties}
 */
public final class TesterraProperties {
    /**
     * Hide default constructor.
     */
    private TesterraProperties() {
    }

    /**
     * Property to set the browser used by Selenium/ Webdriver.
     */
    public static final String BROWSER = "tt.browser";
    public static final String BROWSER_VERSION = "tt.browser.version";

    // BROWSER_SETTING syntax: browser:version
    // BROWSER_SETTING overrides BROWSER and BROWSER_VERSION
    public static final String BROWSER_SETTING = "tt.browser.setting";

    /**
     * Property Key for webdriver mode remote|local
     */
    public static final String WEBDRIVERMODE = "tt.webdriver.mode";

    /**
     * Property key of baseUrl used by Selenium.
     */
    public static final String BASEURL = "tt.baseurl";

    /**
     * Property key stating to take automatic screenshots or not.
     */
//    public static final String AUTOSCREENSHOTS = "tt.takeAutomaticScreenshot";

    public static final String LOG_LEVEL ="tt.loglevel";

    /**
     * tt. test property file.
     */
    public static final String TEST_PROPERTIES_FILE = "tt.test.properties.file";

    /**
     * Failed tests maximum number of retries.
     */
    public static final String FAILED_TESTS_MAX_RETRIES = "tt.failed.tests.max.retries";
    public static final String FAILED_TESTS_RETRY_FLAPPING = "tt.failed.tests.retry.flapping";

    /**
     * Failed tests condition: Throwable Class(~es, devided by ','.
     */
    public static final String FAILED_TESTS_IF_THROWABLE_CLASSES = "tt.failed.tests.if.throwable.classes";

    /**
     * Failed tests condition. Throwable Message(~s, devided by ',').
     */
    public static final String FAILED_TESTS_IF_THROWABLE_MESSAGES = "tt.failed.tests.if.throwable.messages";

    /**
     * WDM close windows rule.
     */
    public static final String CLOSE_WINDOWS_AFTER_TEST_METHODS = "tt.wdm.closewindows.aftertestmethods";

    /**
     * WDM close windows rule.
     */
    public static final String CLOSE_WINDOWS_ON_FAILURE = "tt.wdm.closewindows.onfailure";

    /**
     * State condition.
     */
    public static final String ON_STATE_TESTFAILED_SKIP_FOLLOWING_TESTS = "tt.on.state.testfailed.skip.following.tests";
    /**
     * State condition.
     */
    public static final String ON_STATE_TESTFAILED_SKIP_SHUTDOWN = "tt.on.state.testfailed.skip.shutdown";

    /**
     * Module source root
     */
    public static final String MODULE_SOURCE_ROOT = "tt.module.source.root";
    /**
     * tt.source.lines.prefetch
     */
    public static final String SOURCE_LINES_PREFETCH = "tt.source.lines.prefetch";
    /**
     * Guielement easy mode.
     */
    public static final String GUIELEMENT_TYPE = "tt.guielement.type";

    /*
     * Package the project is located in.
     */
    public static final String PROJECT_PACKAGE = "tt.project.package";

    /**
     * Flag for Perf Test Statistics generation.
     */
    public static final String PERF_GENERATE_STATISTICS = "tt.perf.generate.statistics";
    /**
     * Perf test thinktime.
     */
    public static final String PERF_PAGE_THINKTIME_MS = "tt.perf.page.thinktime.ms";
    /** reuse existing driver for a thread of dataprovider */
    public static final String REUSE_DATAPROVIDER_DRIVER_BY_THREAD = "tt.reuse.dataprovider.driver.by.thread";
    /** Perf test Property, used to set default values of a Load test */
    public static final String PERF_TEST = "tt.perf.test";

    public static final String DB_TIMEOUT = "tt.db.timeout";

    public static final String GUIELEMENT_CHECK_RULE = "tt.guielement.checkrule";

    public static final String SKIP_EXECUTION_WHEN_PREVIOUSLY_PASSED = "tt.skip.execution.when.previously.passed";

    public static final String BROWSER_MAXIMIZE = "tt.browser.maximize";

    public static final String WEBDRIVER_TIMEOUT_SECONDS_PAGELOAD = "webdriver.timeouts.seconds.pageload";
    public static final String WEBDRIVER_TIMEOUT_SECONDS_SCRIPT = "webdriver.timeouts.seconds.script";

    public static final String PROXY_SETTINGS_LOAD = "tt.proxy.settings.load";
    public static final String PROXY_SETTINGS_FILE = "tt.proxy.settings.file";

    public static final String LIST_TESTS = "tt.list.tests";

    public static final String WEB_TAKE_ACTION_SCREENSHOTS = "tt.web.take.action.screenshots";

    public static final String RUNCFG = "tt.runcfg";

    public static final String WATCHDOG_ENABLE = "tt.watchdog.enable";
    public static final String WATCHDOG_TIMEOUT_SECONDS = "tt.watchdog.timeout.seconds";

    /*
    failure corridor
     */
    public static final String FAILURE_CORRIDOR_ACTIVE = "tt.failure.corridor.active";
    public static final String FAILURE_CORRIDOR_ALLOWED_FAILED_TESTS = "tt.failure.corridor.allowed.failed.tests";
    public static final String FAILURE_CORRIDOR_ALLOWED_FAILED_TESTS_HIGH = "tt.failure.corridor.allowed.failed.tests.high";
    public static final String FAILURE_CORRIDOR_ALLOWED_FAILED_TESTS_MID = "tt.failure.corridor.allowed.failed.tests.mid";
    public static final String FAILURE_CORRIDOR_ALLOWED_FAILED_TESTS_LOW = "tt.failure.corridor.allowed.failed.tests.low";

    public static final String STITCH_CHROME_SCREENSHOTS = "tt.stitch.chrome.screenshots";

    public static final String DISPLAY_RESOLUTION = "tt.display.resolution";

    public static final String PAGE_FACTORY_LOOPS = "tt.page.factory.loops";
    public static final String EXECUTION_OMIT_IN_DEVELOPMENT = "tt.execution.omit.indevelopment";
}
