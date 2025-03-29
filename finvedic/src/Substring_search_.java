import java.util.*;
public class Substring_search_ {
    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static List<Integer> kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> occurrences = new ArrayList<>();
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0; 
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) { // Found a match
                occurrences.add(i - j + 1); // Store 1-based index
                j = lps[j - 1]; // Move j to the previous LPS position
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Move j to LPS position
                } else {
                    i++;
                }
            }
        }
        return occurrences;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();
        List<Integer> result = kmpSearch(text, pattern);
        if (!result.isEmpty()) {
            System.out.println("Pattern found at positions: " + result);
        } else {
            System.out.println("Pattern not found in the text.");
        }
        scanner.close();
    }
}
