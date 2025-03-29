
public class reverseOfNUmber {

	public static void main(String[] args) {
		String str = new String();
		str = "radar";
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}

}
