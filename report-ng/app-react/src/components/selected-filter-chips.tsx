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

import type {ResultStatus} from "../model/status-service";
import {StatusService} from "../model/status-service";

import ReportChip from "../widgets/report-chip/report-chip";
import {Button, Stack} from "@mui/material";

type SelectedFiltersChipsProps = {
    selectedStatuses: ResultStatus[],
    selectedClasses: string[],
    handleDelete: (value: string | ResultStatus, type: "status" | "class") => void;
    handleClearAllClick: () => void;
}

const SelectedFiltersChips = ({
                                  selectedStatuses,
                                  selectedClasses,
                                  handleDelete,
                                  handleClearAllClick
                              }: SelectedFiltersChipsProps) => (
    <Stack direction="row" spacing={1}>
        {selectedStatuses.map((status) => {
            const statusInformation = StatusService.get(status);
            if (!statusInformation) return null;

            return (
                <ReportChip key={status} label={statusInformation.label} type="status"
                            handleDelete={() => handleDelete(status, "status")}
                />
            );
        })}
        {selectedClasses.map((rClass) => (
            <ReportChip key={rClass} label={rClass} type="class"
                        handleDelete={() => handleDelete(rClass, "class")}/>
        ))}
        {((selectedStatuses && selectedStatuses.length > 0) || (selectedClasses && selectedClasses.length > 0)) && (
            <Button variant="text" onClick={handleClearAllClick}>CLEAR ALL</Button>
        )}
    </Stack>
);

export default SelectedFiltersChips;
