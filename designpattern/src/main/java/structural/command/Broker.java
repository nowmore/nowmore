package structural.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {

    private List<Order> orders = new ArrayList<>();

    public void take(Order order) {
        orders.add(order);
    }

    public void place() {
        for (Order o : orders) {
            o.execute();
        }

        orders.clear();
    }


    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buy = new BuyStock(stock);
        SellStock sell = new SellStock(stock);

        Broker broker = new Broker();

        broker.take(buy);
        broker.take(sell);

        broker.place();
    }
}
