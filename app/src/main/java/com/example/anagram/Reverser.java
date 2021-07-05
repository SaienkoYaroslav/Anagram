package com.example.anagram;

public class Reverser {

    String reverse(String userInput, String userIgnore) {
        char str[] = userInput.toCharArray();
        int r = str.length - 1, l = 0;
        while (l < r) {
            if (userIgnore.indexOf(str[l]) != -1)
                l++;
            else if (userIgnore.indexOf(str[r]) != -1)
                r--;
            else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
        String revStr = new String(str);
        return revStr;
    }

}
