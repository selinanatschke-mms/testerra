/*
 * Testerra
 *
 * (C) 2022, Clemens Große, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
 */

package io.testerra.report.test.pretest_status.expected.failed;

import eu.tsystems.mms.tic.testframework.annotations.Fails;
import eu.tsystems.mms.tic.testframework.execution.testng.AssertCollector;
import eu.tsystems.mms.tic.testframework.report.model.context.MethodContext;
import io.testerra.report.test.AbstractTestSitesTest;
import io.testerra.report.test.pages.pretest.NonExistingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class GenerateExpectedFailedStatusInTesterraReportTest extends AbstractTestSitesTest {

    final AtomicInteger counter = new AtomicInteger(0);

//    repaired
    @Test
    @Fails(description = "not failing anymore")
    public void test_expectedFailedPassed() {
    }

//    recovered
    @Test()
    public void test_PassedAfterRetry() {
        this.counter.incrementAndGet();
        if (counter.get() == 1) {
            Assert.fail("test_FailedToPassedHistoryWithRetry");
        } else {
            Assert.assertTrue(true);
        }
    }

//    expected failed
    @Test
    @Fails(description = "failing expected")
    public void test_expectedFailed() {
        Assert.fail("No Oil.");
    }

    @Test
    @Fails(description = "collected assert failing")
    public void test_expectedFailedAssertCollector() {
        AssertCollector.fail("failed1");
        AssertCollector.fail("failed2");
        AssertCollector.assertTrue(true, "passed1");
    }

    @Test
    @Fails(description = "Page Not Found")
    public void test_expectedFailedPageNotFound() {
        PAGE_FACTORY.createPage(NonExistingPage.class, WEB_DRIVER_MANAGER.getWebDriver());
    }

    /**
     * Testerra 2 Test
     */

    public boolean expectedFailIsValid(MethodContext methodContext) {
        return true;
    }

    public boolean expectedFailIsNotValid(MethodContext methodContext) {
        return false;
    }

    @Test
    @Fails(validator = "expectedFailIsValid")
    public void test_expectedFailedWithValidator_isValid(){
        Assert.fail("Expected Fail - validator is: " + expectedFailIsValid(null));
    }

    @Test
    @Fails(validator = "expectedFailIsNotValid")
    public void test_expectedFailedWithValidator_isNotValid(){
        Assert.fail("Expected Fail - validator is: " + expectedFailIsNotValid(null));
    }
}
