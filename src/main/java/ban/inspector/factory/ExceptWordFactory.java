package ban.inspector.factory;

import ban.inspector.domain.Word;

import java.util.List;

public interface ExceptWordFactory extends WordFactory {

    List<Word> filter(String word, List<Word> banWords);
    void build();

}
