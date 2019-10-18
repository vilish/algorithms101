package exercise.challenges.arrayAndStrings;

import java.util.Arrays;

public class PermutationDetector {

    public boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;


        return sort(str1).equals(sort(str2));
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
         Arrays.sort(chars);
         return new String(chars);
    }

}
