import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClassProductList extends ArrayList {

    public ArrayList<Product> ListOfProducts;
    public ClassProductList() {
        this.ListOfProducts = new ArrayList<Product>();
        File f = new File("src/ProductInfo.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String inp;
            int itemNum = 1;
            while ((inp = reader.readLine()) != null) {
                String[] split = inp.split(":");

                    this.add(new Product(split[0], split[1], this));
                    itemNum++;

            }
        } catch (IOException e) {
            System.out.println("check your file");

        }

    }

}