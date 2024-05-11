import java.util.Map;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String item, Map<String, Integer> price, Map<String, Integer> quantity);
}
