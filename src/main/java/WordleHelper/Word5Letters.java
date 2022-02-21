package WordleHelper;

import java.util.ArrayList;
import java.util.List;

public class Word5Letters {

    private String word;
    private List<Character> chars = new ArrayList<>();

    public Word5Letters(String word) {
        this.word = word;

        for (char aChar : word.toCharArray()) {
            chars.add((Character) aChar);
        }
    }

    public String getWord() {
        return word;
    }

    public List<Character> getChars() {
        return chars;
    }
}
