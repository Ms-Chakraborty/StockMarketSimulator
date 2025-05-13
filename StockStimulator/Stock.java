public class Stock {
    private String symbol;
    private double price;
    private double initialPrice;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        this.initialPrice = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChangePercent() {
        return ((price - initialPrice) / initialPrice) * 100;
    }
}
