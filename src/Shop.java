import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин мебели! В наличии столы, диваны, шкафы, кухни, кресла и многое другое!");
        System.out.println("Если Вы хотите совершить покупку, введите название мебели!");
        System.out.println("Для вывода в консоль текущей выручки введите \"income\",\" \"  и пароль администратора");
        System.out.println("Для просмотра количества товара на складе введите \"товары\"");
        System.out.println("Для завершения работы введите \"break\"");
        Warehouse wh = new Warehouse();

        Map<String, Integer> price = new HashMap();
        price.put("стол", 10000);
        price.put("шкаф", 50000);
        price.put("кресло", 7500);
        price.put("кухня", 150000);
        price.put("диван", 35000);
        price.put("кровать", 25000);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String item = scanner.nextLine();

            if (item.equals("break")) {
                return;
            }

            if (item.equals("товары")) {
                wh.printWarehouse();
            }

            else if (item.indexOf(" ") >= 0) {
                Accounting.getInstance().getIncome(item.substring(item.indexOf(" ") + 1));
            }

            else if (price.containsKey(item)) {
                wh.update(item);
                Accounting.getInstance().update((Integer)price.get(item));
            }

            else {
                System.out.println("Товара \"" + item + "\" нет на складе.");
            }
        }
    }
}

