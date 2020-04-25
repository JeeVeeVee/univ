package Cedric;

public class Cipher {

    String[] alfabet;

    public Cipher(){
        alfabet = turnIntoArray("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    public String decryptCaesar(String input, int R) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            String inputLetter = input.substring(i, i  +1);
            int index = indexOf(alfabet, inputLetter);
            String nieuweLetter = alfabet[(index + R) % alfabet.length];
            output += nieuweLetter;
        }
        return output;
    }

    public int indexOf(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (target.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public String[] turnIntoArray(String s){
        String[] output = new String[26];
        for(int i = 0; i < s.length(); i++){
            output[i] = s.substring(i, i + 1);
        }
        return output;
    }
}
