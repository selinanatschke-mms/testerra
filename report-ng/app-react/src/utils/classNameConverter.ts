export enum ClassName {
    full = 0,
    simpleName,
    package
}

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
