import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Facade {
    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    public ClassProductList theProductList;
    private Person thePerson;
    JFrame productCategoryFrame;
    String given_username = "";
    String given_password = "";
    String savedID = "";
    String savedPasscode = "";
    int flag=0;
    String temporaryType ="";






    public boolean login () {
        JFrame loginFrame;
        System.out.println("###################################");
        System.out.println("using Facade design pattern for login");
        System.out.println("###################################");
        JLabel userNameLabel;
        JTextField userNameText;
        JLabel passwordLabel;
        JPasswordField passwordText;
        JButton loginButton;
        JButton resetButton;
        JLabel resultFinal;
        String user = "User";
        String pass = "Password";
        String login = "Login";

/**
 *creating a JFrame for login
 */
        loginFrame = new JFrame();
        loginFrame.setLayout(null); //check the
        productCategoryFrame = new JFrame();
        productCategoryFrame.setLayout(null);

        /**
         *creating labels and UI elements for login window
         */

        resultFinal = new JLabel("Login Required!!");
        resultFinal.setBounds(150, 0, 500, 25);
        loginFrame.add(resultFinal);

        JRadioButton buyer = new JRadioButton("buyer");
        JRadioButton seller = new JRadioButton("seller");
        ButtonGroup group = new ButtonGroup();
        group.add(buyer);
        group.add(seller);


        buyer.setText("buyer");

        // Setting text of "seller".
        seller.setText("seller");

        // Setting Bounds of "buyer".
        buyer.setBounds(120, 30, 120, 50);

        // Setting Bounds of "seller".
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

        /**
         adding buttons for login and close
         */

        loginButton = new JButton(login);
        loginButton.setForeground(Color.GREEN);
        loginButton.setBounds(70, 180, 80, 25);
        loginFrame.add(loginButton);

        resetButton = new JButton();
        resetButton.setText("X");
        resetButton.setForeground(Color.RED);
        resetButton.setBounds(400, 0, 50, 23);
        loginFrame.add(resetButton);

        resetButton.addActionListener(event -> loginFrame.setVisible(false));
        loginButton.addActionListener(event -> {
            Scanner scanFile = null;

            /**
             input of details and authentication of user
             */

            given_username = userNameText.getText();
            given_password = new String(passwordText.getPassword());
            if(UserType==0){
                File buyerInfoFile = new File("src/BuyerInfo.txt");
                try {
                    scanFile = new Scanner(buyerInfoFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                File sellerInfoFile = new File("src/SellerInfo.txt");
                try {
                    scanFile = new Scanner(sellerInfoFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            while (scanFile.hasNextLine()) {
                String data = scanFile.nextLine();
                String[] personInfo = data.split(":");
                savedID = personInfo[0];
                savedPasscode = personInfo[1];
                if (savedID.compareTo(given_username) == 0 && savedPasscode.compareTo(given_password) == 0) {   //validating the credentials
                    flag = 1;
                    break;

                }
            }




            // if credentials donot match return error message
            if (flag == 0) {
                resultFinal.setText("Wrong credentials. Please try again!");
            }

            //if logged in successfully, the user sees a pop up asking for product preferences
            if (flag == 1) {
                System.out.println("###################################");
                System.out.println("logged in successfully");
                System.out.println("###################################");
                loginFrame.dispose();
                SelectProduct();
                theProductList = new ClassProductList();
                UserInformation userinfo = new UserInformation(savedID);
                userinfo.userType = getUserType();
                try {
                    createUser(userinfo);
                } catch (FileNotFoundException e) {
                    System.out.println(("file not found"));
                }
                scanFile.close();


            }
        });


        loginFrame.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        loginFrame.setSize(500, 300);
        loginFrame.setVisible(true);
        return false;





    }
    /**
     *returns user type i.e buyer/seller
     */

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

    /**
     *selects product
     */
    public void SelectProduct() {

        JRadioButton produce = new JRadioButton("produce");
        JRadioButton meat = new JRadioButton("meat");
        ButtonGroup group = new ButtonGroup();
        group.add(produce);
        group.add(meat);
        JLabel temp;
        temp = new JLabel("select product type!!");
        temp.setBounds(150, 0, 500, 25);
        productCategoryFrame.add(temp);


        produce.setText("produce");

        // Setting text of "meat".
        meat.setText("meat");

        // Setting Bounds of "produce".
        produce.setBounds(120, 60, 120, 50);

        // Setting Bounds of "meat".
        meat.setBounds(250, 60, 80, 50);
        productCategoryFrame.add(produce);
        productCategoryFrame.add(meat);


        produce.addActionListener(event -> {
            //selection enabled for buyer/seller for choosing produce or meat
            System.out.println("user selected produce");
            nProductCategory = 1;

            productCategoryFrame.dispose();
            productOperation();

        });
        meat.addActionListener(event -> {

            System.out.println("user selected meat");
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
        System.out.println("###################################");
        System.out.println("implementing bridge pattern for creating menu of selected product type");
        System.out.println("###################################");
        p=thePerson.createProductMenu(nProductCategory); //bridge pattern
        result=p.showMenu(theProductList);
        Facade facade = new Facade();
        facade.theProductList = this.theProductList;
        ReminderVisitor r = new ReminderVisitor();
        r.visitFacade(facade);


        JFrame f= new JFrame();
        DefaultListModel<String> l1 = new DefaultListModel<>();
        while(count < result.size()){
            l1.addElement(result.get(count));
            count+=1;
        }
        count=0;
        DefaultListModel<String> l2 = new DefaultListModel<>();
        while(count < thePerson.getProductList().size()){
            l2.addElement(thePerson.getProductList().get(count).ProductIs);
            count+=1;
        }
        JLabel temp;
        temp = new JLabel("select menu type!!");
        temp.setBounds(150, 0, 500, 25);
        f.add(temp);

        JList<String> list = new JList<>(l1);
        JList<String> list2 = new JList<>(l1);
        JList<String> list3 = new JList<>(l2);
        JTabbedPane Menu = new JTabbedPane();
        JPanel showMenu = new JPanel();
        JPanel addToMenu = new JPanel();
        JPanel viewUserProductList = new JPanel();


        Menu.setPreferredSize(new Dimension(600,400));
        Menu.setBounds(50,50,200,200);
        Menu.add("menu",showMenu);
        Menu.add("addMenu",addToMenu);
        Menu.add("List",viewUserProductList);
        f.add(Menu);

        showMenu.add(list);
        addToMenu.add(list2);
        viewUserProductList.add(list3);
        list3.setBounds(200,100, 75,75);
        JButton addButton = new JButton("ADD");
        addButton.setForeground(Color.GREEN);
        addButton.setBounds(80, 400, 100, 55);
        addToMenu.add(addButton);
        addButton.addActionListener(event -> {
            addTrading();

        });

        JLabel labelViewList = new JLabel("user info products!!");
        labelViewList.setBounds(150, 0, 200, 25);
        viewUserProductList.add(labelViewList);


        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

        //implementing bridge pattern

    }
    /**
     *adds trading product
     */
    public void addTrading() {
        System.out.println("Added product for trading for the user of type" +temporaryType );

    }

    /**
     *all the products associated with loggedin user are attached
     *  to the user and are viewable on using List tab
     */

    public void AttachProductToUser(UserInformation user) throws FileNotFoundException {
        File f = new File("src/userProduct.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String inp;
            int itemNum = 1;
            while ((inp = reader.readLine()) != null) {
                String[] s = inp.split(":");
                if(s[0].equalsIgnoreCase(user.name)){
                    thePerson.AddToProductList(s[1]);
                }

                itemNum++;

            }

    } catch (IOException e) {
            throw new RuntimeException(e);
        }}
    /**
     *creates user based on type
     */

        public void createUser(UserInformation userinfoitem) throws FileNotFoundException {
        System.out.println("###################################");
        System.out.println("using factory method for creating person objects dynamically");
        System.out.println("###################################");
        System.out.println("user information is" +userinfoitem.userType + userinfoitem.name);
        System.out.println("###################################");
        if (userinfoitem.userType == 0) {
            thePerson = new Buyer();
            System.out.println("buyer object created");


        } else if (userinfoitem.userType == 1) {
            thePerson = new Seller();
            System.out.println("seller object created");
        }
            AttachProductToUser(userinfoitem);

    }

}
