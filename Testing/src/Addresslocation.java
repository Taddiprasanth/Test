
public class Addresslocation {

	public static void main(String[] args) {
		int a=5;
		int id=System.identityHashCode(a);
		String str= "123";
		String s="123";
		int ids=System.identityHashCode(str);
		int aa=System.identityHashCode(s);
		System.out.println(ids);
		System.out.println(aa);
		System.out.println(id);
	}
}
