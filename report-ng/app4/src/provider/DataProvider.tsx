import React, { createContext, useContext, useState, useEffect, type ReactNode } from 'react';

import {ExecutionAggregate} from "./report-model/report_pb.ts";

const ProtobufContext = createContext<ProtobufContextType | undefined>(undefined);

interface Props {
    children: ReactNode;
}

// export interface ProtobufMessage<T> {
//     decode(reader: Uint8Array, length?: number): T
// }

export interface ProtobufContextType {
    protoData: ExecutionAggregate | null;
    isLoading: boolean;
    error: Error | null;
}

export const DataProvider: React.FC<Props> = ({ children }) => {
    const [protoData, setProtoData] = useState<ExecutionAggregate | null>(null);
    const [isLoading, setIsLoading] = useState<boolean>(true);
    const [error, setError] = useState<Error | null>(null);

    // function getFile(path: string): Promise<Response> {
    //     return fetch(path, {
    //         method: "GET",
    //     });
    // }
    //
    // async function responseToProtoMessage<T>(response: Response, protobufMessageType: ProtobufMessage<T>) {
    //     const arrayBuffer = await response.arrayBuffer();
    //     return  protobufMessageType.decode(new Uint8Array(arrayBuffer));
    // }

    useEffect(() => {
        async function loadBinaryData() {
            try {
                // 1. Nur noch die binären Daten laden
                const response = await fetch("model/execution");
                if (!response.ok) throw new Error(`HTTP Error: ${response.status}`);

                const arrayBuffer = await response.arrayBuffer();

                // 2. Direkt das generierte Model zum Dekodieren nutzen
                const decodedMessage = ExecutionAggregate.decode(new Uint8Array(arrayBuffer));
                console.table(decodedMessage);
                // // 3. In ein Plain-Object umwandeln (für React State empfohlen)
                // const dataObject = ExecutionAggregate.toObject(decodedMessage, {
                //     longs: Number,
                //     enums: String,
                //     defaults: true, // Optional: füllt Standardwerte auf
                // });

                setProtoData(decodedMessage);
            } catch (err) {
                setError(err instanceof Error ? err : new Error("Unknown error"));
            } finally {
                setIsLoading(false);
            }
        }

        loadBinaryData();
    }, []);

    return (
        <ProtobufContext.Provider value={{ protoData, isLoading, error }}>
            {children}
        </ProtobufContext.Provider>
    );

}

export const useProtobuf = () => {
    const context = useContext(ProtobufContext);
    if (!context) throw new Error('useProtobuf must be used within ProtobufProvider');
    return context;
};
