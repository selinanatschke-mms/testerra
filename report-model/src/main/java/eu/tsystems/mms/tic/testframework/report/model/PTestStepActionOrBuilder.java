// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

public interface PTestStepActionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:data.PTestStepAction)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string id = 2;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string id = 2;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>int64 timestamp = 3;</code>
   * @return The timestamp.
   */
  long getTimestamp();

  /**
   * <code>repeated string screenshot_names = 4 [deprecated = true];</code>
   * @return A list containing the screenshotNames.
   */
  @java.lang.Deprecated java.util.List<java.lang.String>
      getScreenshotNamesList();
  /**
   * <code>repeated string screenshot_names = 4 [deprecated = true];</code>
   * @return The count of screenshotNames.
   */
  @java.lang.Deprecated int getScreenshotNamesCount();
  /**
   * <code>repeated string screenshot_names = 4 [deprecated = true];</code>
   * @param index The index of the element to return.
   * @return The screenshotNames at the given index.
   */
  @java.lang.Deprecated java.lang.String getScreenshotNames(int index);
  /**
   * <code>repeated string screenshot_names = 4 [deprecated = true];</code>
   * @param index The index of the value to return.
   * @return The bytes of the screenshotNames at the given index.
   */
  @java.lang.Deprecated com.google.protobuf.ByteString
      getScreenshotNamesBytes(int index);

  /**
   * <code>repeated .data.PClickPathEvent clickpath_events = 5;</code>
   */
  java.util.List<eu.tsystems.mms.tic.testframework.report.model.PClickPathEvent> 
      getClickpathEventsList();
  /**
   * <code>repeated .data.PClickPathEvent clickpath_events = 5;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.PClickPathEvent getClickpathEvents(int index);
  /**
   * <code>repeated .data.PClickPathEvent clickpath_events = 5;</code>
   */
  int getClickpathEventsCount();
  /**
   * <code>repeated .data.PClickPathEvent clickpath_events = 5;</code>
   */
  java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.PClickPathEventOrBuilder> 
      getClickpathEventsOrBuilderList();
  /**
   * <code>repeated .data.PClickPathEvent clickpath_events = 5;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.PClickPathEventOrBuilder getClickpathEventsOrBuilder(
      int index);

  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @return A list containing the screenshotIds.
   */
  java.util.List<java.lang.String>
      getScreenshotIdsList();
  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @return The count of screenshotIds.
   */
  int getScreenshotIdsCount();
  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @param index The index of the element to return.
   * @return The screenshotIds at the given index.
   */
  java.lang.String getScreenshotIds(int index);
  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the screenshotIds at the given index.
   */
  com.google.protobuf.ByteString
      getScreenshotIdsBytes(int index);
}
