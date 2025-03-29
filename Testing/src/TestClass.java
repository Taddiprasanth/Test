import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = 0;
        N = s.nextInt();
        int[] data = new int[N];
        for(int i=0; i<N; i++){
            data[i] = s.nextInt();
        }
        int ans=0;
        int result=0;
        for(int i=0;i<data.length;i++){
            result=data[i]%10;
            if((i+1)==data.length){
                ans=result+ans;
                break;
            }
            ans=result+ans;
            ans=ans*10;
        }
        System.out.println(ans);
        if((ans%10)==0) System.out.println("Yes");
        else System.out.println("No");
        }
    }