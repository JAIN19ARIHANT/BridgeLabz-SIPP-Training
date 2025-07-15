import java.util.*;

public class Menu implements Search {

    protected Map<String,Product> map = new HashMap<>();

    public void addProduct (Product p) {
        map.put(p.getId(),p);
    }

    public void deleteProduct (String id) {
        if (map.containsKey(id)) {
            map.remove(id);
            System.out.println("Product with product Id " + id + " Deleted");
        }
        else {
            System.out.println("Product does not exit");
            return;
        }

    }

    public void deleteProduct (Product p) {
        map.remove(p.getId());
    }

    public void updateProductPrice (String id, Product p) {
        map.put(id,p);
    }

    public void updateProductPrice (String id, int newPrice) {
        Product p = map.get(id);
        if (p != null) {
            p.setPrice(newPrice);
            System.out.println("\u001B[32mPrice of " + p.getName() + " updated Successfully\u001B[0m");
        }else {
            System.out.println("\u001B[31mProduct not found !!\u001B[0m");
        }
    }

    public void displayAll() {
        for (Product p : map.values()) {
            p.display();
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();

        for (Product p : map.values()) {
            if (p.getName().equalsIgnoreCase(name)) {
                result.add(p);
            }
        }

        if (result.isEmpty())   {
            System.out.println("\u001B[31mNO product Exist\u001B[0m");
            return new ArrayList<>();
        }

        return result;
    }

    @Override
    public List<Product> searchByItem(String type) {
        List<Product> result = new ArrayList<>();

        for (Product p : map.values()) {
            if (p.getType().equalsIgnoreCase(type)) {
                result.add(p);
            }
        }

        if (result.isEmpty()) {
            System.out.println("\u001B[31mProduct does not exist\u001B[0m");
        }

        return result;
    }

    public List<Product> sortByPrice() {
        List<Product> sortPrice = new ArrayList<>(map.values());
        sortPrice.sort(Comparator.comparingInt(Product::getPrice));
        return sortPrice;
    }

    public List<Product> sortByName() {
        List<Product> sortName = new ArrayList<>(map.values());
        sortName.sort(Comparator.comparing(Product::getName));
        return sortName;
    }

}
