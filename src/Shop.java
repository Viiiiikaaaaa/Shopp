import java.util.ArrayList;
import java.util.Map;

public class Shop implements Subject{

    ArrayList<Observer> obsList = new ArrayList<>();

    public void registerObserver(Observer observer)
    {
        obsList.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (obsList.contains(observer)) {
            obsList.remove(observer);
        }
    }

    public void notifyObservers(String item, Map<String, Integer> price, Map<String, Integer> quantity) {
        for (Observer observer : obsList) {
            observer.update(item, price, quantity);
        }
    }
}
