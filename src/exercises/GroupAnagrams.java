package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
*/

/*
 * Soluzione: l'idea è questa: due stringhe sono l'anagramma l'una dell'altra se ordinandole
   alfabeticamente sono la stessa stringa. Se sono la stessa stringa me ne accorgo inserendole all'interno
   dell'hastable poiche avrò una collisione.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        		;
    	//Hashmap che mi aiuta a capire se due stringhe sono l'anagramma l'una dell'altra
    	Map<String, ArrayList<String>> hm = new HashMap<>();
    	
    	for (String str : strs) {
    		char[] c = str.toCharArray(); //trasformo la string in un array di char cosi che posso ordinarlo
    		Arrays.sort(c);
    		
    		String ordinateStr = Arrays.toString(c); //ritrasformo in stringa
    		
    		//se l'hashmap non contiene la chiave con quella string significa che non ho un anagramma trovato e
    		//quindi devo creare una nuova entry nell'hashmap
    		if (!hm.containsKey(ordinateStr)) hm.put(ordinateStr,new ArrayList<String>());
    		
    		hm.get(ordinateStr).add(str);
    		
    	}
    	
    	List<List <String>> output = new ArrayList<>(hm.values());
		return output;
    }
    
    public static void main (String[] args) {
    	String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	String[] input2 = null;
    	System.out.println(input2);
    	System.out.println(groupAnagrams(input).toString());
    	
    }
}
