/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editdistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 *
 * @author kaan
 */
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }

    private static int minDistance(String word1, String word2) {
        int result = 0;
        int commonAddingRemoving  = 0 ;
        int remove1 = 0 ;
        int add1 = 0 ;
        Map<Character, Integer> characterFrequencyMap1 = new HashMap();
        Map<Character, Integer> characterFrequencyMap2 = new HashMap();
        Map<Integer, Character> indexCharacterMap1 = new HashMap();
        Map<Integer, Character> indexCharacterMap2 = new HashMap();
        int counter1 = 0;
        int counter2 = 0;
        for (char character : word2.toCharArray()) {
            indexCharacterMap2.put(counter2, character);
            counter2++;
            if (characterFrequencyMap2.containsKey(character)) {
                int value = characterFrequencyMap2.get(character);
                characterFrequencyMap2.put(character, value + 1);
            } else {
                characterFrequencyMap2.put(character, 1);
            }
        }
        for (char character : word1.toCharArray()) {
            indexCharacterMap1.put(counter1, character);
            counter1++;
            if (characterFrequencyMap1.containsKey(character)) {
                int value = characterFrequencyMap1.get(character);
                characterFrequencyMap1.put(character, value + 1);
            } else {
                characterFrequencyMap1.put(character, 1);
            }
        }
        List<Integer> indexesToRemove1 = new ArrayList();
        for (Entry<Character, Integer> entry : characterFrequencyMap1.entrySet()) {
            if (characterFrequencyMap2.containsKey(entry.getKey())) {
                result += Math.abs(characterFrequencyMap2.get(entry.getKey()) - entry.getValue()); // ikisininde ortak icerdigi karakter icin yapilacak ekleme cikarma sayisi
                commonAddingRemoving++ ;
            } else {
                for (Entry<Integer, Character> indexCharEntry : indexCharacterMap1.entrySet()) {
                    if (Objects.equals(indexCharEntry.getValue(), entry.getKey())) {
                        indexesToRemove1.add(indexCharEntry.getKey());
                    }
                }
                remove1++ ;
                result += entry.getValue(); // 1. kelimeden cikarilacak olanlarin toplam sayisi
                System.out.println("1. kelimeden cikarilacaklar : ");
            }
        }
        System.out.println("Ortak ekleme cikarma = " +commonAddingRemoving);
        System.out.println("1. den cikarilacak : "+remove1);
        for (Integer index : indexesToRemove1) {
            indexCharacterMap1.remove(index);
        }
        List<Integer> indexesToRemove2 = new ArrayList();
        for (Entry<Character, Integer> entry : characterFrequencyMap2.entrySet()) {
            if (!characterFrequencyMap1.containsKey(entry.getKey())) {
                result += entry.getValue(); // 1. kelimeye eklenecek olanlarin toplam sayisi
                for (Entry<Integer, Character> indexCharEntry : indexCharacterMap2.entrySet()) {
                    if (Objects.equals(indexCharEntry.getValue(), entry.getKey())) {
                        indexesToRemove2.add(indexCharEntry.getKey());
                    }
                }
            }
        }
        for (Integer index : indexesToRemove2) {
            indexCharacterMap2.remove(index);
        }
        int indexCharacterMap1Counter = 0;
        int indexCharacterMap2Counter = 0;
        Map<Integer, Character> newIndexCharacterMap1 = new HashMap();
        for (Entry<Integer, Character> indexCharacterEntry : indexCharacterMap1.entrySet()) {
            newIndexCharacterMap1.put(indexCharacterMap1Counter, indexCharacterEntry.getValue());
            indexCharacterMap1Counter++;
        }
        Map<Integer, Character> newIndexCharacterMap2 = new HashMap();
        for (Entry<Integer, Character> indexCharacterEntry : indexCharacterMap2.entrySet()) {
            newIndexCharacterMap2.put(indexCharacterMap2Counter, indexCharacterEntry.getValue());
            indexCharacterMap2Counter++;
        }
        for (Entry<Integer, Character> indexCharacterEntry : newIndexCharacterMap1.entrySet()) {
            if (!indexCharacterEntry.getValue().equals(newIndexCharacterMap2.get(indexCharacterEntry.getKey()))) {
                result++;
            }
        }
        return result;
    }

}
