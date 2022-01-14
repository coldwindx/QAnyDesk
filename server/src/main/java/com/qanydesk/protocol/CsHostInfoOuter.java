// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CsHostInfo.proto

package com.qanydesk.protocol;

public final class CsHostInfoOuter {
  private CsHostInfoOuter() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CsHostInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:CsHostInfo.CsHostInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string cpuId = 1;</code>
     * @return The cpuId.
     */
    java.lang.String getCpuId();
    /**
     * <code>string cpuId = 1;</code>
     * @return The bytes for cpuId.
     */
    com.google.protobuf.ByteString
        getCpuIdBytes();

    /**
     * <pre>
     * 硬盘ID
     * </pre>
     *
     * <code>string deviceId = 2;</code>
     * @return The deviceId.
     */
    java.lang.String getDeviceId();
    /**
     * <pre>
     * 硬盘ID
     * </pre>
     *
     * <code>string deviceId = 2;</code>
     * @return The bytes for deviceId.
     */
    com.google.protobuf.ByteString
        getDeviceIdBytes();

    /**
     * <code>string macAddress = 3;</code>
     * @return The macAddress.
     */
    java.lang.String getMacAddress();
    /**
     * <code>string macAddress = 3;</code>
     * @return The bytes for macAddress.
     */
    com.google.protobuf.ByteString
        getMacAddressBytes();

