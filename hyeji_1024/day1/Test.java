package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	 public static int timeMin(){
	        int ans = 0;
	        String str1= "07:59";
	        String str2= "05:34";
	        String[] inTime = str2.split(":");
	        String[] outTime = str1.split(":");
	        System.out.println(inTime[0] + " " + inTime[1]);
	        int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
	        int min = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
	        
	        if(min < 0){
	            min += 60;
	            hour--;
	        }
	        ans = hour*60 + min;
	        
	        return ans;
	    }
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("100", 1);
		map.put("003", 1);
		map.put("433", 1);
		map.put("202", 1);
		map.put("533", 1);
		
		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		
		for(String key : list) {
			System.out.println(key + " " + map.get(key));
		}
		
		int min = 9;
		int ff = 10;
		System.out.println((int)(Math.ceil(min/(double)ff)));
		System.out.println(timeMin());
		
	}
}
