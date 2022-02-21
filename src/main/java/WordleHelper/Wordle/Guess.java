package WordleHelper.Wordle;

import WordleHelper.Word5Letters;

import java.util.*;

public class Guess {

    public GuessResult Evaluator(Word5Letters secret, Word5Letters guess) {

        List<Character> unmatchedCharsOfSecret = new ArrayList<>();
        unmatchedCharsOfSecret.addAll(secret.getChars());
        List<Character> unmatchedCharsOfGuess = new ArrayList<>();
        unmatchedCharsOfGuess.addAll(guess.getChars());

        GuessResult guessResult = new GuessResult();
        guessResult.setGuess(guess);

        regexpBuilder(unmatchedCharsOfGuess, unmatchedCharsOfSecret, guessResult);
        unmatchedBuilder(unmatchedCharsOfGuess, unmatchedCharsOfSecret, guessResult);
        completeFeedback(guess, guessResult);

        return guessResult;
    }

    public void regexpBuilder(List<Character> unmatchedCharsOfGuess, List<Character> unmatchedCharsOfSecret, GuessResult guessResult) {

        String regexp = "";

        ListIterator<Character> guessCharListIterator = unmatchedCharsOfGuess.listIterator();
        ListIterator<Character> secretCharListIterator = unmatchedCharsOfSecret.listIterator();
        int i = 0;

        while (guessCharListIterator.hasNext()) {
            Character guessChar = guessCharListIterator.next();
            Character secretChar = secretCharListIterator.next();

            if (guessChar.equals(secretChar)) {
                regexp = regexp + guessChar;
                guessResult.addFeedback(guessChar, i);
                guessCharListIterator.remove();
                secretCharListIterator.remove();
            } else {
                regexp = regexp + "[^" + guessChar + "]";
            }
            i++;
        }

        guessResult.setRegexp(regexp);
    }

    private void unmatchedBuilder(List<Character> unmatchedCharsOfGuess, List<Character> unmatchedCharsOfSecret, GuessResult guessResult) {

        Map<Character, Integer> unmatched = new HashMap<>();

        ListIterator<Character> guessCharListIterator = unmatchedCharsOfGuess.listIterator();
        ListIterator<Character> secretCharListIterator;

        while (guessCharListIterator.hasNext()) {

            Character guessChar = guessCharListIterator.next();
            secretCharListIterator = unmatchedCharsOfSecret.listIterator();

            outer:
            while (secretCharListIterator.hasNext()) {
                Character secretChar = secretCharListIterator.next();
                if (guessChar.equals(secretChar)) {

                    if (!unmatched.containsKey(guessChar)) {
                        unmatched.put(guessChar, 1);
                    } else {
                        unmatched.put(guessChar, unmatched.get(guessChar) + 1);
                    }

                    guessCharListIterator.remove();
                    secretCharListIterator.remove();
                    break outer;
                }
            }
        }

        guessResult.setUnmatched(unmatched);

    }

    private void completeFeedback(Word5Letters guess, GuessResult guessResult) {

        Map<Character, Integer> unmatched = guessResult.getUnmatched();
        Character[] feedback = guessResult.getFeedback();

        if (!unmatched.isEmpty()) {
            for (Character key : unmatched.keySet()) {
                int occurence = unmatched.get(key);
                int i = 0;

                while (occurence > 0) {
                    if (guess.getChars().get(i).equals(key) && feedback[i].equals('-')) {
                        guessResult.addFeedback('*', i);
                        occurence--;
                    }
                    i++;
                }
            }
        }
    }

}
