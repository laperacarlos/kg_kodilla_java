package food2door.supplier.service;

import java.util.HashSet;
import java.util.Set;

public class Food2DoorDatabase {
    private final Set<Supplier> suppliersDatabase = new HashSet<>();

    public void addSupplierToDataBase(Supplier supplier) {
        suppliersDatabase.add(supplier);
    }

    public Set<Supplier> getSuppliersDatabase() {
        return suppliersDatabase;
    }
}
