package WordleHelper.Wordle;

import WordleHelper.Word5Letters;

import java.util.Map;

public class GuessResult {

    private Word5Letters guess;
    private String regexp;
    private Map<Character,Integer> unmatched;
    private Character[] feedback = {'-','-','-','-','-'};

    public Word5Letters getGuess() {
        return guess;
    }

    public void setGuess(Word5Letters guess) {
        this.guess = guess;
    }

    public void setFeedback(Character[] feedback) {
        this.feedback = feedback;
    }

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    public Map<Character, Integer> getUnmatched() {
        return unmatched;
    }

    public void setUnmatched(Map<Character, Integer> unmatched) {
        this.unmatched = unmatched;
    }

    public Character[] getFeedback() {
        return feedback;
    }

    public void addFeedback(Character aChar, int index) {
        feedback[index] = aChar;
    }
}
