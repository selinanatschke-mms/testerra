/*
 * Testerra
 *
 * (C) 2020,  Peter Lehmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
 package eu.tsystems.mms.tic.testframework.report.hooks;

import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.report.model.context.report.DefaultReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IConfigureCallBack;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public final class ConfigMethodHook extends Hook {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigMethodHook.class);

    private ConfigMethodHook() {
        
    }

    public static void runHook(IConfigureCallBack callBack, ITestResult testResult) {

        final ITestNGMethod testNGMethod = testResult.getMethod();

        if (DefaultReport.Properties.LIST_TESTS.asBool()) {
            LOGGER.info("Dry run for list tests: " + testNGMethod.getMethodName());
            // no sleep
            return;
        }
        if (Testerra.Properties.DRY_RUN.asBool()) {
            if (dryRun(testNGMethod)) {
                return;
            }
        }

        // default behaviour
        callBack.runConfigurationMethod(testResult);
    }

}
