import java.util.*;

public class Stock_Trading {
    private final Map<String, Integer> holdings;
    private final Map<String, Double> marketPrices;

    public Stock_Trading() {
        holdings = new HashMap<>();
        marketPrices = new HashMap<>();
        loadStockPrices();
    }
    private void loadStockPrices() {
        marketPrices.put("AAPL", 150.0);
        marketPrices.put("GOOGL", 2800.0);
        marketPrices.put("MSFT", 300.0);
        marketPrices.put("AMZN", 3400.0);
        marketPrices.put("TSLA", 700.0);
    }
    public void purchaseStock(String ticker, int amount) {
        if (!marketPrices.containsKey(ticker)) {
            System.out.println("Stock ticker not found.");
            return;
        }
        holdings.put(ticker, holdings.getOrDefault(ticker, 0) + amount);
        System.out.println("Purchased " + amount + " shares of " + ticker + " at $" + marketPrices.get(ticker) + " each.");
    }

    public void offloadStock(String ticker, int amount) {
        if (!holdings.containsKey(ticker) || holdings.get(ticker) < amount) {
            System.out.println("Not enough shares to sell.");
            return;
        }
        holdings.put(ticker, holdings.get(ticker) - amount);
        if (holdings.get(ticker) == 0) {
            holdings.remove(ticker);
        }
        System.out.println("Sold " + amount + " shares of " + ticker + " at $" + marketPrices.get(ticker) + " each.");
    }

    public void displayHoldings() {
        System.out.println("\nYour Stock Holdings:");
        if (holdings.isEmpty()) {
            System.out.println("No stocks in your portfolio.");
            return;
        }
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " shares ($" + marketPrices.get(entry.getKey()) + " each)");
        }
    }

    public void displayMarketPrices() {
        System.out.println("\nMarket Stock Prices:");
        for (Map.Entry<String, Double> entry : marketPrices.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock_Trading manager = new Stock_Trading();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Purchase Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Holdings");
            System.out.println("4. View Market Prices");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter stock ticker to purchase: ");
                    String buyTicker = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int buyAmount = scanner.nextInt();
                    manager.purchaseStock(buyTicker, buyAmount);
                    break;

                case 2:
                    System.out.print("Enter stock ticker to sell: ");
                    String sellTicker = scanner.nextLine().toUpperCase();
                    System.out.print("Enter quantity: ");
                    int sellAmount = scanner.nextInt();
                    manager.offloadStock(sellTicker, sellAmount);
                    break;

                case 3:
                    manager.displayHoldings();
                    break;

                case 4:
                    manager.displayMarketPrices();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
