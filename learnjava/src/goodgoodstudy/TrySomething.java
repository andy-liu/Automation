package goodgoodstudy;

public class TrySomething {
	public TrySomething(){
		System.out.println("class TrySomething");
	}
	
	public static boolean verifyIf(int a){
		if(a>1){
			return true;
		}
		return false;
	}
	
	public static boolean testReturn(int a){
		if (a>1){
			int b = a / 0;
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) { 
//         System.out.println(verifyIf(3));
		System.out.println(testReturn(0));
    } 
}

