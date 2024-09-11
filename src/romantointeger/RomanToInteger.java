/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package romantointeger;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kaan
 */
public class RomanToInteger {

    public static void main(String[] args) {

        String word = "DCXXI";

        Map<String, Integer> patternValueMap = new HashMap();

        patternValueMap.put("XC", 90);
        patternValueMap.put("XL", 40);
        patternValueMap.put("IV", 4);
        patternValueMap.put("IX", 9);
        patternValueMap.put("CD", 400);
        patternValueMap.put("CM", 900);
        patternValueMap.put("III", 3);
        patternValueMap.put("II", 2);
        patternValueMap.put("I", 1);
        patternValueMap.put("V", 5);
        patternValueMap.put("X", 10);
        patternValueMap.put("L", 50);
        patternValueMap.put("C", 100);
        patternValueMap.put("D", 500);
        patternValueMap.put("M", 1000);

        int result = 0;

        for (Map.Entry<String, Integer> entry : patternValueMap.entrySet()) {
            result += findPatternRepeatAndReturnValue(entry.getKey(), word, entry.getValue());
        }

        System.out.println(result);
    }

    private static int findPatternRepeatAndReturnValue(String pattern, String word, int value) {
        String regex = null;
        if (pattern.equals("II")) {
            regex = "(?<!C|V|X|I)II(?!I)";
        } else if (pattern.length() == 2 || pattern.length() == 3) {
            regex = pattern;
        } else {
            switch (pattern) {
                case "I":
                    regex = "(?<!C|V|X|I)I(?!I|V|X)";  // "I" öncesinde ve sonrasında istenmeyen harfler yoksa "I"
                    break;
                case "II":
                    regex = "(?<!C|V|X|I)II(?!I)";  // "II" öncesinde ve sonrasında istenmeyen harfler yoksa "II"
                    break;
                case "V":
                    regex = "(?<!I)V(?!X)";  // "IV" ve "VX" hariç "V"
                    break;
                case "X":
                    regex = "(?<!I|L|C)X(?!C|L)";  // "XC", "XL", "IX" hariç "X"
                    break;
                case "L":
                    regex = "(?<!X)L";  // "XL" hariç "L"
                    break;
                case "C":
                    regex = "(?<!X)C(?!M|D)";  // "XC", "CM" hariç "C"
                    break;
                case "D":
                    regex = "(?<!C)D";  // "CD" hariç "D"
                    break;
                case "M":
                    regex = "(?<!C)M";  // "CM" hariç "M"
                    break;
            }
        }

        Pattern patternObj = Pattern.compile(regex);
        Matcher matcher = patternObj.matcher(word);
        int result = 0;
        while (matcher.find()) {
            result++;
        }
        System.out.println(result+" adet "+pattern+" bulundu.");
        return value * result;
    }

}
