package javaversion;
import java.util.LinkedList;
import java.util.List;


public class RecursiveList {
	
	static int add(List<Integer> removeOne2){
		if (removeOne2.isEmpty()) return 0;
		List removeOne = removeOne2.subList(0, removeOne2.size()-1);
		return  removeOne2.get(removeOne2.size()-1)+ add(removeOne);
		
	}
	
	static int max(List<Integer> findMax,int maxVal){
		if(findMax.isEmpty()){
			return maxVal;
		}
		List removeOne = findMax.subList(0, findMax.size()-1);
		if(findMax.get(findMax.size()-1)>maxVal){
			maxVal=findMax.get(findMax.size()-1);
		}
		return max(removeOne,maxVal);
	}
	
	public static void main(String []args){
		List<Integer> list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(add(list));
		System.out.println(max(list,0));
		
	}
}
