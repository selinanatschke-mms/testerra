import { Duration } from "luxon";

export function formatDuration(value: number | string): string {
    const ms =
        typeof value === "string" ? Number.parseInt(value, 10) : value;

    const d = Duration.fromMillis(ms).shiftTo(
        "days",
        "hours",
        "minutes",
        "seconds"
    );

    const parts = [
        d.days ? `${Math.floor(d.days)}d` : null,
        d.hours ? `${Math.floor(d.hours)}h` : null,
        d.minutes ? `${Math.floor(d.minutes)}m` : null,
        d.seconds ? `${Math.floor(d.seconds)}s` : null,
    ].filter(Boolean); // removes 0 values

    return parts.length ? parts.join(" ") : "0s";
}