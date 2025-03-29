import java.util.Scanner;

public class AdditionUsingMethods {

	private int a;
	private int b;
	Scanner scan= new Scanner(System.in);
	public int getA1() {
		return a;
	}
	public void setA1() {
		int a1=scan.nextInt();
		this.a = a1;
	}
	public int getB1() {
		return b;
	}
	public void setB1() {
		int b1=scan.nextInt();
		this.b = b1;
	}

}


