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

export function useTestListFilters() {
    const statusMenuItems = StatusService.getRelevantStatuses();

    const classMenuItems: { value: string, label: string }[] = [{
        value: "SimpleTest2",
        label: "SimpleTest2"
    }, {value: "SimpleTest", label: "SimpleTest"}]

    const [configurationMethodsChecked, setConfigurationMethodsChecked] = React.useState(false);
    const [searchParams, setSearchParams] = useSearchParams();

    const statusParam = searchParams.get("status");
    const classParam = searchParams.get("class");

    const selectedStatuses: ResultStatus[] = statusParam
        ? statusParam
            .split("~")
            .map(statusKey => StatusService.getStatusByKey(statusKey))
            .filter(Boolean) as ResultStatus[]
        : [];
    const selectedClasses: string[] = classParam
        ? (classParam.split("~") as string[])
        : [];

    const handleStatusChange = (statuses: ResultStatus[]) => {
        const params = new URLSearchParams(searchParams);

        if (statuses.length > 0) {
            const keys = statuses.map(
                s => StatusService.get(s)?.key
            ).filter(Boolean);

            params.set("status", keys.join("~"));
        } else {
            params.delete("status");
        }

        setSearchParams(params);
    };

    const handleClassChange = (classes: string[]) => {
        const params = new URLSearchParams(searchParams);

        if (classes.length > 0) {
            params.set("class", classes.join("~"));
        } else {
            params.delete("class");
        }

        setSearchParams(params);
    };

    const handleConfigurationMethodsChecked = (value: any) => {
        setConfigurationMethodsChecked(value);
    };

    const handleDelete = (value: string | ResultStatus, type: "status" | "class") => {
        setSearchParams(prev => {
            const params = new URLSearchParams(prev);

            if (type === "status") {
                const updated = selectedStatuses.filter(s => s !== value);
                if (updated.length > 0) {
                    const keys = updated
                        .map(s => StatusService.get(s)?.key)
                        .filter(Boolean);
                    params.set("status", keys.join("~"));
                } else {
                    params.delete("status");
                }
            }

            if (type === "class") {
                const updated = selectedClasses.filter(c => c !== value);
                if (updated.length > 0) {
                    params.set("class", updated.join("~"));
                } else {
                    params.delete("class");
                }
            }

            return params;
        });
    };

    const handleClearAllClick = () => {
        const params = new URLSearchParams(searchParams);
        params.delete("status");
        params.delete("class");
        setSearchParams(params);
    }

    return {
        statusMenuItems,
        classMenuItems,
        selectedStatuses,
        selectedClasses,
        configurationMethodsChecked,
        handleStatusChange,
        handleClassChange,
        handleConfigurationMethodsChecked,
        handleDelete,
        handleClearAllClick,
    };
}
