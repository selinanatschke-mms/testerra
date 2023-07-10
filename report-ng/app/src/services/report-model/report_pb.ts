/* eslint-disable */
import _m0 from "protobufjs/minimal";
import {
  ClassContext,
  ExecutionContext,
  MethodContext,
  SessionContext,
  SuiteContext,
  TestContext,
} from "./framework_pb";

export interface ExecutionAggregate {
  executionContext?: ExecutionContext;
  suiteContexts?: { [key: string]: SuiteContext };
  testContexts?: { [key: string]: TestContext };
  classContexts?: { [key: string]: ClassContext };
  methodContexts?: { [key: string]: MethodContext };
  sessionContexts?: { [key: string]: SessionContext };
}

export interface ExecutionAggregate_SuiteContextsEntry {
  key: string;
  value?: SuiteContext;
}

export interface ExecutionAggregate_TestContextsEntry {
  key: string;
  value?: TestContext;
}

export interface ExecutionAggregate_ClassContextsEntry {
  key: string;
  value?: ClassContext;
}

export interface ExecutionAggregate_MethodContextsEntry {
  key: string;
  value?: MethodContext;
}

export interface ExecutionAggregate_SessionContextsEntry {
  key: string;
  value?: SessionContext;
}

function createBaseExecutionAggregate(): ExecutionAggregate {
  return {
    executionContext: undefined,
    suiteContexts: {},
    testContexts: {},
    classContexts: {},
    methodContexts: {},
    sessionContexts: {},
  };
}

export const ExecutionAggregate = {
  encode(message: ExecutionAggregate, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.executionContext !== undefined) {
      ExecutionContext.encode(message.executionContext, writer.uint32(10).fork()).ldelim();
    }
    Object.entries(message.suiteContexts || {}).forEach(([key, value]) => {
      ExecutionAggregate_SuiteContextsEntry.encode({ key: key as any, value }, writer.uint32(18).fork()).ldelim();
    });
    Object.entries(message.testContexts || {}).forEach(([key, value]) => {
      ExecutionAggregate_TestContextsEntry.encode({ key: key as any, value }, writer.uint32(26).fork()).ldelim();
    });
    Object.entries(message.classContexts || {}).forEach(([key, value]) => {
      ExecutionAggregate_ClassContextsEntry.encode({ key: key as any, value }, writer.uint32(34).fork()).ldelim();
    });
    Object.entries(message.methodContexts || {}).forEach(([key, value]) => {
      ExecutionAggregate_MethodContextsEntry.encode({ key: key as any, value }, writer.uint32(42).fork()).ldelim();
    });
    Object.entries(message.sessionContexts || {}).forEach(([key, value]) => {
      ExecutionAggregate_SessionContextsEntry.encode({ key: key as any, value }, writer.uint32(50).fork()).ldelim();
    });
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ExecutionAggregate {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExecutionAggregate();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.executionContext = ExecutionContext.decode(reader, reader.uint32());
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          const entry2 = ExecutionAggregate_SuiteContextsEntry.decode(reader, reader.uint32());
          if (entry2.value !== undefined) {
            message.suiteContexts![entry2.key] = entry2.value;
          }
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          const entry3 = ExecutionAggregate_TestContextsEntry.decode(reader, reader.uint32());
          if (entry3.value !== undefined) {
            message.testContexts![entry3.key] = entry3.value;
          }
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          const entry4 = ExecutionAggregate_ClassContextsEntry.decode(reader, reader.uint32());
          if (entry4.value !== undefined) {
            message.classContexts![entry4.key] = entry4.value;
          }
          continue;
        case 5:
          if (tag !== 42) {
            break;
          }

          const entry5 = ExecutionAggregate_MethodContextsEntry.decode(reader, reader.uint32());
          if (entry5.value !== undefined) {
            message.methodContexts![entry5.key] = entry5.value;
          }
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          const entry6 = ExecutionAggregate_SessionContextsEntry.decode(reader, reader.uint32());
          if (entry6.value !== undefined) {
            message.sessionContexts![entry6.key] = entry6.value;
          }
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },
};

function createBaseExecutionAggregate_SuiteContextsEntry(): ExecutionAggregate_SuiteContextsEntry {
  return { key: "", value: undefined };
}

export const ExecutionAggregate_SuiteContextsEntry = {
  encode(message: ExecutionAggregate_SuiteContextsEntry, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.key !== "") {
      writer.uint32(10).string(message.key);
    }
    if (message.value !== undefined) {
      SuiteContext.encode(message.value, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ExecutionAggregate_SuiteContextsEntry {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExecutionAggregate_SuiteContextsEntry();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.key = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.value = SuiteContext.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },
};

function createBaseExecutionAggregate_TestContextsEntry(): ExecutionAggregate_TestContextsEntry {
  return { key: "", value: undefined };
}

export const ExecutionAggregate_TestContextsEntry = {
  encode(message: ExecutionAggregate_TestContextsEntry, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.key !== "") {
      writer.uint32(10).string(message.key);
    }
    if (message.value !== undefined) {
      TestContext.encode(message.value, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ExecutionAggregate_TestContextsEntry {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExecutionAggregate_TestContextsEntry();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.key = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.value = TestContext.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },
};

function createBaseExecutionAggregate_ClassContextsEntry(): ExecutionAggregate_ClassContextsEntry {
  return { key: "", value: undefined };
}

export const ExecutionAggregate_ClassContextsEntry = {
  encode(message: ExecutionAggregate_ClassContextsEntry, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.key !== "") {
      writer.uint32(10).string(message.key);
    }
    if (message.value !== undefined) {
      ClassContext.encode(message.value, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ExecutionAggregate_ClassContextsEntry {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExecutionAggregate_ClassContextsEntry();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.key = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.value = ClassContext.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },
};

function createBaseExecutionAggregate_MethodContextsEntry(): ExecutionAggregate_MethodContextsEntry {
  return { key: "", value: undefined };
}

export const ExecutionAggregate_MethodContextsEntry = {
  encode(message: ExecutionAggregate_MethodContextsEntry, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.key !== "") {
      writer.uint32(10).string(message.key);
    }
    if (message.value !== undefined) {
      MethodContext.encode(message.value, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ExecutionAggregate_MethodContextsEntry {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExecutionAggregate_MethodContextsEntry();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.key = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.value = MethodContext.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },
};

function createBaseExecutionAggregate_SessionContextsEntry(): ExecutionAggregate_SessionContextsEntry {
  return { key: "", value: undefined };
}

export const ExecutionAggregate_SessionContextsEntry = {
  encode(message: ExecutionAggregate_SessionContextsEntry, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.key !== "") {
      writer.uint32(10).string(message.key);
    }
    if (message.value !== undefined) {
      SessionContext.encode(message.value, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ExecutionAggregate_SessionContextsEntry {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExecutionAggregate_SessionContextsEntry();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.key = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.value = SessionContext.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },
};
