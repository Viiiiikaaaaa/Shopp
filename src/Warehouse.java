import java.util.*;

public class Warehouse implements Observer {

    List<Observer> observers = new ArrayList<>();
    Subject shop;

    public Warehouse(Subject shop) {
        this.shop = shop;
        shop.registerObserver(this);
    }

    public void update(String item,Map <String, Integer> price,Map<String, Integer> quantity) {
        if (quantity.containsKey(item)) {
            int prevValue = quantity.get(item);
            if (prevValue == 0) {
                System.out.println("Товара \"" + item + "\" нет на складе.");
            } else {
                System.out.println("Спасибо за покупку!");
                quantity.put(item, prevValue - 1);
            }
        }
        else
        if (item.equals("товары"))
            printWarehouse(quantity);
    }

    public void printWarehouse(Map<String, Integer> quantity)
    {
        for (var pr: quantity.entrySet())
            System.out.println(pr + " шт.");
    }
}
