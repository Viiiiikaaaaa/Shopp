import java.util.Map;

public class DeliveryService implements Observer {
    Subject shop;
    public DeliveryService(Subject shop)
    {
        this.shop=shop;
        shop.registerObserver(this);
    }

    public void update(String item, Map<String, Integer> price,Map<String, Integer> quantity) {
        if (quantity.containsKey(item)) {
            int previousQuantity = quantity.get(item) + 1;
            System.out.println("Товар \"" + item + "\" был куплен. Нужно организовать доставку.");
        }
    }
}