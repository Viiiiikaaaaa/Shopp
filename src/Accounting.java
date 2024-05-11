import java.util.Map;

public class Accounting implements Observer{
    private static Accounting instance;
    private int income = 0;
    private final String PASSWORD = "admin";
    private static Subject shop;

    private Accounting(Subject shop) {
        Accounting.shop=shop;
        shop.registerObserver(this);
    }

    public static Accounting getInstance(Subject shop) {
        if (instance == null) {
            instance = new Accounting(shop);
        }
        return instance;
    }

    public void getIncome(String psw) {
        if (psw.equals("admin")) {
            System.out.println("Your income is " + this.income);
        } else {
            System.out.println("Неверный пароль");
        }

    }

    public void update(int newOrder) {

        this.income += newOrder;
    }


    public void update(String item, Map<String, Integer> price, Map<String, Integer> quantity) {
        System.out.println("Выручка увеличена на " + price.get(item));
    }
}
