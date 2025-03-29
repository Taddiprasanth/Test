import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWordEnd;

    public TrieNode() {
        children = new HashMap<>();
        isWordEnd = false;
    }
}

public class Trie_tree {
    private final TrieNode rootNode;

    public Trie_tree() {
        rootNode = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode currentNode = rootNode;
        for (char ch : word.toCharArray()) {
            currentNode.children.putIfAbsent(ch, new TrieNode());
            currentNode = currentNode.children.get(ch);
        }
        currentNode.isWordEnd = true;
    }

    public boolean findWord(String word) {
        TrieNode currentNode = rootNode;
        for (char ch : word.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                return false;
            }
            currentNode = currentNode.children.get(ch);
        }
        return currentNode.isWordEnd;
    }

    public void removeWord(String word) {
        removeWordHelper(rootNode, word, 0);
    }

    private boolean removeWordHelper(TrieNode currentNode, String word, int index) {
        if (index == word.length()) {
            if (!currentNode.isWordEnd) {
                return false;
            }
            currentNode.isWordEnd = false;
            return currentNode.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode nextNode = currentNode.children.get(ch);
        if (nextNode == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = removeWordHelper(nextNode, word, index + 1);

        if (shouldDeleteCurrentNode) {
            currentNode.children.remove(ch);
            return currentNode.children.isEmpty() && !currentNode.isWordEnd;
        }
        return false;
    }

    public void showWords() {
        System.out.println("\nWords in Trie:");
        displayHelper(rootNode, "");
    }

    private void displayHelper(TrieNode node, String word) {
        if (node.isWordEnd) {
            System.out.println(word);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            displayHelper(entry.getValue(), word + entry.getKey());
        }
    }

    public void showTrieTree() {
        System.out.println("\nTrie Structure:");
        showTrieHelper(rootNode, 0);
    }

    private void showTrieHelper(TrieNode node, int level) {
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            char ch = entry.getKey();
            TrieNode childNode = entry.getValue();
            System.out.println(new String(new char[level]).replace("\0", "  ") + "└── " + ch + (childNode.isWordEnd ? " (end)" : ""));
            showTrieHelper(childNode, level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trie_tree trie = new Trie_tree();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add word");
            System.out.println("2. Find word");
            System.out.println("3. Remove word");
            System.out.println("4. Display Trie as List");
            System.out.println("5. Display Trie as Tree");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter word to add: ");
                    String addWord = scanner.nextLine();
                    trie.addWord(addWord);
                    System.out.println("\"" + addWord + "\" added.");
                    break;

                case 2:
                    System.out.print("Enter word to find: ");
                    String findWord = scanner.nextLine();
                    System.out.println("\"" + findWord + "\" found: " + trie.findWord(findWord));
                    break;

                case 3:
                    System.out.print("Enter word to remove: ");
                    String removeWord = scanner.nextLine();
                    trie.removeWord(removeWord);
                    System.out.println("\"" + removeWord + "\" removed (if it existed).");
                    break;

                case 4:
                    trie.showWords();
                    break;

                case 5:
                    trie.showTrieTree();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
