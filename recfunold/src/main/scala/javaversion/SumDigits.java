package javaversion;

public class SumDigits {
	int sum=0;
	
	private static int sumDigits(int n) {
		System.out.println("n:"+n);
		if(n<10){
			return n;
		}
		return n/10+ sumDigits(n/10);
	}
	
	public static void main(String []args){
		System.out.println("sumDigits:"+sumDigits(126));
		System.out.println("sumDigits:"+sumDigits(49));
		System.out.println("sumDigits:"+sumDigits(12));

	}
}
