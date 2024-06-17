package ban.inspector.config;

import ban.inspector.utils.ExceptWordUtil;

public interface ExceptWordFactory {

    ExceptWordFactoryImpl.ExceptWordFactoryBuilder add(ExceptWordUtil exceptWordUtil);

}
