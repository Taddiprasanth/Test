
public class Fibonacci_series {

	public static void main(String[] args) {
		int a1=0;
		int a2=1;
		int a3=0;
		System.out.println(a1);
		for(int i=1;i<5;i++) {
			a1=a2;
			a2=a3;
			a3=a2+a1;
			System.out.println(a3 );
		}
	}

}
