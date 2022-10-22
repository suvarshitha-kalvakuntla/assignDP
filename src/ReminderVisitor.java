import java.util.ArrayList;
import java.util.Iterator;

public class ReminderVisitor extends NodeVisitor{

    private Reminder m_Reminder;

    private ClassProductList classProductList;

    /**
     *visits all the person objects associated with provided product object
     */
    public void visitProduct(Product product) {
        System.out.println("###################################");
        System.out.println("implementing visitor pattern");
        System.out.println("visiting person nodes associated with this product");
        System.out.println("###################################");
        for (int i = 0; i < product.getPersonList().size(); i++) {
            Person currentProduct = product.getPersonList().get(i);
            System.out.println(currentProduct.toString());

        }


    }

    public void visitTrading(Trading trading) {

    }

    /**
     *visits all products of required type
     */

    public void visitFacade(Facade wrapperObject) {


        System.out.println("###################################");
        System.out.println("using Iterator pattern");
        System.out.println("###################################");
        ListIterator p = wrapperObject.theProductList.getIterator();
        System.out.println("using Visitor pattern to visit facade productlist");
        System.out.println("###################################");
        while (p.hasNext()) {
            Product pro = (Product) p.Next();

        }



    }
}
