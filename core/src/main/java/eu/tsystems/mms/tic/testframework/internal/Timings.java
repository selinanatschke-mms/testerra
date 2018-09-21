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
package eu.tsystems.mms.tic.testframework.internal;

import eu.tsystems.mms.tic.testframework.exceptions.FennecSystemException;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pele on 24.08.2015.
 */
public final class Timings {

    public static final long LARGE_LIMIT = 2000;

    public static final Map<Integer, Long> TIMING_GUIELEMENT_FIND = new ConcurrentHashMap<Integer, Long>();
    public static final Map<Integer, Long> TIMING_GUIELEMENT_FIND_WITH_PARENT = new ConcurrentHashMap<Integer, Long>();

    private static int findCounter = 0;

    public static synchronized int raiseFindCounter() {
        findCounter++;
        return findCounter;
    }

    private static File createGraph(String title, String filename, Map<Integer, Long> map) {
        XYSeriesCollection collection = new XYSeriesCollection();
        XYSeries series = new XYSeries("find()s");
        for (Integer integer : map.keySet()) {
            series.add(integer, map.get(integer));
        }
        collection.addSeries(series);
        JFreeChart chart = GraphGenerator.createLineChart(collection, title, "#", "ms", GraphGenerator.DataType.NUMBER);
        try {
            File file = GraphGenerator.saveGraphAsJPEG(chart, "graph/" + filename + ".jpg", 800, 400);
            return file;
        } catch (IOException e) {
            throw new FennecSystemException("Could not save graph", e);
        }
    }

    public static List<String> getLargeFindTimings() {
        List<String> out = new ArrayList<String>();
        out.add("Large timings > " + LARGE_LIMIT + " ms:");
        out.add("");
        for (Integer key : TIMING_GUIELEMENT_FIND.keySet()) {
            Long value = TIMING_GUIELEMENT_FIND.get(key);
            if (value > LARGE_LIMIT) {
                out.add("#" + key + " : " + value + " ms");
            }
        }
        out.add("");
        return out;
    }

    public static File createGuiElementFindTimingsGraph() {
        /*
        Create chart
         */
        return createGraph("find()s", "timingsFind", TIMING_GUIELEMENT_FIND);
    }

    public static String createGuiElementFindTimingsInfo() {
        int size = TIMING_GUIELEMENT_FIND.size();
        if (size == 0) {
            return "Nothing measured";
        }
        String msg = size + " GuiElement find()s: ";
        msg = calc(TIMING_GUIELEMENT_FIND, size, msg);
        return msg;
    }

    public static File createGuiElementFindWithParentTimingsGraph() {
        /*
        Create chart
         */
        return createGraph("find()s with parent", "timingsFindParent", TIMING_GUIELEMENT_FIND_WITH_PARENT);
    }

    public static String createGuiElementFindWithParentTimingsInfo() {
        int size = TIMING_GUIELEMENT_FIND_WITH_PARENT.size();
        if (size == 0) {
            return "Nothing measured";
        }
        String msg = size + " GuiElement find()s with parent: ";
        msg = calc(TIMING_GUIELEMENT_FIND_WITH_PARENT, size, msg);
        return msg;
    }

    private static String calc(Map<Integer, Long> map, int size, String msg) {
        long min = -1;
        long max = -1;
        long sum = 0;
        for (Integer key : map.keySet()) {
            if (min == -1) {
                min = map.get(key);
            }
            Long l = map.get(key);
            sum += l;
            if (l < min) {
                min = l;
            }
            if (l > max) {
                max = l;
            }
        }
        long mid = sum / size;

        msg += min + " ms < [" + mid + " ms] < " + max + " ms";
        return msg;
    }

    public static boolean hasGuiElementFindInfo() {
        return TIMING_GUIELEMENT_FIND.size() > 0 || TIMING_GUIELEMENT_FIND_WITH_PARENT.size() > 0;
    }
}