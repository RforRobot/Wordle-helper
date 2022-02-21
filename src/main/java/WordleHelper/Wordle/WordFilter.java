package WordleHelper.Wordle;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import WordleHelper.Word5Letters;

public class WordFilter {

    public static void main(String[] args) {

        Path path = Path.of("src/main/resources/words");
        List<Word5Letters> wordList = new ArrayList<>();

        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String word;
            Word5Letters word5Letters;

            while ((word = reader.readLine()) != null) {
                word = word.substring(0, 5);
                word5Letters = new Word5Letters(word);
                wordList.add(word5Letters);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("List loaded");

        takeAGuess(wordList);

    }

    private static void takeAGuess(List<Word5Letters> wordList) {

        Word5Letters secret = new Word5Letters("which");
        Guess guessClass = new Guess();

        Word5Letters guess = new Word5Letters("watch");
//        Word5Letters guess = takeAGuess();
        GuessResult guessResult = guessClass.Evaluator(secret, guess);

        List<Word5Letters> leftOverList = wordFilter(wordList, guessResult);

        for (Word5Letters word : leftOverList) {
            System.out.println(word.getWord());
        }
        System.out.println(leftOverList.size());
        System.out.println("Your guess:\n" + guess.getWord() + "\n");
        for (int i = 0; i < 5; i++) {
            System.out.print(guessResult.getFeedback()[i]);
        }

    }


    private static Word5Letters takeAGuess() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("GUESS");
        String guess = scanner.nextLine();
        Word5Letters guess5 = new Word5Letters(guess);
        return guess5;
    }

    // change this to private
    public static List<Word5Letters> wordFilter(List<Word5Letters> wordList, GuessResult guessResult) {

        List<Word5Letters> leftOverList = new ArrayList<>();

        Guess aGuess = new Guess();

        for (Word5Letters word : wordList) {
            if (word.getWord().matches(guessResult.getRegexp())) {
                if (Arrays.equals(guessResult.getFeedback(), aGuess.Evaluator(word, guessResult.getGuess()).getFeedback())) {
                    leftOverList.add(word);
                }
            }
        }

        return leftOverList;
    }

}
