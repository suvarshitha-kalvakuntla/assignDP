import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClassProductList extends ArrayList {

    public ArrayList<Product> ListOfProducts;
    public ProductIterator iterator;

    public ClassProductList() {
        this.ListOfProducts = new ArrayList<Product>();
        System.out.println("using iterator pattern");
        this.iterator = new ProductIterator(this    );
        File f = new File("src/ProductInfo.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String inp;
            int itemNum = 1;
            while ((inp = reader.readLine()) != null) {
                String[] s = inp.split(":");

                    add(new Product(s[0], s[1]));
                    itemNum++;

            }
            System.out.println(ListOfProducts);
        } catch (IOException e) {
            System.out.println("check your file");

        }

    }

    public ProductIterator getIterator() {
        return this.iterator;
    }
}
