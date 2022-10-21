public class Seller extends Person{
    private Buyer buyer;

    public void showMenu() {

    }
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
}
