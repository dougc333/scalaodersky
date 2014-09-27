package javaversion;

public class Pascal {
	//n=row k =cols
	public static int pascal(int col,int row){
		System.out.println("col:"+col+ "row:"+row);
		if(col<0 || row<0 || col>row){
			//System.out.println("return 0");
			return 0;
		}
		if(col==0 || col==row){
			//System.out.println("return 1");
			return 1;
		}
				
		return pascal(col-1,row-1) + pascal(col,row-1); 
	}
	
	public static void main(String []args){
		System.out.println("col 0 row 2:"+pascal(0,2));
		System.out.println("col 1 row 2:"+pascal(1,2));
		System.out.println("col 2 row 2:"+pascal(2,2));
		System.out.println("++++++++++++++++++++++++++");
		System.out.println("col 0 row 3:"+pascal(0,3));
		System.out.println("col 1 row 3:"+pascal(1,3));
		System.out.println("col 2 row 3:"+pascal(2,3));
		System.out.println("col 3 row 3:"+pascal(3,3));
		System.out.println("++++++++++++++++++++++++++");
		System.out.println("col 0 row 4:"+pascal(0,4));
		System.out.println("col 1 row 4:"+pascal(1,4));
		System.out.println("col 2 row 4:"+pascal(2,4));
		System.out.println("col 3 row 4:"+pascal(3,4));
		System.out.println("col 4 row 4:"+pascal(4,4));
		
		
		//System.out.println(""+pascal(2,1));
		//System.out.println(""+pascal(3,1));
	
	}
}
