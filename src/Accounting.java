public class Accounting  {
    private static Accounting instance;
    private int income = 0;
    private final String PASSWORD = "admin";

    private Accounting() {
    }

    public static Accounting getInstance() {
        if (instance == null) {
            instance = new Accounting();
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

}
