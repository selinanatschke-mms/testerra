/*
 * Testerra
 *
 * (C) 2026, Selina Natschke, Deutsche Telekom MMS GmbH, Deutsche Telekom AG
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

import { useSearchParams } from "react-router-dom";
import { StatusService } from "../model/status-service";
import type { ResultStatus } from "../model/status-service";
import * as React from "react";
import {useReportData} from "../provider/DataProvider";
import {ClassName, classNameConverter} from "../utils/classNameConverter";

export type FilterType = "status" | "class";

export type FilterValueMap = {
    status: ResultStatus[];
    class: string[];
};

type FilterDef<K extends FilterType> = {
    filterType: string;
    // URL -> value
    parse: (raw: string | null) => FilterValueMap[K] | undefined;
    // value -> URL string (or null -> remove)
    convertToURLString: (value: FilterValueMap[K]) => string | null;
};

export const FILTERS: { [K in FilterType]: FilterDef<K> } = {
    status: {
        filterType: "status",
        parse: (statusParam) => {
            return statusParam
            ? statusParam
                .split("~")
                .map(statusKey => StatusService.getStatusByKey(statusKey))
                .filter(Boolean) as ResultStatus[]
            : [];
        },
        convertToURLString: (statuses) => {
            if (!statuses.length) return null;
            const value = statuses
                .map(s => StatusService.get(s)?.key)
                .filter(Boolean)
                .join("~");
            return value || null;
        },
    },

    class: {
        filterType: "class",
        parse: (classParam) => {
            return classParam
            ? classParam.split("~") as string[]
            : []
        },
        convertToURLString: (classes) => (classes.length > 0 ? classes.join("~") : null),
    }
};

export type FiltersState = Partial<FilterValueMap>;     // Partial because not every filter has to be set always

export function useTestListFilters() {
    const {executionMngr} = useReportData();

    let classMenuItems: string[] = []

    if (executionMngr) {
        const execStatistics = executionMngr.getExecutionStatistics();

        classMenuItems = [...execStatistics.classStatistics
            .map((classStat) => classNameConverter(classStat.classIdentifier, ClassName.simpleName))
            .sort((a, b) => a.localeCompare(b)
            )]
    }

    const statusMenuItems = StatusService.getRelevantStatuses();

    const [configurationMethodsChecked, setConfigurationMethodsChecked] = React.useState(false);
    const [searchParams, setSearchParams] = useSearchParams();

    // read filters from URL when searchParam changes (useMemo)
    const filters: FiltersState = React.useMemo(() => {
        const updatedFilters: FiltersState = {};
        (Object.keys(FILTERS) as FilterType[]).forEach((filterType) => {
            const filterDefinition = FILTERS[filterType];
            const parsedFilter = filterDefinition.parse(searchParams.get(filterDefinition.filterType));

            // if filter for this type is set, add values to newFilters
            if (parsedFilter !== undefined) {
                (updatedFilters as any)[filterType] = parsedFilter;     // "as any" necessary because TS does not know, that "status" gets "ResultStatus[]" and "class" gets "string[]"
            }
        });
        return updatedFilters;
    }, [searchParams]);

    // helper: update URL
    const setFilter = <T extends FilterType>(filter: T, updatedFilter: FilterValueMap[T]) => {
        const filterDefinition = FILTERS[filter];
        const params = new URLSearchParams(searchParams);
        const convertedFilter = filterDefinition.convertToURLString(updatedFilter);

        if (convertedFilter === null) params.delete(filterDefinition.filterType);
        else params.set(filterDefinition.filterType, convertedFilter);

        setSearchParams(params);
    };

    const clearAll = () => {
        const params = new URLSearchParams(searchParams);
        (Object.keys(FILTERS) as FilterType[]).forEach((type) => {
            params.delete(FILTERS[type].filterType);
        });
        setSearchParams(params);
    };

    const handleConfigurationMethodsChecked = (event: React.ChangeEvent<HTMLInputElement>) => {
        setConfigurationMethodsChecked(event.target.checked);
    };

    // generic remove function (for arrays and strings)
    const handleDelete = (filter: FilterType, filterToRemove?: string | ResultStatus) => {
        // multiple-value filters (arrays; remove = only the one that should be removed is removed)
        if (filter === "status" || filter === "class") {
            const currentFilters = (filters[filter] ?? []) as any[];
            const updatedFilters = currentFilters.filter(filter => filter !== filterToRemove);
            setFilter(filter as any, updatedFilters as any);
            return;
        }

        // single-value filters (remove = delete param)
        setFilter(filter as any, "" as any);
    };

    return {
        statusMenuItems,
        classMenuItems,
        filters,
        configurationMethodsChecked,
        setFilter,
        handleConfigurationMethodsChecked,
        handleDelete,
        clearAll,
    };
}
