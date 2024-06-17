package ban.inspector.config;

import ban.inspector.utils.BanWordUtil;

public interface BanWordFactory {

    BanWordFactoryImpl.BanWordFactoryBuilder add(BanWordUtil banWordUtil);

}
