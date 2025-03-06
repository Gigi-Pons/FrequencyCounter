import java.util.*;

public class FrequencyCounter {

    public static void main(String[] args) {
        String characters = "Bwesposisde";
        String document = "Bessie";
        FrequencyCounter fc = new FrequencyCounter();
        boolean result = fc.checkDocument(characters, document);
        if(result) {
            System.out.println("The document can be formed");
        } else {
            System.out.println("The document can't be formed");
        }
    }

    public boolean checkDocument(String characters, String document) {
        //Hashmap to store characters as keys and values as integers
        HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();

        //This for loop counts the number of characters in the character string.  For each
        //character, the value is incremented by 1
        for(int i=0; i<characters.length(); i++) {
            char character = characters.charAt(i);
            //checks the current count in characterCounts hashmap
            Integer count = characterCounts.get(character);
            //if it's null, it means it doesn't exists, therefore we must create the first entry
            if(count == null) {
                characterCounts.put(character, 1);
            } else {
                characterCounts.put(character, count+1);
            }
        }

        //This for loop iterates through the document String.  For each character encountered,
        //it compares it to our characterCounts hashmap.  If the key has a value, then the loop keeps going,
        //if the key returns 0, that means there aren't enough characters to generate the document.
        for(int i=0; i<document.length(); i++) {
            char character = document.charAt(i);
            if(!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {
                return false;
            }
            //if it doesn't return 0 or the key is actually found, then decrement its value by 1 for that key
            characterCounts.put(character, characterCounts.get(character) - 1);
        }
        return true;
    }
}



































