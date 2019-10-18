package datastructures;

public class MaxDigit {

    public static int make(int N) {

        String sb = String.valueOf(N);

        StringBuilder s = new StringBuilder(sb);

        if (N == 0) {
            s.insert(0, 5);
        } else if (N > 0) {
            for (int i = 0; i < s.length(); i++) {

                char val = s.charAt(i);
//                System.out.println(Integer.parseInt(String.valueOf(val)) < 5);

                if (Integer.parseInt(String.valueOf(val)) < 5) {
                    //insert here
                    s.insert(i, 5);
                    break;
                }


            }
        } else {
            for (int i = 1; i < s.length(); i++) {

                char val = s.charAt(i);
                System.out.println(Integer.parseInt(String.valueOf(val)) > 5);

                if (Integer.parseInt(String.valueOf(val)) > 5) {
                    //insert here
                    s.insert(i, 5);
                    break;
                }

            }
        }

        if (s.length() == sb.length()) {
            s.append(5);
        }


        System.out.println(s);

        return Integer.parseInt(s.toString());

    }

    public static void main(String abc[]) {

        int count = make(-111);
        System.out.println(count);

    }


}
