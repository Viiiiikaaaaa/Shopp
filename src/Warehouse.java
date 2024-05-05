import java.util.*;

interface Observer {
    void update(String item);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String item);
}

public class Warehouse implements Subject {
    Map<String, Integer> quantity = new HashMap();
    List<Observer> observers = new ArrayList<>();
    public Warehouse() {
        this.quantity.put("стол", 10);
        this.quantity.put("шкаф", 5);
        this.quantity.put("кресло", 5);
        this.quantity.put("кухня", 2);
        this.quantity.put("диван", 3);
        this.quantity.put("кровать", 2);
    }

    public void update(String item) {
        int prevValue = (Integer)this.quantity.get(item);
        if (prevValue == 0) {
            System.out.println("Товара \"" + item + "\" нет на складе.");
        } else {
            System.out.println("Спасибо за покупку!");
            DeliveryService ds = new DeliveryService();
            ds.update(item);
            --prevValue;
            this.quantity.put(item, prevValue);
            notifyObservers(item);
        }

    }

    public void printWarehouse() {
        Iterator var1 = this.quantity.entrySet().iterator();

        while(var1.hasNext()) {
            Map.Entry<String, Integer> pr = (Map.Entry)var1.next();
            System.out.println("" + pr + " шт.");
        }

    }

    @Override
    public void addObserver(Observer observer) {
    }

    @Override
    public void removeObserver(Observer observer) {
    }

    @Override
    public void notifyObservers(String item) {
    }
}
