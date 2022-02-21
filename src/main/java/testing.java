import WordleHelper.Word5Letters;
import WordleHelper.Wordle.Guess;
import WordleHelper.Wordle.GuessResult;

import java.util.*;

public class testing {

    public static void main(String[] args) {

        String string = "joanna";

        System.out.println(string.matches(".[^c].nna"));
        System.out.println(string.matches(".[^o].nna"));

        System.out.println("" + 'a' + "[^o]");

        System.out.println("-----");

        Word5Letters watch = new Word5Letters("watch");
//        Word5Letters watch = new Word5Letters("watch");
//        Word5Letters which = new Word5Letters("which");
//        Word5Letters welch = new Word5Letters("welch");
//
//        Guess guessC = new Guess();
//
//        Character[] guessResult = guessC.Evaluator(watch,which).getFeedback();
//        Character[] guessResult1 = guessC.Evaluator(watch,welch).getFeedback();
//        Character[] guessResult2 = guessC.Evaluator(which,welch).getFeedback();
//
//
//
//        System.out.println();
//        System.out.println(Arrays.equals(guessResult,guessResult1));
//
//        System.out.println();
//        System.out.println(guessResult.equals(guessResult2));
//
//        System.out.println();
//        System.out.println(guessResult1.equals(guessResult2));


//        System.out.println(guessResult.getRegexp());
//        System.out.println(guessResult.getUnmatched().entrySet().toString());




        // System.out.println(string.contains("a"));
//        char[] chars = string.toCharArray();
//        System.out.println(String.valueOf(chars));




    }

    private static int joe(List<Character> aList) {

        ListIterator<Character> iterator = aList.listIterator();
        while (iterator.hasNext())
        {
            Character aChar = iterator.next();
            System.out.println(aChar);
            if(aChar.equals('b')) {
                iterator.remove();
            }
        }

        int a = aList.size();

        return a;
    }


}
