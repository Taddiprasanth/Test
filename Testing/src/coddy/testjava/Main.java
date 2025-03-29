package coddy.testjava;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        String season = "";
        
        // Write your code below
        switch(month){
            case 1:
                season ="Winter";
                break;
            case 2:
                season ="Winter";
                break;
            case 3:
                season="Spring";
                break;
            case 4:
                season="Spring";
                break;
            case 5:
                season="Spring";
                break;
            case 6:
                season="Summer";
                break;
             case 7:
                season="Summer";
                break;
             case 8:
                season="Summer";
                break;
            case 9:
                season ="Autumn";
                break;
            case 10:
                season ="Autumn";
                break;
            case 11:
                season ="Autumn";
                break;
            case 12:
                season ="Winter";
                break;
            default:
                season="Invalid month";
        }
        
        System.out.println(season);
    }
}
