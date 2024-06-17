package ban.inspector.utils;

import ban.inspector.domain.Word;

import java.util.ArrayList;
import java.util.List;

public abstract class BanWordUtil extends WordUtilImpl implements WordUtilSettings {

    public final List<Word> filter(String word) {
        String newWord = setWordForm(word);
        return useToArray(newWord);
    }

    protected abstract String setWordForm(String word);

    @Override
    public boolean setIgnoreSpace() {
        return true;
    }

    private List<Word> useToArray(String word) {
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            int txt = find(word, i, 0, setIgnoreSpace());
            if (txt != -1) {
                words.add(new Word(word.substring(i, i + txt), i));
                i += txt - 1;
            }
        }
        return words;
    }

}
