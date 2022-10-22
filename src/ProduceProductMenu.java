import java.util.ArrayList;

public class ProduceProductMenu implements  ProductMenu {
    /**
     *displays menu based on type of product selected
     */
    public ArrayList showMenu(ClassProductList theProductList) {
        System.out.println("###################################");
        System.out.println("using iterator pattern to iterate over produce products");
        System.out.println("###################################");
        ArrayList<String> ListOfProducts = new ArrayList<>();
        int variable = 1;
        ListIterator in = theProductList.getIterator();
        while (in.hasNext()) {
            Product p = (Product) in.Next();
            if (p.ProductCategory.equals("Produce")) {
                System.out.println(variable + ". " + p.ProductIs);
                variable++;
                ListOfProducts.add(p.ProductIs);

            }
        }
        return ListOfProducts;
    }
}
