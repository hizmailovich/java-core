package io.ylab;

public class Main {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")
                + "\n" + fuzzySearch("cwhl", "cartwheel")
                + "\n" + fuzzySearch("cwhee", "cartwheel")
                + "\n" + fuzzySearch("cartwheel", "cartwheel")
                + "\n" + fuzzySearch("cwheeel", "cartwheel")
                + "\n" + fuzzySearch("lw", "cartwheel"));
    }

    private static boolean fuzzySearch(String word, String str) {
        char[] wordArray = word.toCharArray();
        char[] strArray = str.toCharArray();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (counter == word.length()) {
                break;
            }
            if (wordArray[counter] == strArray[i]) {
                counter++;
            }
        }
        return counter == word.length();
    }
}
