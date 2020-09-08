/*
 * Testerra
 *
 * (C) 2020, Peter Lehmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
 package eu.tsystems.mms.tic.testframework.boot;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.common.TesterraCommons;
import eu.tsystems.mms.tic.testframework.hooks.ModuleHook;
import eu.tsystems.mms.tic.testframework.internal.BuildInformation;
import eu.tsystems.mms.tic.testframework.utils.StringUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Booter {

    private static final Logger LOGGER;
    private static Set<ModuleHook> MODULE_HOOKS;

    static {
        TesterraCommons.init();
        LOGGER = LoggerFactory.getLogger(Booter.class);
        // when logger is configured:
        printTesterraBanner();
        initHooks();
    }

    public static void bootOnce() {}

    /**
     * Prints testerra build information.
     */
    private static void printTesterraBanner() {
        List<String> frameworkBanner = new LinkedList<>();
        String buildVersion = "";
        List<String> bannerVersions = new LinkedList<>();

        /*
        load banner
         */
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("banner.txt");
        if (is != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.lines().forEach(frameworkBanner::add);
        } else {
            LOGGER.debug("Could not read banner");
        }

        /*
        get versions info
         */
        BuildInformation buildInformation = BuildInformation.getInstance();
        bannerVersions.add("build.java.version: " + buildInformation.buildJavaVersion);
        bannerVersions.add("build.os.name:      " + buildInformation.buildOsName);
        bannerVersions.add("build.os.arch:      " + buildInformation.buildOsArch);
        bannerVersions.add("build.os.version:   " + buildInformation.buildOsVersion);
        bannerVersions.add("build.user.name:    " + buildInformation.buildUserName);
        bannerVersions.add("build.timestamp:    " + buildInformation.buildTimestamp);

        buildVersion = buildInformation.buildVersion;

        /*
        beautify
         */
        String wall = " ° ";
        final int widthLogo = frameworkBanner.stream().mapToInt(String::length).max().getAsInt();
        frameworkBanner = frameworkBanner.stream().map(s -> s + StringUtils.repeat(" ", widthLogo - s.length())).collect(Collectors.toList());
        final int width = bannerVersions.stream().mapToInt(String::length).max().getAsInt();
        frameworkBanner = frameworkBanner.stream().map(s -> wall + StringUtils.center(s, width) + wall).collect(Collectors.toList());
        buildVersion = wall + StringUtils.center(buildVersion, width) + wall;
        bannerVersions = bannerVersions.stream().map(s -> wall + s + StringUtils.repeat(" ", width - s.length()) + wall).collect(Collectors.toList());

        /*
        print banner
         */
        String ruler = StringUtils.repeat(wall, width / wall.length() + 2);
        LOGGER.info(ruler);
        frameworkBanner.forEach(LOGGER::info);
        LOGGER.info(buildVersion);
        LOGGER.info(ruler);
        bannerVersions.forEach(LOGGER::info);
        LOGGER.info(ruler);
    }

    private static void initHooks() {
        MODULE_HOOKS = Testerra.injector.getInstance(Key.get(new TypeLiteral<Set<ModuleHook>>(){}));
        MODULE_HOOKS.forEach(moduleHook -> {
            LOGGER.debug("Calling Init Hook " + moduleHook.getClass().getSimpleName() + "...");
            moduleHook.init();
        });
    }

    public static void shutdown() {
        MODULE_HOOKS.forEach(moduleHook -> {
            LOGGER.debug("Shutting down " + moduleHook.getClass().getSimpleName());
            moduleHook.terminate();
        });
    }
}
