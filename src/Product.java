import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Product {


        private Trading trading;

        private ClassProductList classProductList;
        public String ProductCategory;
        public String ProductIs;
        public ArrayList<Person> personList;

        public Product(String name){
            this.ProductIs = name;
        }

        public Product(String type,String name){
            this.ProductCategory = type;
            this.ProductIs=name;

        }
        public ArrayList<Person> getPersonList(){
            File f = new File("src/userProduct.txt");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String inp;
                int itemNum = 1;
                while ((inp = reader.readLine()) != null) {
                    String[] s = inp.split(":");
                    //System.out.println("attaching product"+s[0] + " "+ s[0].equalsIgnoreCase(user.name));
                    if(s[1].equalsIgnoreCase(this.ProductIs)){
                        personList.add(new Buyer());
                    }

                    itemNum++;

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return personList;
        }


}
