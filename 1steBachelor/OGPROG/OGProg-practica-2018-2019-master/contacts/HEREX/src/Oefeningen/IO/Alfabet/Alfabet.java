package Oefeningen.IO.Alfabet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Alfabet {
    public static void main(String[] args) throws IOException {
        Writer out = new FileWriter("alfabet.out");
        for(char ch='1'; ch <= 'z'; ch++){
            out.write(ch);
        }
        out.close();
    }
}
