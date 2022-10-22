import java.util.ArrayList;

public class Seller extends Person{
    private Buyer buyer;
    public ArrayList<Product> ProductList = new ArrayList<>();

    public void showMenu() {

    }
    /**
     *creates product menu based on selection
     */
    public ProductMenu createProductMenu(int nProductCategory) {
        ProductMenu productMenu;
        System.out.println("Factory pattern is implemented here");
        if(nProductCategory == 0){
            productMenu = new MeatProductMenu();
        }
        else {
            productMenu = new ProduceProductMenu();
        }
        return productMenu;
    }
    /**
     *provided product is added to product list associated with seller
     */
    public void AddToProductList(String p){
        Product product = new Product(p);
        ProductList.add(product);

    }
    /**
     *returns product list
     */
    public ArrayList<Product> getProductList(){
        return ProductList;
    }

}
