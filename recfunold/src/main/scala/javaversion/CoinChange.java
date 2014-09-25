package javaversion;

public class CoinChange {

	
	public static int change(int sum, int largest){
		if(largest==0){
			return 0;
		}
		if(sum==0){
			return 1;
		}
		if(sum<0 ){
			return 0;
		}
		
		return change(sum,largest-1)+change(sum-largest,largest);
	}
	
	public static void main(String []args){
		
		System.out.println(change(4,2));
		
	}
}
