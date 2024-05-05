import java.util.Observable;
import java.util.Observer;

public class DeliveryService implements Observer {
    @Override
    public void update(Observable item, Object arg) {
    }
    public void update(String item) {
        System.out.println("Товар \"" + item + "\" был куплен. Нужно организовать доставку.");
    }
}