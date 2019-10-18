package datastructures;

public class MakeAnagram {

    public static int make(String A, String B) {

        int count = 0;

        return getMissingCharCount(A, B) + getMissingCharCount(B, A);

    }

    private static int getMissingCharCount(String str1, String str2) {

        StringBuilder sb = new StringBuilder(str2);

        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            int index = sb.indexOf(String.valueOf(str1.charAt(i)));
            if (index < 0) {
                count++;
            } else {
                sb.deleteCharAt(index);
            }

        }
        return count;
    }


    public static void main(String abc[]) {

        int count = make("pear", "aapple");
        System.out.println(count);

    }


}
