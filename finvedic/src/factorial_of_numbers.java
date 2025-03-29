
public class factorial_of_numbers {

	public static void main(String[] args) {
		int a=5;
		int sum=1;
		System.out.print(a+"!=");
		while(a!=0) {
			sum=sum*a;
			a--;
		}
		System.out.println(sum);
	}

}
