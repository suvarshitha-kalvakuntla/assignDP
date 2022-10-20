


import javax.swing.*;

public class MeatProductMenu implements ProductMenu {

    public void showMenu() {

    }

    public void showAddButton() {
        //JButton button = new JButton(new ImageIcon("images/start.gif"));
        JButton addbutton = new JButton("Add");
        frame.add(addbutton);//Jframe -frame for product menu needs to be defioned
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                addbuttonActionPerformed(evt);
            }
        });

    }

    public void showViewButton() {
        //JButton button = new JButton(new ImageIcon("images/start.gif"));
        JButton viewButton = new JButton("Add");
        frame.add(viewButton);//Jframe -frame for product menu needs to be defioned
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                viewbuttonActionPerformed(evt);
            }
        });

    }

    public void showRadioButton() {
        //JButton button = new JButton(new ImageIcon("images/start.gif"));
        JButton radiobutton = new JButton("Add");
        frame.add(radioButton);//Jframe -frame for product menu needs to be defioned
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // delegate to event handler method
                radiobuttonActionPerformed(evt);
            }
        });

    }

    public void showLabels() {

    }

    public void showComBoxes() {

    }

}

