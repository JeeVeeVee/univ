package Reeks01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomVisit {

    private static final long SEED = 1234;

    public static int visitElements(int dimension1, int dimension2,
                                    int dimension3, int iterations,
                                    int internalIterations) {
        Random random = new Random(SEED);

        int numberVisited = 0;
        for (int i = 0; i < iterations; i++) {
            System.out.println(i);
            boolean[][][] alreadyVisited = new boolean[dimension1][dimension2][dimension3];
            for (int j = 0; j < internalIterations; j++) {
                int a = random.nextInt(dimension1);
                int b = random.nextInt(dimension2);
                int c = random.nextInt(dimension3);
                if (!alreadyVisited[a][b][c]) {
                    alreadyVisited[a][b][c] = true;
                    numberVisited++;
                }
            }
        }
        return numberVisited;
    }

    public static int visitElements1(int dimension1, int dimension2,
                                     int dimension3, int iterations,
                                     int internalIterations) {
        Random random = new Random(SEED);

        int numberVisited = 0;
        for (int i = 0; i < iterations; i++) {
            ArrayList<int[]> visited = new ArrayList<>();
            for (int j = 0; j < internalIterations; j++) {
                int a = random.nextInt(dimension1);
                int b = random.nextInt(dimension2);
                int c = random.nextInt(dimension3);
                int[] coordinaat = {a,b,c};
                boolean wecool = true;
                for(int[] y : visited){
                    if (Arrays.equals(coordinaat, y)){
                        wecool  = false;
                        break;
                    }
                }
                if (wecool){
                    visited.add(coordinaat);
                    numberVisited++;
                }
            }
        }
        return numberVisited;
    }

    public static int visitElements2(int dimension1, int dimension2,
                                     int dimension3, int iterations,
                                     int internalIterations) {
        Random random = new Random(SEED);

        int numberVisited = 0;
        for (int i = 0; i < iterations; i++) {
            ArrayList<Integer> visitedx = new ArrayList<>();
            ArrayList<Integer> visitedy = new ArrayList<>();
            ArrayList<Integer> visitedz = new ArrayList<>();
            int a, b, c;
            for (int j = 0; j < internalIterations; j++) {
                a = random.nextInt(dimension1);
                b = random.nextInt(dimension2);
                c = random.nextInt(dimension3);
                int[] coordinaat = {a,b,c};
                if (! (visitedx.contains(a) && visitedy.contains(b) && visitedz.contains(b))){
                    visitedx.add(a);
                    visitedy.add(b);
                    visitedx.add(c);
                    numberVisited++;
                }
            }
        }
        return numberVisited;
    }

    public static void main(String[] args) {
        int dimension1 = 10000;
        int dimension2 = 100;
        int dimension3 = 10;
        int iterations = 1000;
        int internalIterations = 200;
        Timer timer = new Timer();
        timer.start();
        int visited1 = visitElements2(dimension1, dimension2, dimension3,
                iterations, internalIterations);
        timer.end();
        System.out.println(timer.delta());
        System.out.println("Number of elements visited " + visited1);


    }

}