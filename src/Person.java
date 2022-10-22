import java.util.ArrayList;

public abstract class Person {
    private ProductMenu theProductMenu;

    private Buyer buyer;

    private ProductMenu productMenu;

    public ArrayList<Product> ProductList = new ArrayList<>();

    public void showMenu() {

    }

    public void showAddButton() {

    }

    public void showViewButton() {

    }

    public void showRadioButton() {

    }

    public void showLabels() {

    }

    public abstract ProductMenu createProductMenu(int nProductCategory);
    public void AddToProductList(String p){

    }
    public ArrayList<Product> getProductList(){
        return ProductList;
    }

}
