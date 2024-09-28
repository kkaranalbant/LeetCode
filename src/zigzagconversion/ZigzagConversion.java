/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zigzagconversion;

/**
 *
 * @author kaan
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        System.out.println(convert("asdasd", 1));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) return s ;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int currentIndex = i;
            result.append(s.charAt(currentIndex));
            boolean upToDown = true;
            while (currentIndex < s.length()) {
                int upToDownIncreaseAmount = (2 * (numRows - i - 1));
                if (upToDown) {
                    if (upToDownIncreaseAmount != 0) {
                        currentIndex = currentIndex + upToDownIncreaseAmount;
                        if (currentIndex < s.length()) {
                            result.append(s.charAt(currentIndex));
                        }
                    }
                    upToDown = false;
                }
                int downToUpIncreaseAmount = 2 * i;
                if (!upToDown) {
                    if (downToUpIncreaseAmount != 0 && currentIndex < s.length()) {
                        currentIndex = currentIndex + downToUpIncreaseAmount;
                        if (currentIndex < s.length()) {
                            result.append(s.charAt(currentIndex));
                        }
                    }
                    upToDown = true;
                }
            }
        }
        return result.toString();
    }

}
