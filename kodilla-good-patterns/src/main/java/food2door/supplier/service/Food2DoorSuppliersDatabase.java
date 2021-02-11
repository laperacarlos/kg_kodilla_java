package food2door.supplier.service;

import java.util.HashMap;
import java.util.Map;

public class Food2DoorSuppliersDatabase {
    private int supplierId = 0;
    private final Map<Integer, Supplier> suppliersDatabase = new HashMap<>();

    public void addSupplierToDataBase(Supplier supplier) {
        supplierId++;
        suppliersDatabase.put(supplierId, supplier);
    }

    public Map<Integer, Supplier> getSuppliersDatabase() {
        return suppliersDatabase;
    }
}
