package com.example.lab2e;

public class WordCounter {
    public static int Characters(String str) {
        return str.length();
    }
    public static int Words(String str) {
//        int count = 0 ;
////
////        for (int i = 0 ; i<str.length();i++){
////            int cur = str.charAt(i);
////            if( cur ==' ' || cur == '.' || cur ==',' ){
////                count++;
////            }
////        }
////        return count;
        int wordCount = 0;

        boolean isWord = false;
        int endOfLine = str.length() - 1;
        char[] characters = str.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i]) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetter(characters[i]) && isWord) {
                wordCount++;
                isWord = false;
            } else if (Character.isLetter(characters[i]) && i == endOfLine) {
                wordCount++;
            }
        }

        return wordCount;
    }
}
