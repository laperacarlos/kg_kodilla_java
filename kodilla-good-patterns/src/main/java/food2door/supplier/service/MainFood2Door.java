package food2door.supplier.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFood2Door {

    public static void main(String[] args) {
        NewProduct productToDataBase1 = new NewProduct(1, "Marchew", 75);
        NewProduct productToDataBase2 = new NewProduct(2, "Kapusta", 65);
        NewProduct productToDataBase3 = new NewProduct(3, "Por", 50);
        NewProduct productToDataBase4 = new NewProduct(4, "Cebula", 26);
        NewProduct productToDataBase5 = new NewProduct(5, "Pomidor", 90);
        NewProduct productToDataBase6 = new NewProduct(6, "Groch", 75);

        NewProduct productToOrder1 = new NewProduct(1, "Marchew", 2);
        NewProduct productToOrder2 = new NewProduct(2, "Kapusta", 3);
        NewProduct productToOrder3 = new NewProduct(3, "Por", 1);


        List<ProductData> listToDatabase1 = new ArrayList<>(Arrays.asList(productToDataBase1, productToDataBase2, productToDataBase3));
        List<ProductData> listToDatabase2 = new ArrayList<>(Arrays.asList(productToDataBase4, productToDataBase5, productToDataBase6));
        List<ProductData> listToOrder = new ArrayList<>(Arrays.asList(productToOrder1, productToOrder2, productToOrder3));

        ExtraFoodShop extraFoodShop = new ExtraFoodShop(listToDatabase1);
        HealthyShop healthyShop = new HealthyShop(listToDatabase2);

        Food2DoorDatabase food2DoorDatabase = new Food2DoorDatabase();
        food2DoorDatabase.addSupplierToDataBase(extraFoodShop);
        food2DoorDatabase.addSupplierToDataBase(healthyShop);

        NewRequest newRequest = new NewRequest(76743, extraFoodShop, listToOrder);

        OrderService orderService = new OrderService();
        orderService.process(newRequest);

        System.out.println(food2DoorDatabase.getSuppliersDatabase().size());
        System.out.println(extraFoodShop.getProductDatabase().size());
        System.out.println(healthyShop.getProductDatabase().size());
    }
}