    /**
     * <code>int32 active = 4;</code>
     * @return The active.
     */
    int getActive();
  }
  /**
   * <pre>
   * C++的头文件名取第一个message名
   * </pre>
   *
   * Protobuf type {@code CsHostInfo.CsHostInfo}
   */
  public static final class CsHostInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:CsHostInfo.CsHostInfo)
      CsHostInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CsHostInfo.newBuilder() to construct.
    private CsHostInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CsHostInfo() {
      cpuId_ = "";
      deviceId_ = "";
      macAddress_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new CsHostInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private CsHostInfo(
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

              cpuId_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              deviceId_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              macAddress_ = s;
              break;
            }
            case 32: {

              active_ = input.readInt32();
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
      return com.qanydesk.protocol.CsHostInfoOuter.internal_static_CsHostInfo_CsHostInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.qanydesk.protocol.CsHostInfoOuter.internal_static_CsHostInfo_CsHostInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.class, com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.Builder.class);
    }

    public static final int CPUID_FIELD_NUMBER = 1;
    private volatile java.lang.Object cpuId_;
    /**
     * <code>string cpuId = 1;</code>
     * @return The cpuId.
     */
    @java.lang.Override
    public java.lang.String getCpuId() {
      java.lang.Object ref = cpuId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cpuId_ = s;
        return s;
      }
    }
    /**
     * <code>string cpuId = 1;</code>
     * @return The bytes for cpuId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getCpuIdBytes() {
      java.lang.Object ref = cpuId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cpuId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DEVICEID_FIELD_NUMBER = 2;
    private volatile java.lang.Object deviceId_;
    /**
     * <pre>
     * 硬盘ID
     * </pre>
     *
     * <code>string deviceId = 2;</code>
     * @return The deviceId.
     */
    @java.lang.Override
    public java.lang.String getDeviceId() {
      java.lang.Object ref = deviceId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        deviceId_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 硬盘ID
     * </pre>
     *
     * <code>string deviceId = 2;</code>
     * @return The bytes for deviceId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getDeviceIdBytes() {
      java.lang.Object ref = deviceId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        deviceId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MACADDRESS_FIELD_NUMBER = 3;
    private volatile java.lang.Object macAddress_;
    /**
     * <code>string macAddress = 3;</code>
     * @return The macAddress.
     */
    @java.lang.Override
    public java.lang.String getMacAddress() {
      java.lang.Object ref = macAddress_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        macAddress_ = s;
        return s;
      }
    }
    /**
     * <code>string macAddress = 3;</code>
     * @return The bytes for macAddress.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMacAddressBytes() {
      java.lang.Object ref = macAddress_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        macAddress_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ACTIVE_FIELD_NUMBER = 4;
    private int active_;
    /**
     * <code>int32 active = 4;</code>
     * @return The active.
     */
    @java.lang.Override
    public int getActive() {
      return active_;
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
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cpuId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cpuId_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(deviceId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, deviceId_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(macAddress_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, macAddress_);
      }
      if (active_ != 0) {
        output.writeInt32(4, active_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(cpuId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cpuId_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(deviceId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, deviceId_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(macAddress_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, macAddress_);
      }
      if (active_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, active_);
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
      if (!(obj instanceof com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo)) {
        return super.equals(obj);
      }
      com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo other = (com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo) obj;

      if (!getCpuId()
          .equals(other.getCpuId())) return false;
      if (!getDeviceId()
          .equals(other.getDeviceId())) return false;
      if (!getMacAddress()
          .equals(other.getMacAddress())) return false;
      if (getActive()
          != other.getActive()) return false;
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
      hash = (37 * hash) + CPUID_FIELD_NUMBER;
      hash = (53 * hash) + getCpuId().hashCode();
      hash = (37 * hash) + DEVICEID_FIELD_NUMBER;
      hash = (53 * hash) + getDeviceId().hashCode();
      hash = (37 * hash) + MACADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getMacAddress().hashCode();
      hash = (37 * hash) + ACTIVE_FIELD_NUMBER;
      hash = (53 * hash) + getActive();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parseFrom(
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
    public static Builder newBuilder(com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo prototype) {
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
     * <pre>
     * C++的头文件名取第一个message名
     * </pre>
     *
     * Protobuf type {@code CsHostInfo.CsHostInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:CsHostInfo.CsHostInfo)
        com.qanydesk.protocol.CsHostInfoOuter.CsHostInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.qanydesk.protocol.CsHostInfoOuter.internal_static_CsHostInfo_CsHostInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.qanydesk.protocol.CsHostInfoOuter.internal_static_CsHostInfo_CsHostInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.class, com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.Builder.class);
      }

      // Construct using com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.newBuilder()
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
        cpuId_ = "";

        deviceId_ = "";

        macAddress_ = "";

        active_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.qanydesk.protocol.CsHostInfoOuter.internal_static_CsHostInfo_CsHostInfo_descriptor;
      }

      @java.lang.Override
      public com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo getDefaultInstanceForType() {
        return com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.getDefaultInstance();
      }

      @java.lang.Override
      public com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo build() {
        com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo buildPartial() {
        com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo result = new com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo(this);
        result.cpuId_ = cpuId_;
        result.deviceId_ = deviceId_;
        result.macAddress_ = macAddress_;
        result.active_ = active_;
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
        if (other instanceof com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo) {
          return mergeFrom((com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo other) {
        if (other == com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo.getDefaultInstance()) return this;
        if (!other.getCpuId().isEmpty()) {
          cpuId_ = other.cpuId_;
          onChanged();
        }
        if (!other.getDeviceId().isEmpty()) {
          deviceId_ = other.deviceId_;
          onChanged();
        }
        if (!other.getMacAddress().isEmpty()) {
          macAddress_ = other.macAddress_;
          onChanged();
        }
        if (other.getActive() != 0) {
          setActive(other.getActive());
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
        com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object cpuId_ = "";
      /**
       * <code>string cpuId = 1;</code>
       * @return The cpuId.
       */
      public java.lang.String getCpuId() {
        java.lang.Object ref = cpuId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          cpuId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string cpuId = 1;</code>
       * @return The bytes for cpuId.
       */
      public com.google.protobuf.ByteString
          getCpuIdBytes() {
        java.lang.Object ref = cpuId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          cpuId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string cpuId = 1;</code>
       * @param value The cpuId to set.
       * @return This builder for chaining.
       */
      public Builder setCpuId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        cpuId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string cpuId = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearCpuId() {
        
        cpuId_ = getDefaultInstance().getCpuId();
        onChanged();
        return this;
      }
      /**
       * <code>string cpuId = 1;</code>
       * @param value The bytes for cpuId to set.
       * @return This builder for chaining.
       */
      public Builder setCpuIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        cpuId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object deviceId_ = "";
      /**
       * <pre>
       * 硬盘ID
       * </pre>
       *
       * <code>string deviceId = 2;</code>
       * @return The deviceId.
       */
      public java.lang.String getDeviceId() {
        java.lang.Object ref = deviceId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          deviceId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * 硬盘ID
       * </pre>
       *
       * <code>string deviceId = 2;</code>
       * @return The bytes for deviceId.
       */
      public com.google.protobuf.ByteString
          getDeviceIdBytes() {
        java.lang.Object ref = deviceId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          deviceId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 硬盘ID
       * </pre>
       *
       * <code>string deviceId = 2;</code>
       * @param value The deviceId to set.
       * @return This builder for chaining.
       */
      public Builder setDeviceId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        deviceId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 硬盘ID
       * </pre>
       *
       * <code>string deviceId = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearDeviceId() {
        
        deviceId_ = getDefaultInstance().getDeviceId();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 硬盘ID
       * </pre>
       *
       * <code>string deviceId = 2;</code>
       * @param value The bytes for deviceId to set.
       * @return This builder for chaining.
       */
      public Builder setDeviceIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        deviceId_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object macAddress_ = "";
      /**
       * <code>string macAddress = 3;</code>
       * @return The macAddress.
       */
      public java.lang.String getMacAddress() {
        java.lang.Object ref = macAddress_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          macAddress_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string macAddress = 3;</code>
       * @return The bytes for macAddress.
       */
      public com.google.protobuf.ByteString
          getMacAddressBytes() {
        java.lang.Object ref = macAddress_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          macAddress_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string macAddress = 3;</code>
       * @param value The macAddress to set.
       * @return This builder for chaining.
       */
      public Builder setMacAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        macAddress_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string macAddress = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearMacAddress() {
        
        macAddress_ = getDefaultInstance().getMacAddress();
        onChanged();
        return this;
      }
      /**
       * <code>string macAddress = 3;</code>
       * @param value The bytes for macAddress to set.
       * @return This builder for chaining.
       */
      public Builder setMacAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        macAddress_ = value;
        onChanged();
        return this;
      }

      private int active_ ;
      /**
       * <code>int32 active = 4;</code>
       * @return The active.
       */
      @java.lang.Override
      public int getActive() {
        return active_;
      }
      /**
       * <code>int32 active = 4;</code>
       * @param value The active to set.
       * @return This builder for chaining.
       */
      public Builder setActive(int value) {
        
        active_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 active = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearActive() {
        
        active_ = 0;
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


      // @@protoc_insertion_point(builder_scope:CsHostInfo.CsHostInfo)
    }

    // @@protoc_insertion_point(class_scope:CsHostInfo.CsHostInfo)
    private static final com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo();
    }

    public static com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CsHostInfo>
        PARSER = new com.google.protobuf.AbstractParser<CsHostInfo>() {
      @java.lang.Override
      public CsHostInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new CsHostInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<CsHostInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CsHostInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.qanydesk.protocol.CsHostInfoOuter.CsHostInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CsHostInfo_CsHostInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CsHostInfo_CsHostInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020CsHostInfo.proto\022\nCsHostInfo\"Q\n\nCsHost" +
      "Info\022\r\n\005cpuId\030\001 \001(\t\022\020\n\010deviceId\030\002 \001(\t\022\022\n" +
      "\nmacAddress\030\003 \001(\t\022\016\n\006active\030\004 \001(\005B*\n\025com" +
      ".qanydesk.protocolB\017CsHostInfoOuterH\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_CsHostInfo_CsHostInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CsHostInfo_CsHostInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CsHostInfo_CsHostInfo_descriptor,
        new java.lang.String[] { "CpuId", "DeviceId", "MacAddress", "Active", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
