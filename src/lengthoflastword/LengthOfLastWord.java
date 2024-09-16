/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lengthoflastword;

/**
 *
 * @author kaan
 */
public class LengthOfLastWord {
    
    public static void main(String[] args) {
        String x = "   fly me   to   the moon  " ;
        String [] xSplit = x.split(" ");
        String result = null ;
        for (int i = xSplit.length - 1 ; i>=0 ; i--) {
            if (!xSplit[i].contains(" ")) {
                result = xSplit[i];
                break ;
            }
        }
    }
    
    
    
}
