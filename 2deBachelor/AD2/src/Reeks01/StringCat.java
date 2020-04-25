package Reeks01;

import java.util.ArrayList;
import  java.util.Random;

public class StringCat {

    private static final long SEED = 1234;

    public String generateString(int length) {
        Random rand = new Random(SEED);
        String str = new String();
        for (int i = 0; i < length; i++) {
            str += (char) ('a' + rand.nextInt('z' - 'a' + 1));
        }
        return str;
    }


    public String generateString1(int length) {
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random(SEED);
        ArrayList<String> arrayList = new ArrayList<>();
        String str = new String();
        for (int i = 0; i < length; i++) {
            arrayList.add(alfabet.substring(rand.nextInt(alfabet.length())));
        }
        for(String s : arrayList){
            str += s;
        }
        return str;

    }

    public static void main(String[] args) {
        StringCat test = new StringCat();
        int length = 10000;

        Timer timer = new Timer();
        test.generateString(length);
        System.out.printf("Time for length %6d is: %f\n", length, timer.delta());

        Timer timer1 = new Timer();
        test.generateString1(length);
        System.out.printf("Time for length %6d is: %f\n", length, timer1.delta());
    }
}
