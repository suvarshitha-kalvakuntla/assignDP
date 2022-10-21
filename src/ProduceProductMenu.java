import java.util.ArrayList;

public class ProduceProductMenu implements  ProductMenu {
    public ArrayList showMenu(ClassProductList theProductList) {
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
