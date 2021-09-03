package eu.tsystems.mms.tic.testframework.common;

public interface IPropertyManager {
    default void setTestLocalProperty(IProperties property, Object value) {
        setTestLocalProperty(property.toString(), value);
    }
    void setTestLocalProperty(String key, Object value);

    default void setSystemProperty(IProperties property, Object value) {
        setSystemProperty(property.toString(), value);
    }
    void setSystemProperty(String key, Object value);

    default void removeSystemProperty(IProperties property) {
        removeSystemProperty(property.toString());
    }
    void removeSystemProperty(String key);

    default void removeTestLocalProperty(IProperties property) {
        removeTestLocalProperty(property.toString());
    }
    void removeTestLocalProperty(String key);

    /**
     * @return TRUE if the properties file has been loaded
     */
    boolean loadProperties(String resourceFile);

    default void getProperty(IProperties property) {
        getProperty(property.toString());
    }

    default String getProperty(String key) {
        return getProperty(key, null);
    }

    default void getProperty(IProperties property, Object defaultValue) {
        getProperty(property.toString(), defaultValue);
    }
    String getProperty(String key, Object defaultValue);

    default void getDoubleProperty(IProperties property, Object defaultValue) {
        getDoubleProperty(property.toString(), defaultValue);
    }
    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    double getDoubleProperty(String key, Object defaultValue);

    default void getDoubleProperty(IProperties property) {
        getDoubleProperty(property.toString());
    }
    /**
     * Gets the value of the property identified by its key.
     *
     * @param key key of the property
     *
     * @return property value or -1 if value cannot be parsed or is not set.
     */
    default double getDoubleProperty(String key) {
        return getDoubleProperty(key, -1);
    }

    default void getLongProperty(IProperties property, Object defaultValue) {
        getLongProperty(property.toString(), defaultValue);
    }
    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    long getLongProperty(String key, Object defaultValue);

    default void getLongProperty(IProperties property) {
        getLongProperty(property.toString());
    }
    /**
     * Gets the value of the property identified by its key.
     *
     * @param key key of the property
     *
     * @return property value or -1 if value cannot be parsed or is not set.
     */
    default long getLongProperty(String key) {
        return getLongProperty(key, -1);
    }

    default void getBooleanProperty(IProperties property, Object defaultValue) {
        getBooleanProperty(property.toString(), defaultValue);
    }
    /**
     * Get boolean property.
     *
     * @param key true or false.
     *
     * @return boolean property value or default false, if property is not set
     *
     * @see java.lang.Boolean#parseBoolean(String)
     */
    default boolean getBooleanProperty(String key) {
        return getBooleanProperty(key, false);
    }

    default void getBooleanProperty(IProperties property) {
        getLongProperty(property.toString());
    }
    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    boolean getBooleanProperty(final String key, Object defaultValue);
}
