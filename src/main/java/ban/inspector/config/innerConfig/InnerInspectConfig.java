package ban.inspector.config.innerConfig;

import ban.inspector.config.BanWordFactoryImpl;
import ban.inspector.config.ExceptWordFactoryImpl;
import ban.inspector.config.InspectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InnerInspectConfig {

    private final BanWordFactoryImpl banWordFactory;
    private final ExceptWordFactoryImpl exceptFactory;
    private final InspectConfig inspectConfig;

    @Autowired
    public InnerInspectConfig(BanWordFactoryImpl banWordFactory, ExceptWordFactoryImpl exceptFactory, InspectConfig inspectConfig) {
        this.banWordFactory = banWordFactory;
        this.exceptFactory = exceptFactory;
        this.inspectConfig = inspectConfig;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void onApplicationReady() {
        inspectConfig.addBanWordInspector(banWordFactory);
        inspectConfig.addExceptWordInspector(exceptFactory);
    }

    public BanWordFactoryImpl getBanWordFactory() {
        return banWordFactory;
    }

    public ExceptWordFactoryImpl getExceptFactory() {
        return exceptFactory;
    }

}
