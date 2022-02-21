package WordleHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordListCreator {

    public static void main(String[] args) {

        Path path = Path.of("src/main/resources/words");
        List<Word5Letters> wordList = new ArrayList<>();

        try {
            BufferedReader reader = Files.newBufferedReader(path);
            String word;
            Word5Letters word5Letters;

            while((word = reader.readLine())!=null) {
                word = word.substring(0,5);
                word5Letters = new Word5Letters(word);
                wordList.add(word5Letters);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("List loaded");

    }

}
