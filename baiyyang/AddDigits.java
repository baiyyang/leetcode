package baiyyang;

public class AddDigits {
	
	public static void main(String[] args) {
		System.out.println(addDigits(0));
	}
	
	public static int addDigits(int num) {
        return 1+(num-1)%9;
    }

}
