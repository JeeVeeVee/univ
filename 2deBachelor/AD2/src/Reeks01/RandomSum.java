package Reeks01;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomSum {

    private static final int MAX = 10000;

    private static final long SEED = 1234;

    public static long sum(int start, int end, int iterations) {
        Random random = new Random(SEED);

        Map<Integer, Integer> map = new HashMap<>();
        Timer timer = new Timer();
        timer.start();
        //Populate map
        for (int i = start; i < end; i++) {
            map.put(i, random.nextInt(MAX));
        }
        timer.end();
        System.out.println("populate: " + Double.toString(timer.delta()));
        int[] arr = new int[iterations];
        int sum = 0;
        timer.start();
        for (int i = 0; i < iterations; i++) {
            arr[i] = map.get(random.nextInt(end - start) + start);
        }
        timer.end();
        System.out.println("calc: " + Double.toString(timer.delta()));

        timer.start();
        for (int i = 0; i < iterations; i++) {
            sum += arr[i];
        }

        timer.end();
        System.out.println("summatie: " + Double.toString(timer.delta()));
        return sum;
    }

    public static void main(String[] args) {
        int start = 97;
        int end = 200000;
        int iterations = 50000000;
        System.out.println("Sum is: " + sum(start, end, iterations));
    }

}