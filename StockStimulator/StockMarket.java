import java.util.*;

public class StockMarket implements Subject {
    private HashMap<String, Stock> stockList = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    // Add a new stock to the market
    public void addStock(String symbol, double price) {
        stockList.put(symbol.toUpperCase(), new Stock(symbol.toUpperCase(), price));
    }

    // Get a stock by symbol
    public Stock getStock(String symbol) {
        return stockList.get(symbol.toUpperCase());
    }

    // Display all available stocks
    public void displayStocks() {
        System.out.println("\nAvailable Stocks:");
        for (Stock stock : stockList.values()) {
            System.out.printf("%s - $%.2f (%.2f%%)\n",
                stock.getSymbol(),
                stock.getPrice(),
                stock.getChangePercent());
        }
    }

    // Update the price of a stock and notify observers
    public void updatePrice(String symbol, double newPrice) {
        symbol = symbol.toUpperCase();
        if (stockList.containsKey(symbol)) {
            stockList.get(symbol).setPrice(newPrice);
            notifyObservers(symbol, newPrice);
        }
    }

    // Return all stock symbols
    public Set<String> getSymbols() {
        return stockList.keySet();
    }

    // Show top 3 gainers and top 3 losers based on % change
    public void showTopMovers() {
        PriorityQueue<Stock> gainers = new PriorityQueue<>(
            (a, b) -> Double.compare(b.getChangePercent(), a.getChangePercent()));
        PriorityQueue<Stock> losers = new PriorityQueue<>(
            (a, b) -> Double.compare(a.getChangePercent(), b.getChangePercent()));

        for (Stock s : stockList.values()) {
            if (s.getChangePercent() >= 0) {
                gainers.offer(s);
            } else {
                losers.offer(s);
            }
        }

        System.out.println("\n📈 Top Gainers:");
        for (int i = 0; i < 3 && !gainers.isEmpty(); i++) {
            Stock s = gainers.poll();
            System.out.printf("%s: %.2f%%\n", s.getSymbol(), s.getChangePercent());
        }

        System.out.println("\n📉 Top Losers:");
        for (int i = 0; i < 3 && !losers.isEmpty(); i++) {
            Stock s = losers.poll();
            System.out.printf("%s: %.2f%%\n", s.getSymbol(), s.getChangePercent());
        }
    }

    // Observer Pattern methods
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String symbol, double newPrice) {
        for (Observer o : observers) {
            o.update(symbol, newPrice);
        }
    }
}

