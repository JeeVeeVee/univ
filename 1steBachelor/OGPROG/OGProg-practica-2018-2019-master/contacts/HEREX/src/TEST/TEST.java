package TEST;

import java.io.*;

public class TEST {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("alfabet.out");
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                writer.write(ch);
                System.out.println(ch);
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
