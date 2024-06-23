package ban.inspector.updater;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class WordUpdaterImpl implements WordUpdater {

    private static final Log logger = LogFactory.getLog(WordUpdater.class);


    @Override
    public void update() {
        logger.info("Checking for Word Updates");
    }

    @Override
    public List<String> getDefaultBanWords() {
        try {
            ClassPathResource resource = new ClassPathResource("static/BanWords.json");
            return new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<>() {});
        } catch (IOException e) {
            logger.error(e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<String> getDefaultExceptWords() {
        try {
            ClassPathResource resource = new ClassPathResource("static/ExceptWords.json");
            return new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<>() {});
        } catch (IOException e) {
            logger.error(e);
            return new ArrayList<>();
        }
    }

    public static class UpdateInfo {
        private final String version;
        private final List<String> words;

        public UpdateInfo(String version, List<String> words) {
            this.version = version;
            this.words = words;
        }

        public String getVersion() {
            return version;
        }

        public List<String> getWords() {
            return words;
        }
    }
}
