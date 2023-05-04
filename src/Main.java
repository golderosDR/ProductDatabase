import java.io.File;
import java.util.*;
import java.io.IOException;
import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) throws IOException {

        boolean resDirectory = new File("./res").mkdirs();
        System.out.println("Creating products...");

        Product product0 = new Product("Milk Milrama 1,5, 1l", 1.27, Category.FOOD);
        //чтобы отслеживать корректно ли время
        wait(1000);
        Product product1 = new Product("EPSON XP-2100", 110.99, Category.ELECTRONICS);
        wait(1000);
        Product product2 = new Product("Winter jacket with a zipper, sintipon", 50.65, Category.CLOTH);
        wait(1000);
        Product product3 = new Product("Detergent Ariel, 4 l", 13.99, Category.HOUSEHOLD);
        wait(1000);
        Product product4 = new Product("Soccer ball, natural leather", 30.00, Category.SPORT);

        System.out.println("Creating list of products...");
        wait(1000);
        List<Product> productList = new ArrayList<>(List.of(product0, product1, product2, product3, product4));

        product0.setPrise(1.50);

        product4.setPrise();//вручную через сканер

        HashMap<String, Double> productMap = getProductMap(productList);
        printProductMap(productMap);


    }

    public static void wait(int ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ignored) {}
    }
    public static HashMap<String, Double> getProductMap(List<Product> productList) {
        HashMap<String, Double> productMap = new HashMap<>();
        for (Product product: productList) {
            productMap.put(product.getName(), product.getPrise());
        }
        return  productMap;
    }
    public static void printProductMap(Map<String, Double> productMap) {
        if (!productMap.isEmpty()) {
            System.out.println();
            for (String name: productMap.keySet() ) {
                System.out.printf("Name: %s, current prise : %.2f Euro.%n",name, productMap.get(name));
            }
        }
    }

}