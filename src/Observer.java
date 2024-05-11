import java.util.Map;

interface Observer {
    void update(String item, Map<String, Integer> price, Map<String, Integer> quantity);
}