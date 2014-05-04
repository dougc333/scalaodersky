package javaversion;


/**
*
* @param chars a string represented as a list of chars
* @return true if the string contains a balanced number of parentheses, false o/w

def balance(chars: List[Char]): Boolean = {
  @tailrec
  def balance(chars: List[Char], acc: Int): Boolean = {
   if (chars.isEmpty) (acc == 0)
   else if (acc >= 0) {
     if ('('.equals(chars.head)) balance(chars.tail, acc + 1)
     else if (')'.equals(chars.head)) balance(chars.tail, acc - 1)
     else balance(chars.tail, acc)
   } else false
 }
 balance(chars, 0)
} 
*/



public class ParenBalance {

	//do we return false on first unbalanced parenthesis? 
	public static boolean balance(String foo){
		String s = cleanString(foo);
		//System.out.println(s);
		if (s.isEmpty()){
			return true;
		}else if(s.charAt(0)==')'){
			return false;  
		}
		if(s.charAt(s.length()-1)==')' && s.charAt(s.length()-2)=='('){
			return balance(s.substring(0,s.length()-2));
		}

		if(s.charAt(0)=='('){
			if(s.charAt(1)==')'){
				return balance(s.substring(2,s.length()));
			}else if(s.charAt(s.length()-1)==')'){
				return balance(s.substring(1,s.length()-1));
			}
		}
		//should never see this
		return false;
	}
	
	
	private static String cleanString(String foo){
		//remove everything but the parenthesis
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<foo.length();i++){
			if(foo.charAt(i)=='(' || foo.charAt(i)==')'){
				sb.append(foo.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static void main(String []args){
		System.out.println(balance(":-)"));
		System.out.println(balance("())("));
		System.out.println(balance("(if (zero? x) max (/ 1 x))"));
		System.out.println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)"));
		
		
	}
}
