


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MeatProductMenu implements ProductMenu {



    public ArrayList<String> showMenu(ClassProductList theProductList) {

        ArrayList<String> ListOfProducts = new ArrayList<>();
        int variable = 1;
        ListIterator in = theProductList.getIterator();
        while (in.hasNext()) {
            Product p = (Product) in.Next();
            if (p.ProductCategory.equals("Meat")) {
                System.out.println(variable + ". " + p.ProductIs);
                variable++;
                ListOfProducts.add(p.ProductIs);
            }
        }
        return ListOfProducts;

    }

    public void showAddButton() {
        //JButton button = new JButton(new ImageIcon("images/start.gif"));
       /* JButton addbutton = new JButton("Add");
        frame.add(addbutton);//Jframe -frame for product menu needs to be defioned
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                addbuttonActionPerformed(evt);
            }
        }); */

    }

    public void showViewButton() {
       /* //JButton button = new JButton(new ImageIcon("images/start.gif"));
        JButton viewButton = new JButton("Add");
        frame.add(viewButton);//Jframe -frame for product menu needs to be defioned
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                viewbuttonActionPerformed(evt);
            }
        });
*/
    }

    public void showRadioButton() {
   /*     //JButton button = new JButton(new ImageIcon("images/start.gif"));
        JButton radiobutton = new JButton("Add");
        frame.add(radioButton);//Jframe -frame for product menu needs to be defioned
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                radiobuttonActionPerformed(evt);
            }
        });
*/
    }

    public void showLabels() {

    }

    public void showComBoxes() {

    }

}

