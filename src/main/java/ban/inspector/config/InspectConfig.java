package ban.inspector.config;

public interface InspectConfig {

    default void addBanWordInspector(BanWordFactory factory) {}
    default void addExceptWordInspector(ExceptWordFactory factory) {}
}
