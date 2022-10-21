import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Facade {



    private int UserType;

    private Product theSelectedProduct;

    private int nProductCategory;

    private ClassProductList theProductList;

    private Person thePerson;

    JFrame loginFrame;
    JFrame productCategoryFrame;
    String given_username = "";
    String given_password = "";
    String database_UserName = "";
    String database_Password = "";
    int flag=0;
    String temporaryType ="";
    String type1 = "buyer";
    String type2 = "seller";




    public boolean login () {
        System.out.println("Implementing Facade design pattern");
        JLabel userNameLabel;
        JTextField userNameText;
        JLabel passwordLabel;
        JPasswordField passwordText;
        JButton loginButton;
        JButton resetButton;
        JLabel resultFinal;
        ///CHANGE THESE
        String user = "User";
        String pass = "Password";
        String login = "Login";



        loginFrame = new JFrame();
        loginFrame.setLayout(null); //check the
        productCategoryFrame = new JFrame();
        productCategoryFrame.setLayout(null);


        resultFinal = new JLabel("Login Required!!");
        resultFinal.setBounds(150, 0, 500, 25);
        loginFrame.add(resultFinal);

        JRadioButton buyer = new JRadioButton("buyer");
        JRadioButton seller = new JRadioButton("seller");
        ButtonGroup group = new ButtonGroup();
        group.add(buyer);
        group.add(seller);


        buyer.setText("buyer");

        // Setting text of "jRadioButton4".
        seller.setText("seller");

        // Setting Bounds of "jRadioButton2".
        buyer.setBounds(120, 30, 120, 50);

        // Setting Bounds of "jRadioButton4".
        seller.setBounds(250, 30, 80, 50);

        loginFrame.add(buyer);
        loginFrame.add(seller);


        buyer.addActionListener(event -> {
            temporaryType = "buyer";
            UserType = 0;
        });
        seller.addActionListener(event -> {

            temporaryType = "seller";
            UserType = 1;
        });



        userNameLabel = new JLabel(user);
        userNameLabel.setBounds(100, 80, 80, 25);
        loginFrame.add(userNameLabel);

        userNameText = new JTextField(20);
        userNameText.setBounds(200, 80, 165, 25);
        loginFrame.add(userNameText);

        passwordLabel = new JLabel(pass);
        passwordLabel.setBounds(100, 110, 80, 25);
        loginFrame.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(200, 110, 165, 25);
        loginFrame.add(passwordText);


        loginButton = new JButton(login);
        loginButton.setForeground(Color.GREEN);
        loginButton.setBounds(70, 180, 80, 25);
        loginFrame.add(loginButton);

        resetButton = new JButton();
        resetButton.setText("X");
        resetButton.setForeground(Color.RED);
        resetButton.setBounds(300, 0, 50, 23);
        loginFrame.add(resetButton);


        resetButton.addActionListener(event -> loginFrame.setVisible(false));
        loginButton.addActionListener(event -> {
            Scanner scanFile = null;

            given_username = userNameText.getText();
            given_password = new String(passwordText.getPassword());
            File buyerInfoFile = new File("src/BuyerInfo.txt");
            try {
                scanFile = new Scanner(buyerInfoFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (scanFile.hasNextLine()) {
                String data = scanFile.nextLine();
                String[] personInfo = data.split(":");
                database_UserName = personInfo[0];
                database_Password = personInfo[1];
                if (database_UserName.compareTo(given_username) == 0 && database_Password.compareTo(given_password) == 0) {   //validating the credentials
                    flag = 1;
                    break;
                }
            }


            File sellerInfoFile = new File("src/SellerInfo.txt");
            try {
                scanFile = new Scanner(sellerInfoFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            while (scanFile.hasNextLine()) {
                String data = scanFile.nextLine();
                String[] personInfo = data.split(":");
                database_UserName = personInfo[0];
                database_Password = personInfo[1];
                if (database_UserName.compareTo(given_username) == 0 && database_Password.compareTo(given_password) == 0) {   //validating the credentials
                    flag = 1;

                    break;
                }
            }

            // If neither buyer no seller credentials match the current user entered details
            if (flag == 0) {
                resultFinal.setText("Wrong credentials. Please try again!");
            }

            //If user credentials are approved... printing list of products using iterator pattern to the console
            if (flag == 1) {
                loginFrame.dispose();
                SelectProduct();
                theProductList = new ClassProductList();
                createUserType();


                scanFile.close();}
        });


        loginFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        loginFrame.setSize(500, 300);
        loginFrame.setVisible(true);
        return false;











    }

    public int getUserType() {
        if(temporaryType=="buyer"){
            return 0;
        }
        else{
            return 1;
        }

    }

    public void createUserType(){
        if(getUserType()==1){
            Person seller = new Seller();//or seller seller check
            thePerson = seller;
        }
        else{
            Person buyer = new Buyer();
            thePerson = buyer;
        }
    }
    public void SelectProduct() {
          System.out.println("hey");
        JRadioButton produce = new JRadioButton("produce");
        JRadioButton meat = new JRadioButton("meat");
        ButtonGroup group = new ButtonGroup();
        group.add(produce);
        group.add(meat);


        produce.setText("produce");

        // Setting text of "jRadioButton4".
        meat.setText("meat");

        // Setting Bounds of "jRadioButton2".
        produce.setBounds(120, 30, 120, 50);

        // Setting Bounds of "jRadioButton4".
        meat.setBounds(250, 30, 80, 50);
        productCategoryFrame.add(produce);
        productCategoryFrame.add(meat);


        produce.addActionListener(event -> {
            //set whether
            System.out.println("produce is selected");
            nProductCategory = 1;

            productCategoryFrame.dispose();
            productOperation();

        });
        meat.addActionListener(event -> {
            //set whether
            System.out.println("meat is selected");
            nProductCategory = 0;
            productCategoryFrame.dispose();
            productOperation();

        });
        productCategoryFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        productCategoryFrame.setSize(500, 300);
        productCategoryFrame.setVisible(true);




    }

    public void productOperation() {
        ArrayList<String> result = new ArrayList();
        ProductMenu p;
        int count=0;
        p=thePerson.createProductMenu(nProductCategory); //bridge pattern
        result=p.showMenu(theProductList);


        JFrame f= new JFrame();
        DefaultListModel<String> l1 = new DefaultListModel<>();
        while(count< result.size()){
            l1.addElement(result.get(count));
            count+=1;
        }

        JList<String> list = new JList<>(l1);
        JTabbedPane Menu = new JTabbedPane();
        JPanel showMenu = new JPanel();
        JPanel addToMenu = new JPanel();
        JList list1;

        Menu.setBounds(50,50,200,200);
        Menu.add("menu",showMenu);
        Menu.add("addToMenu",addToMenu);
        f.add(Menu);
        JRadioButton radioButton1;
        list.setBounds(200,200, 75,75);
        showMenu.add(list);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);



        //implementing bridge pattern

    }

}
