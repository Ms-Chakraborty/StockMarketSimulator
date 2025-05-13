import java.util.HashMap;

public class Portfolio {
    private HashMap<String, Integer> holdings = new HashMap<>();

    public void buy(String symbol, int qty) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + qty);
    }

    public void sell(String symbol, int qty) {
        if (holdings.containsKey(symbol)) {
            int current = holdings.get(symbol);
            if (qty >= current) {
                holdings.remove(symbol);
            } else {
                holdings.put(symbol, current - qty);
            }
        }
    }

    public void display() {
        System.out.println("Your Portfolio:");
        for (String symbol : holdings.keySet()) {
            System.out.println(symbol + " x " + holdings.get(symbol));
        }
    }
}
