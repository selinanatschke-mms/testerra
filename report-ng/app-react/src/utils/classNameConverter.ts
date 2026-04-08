export const ClassName = {
    full: "full",
    simpleName: "simpleName",
    package: "package"
} as const;
export type ClassName = typeof ClassName[keyof typeof ClassName];

export function classNameConverter(value: string, mode: ClassName): string {
    switch (mode) {
        case ClassName.package:
            if (value.lastIndexOf('.') > 0) {
                return value.substring(0, value.lastIndexOf('.'));
            } else {
                return '';
            }
        case ClassName.simpleName:
            if (value.lastIndexOf('.') > 0) {
                return value.substring(value.lastIndexOf('.') + 1);
            }
            break;
        case ClassName.full:
            return value;
    }
    return value;
}
