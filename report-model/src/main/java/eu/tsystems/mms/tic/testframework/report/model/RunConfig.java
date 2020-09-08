// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * Protobuf type {@code data.RunConfig}
 */
public  final class RunConfig extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:data.RunConfig)
    RunConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RunConfig.newBuilder() to construct.
  private RunConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RunConfig() {
    runcfg_ = "";
    reportName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RunConfig();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RunConfig(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            runcfg_ = s;
            break;
          }
          case 18: {
            eu.tsystems.mms.tic.testframework.report.model.BuildInformation.Builder subBuilder = null;
            if (buildInformation_ != null) {
              subBuilder = buildInformation_.toBuilder();
            }
            buildInformation_ = input.readMessage(eu.tsystems.mms.tic.testframework.report.model.BuildInformation.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(buildInformation_);
              buildInformation_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            reportName_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_RunConfig_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_RunConfig_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            eu.tsystems.mms.tic.testframework.report.model.RunConfig.class, eu.tsystems.mms.tic.testframework.report.model.RunConfig.Builder.class);
  }

  public static final int RUNCFG_FIELD_NUMBER = 1;
  private volatile java.lang.Object runcfg_;
  /**
   * <code>string runcfg = 1;</code>
   * @return The runcfg.
   */
  public java.lang.String getRuncfg() {
    java.lang.Object ref = runcfg_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      runcfg_ = s;
      return s;
    }
  }
  /**
   * <code>string runcfg = 1;</code>
   * @return The bytes for runcfg.
   */
  public com.google.protobuf.ByteString
      getRuncfgBytes() {
    java.lang.Object ref = runcfg_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      runcfg_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BUILD_INFORMATION_FIELD_NUMBER = 2;
  private eu.tsystems.mms.tic.testframework.report.model.BuildInformation buildInformation_;
  /**
   * <code>.data.BuildInformation build_information = 2;</code>
   * @return Whether the buildInformation field is set.
   */
  public boolean hasBuildInformation() {
    return buildInformation_ != null;
  }
  /**
   * <code>.data.BuildInformation build_information = 2;</code>
   * @return The buildInformation.
   */
  public eu.tsystems.mms.tic.testframework.report.model.BuildInformation getBuildInformation() {
    return buildInformation_ == null ? eu.tsystems.mms.tic.testframework.report.model.BuildInformation.getDefaultInstance() : buildInformation_;
  }
  /**
   * <code>.data.BuildInformation build_information = 2;</code>
   */
  public eu.tsystems.mms.tic.testframework.report.model.BuildInformationOrBuilder getBuildInformationOrBuilder() {
    return getBuildInformation();
  }

  public static final int REPORT_NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object reportName_;
  /**
   * <code>string report_name = 3;</code>
   * @return The reportName.
   */
  public java.lang.String getReportName() {
    java.lang.Object ref = reportName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reportName_ = s;
      return s;
    }
  }
  /**
   * <code>string report_name = 3;</code>
   * @return The bytes for reportName.
   */
  public com.google.protobuf.ByteString
      getReportNameBytes() {
    java.lang.Object ref = reportName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reportName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRuncfgBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, runcfg_);
    }
    if (buildInformation_ != null) {
      output.writeMessage(2, getBuildInformation());
    }
    if (!getReportNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, reportName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRuncfgBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, runcfg_);
    }
    if (buildInformation_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getBuildInformation());
    }
    if (!getReportNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, reportName_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof eu.tsystems.mms.tic.testframework.report.model.RunConfig)) {
      return super.equals(obj);
    }
    eu.tsystems.mms.tic.testframework.report.model.RunConfig other = (eu.tsystems.mms.tic.testframework.report.model.RunConfig) obj;

    if (!getRuncfg()
        .equals(other.getRuncfg())) return false;
    if (hasBuildInformation() != other.hasBuildInformation()) return false;
    if (hasBuildInformation()) {
      if (!getBuildInformation()
          .equals(other.getBuildInformation())) return false;
    }
    if (!getReportName()
        .equals(other.getReportName())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RUNCFG_FIELD_NUMBER;
    hash = (53 * hash) + getRuncfg().hashCode();
    if (hasBuildInformation()) {
      hash = (37 * hash) + BUILD_INFORMATION_FIELD_NUMBER;
      hash = (53 * hash) + getBuildInformation().hashCode();
    }
    hash = (37 * hash) + REPORT_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getReportName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(eu.tsystems.mms.tic.testframework.report.model.RunConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code data.RunConfig}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:data.RunConfig)
      eu.tsystems.mms.tic.testframework.report.model.RunConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_RunConfig_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_RunConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              eu.tsystems.mms.tic.testframework.report.model.RunConfig.class, eu.tsystems.mms.tic.testframework.report.model.RunConfig.Builder.class);
    }

    // Construct using eu.tsystems.mms.tic.testframework.report.model.RunConfig.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      runcfg_ = "";

      if (buildInformationBuilder_ == null) {
        buildInformation_ = null;
      } else {
        buildInformation_ = null;
        buildInformationBuilder_ = null;
      }
      reportName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_RunConfig_descriptor;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.RunConfig getDefaultInstanceForType() {
      return eu.tsystems.mms.tic.testframework.report.model.RunConfig.getDefaultInstance();
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.RunConfig build() {
      eu.tsystems.mms.tic.testframework.report.model.RunConfig result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.RunConfig buildPartial() {
      eu.tsystems.mms.tic.testframework.report.model.RunConfig result = new eu.tsystems.mms.tic.testframework.report.model.RunConfig(this);
      result.runcfg_ = runcfg_;
      if (buildInformationBuilder_ == null) {
        result.buildInformation_ = buildInformation_;
      } else {
        result.buildInformation_ = buildInformationBuilder_.build();
      }
      result.reportName_ = reportName_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof eu.tsystems.mms.tic.testframework.report.model.RunConfig) {
        return mergeFrom((eu.tsystems.mms.tic.testframework.report.model.RunConfig)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(eu.tsystems.mms.tic.testframework.report.model.RunConfig other) {
      if (other == eu.tsystems.mms.tic.testframework.report.model.RunConfig.getDefaultInstance()) return this;
      if (!other.getRuncfg().isEmpty()) {
        runcfg_ = other.runcfg_;
        onChanged();
      }
      if (other.hasBuildInformation()) {
        mergeBuildInformation(other.getBuildInformation());
      }
      if (!other.getReportName().isEmpty()) {
        reportName_ = other.reportName_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      eu.tsystems.mms.tic.testframework.report.model.RunConfig parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (eu.tsystems.mms.tic.testframework.report.model.RunConfig) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object runcfg_ = "";
    /**
     * <code>string runcfg = 1;</code>
     * @return The runcfg.
     */
    public java.lang.String getRuncfg() {
      java.lang.Object ref = runcfg_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        runcfg_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string runcfg = 1;</code>
     * @return The bytes for runcfg.
     */
    public com.google.protobuf.ByteString
        getRuncfgBytes() {
      java.lang.Object ref = runcfg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        runcfg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string runcfg = 1;</code>
     * @param value The runcfg to set.
     * @return This builder for chaining.
     */
    public Builder setRuncfg(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      runcfg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string runcfg = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearRuncfg() {
      
      runcfg_ = getDefaultInstance().getRuncfg();
      onChanged();
      return this;
    }
    /**
     * <code>string runcfg = 1;</code>
     * @param value The bytes for runcfg to set.
     * @return This builder for chaining.
     */
    public Builder setRuncfgBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      runcfg_ = value;
      onChanged();
      return this;
    }

    private eu.tsystems.mms.tic.testframework.report.model.BuildInformation buildInformation_;
    private com.google.protobuf.SingleFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.BuildInformation, eu.tsystems.mms.tic.testframework.report.model.BuildInformation.Builder, eu.tsystems.mms.tic.testframework.report.model.BuildInformationOrBuilder> buildInformationBuilder_;
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     * @return Whether the buildInformation field is set.
     */
    public boolean hasBuildInformation() {
      return buildInformationBuilder_ != null || buildInformation_ != null;
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     * @return The buildInformation.
     */
    public eu.tsystems.mms.tic.testframework.report.model.BuildInformation getBuildInformation() {
      if (buildInformationBuilder_ == null) {
        return buildInformation_ == null ? eu.tsystems.mms.tic.testframework.report.model.BuildInformation.getDefaultInstance() : buildInformation_;
      } else {
        return buildInformationBuilder_.getMessage();
      }
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    public Builder setBuildInformation(eu.tsystems.mms.tic.testframework.report.model.BuildInformation value) {
      if (buildInformationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        buildInformation_ = value;
        onChanged();
      } else {
        buildInformationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    public Builder setBuildInformation(
        eu.tsystems.mms.tic.testframework.report.model.BuildInformation.Builder builderForValue) {
      if (buildInformationBuilder_ == null) {
        buildInformation_ = builderForValue.build();
        onChanged();
      } else {
        buildInformationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    public Builder mergeBuildInformation(eu.tsystems.mms.tic.testframework.report.model.BuildInformation value) {
      if (buildInformationBuilder_ == null) {
        if (buildInformation_ != null) {
          buildInformation_ =
            eu.tsystems.mms.tic.testframework.report.model.BuildInformation.newBuilder(buildInformation_).mergeFrom(value).buildPartial();
        } else {
          buildInformation_ = value;
        }
        onChanged();
      } else {
        buildInformationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    public Builder clearBuildInformation() {
      if (buildInformationBuilder_ == null) {
        buildInformation_ = null;
        onChanged();
      } else {
        buildInformation_ = null;
        buildInformationBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.BuildInformation.Builder getBuildInformationBuilder() {
      
      onChanged();
      return getBuildInformationFieldBuilder().getBuilder();
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.BuildInformationOrBuilder getBuildInformationOrBuilder() {
      if (buildInformationBuilder_ != null) {
        return buildInformationBuilder_.getMessageOrBuilder();
      } else {
        return buildInformation_ == null ?
            eu.tsystems.mms.tic.testframework.report.model.BuildInformation.getDefaultInstance() : buildInformation_;
      }
    }
    /**
     * <code>.data.BuildInformation build_information = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.BuildInformation, eu.tsystems.mms.tic.testframework.report.model.BuildInformation.Builder, eu.tsystems.mms.tic.testframework.report.model.BuildInformationOrBuilder> 
        getBuildInformationFieldBuilder() {
      if (buildInformationBuilder_ == null) {
        buildInformationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            eu.tsystems.mms.tic.testframework.report.model.BuildInformation, eu.tsystems.mms.tic.testframework.report.model.BuildInformation.Builder, eu.tsystems.mms.tic.testframework.report.model.BuildInformationOrBuilder>(
                getBuildInformation(),
                getParentForChildren(),
                isClean());
        buildInformation_ = null;
      }
      return buildInformationBuilder_;
    }

    private java.lang.Object reportName_ = "";
    /**
     * <code>string report_name = 3;</code>
     * @return The reportName.
     */
    public java.lang.String getReportName() {
      java.lang.Object ref = reportName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reportName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string report_name = 3;</code>
     * @return The bytes for reportName.
     */
    public com.google.protobuf.ByteString
        getReportNameBytes() {
      java.lang.Object ref = reportName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reportName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string report_name = 3;</code>
     * @param value The reportName to set.
     * @return This builder for chaining.
     */
    public Builder setReportName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reportName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string report_name = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearReportName() {
      
      reportName_ = getDefaultInstance().getReportName();
      onChanged();
      return this;
    }
    /**
     * <code>string report_name = 3;</code>
     * @param value The bytes for reportName to set.
     * @return This builder for chaining.
     */
    public Builder setReportNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reportName_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:data.RunConfig)
  }

  // @@protoc_insertion_point(class_scope:data.RunConfig)
  private static final eu.tsystems.mms.tic.testframework.report.model.RunConfig DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new eu.tsystems.mms.tic.testframework.report.model.RunConfig();
  }

  public static eu.tsystems.mms.tic.testframework.report.model.RunConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RunConfig>
      PARSER = new com.google.protobuf.AbstractParser<RunConfig>() {
    @java.lang.Override
    public RunConfig parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RunConfig(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RunConfig> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RunConfig> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.RunConfig getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

