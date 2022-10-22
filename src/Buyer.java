import java.util.ArrayList;

public class Buyer extends Person{
    private Seller seller;

    private Person person;

    public ArrayList<Product> ProductList = new ArrayList<>();

    public void showMenu() {


    }

    /**
     *based on product category class object is created
     */
    public ProductMenu createProductMenu(int nProductCategory) {
        ProductMenu productMenu;
        System.out.println("Factory pattern is implemented");
        if(nProductCategory == 0){
             productMenu = new MeatProductMenu();
        }
        else {
             productMenu = new ProduceProductMenu();
        }
        return productMenu;
    }

    /**
     *provided product is added to product list associated with buyer
     */
    public void AddToProductList(String p){
        Product product = new Product(p);
        ProductList.add(product);
        System.out.println("added to product list");

    }
    /**
     *returns product list
     */
    public ArrayList<Product> getProductList(){
        return ProductList;
    }

}
