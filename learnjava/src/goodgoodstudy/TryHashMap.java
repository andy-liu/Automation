package goodgoodstudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TryHashMap {
	public static void main(String[] args){
		Map<String, String> m1 = new HashMap<String, String>(); 
	    m1.put("Zara", "10");
	    System.out.println(m1.put("Zara", "8"));
		System.out.println(m1);
		
		List<String> myStrList = new ArrayList<String>();
		myStrList.add("Hello");
		myStrList.add("World");
		System.out.println(myStrList);
		
		List<Integer> myIntList = new ArrayList<Integer>();
		myIntList.add(5);
		System.out.println(myIntList);
	}
}
