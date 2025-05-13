import java.util.Scanner;

public class Main {

    // Observer to receive stock price updates
    public static class StockObserver implements Observer {
        @Override
        public void update(String symbol, double newPrice) {
            System.out.println("[UPDATE] " + symbol + " price changed to $" + String.format("%.2f", newPrice));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Setup market and user
        StockMarket market = new StockMarket();
        market.addStock("AAPL", 150.0);
        market.addStock("TSLA", 800.0);
        market.addStock("GOOG", 2700.0);
        market.addStock("MSFT", 300.0);

        User user = new User("Alice");
        market.addObserver(new StockObserver());

        // Start price update thread
        PriceUpdater updater = new PriceUpdater(market);
        updater.start();

        // Menu loop
        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Show Top Movers");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.displayStocks();
                    break;
                case 2:
                    System.out.print("Enter Stock Symbol: ");
                    String buySym = sc.next().toUpperCase();
                    System.out.print("Quantity: ");
                    int qtyBuy = sc.nextInt();
                    user.getPortfolio().buy(buySym, qtyBuy);
                    break;
                case 3:
                    System.out.print("Enter Stock Symbol: ");
                    String sellSym = sc.next().toUpperCase();
                    System.out.print("Quantity: ");
                    int qtySell = sc.nextInt();
                    user.getPortfolio().sell(sellSym, qtySell);
                    break;
                case 4:
                    user.getPortfolio().display();
                    break;
                case 5:
                    market.showTopMovers();
                    break;
                case 6:
                    updater.interrupt();  // stop price updater thread
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

