import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


    // Complete the makingAnagrams function below.
	// Both strings must contain the same exact letters 
	// in the same exact frequency.
    static int makingAnagrams(String s1, String s2) {

    	int del = 0;
    	
//      // **** sort s1 ****
//    	byte[] b1 = s1.getBytes();
//    	Arrays.sort(b1);
//    	String s1s =new String(b1);
//    	
//    	System.out.println("s1s ==>" + s1s + "<==");
//
//    	// **** sort s2 ****
//    	byte[] b2 = s2.getBytes();
//    	Arrays.sort(b2);
//    	String s2s = new String(b2);
//    	
//    	System.out.println("s2s ==>" + s2s + "<==");  	
    	
    	// **** build hash map with counts of letters in s1 ****
    	HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
    	for (char ch : s1.toCharArray()) {
    		if (hm1.containsKey(ch)) {
    			int count = hm1.get(ch);
    			count++;
    			hm1.put(ch, count);
    		} else {
    			hm1.put(ch, 1);
    		}
    	}
    	
//    	System.out.println("hm1: " + hm1.toString());

    	// **** build hash map with counts of letters in s2 ****
    	HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
    	for (char ch : s2.toCharArray()) {
    		if (hm2.containsKey(ch)) {
    			int count = hm2.get(ch);
    			count++;
    			hm2.put(ch, count);
    		} else {
    			hm2.put(ch, 1);
    		}
    	}
    	
//    	System.out.println("hm2: " + hm2.toString());
     	
    	// **** traverse hm1 looking at hm2 ****
    	for (Map.Entry<Character, Integer> pair : hm1.entrySet()) {
    		
    		char ch1 	= pair.getKey();
    		int count1 	= pair.getValue();
    		
    		// **** look for ch1 in hm2 ****
    		if (hm2.containsKey(ch1)) {
    			int count2 = hm2.get(ch1);
    			del += Math.abs(count1 - count2);
    		} else {
    			del += count1;
    		}
     	}
    	
//    	System.out.println("del: " + del);

    	// **** traverse hm2 looking at hm1 ****
    	for (Map.Entry<Character, Integer> pair : hm2.entrySet()) {
    		
    		char ch2 	= pair.getKey();
    		int count2 	= pair.getValue();
    		
    		// **** look for ch2 in hm1 ****
    		if (hm1.containsKey(ch2)) {
    			int count1 = hm1.get(ch2);
//    			del += Math.abs(count2 - count1);
    		} else {
    			del += count2;
    		}
    		
    	}
    	
//    	System.out.println("del: " + del);   	
    	
    	// **** ****
    	return del;
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
