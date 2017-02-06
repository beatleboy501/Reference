package com.bigonotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindExtra {
	
	public static String usingNestedForLoop(String[] firstArray, String[] secondArray){
		String result = "";
		for(int i = 0; i < firstArray.length - 1; i++){ // for each in the first array
			boolean found = false;
			for(int j = 0; j < secondArray.length; j++){// compare to each in second array
				if(firstArray[i].equals(secondArray[j])){
					found = true;
					break;
				}
			}
			if((found == false)){
				result = firstArray[i];
				break;
			}
		}
		return secondArray[secondArray.length - 1];
	}
	
	public static String usingCollection(String[] a, String[] b){
		Collection<String> listTwo = new ArrayList<String>(Arrays.asList(b));
		listTwo.removeAll(Arrays.asList(a));
		return listTwo.toString();
	}
	
	public static String usingList(String[] a, String[] b){
		List<String> compareList = new ArrayList<String>(Arrays.asList(a));
		List<String> baseList = new ArrayList<String>(Arrays.asList(b));
		compareList.removeAll(baseList);
		return compareList.toString();
	}
	
	// O(N) This is the fastest
	public static String usingSet(String[] a, String[] b){
		Set<String> extra = new HashSet<String>(Arrays.asList(b));
		extra.removeAll(Arrays.asList(a));
		return extra.toString();
	}
		
	public static String usingOn(String[] a, String[] b){
		List<String> baseList = new ArrayList<String>(Arrays.asList(a));
		for(String string : b){
			if(baseList.contains(string)){
				continue;
			}
			else{
				return string; // because it's the extra one
			}
		}
		return null;
	}
	
	public static String usingIntersect(String[] a, String[] b){
		
	    int i = 0, j = 0; 
	    while ((i <= a.length - 1) && (j <= b.length - 1)) { 
	        if (a[i] == b[j]) {
	            i ++;
	            j++;
	        } 
	        else { 
	            return b[i];
	        }
	    }
		return b[b.length - 1];
	}
}