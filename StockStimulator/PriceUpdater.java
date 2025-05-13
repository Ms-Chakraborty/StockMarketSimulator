import java.util.*;

public class PriceUpdater extends Thread {
    private StockMarket market;
    private Random rand = new Random();

    public PriceUpdater(StockMarket market) {
        this.market = market;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // Update every 5 seconds
                for (String symbol : market.getSymbols()) {
                    double change = (rand.nextDouble() - 0.5) * 10; // +/-5% approx
                    Stock stock = market.getStock(symbol);
                    double newPrice = Math.max(1.0, stock.getPrice() + change);
                    market.updatePrice(symbol, newPrice);
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
