import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopDm {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин мебели! В наличии столы, диваны, шкафы, кухни, кресла и многое другое!");
        System.out.println("Если Вы хотите совершить покупку, введите название мебели!");
        System.out.println("Для вывода в консоль текущей выручки введите \"income\",\" \"  и пароль администратора");
        System.out.println("Для просмотра количества товара на складе введите \"товары\"");
        System.out.println("Для завершения работы введите \"break\"");
        Shop shop = new Shop();
        Warehouse wh = new Warehouse(shop);
        Accounting ac = Accounting.getInstance(shop);
        DeliveryService ds = new DeliveryService(shop);
        // создать ас объект, доставки (передать в конструктор wh) в конструкторе и ас и доставке нужно вызвать у склада ? метод addОbs. в конст.

        Map<String, Integer> price = new HashMap();
        price.put("стол", 10000);
        price.put("шкаф", 50000);
        price.put("кресло", 7500);
        price.put("кухня", 150000);
        price.put("диван", 35000);
        price.put("кровать", 25000);

        Map<String, Integer> quantity = new HashMap();
        quantity.put("стол", 10);
        quantity.put("шкаф", 5);
        quantity.put("кресло", 5);
        quantity.put("кухня", 2);
        quantity.put("диван", 3);
        quantity.put("кровать", 2);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String item = scanner.nextLine();

            if (item.equals("break")) {
                return;
            }
            else {
                shop.notifyObservers(item,price,quantity);

            }
        }
    }
}

