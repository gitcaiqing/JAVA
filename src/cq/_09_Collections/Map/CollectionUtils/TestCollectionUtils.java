package cq._09_Collections.Map.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class TestCollectionUtils {
	
	@Test
	public void testCollectionUtils(){
		
		List<String> arrList = new ArrayList<String>();
		arrList.add("a");
		arrList.add("c");
		arrList.add("b");
		arrList.add("d");
		System.out.println(arrList);
		
		//转成数组
		//System.out.println("toArray:"+arrList.toArray().length);
	
		
		String[] array = arrList.toArray(new String[arrList.size()]);
		
		for(String arr:array){
			System.out.println("arr:"+arr);
		}
		System.out.println(array.length);
		
		//数组转成集合
		String[] str = {"1","2","3","4","5"};
		System.out.println("toList:"+Arrays.asList(str));
		
		String max =Collections.max(arrList);
		System.out.println("max:"+max);
		
		//Collections.sort(arrList);
		//System.out.println(arrList);
		
		Collections.sort(arrList,new StrLenComparator());
		System.out.println("comparator:"+arrList);
		
		Collections.reverse(arrList);
		System.out.println(arrList);
		
		Collections.replaceAll(arrList, "d", "dd");
		System.out.println(arrList);
		//全部替换
		//Collections.fill(arrList, "whole");
		//System.out.println(arrList);
		
	}
	
}

 class StrLenComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() > s2.length()){
			return 1;
		}
		if(s1.length() < s2.length()){
			return -1;
		}
		
		return s1.compareTo(s2);
	}

	
	
}






