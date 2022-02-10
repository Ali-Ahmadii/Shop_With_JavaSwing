import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.*;
public class main {
    public static void main(String[] args) {
        homepage(0, "anything");
    }
    public static void sellerproductsreporter(String name){
        File insideofmyproducts = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller\\"+name +"\\products");
        int counter = insideofmyproducts.list().length;
        JFrame mainfarme = new JFrame();
        mainfarme.setBounds(370, 100, 800, 600);
        mainfarme.setVisible(true);
        mainfarme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel uppanel = new JPanel();
        JPanel centeralpanel = new JPanel();
        JButton backbutton = new JButton("Back");

        String column[] = {"Product Name","Product Price","Availibility","Product Category"};
        String data[][]=new String[counter][4];

        JTable productstable = new JTable(data,column);
        JScrollPane productpane = new JScrollPane(productstable);
        productpane.setVisible(true);



        String productscontetnts[]=insideofmyproducts.list();

        int i = 0;
        while(i<counter){
            File specificproduct = new File(insideofmyproducts+"\\"+productscontetnts[i]);
            File pname = new File(specificproduct+"\\productname.txt");
            File pprice = new File(specificproduct+"\\price.txt");
            File pava = new File(specificproduct +"\\count.txt");
            File pcategory = new File(specificproduct+"\\productcategory.txt");
            try {
                Scanner writename = new Scanner(pname);
                data[i][0]=writename.nextLine();
                writename.close();
            } catch (Exception e) {
            }
            try {
                Scanner writeprice = new Scanner(pprice);
                data[i][1]=writeprice.nextLine();
                writeprice.close();
            } catch (Exception e) {
            }
            try {
                Scanner writenumber = new Scanner(pava);
                data[i][2]=writenumber.nextLine();
                writenumber.close();
            } catch (Exception e) {
            }
            try {
                Scanner writecategory = new Scanner(pcategory);
                data[i][3]=writecategory.nextLine();
                writecategory.close();
            } catch (Exception e) {
            }
            i++;
        }

        mainfarme.add(uppanel,BorderLayout.NORTH);
        uppanel.add(backbutton);
        mainfarme.add(productpane);
        backbutton.addActionListener(e->{
            mainfarme.dispose();
            sellerpage(name);
        });

    }

    public static void deleter (Path path) throws IOException{
        Files.walk(path).sorted(Comparator.reverseOrder()).map(Path :: toFile).forEach(File :: delete);
    }

    public static void copyDir(Path src, Path dest) throws IOException {
        Files.walk(src)
                .forEach(source -> {
                    try {
                        Files.copy(source, dest.resolve(src.relativize(source)),
                        StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void boughtproducts(String name){
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setVisible(true);
        mainframe.setResizable(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel uppanel = new JPanel();
        JPanel centerlpanel = new JPanel();
        JButton backbutton = new JButton("Back");
        File counter = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client"+"\\"+name+"\\finalbuy\\");
        if(!counter.exists()){
            counter.mkdirs();
        }
        int tellmenumber = counter.list().length;
        String insidefinalbuy[] = counter.list();
        String data[][]=new String[tellmenumber][4];
        int i =0;
        if(!counter.exists()){
            tellmenumber=0;
        }
        while(i<tellmenumber){
            File nameofproduct = new File(counter+"\\"+insidefinalbuy[i]+"\\productname.txt");
            File priceofproduct = new File(counter+"\\"+insidefinalbuy[i]+"\\x1price.txt");
            File choosennumber = new File(counter+"\\"+insidefinalbuy[i]+"\\number.txt");
            File productcode = new File(counter+"\\"+insidefinalbuy[i]+"\\productcode.txt");
            try {
                Scanner scanname = new Scanner(nameofproduct);
                data[i][0]=scanname.nextLine();
                scanname.close();
            } catch (Exception e1) {
            }
            try {
                Scanner scanprice = new Scanner(priceofproduct);
                data[i][1]=scanprice.nextLine();
                scanprice.close();
            } catch (Exception e2) {
            }
            try {
                Scanner scannumber = new Scanner(choosennumber);
                data [i][2]=scannumber.nextLine();
                scannumber.close();
            } catch (Exception e3) {
            }
            try {
                Scanner scancode = new Scanner(productcode);
                data[i][3]=scancode.nextLine();
                scancode.close();
            } catch (Exception e) {
            }

            i++;
        }   
        String column[]={"Product Name","Price","Number","Product Code"};

        JTable jt=new JTable(data,column); 
        JScrollPane js=new JScrollPane(jt);
        js.setVisible(true);
        backbutton.addActionListener(e->{
            mainframe.dispose();
            clientpage(name);
        });
        mainframe.add(uppanel,BorderLayout.NORTH);
        uppanel.add(backbutton);
        mainframe.add(js);
    }


    public static void clientpage(String name){
        int falg=1;
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon shoppic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\shop.png");
        ImageIcon clientback = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\clientback.jpg");
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setVisible(true);
        mainframe.setResizable(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel hellolabel = new JLabel("Hello" +name);
        hellolabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JLabel backgroundlabel = new JLabel();
        backgroundlabel.setIcon(clientback);
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setBorderPainted(false);
        homebutton.setContentAreaFilled(false);
        JButton boughbutton = new JButton("Bough Products");

        JButton buyworth = new JButton();
        buyworth.setBounds(450, 100, 200, 50);
        buyworth.setBorderPainted(false);
        buyworth.setBackground(Color.white);
        buyworth.setForeground(Color.black);
        File buyworthfile = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client"+"\\"+name +"\\"+"buyfolder\\buyworth.txt");
        try {
            Scanner buyworthscan = new Scanner(buyworthfile);
            String piiii = buyworthscan.nextLine();
            buyworth.setText(piiii);
        } catch (Exception e) {
        }


        boughbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        boughbutton.setBounds(100, 100, 200, 50);
        boughbutton.setBackground(new Color(143,187,212));
        JPanel uppanel = new JPanel();
        uppanel.setBackground(new Color(143,187,212));
        JPanel centeralpanel = new JPanel();
        JPanel lowerpanel = new JPanel(new GridLayout(1,1));
        lowerpanel.setBackground(new Color(143,187,212));
        mainframe.add(uppanel,BorderLayout.NORTH);
        uppanel.add(hellolabel);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        mainframe.add(centeralpanel);
        lowerpanel.add(homebutton);
        centeralpanel.add(backgroundlabel);
        backgroundlabel.add(boughbutton);
        backgroundlabel.add(buyworth);
        boughbutton.addActionListener(e->{
            mainframe.dispose();
            boughtproducts(name);
        });
        homebutton.addActionListener(e->{
            File cartmaker = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client"+"\\"+name +"\\"+"buyfolder\\cart");
            if(cartmaker.exists()){

            }
            else{
                cartmaker.mkdirs();
            }
            mainframe.dispose();
            homepage(1,name);
        });
    }
    public static void sellerpage(String name){
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon backgroundpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\sellerback.png");
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setVisible(true);
        mainframe.setResizable(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel hellolable = new JLabel();
        hellolable.setText("Hello " +name);
        hellolable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setBorderPainted(false);
        homebutton.setContentAreaFilled(false);

        JButton saleworth = new JButton();
        saleworth.setBounds(400, 50, 150,75);
        saleworth.setContentAreaFilled(false);
        saleworth.setBorderPainted(false);
        saleworth.setBackground(Color.white);
        saleworth.setForeground(Color.black);
        File saleworthfile = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller"+"\\"+name+"\\sellfolder\\buy.txt");
        try {
            Scanner saleworthnumber = new Scanner(saleworthfile);
            String cc = saleworthnumber.nextLine();
            saleworth.setText(cc);
            saleworthnumber.close();
        } catch (Exception e) {
        }

        JLabel browsedirection = new JLabel();
        browsedirection.setBounds(400, 150, 100, 25);

        JLabel backgroundlabel = new JLabel();
        backgroundlabel.setIcon(backgroundpic);
        JLabel productnamelabel = new JLabel("Product Name");
        productnamelabel.setBounds(100, 50, 100, 25);
        productnamelabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea productnamearea = new JTextArea();
        productnamearea.setBounds(225, 50, 100, 25);
        productnamearea.setFont(new Font("Times New Roman", Font.PLAIN, 15));


        JLabel categorylabel = new JLabel("Product Category");  
        categorylabel.setBounds(100, 100, 100, 25);
        categorylabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        String facilities[]={"Book","Electronic","Clothes","Toys And Entertainment","SuperMarket","Health Care","Other Things"};
        JComboBox categorybox = new JComboBox(facilities);
        categorybox.setBounds(225, 100, 100, 25);
        categorybox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        categorybox.setBackground(new Color(255,180,2));


        JLabel productpic = new JLabel("Product Picture");
        productpic.setBounds(100, 150, 100, 25);
        productpic.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JButton browsepic = new JButton("Browse File");
        browsepic.setBounds(225, 150, 100, 25);
        browsepic.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        browsepic.setBackground(new Color(255,180,2));
        String imagedirectory;
        browsepic.addActionListener(e->{
        JFileChooser openpic = new JFileChooser();
        openpic.showSaveDialog(null);
        String directionofimage = openpic.getSelectedFile().getAbsolutePath();
        browsedirection.setText(directionofimage);
        });

        JLabel productprice = new JLabel("Price");
        productprice.setBounds(100, 200, 100, 25);
        productprice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea productpricearea = new JTextArea();
        productpricearea.setBounds(225, 200, 100, 25);
        productpricearea.setFont(new Font("Times New Roman", Font.PLAIN, 15));


        JLabel productnumber = new JLabel("Numbers Of Product");
        productnumber.setBounds(100, 250, 175, 25);
        productnumber.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea productnumberarea = new JTextArea();
        productnumberarea.setBounds(250, 250, 75, 25);
        productnumberarea.setFont(new Font("Times New Roman", Font.PLAIN, 15));


        int i;
        JButton addbutton = new JButton("Add");
        addbutton.setBounds(100, 300, 225, 50);
        addbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addbutton.setBackground(new Color(234,89,6));
        addbutton.addActionListener(e->{
            File codeforproduct = new File("C:\\Java\\java\\src\\FinalProject\\coder.txt");
            File insideofsellerfloder = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller\\"+name+"\\"+"products");
            if(insideofsellerfloder.exists()){
            }
            else{
            insideofsellerfloder.mkdirs();
            }
            String productnamestring = productnamearea.getText();
            String productcategorystring = categorybox.getSelectedItem().toString();
            String imagestring = browsedirection.getText();
            int priceint = Integer.parseInt(productpricearea.getText());
            int howmanyint = Integer.parseInt(productnumberarea.getText());
            String pricstring = productpricearea.getText();
            String howmanystring = productnumberarea.getText();
            if(!productnamestring.isEmpty()&&!productcategorystring.isEmpty()&&!imagestring.isEmpty()&&!String.valueOf(priceint).isEmpty()&&!String.valueOf(howmanyint).isEmpty()){
            
            try {
                Scanner scancode = new Scanner(codeforproduct);
                String crypt = scancode.nextLine();
                try {
                    FileWriter changecode = new FileWriter(codeforproduct);
                    int x = Integer.parseInt(crypt);
                    x++;
                    String next = String.valueOf(x);
                    changecode.write(next +"\n");
                    scancode.close();
                    changecode.close();
                    File makefolderforproduc = new File(insideofsellerfloder+"\\"+crypt);
                    makefolderforproduc.mkdirs();
                    File savethisinproducts = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All\\"+crypt);
                    savethisinproducts.mkdirs();
                    File savethisinrelatedcategory = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\"+productcategorystring +"\\" +crypt);
                    savethisinrelatedcategory.mkdirs();
                    File sellername = new File(savethisinproducts +"\\sellername.txt");
                    File productnamefile = new File(makefolderforproduc+"\\productname.txt");

                    File productcategoryfile = new File(makefolderforproduc+"\\productcategory.txt");

                    File imagefile = new File(makefolderforproduc+"\\image.txt");
                    File pricefile = new File(makefolderforproduc+"\\price.txt");
                    File howmanyfile = new File(makefolderforproduc+"\\count.txt");
                    try {
                        FileWriter productnamewriter = new FileWriter(productnamefile);
                        productnamewriter.write(productnamestring);
                        productnamewriter.close();
                        FileWriter productcategorywriter = new FileWriter(productcategoryfile);
                        productcategorywriter.write(productcategorystring);
                        productcategorywriter.close();
                        FileWriter productimagewriter = new FileWriter(imagefile);
                        productimagewriter.write(imagestring);
                        productimagewriter.close();
                        FileWriter productpricewriter = new FileWriter(pricefile);
                        productpricewriter.write(pricstring);
                        productpricewriter.close();
                        FileWriter productcountWriter = new FileWriter(howmanyfile);
                        productcountWriter.write(howmanystring);
                        productcountWriter.close();
                        FileWriter sellernamewriter = new FileWriter(sellername);
                        sellernamewriter.write(name);
                        sellernamewriter.close();
                    } catch (Exception as) {
                        System.out.println("ERROR LINE 253");
                    }
                    try {
                        copyDir(makefolderforproduc.toPath(), savethisinproducts.toPath());
                        copyDir(savethisinproducts.toPath(), savethisinrelatedcategory.toPath());
                        System.out.println("coppied");
                    } catch (Exception t) {
                    }
                    
                } 
                catch (Exception t) {
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            }
        });


        JButton allproducts = new JButton("My Products");
        allproducts.setBounds(400, 150, 150, 75);
        allproducts.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        allproducts.setBackground(new Color(234,86,6));
        allproducts.addActionListener(e->{
            mainframe.dispose();
            sellerproductsreporter(name);
        });

        JPanel uppanel = new JPanel();
        JPanel centerpanel = new JPanel();
        JPanel lowerpanel = new JPanel();
        lowerpanel.setBackground(new Color(236,109,6));
        mainframe.add(uppanel,BorderLayout.NORTH);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        mainframe.add(centerpanel);
        lowerpanel.add(homebutton);
        uppanel.add(hellolable);
        centerpanel.add(backgroundlabel);
        backgroundlabel.add(productnamelabel);
        backgroundlabel.add(productnamearea);
        backgroundlabel.add(categorylabel);
        backgroundlabel.add(categorybox);
        backgroundlabel.add(productprice);
        backgroundlabel.add(productpricearea);
        backgroundlabel.add(productnumber);
        backgroundlabel.add(productnumberarea);
        backgroundlabel.add(addbutton);
        backgroundlabel.add(productpic);
        backgroundlabel.add(browsepic);
        backgroundlabel.add(saleworth);
        backgroundlabel.add(allproducts);
        homebutton.addActionListener(e->{
            mainframe.dispose();
            homepage(3,name);
        });
    }
    public static void userreporter(){
        ImageIcon trashpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\trash.png");
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 900, 600);
        mainframe.setVisible(true);
        mainframe.setResizable(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel clienttext = new JLabel("Client",JLabel.CENTER);
        JLabel sellertext = new JLabel("Seller",JLabel.CENTER);

        File clientcounter = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client");

        int tellmenumberofclient = clientcounter.list().length;
        String dataclient[][]=new String[tellmenumberofclient][6];
        String columnclient[]={"Firstname","Lastname","username","E-Main","Password","Buying Worth"};


        String clientcontents[] = clientcounter.list();
        int length = clientcontents.length;
        int i = 0;
        while(i<length){
            File specificclient = new File(clientcounter+"\\"+clientcontents[i]);
            System.out.println(specificclient);
            File firstname = new File(specificclient+"\\firstname.txt");
            File lastname = new File(specificclient+"\\lastname.txt");
            File username = new File(specificclient+"\\username.txt");
            File email = new File(specificclient+"\\email.txt");
            File password = new File(specificclient+"\\password.txt");
            File buy = new File(specificclient+"\\buyfolder"+"\\buyworth.txt");
            try {
                Scanner writefirstname = new Scanner(firstname);
                dataclient[i][0]=writefirstname.nextLine();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                Scanner writelastname = new Scanner(lastname);
                dataclient[i][1]=writelastname.nextLine();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            try {
                Scanner writeusername = new Scanner(username);
                dataclient[i][2]=writeusername.nextLine();
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
            }
            try {
                Scanner writeemail = new Scanner(email);
                dataclient[i][3]=writeemail.nextLine();
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            }
            try {
                Scanner writepassword = new Scanner(password);
                dataclient[i][4]=writepassword.nextLine();
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
            }
            try {
                Scanner writebuy = new Scanner(buy);
                dataclient[i][5]=writebuy.nextLine();
            } catch (FileNotFoundException e6) {
                e6.printStackTrace();
            }
            i++;
        }

        JTable clienttable = new JTable(dataclient,columnclient);
        JScrollPane clientpane = new JScrollPane(clienttable);
        clientpane.setVisible(true);

        File sellerscounter = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller");
        int tellmenumberofsellers = sellerscounter.list().length;


        String dataseller[][]=new String[tellmenumberofsellers][6];
        String columnseller[]={"Firstname","Lastname","username","E-Main","Password","Selling Worth"};

        String sellercontents[]=sellerscounter.list();
        int lengthseller = sellercontents.length;
        int j = 0;
        while(j<lengthseller){
            File specificclient = new File(sellerscounter+"\\"+sellercontents[j]);
            System.out.println(specificclient);
            File firstname = new File(specificclient+"\\firstname.txt");
            File lastname = new File(specificclient+"\\lastname.txt");
            File username = new File(specificclient+"\\username.txt");
            File email = new File(specificclient+"\\email.txt");
            File password = new File(specificclient+"\\password.txt");
            File buy = new File(specificclient+"\\sellfolder"+"\\buy.txt");
            try {
                Scanner writefirstname = new Scanner(firstname);
                dataseller[j][0]=writefirstname.nextLine();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            try {
                Scanner writelastname = new Scanner(lastname);
                dataseller[j][1]=writelastname.nextLine();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            try {
                Scanner writeusername = new Scanner(username);
                dataseller[j][2]=writeusername.nextLine();
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
            }
            try {
                Scanner writeemail = new Scanner(email);
                dataseller[j][3]=writeemail.nextLine();
            } catch (FileNotFoundException e4) {
                e4.printStackTrace();
            }
            try {
                Scanner writepassword = new Scanner(password);
                dataseller[j][4]=writepassword.nextLine();
            } catch (FileNotFoundException e5) {
                e5.printStackTrace();
            }
            try {
                Scanner writebuy = new Scanner(buy);
                dataseller[j][5]=writebuy.nextLine();
            } catch (FileNotFoundException e6) {
                e6.printStackTrace();
            }
            j++;
        }




        JTable sellertable = new JTable(dataseller,columnseller);
        JScrollPane sellerpane = new JScrollPane(sellertable);
        clientpane.setVisible(true);
        
        JPanel uppanel = new JPanel(new GridLayout(2,1));
        JButton backbutton = new JButton("Back");
        backbutton.addActionListener(e->{
            mainframe.dispose();
            adminpage();
        });
        JPanel uppanelunder = new JPanel(new GridLayout(1,2));
        JPanel centerlapanel = new JPanel(new GridLayout(1,2));
        JLabel asklabel = new JLabel("Enter User Of Person You Want To Delet");
        asklabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JTextArea userdeleterarea = new JTextArea();
        userdeleterarea.setFont(new Font("Times New Roman", Font.PLAIN, 48));

        JButton deletbutton = new JButton();
        deletbutton.setIcon(trashpic);
        deletbutton.setContentAreaFilled(false);
        deletbutton.setBorderPainted(false);

        deletbutton.addActionListener(e->{
        });

        mainframe.add(uppanel,BorderLayout.NORTH);
        mainframe.add(centerlapanel);
        uppanel.add(backbutton);
        uppanel.add(uppanelunder);
        uppanelunder.add(clienttext);
        uppanelunder.add(sellertext);
        centerlapanel.add(clientpane);
        centerlapanel.add(sellerpane);
    }



    // public static void sellreport(){
    //     JFrame mainframe = new JFrame();
    //     mainframe.setBounds(370, 100, 800, 600);
    //     mainframe.setVisible(true);
    //     mainframe.setResizable(true);
    //     mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     JButton backbutton = new JButton("Back");
    //     backbutton.addActionListener(e->{
    //         mainframe.dispose();
    //         adminpage();
    //     });
    //     //will take from file
    //     //from here
    //     String data[][]={ {"101","Amit","670000"," "," "," "," "}};   
    //     String column[]={"Product Code","Numbers","Sale Number","Product Price","Product Sell Worth","Seller Username","Buyer"};         
    //     JTable jt=new JTable(data,column); 
    //     JScrollBar bar = new JScrollBar();
    //     JPanel uppanel = new JPanel(new GridLayout(1,1));
    //     JPanel centeralpanel = new JPanel(new BorderLayout());
    //     // JScrollPane pp = new JScrollPane();
    //     JScrollPane js=new JScrollPane(jt);
    //     js.setVisible(true);
    //     mainframe.add(uppanel,BorderLayout.NORTH);
    //     mainframe.add(centeralpanel);
    //     uppanel.add(backbutton);
    //     centeralpanel.add(js);
    // }
    public static void adminpage(){
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon adminback = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\adminback.jpg");
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setVisible(true);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel upperpanel = new JPanel();
        JPanel lowerpanel = new JPanel();
        upperpanel.setBackground(new Color(46,73,128));
        lowerpanel.setBackground(new Color(46,73,128));

        JLabel backgroundlabel = new JLabel();
        backgroundlabel.setIcon(adminback);


        JButton usersreport = new JButton("All Users Information");
        usersreport.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        usersreport.setBounds(100, 150, 250, 50);
        usersreport.setContentAreaFilled(false);
        usersreport.setBorderPainted(false);
        usersreport.setForeground(Color.white);

        JButton productsreport = new JButton("All Products Information");
        productsreport.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        productsreport.setBounds(100, 200, 250, 50);
        productsreport.setContentAreaFilled(false);
        productsreport.setBorderPainted(false);
        productsreport.setForeground(Color.white);
        productsreport.addActionListener(e->{
            mainframe.dispose();
            productsreport();
        });

        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        JLabel hellolLabel = new JLabel("Hello Admin");
        hellolLabel.setForeground(Color.white);
        hellolLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        mainframe.add(upperpanel,BorderLayout.NORTH);
        mainframe.add(backgroundlabel);
        lowerpanel.add(homebutton);
        upperpanel.add(hellolLabel);
        backgroundlabel.add(usersreport);
        backgroundlabel.add(productsreport);
        homebutton.addActionListener(e->{
            mainframe.dispose();
            homepage(3,"Admin");
        });
        usersreport.addActionListener(e->{
            mainframe.dispose();
            userreporter();
        });
    }
    public static void signup(){
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon background = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\userback.jpg");
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setVisible(true);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel backgroundlabel = new JLabel();
        backgroundlabel.setIcon(background);
        backgroundlabel.setLayout(null);
        JPanel upperpanel = new JPanel();
        JPanel lowerpanel = new JPanel();
        upperpanel.setBackground(new Color(37,175,243));
        lowerpanel.setBackground(new Color(37,175,243));
        JButton homebutton = new JButton();
        JButton signinbutton = new JButton("SIGN IN");
        signinbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        signinbutton.setContentAreaFilled(false);
        signinbutton.setBorderPainted(false);
        homebutton.setIcon(homepic);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);
        String pp[]={"Client","Seller"};
        JComboBox determination = new JComboBox(pp);
        determination.setBounds(345, 75, 100, 25);
        //biiiiii
        JLabel usernameLabel = new JLabel("User Name :");
        usernameLabel.setBounds(250, 125, 100, 25);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea usernamearea = new JTextArea();
        usernamearea.setBounds(350, 125, 100, 25);


        JLabel nameLabel = new JLabel("First Name :");
        nameLabel.setBounds(250, 175, 100, 25);
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea namearea = new JTextArea();
        namearea.setBounds(350, 175, 100, 25);


        JLabel lastnamelabel = new JLabel("Last Name :");
        lastnamelabel.setBounds(250, 225, 100, 25);
        lastnamelabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea lastnamearea = new JTextArea();
        lastnamearea.setBounds(350, 225, 100, 25);



        JLabel emailLabel = new JLabel("E-Mail :");
        emailLabel.setBounds(250, 275, 100, 25);
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JTextArea emailarea = new JTextArea();
        emailarea.setBounds(350, 275, 100, 25);



        JLabel passwprdlLabel = new JLabel("Password :");
        passwprdlLabel.setBounds(250, 325, 100, 25);
        passwprdlLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JPasswordField passwordarea = new JPasswordField();
        passwordarea.setBounds(350, 325, 100, 25);



        JLabel repasswordlabel = new JLabel("Re Password :");
        repasswordlabel.setBounds(250, 375, 100, 25);
        repasswordlabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JPasswordField repasswordarea = new JPasswordField();
        repasswordarea.setBounds(350, 375, 100, 25);
        JLabel errorlabel = new JLabel("");
        errorlabel.setBounds(200, 25, 400, 25);

        JButton enterbutton = new JButton("Enter");
        enterbutton.setBorderPainted(false);
        enterbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        enterbutton.setBounds(350, 420, 100, 50);
        enterbutton.setBackground(new Color(37,175,243));
        enterbutton.addActionListener(e->{
            int errorflag = 0;
            try {
                String acs = determination.getSelectedItem().toString();
                String username = usernamearea.getText();
                String firstname = namearea.getText();
                String lastname = lastnamearea.getText();
                String email = emailarea.getText();
                String pass = new String(passwordarea.getPassword());
                String repass = new String(repasswordarea.getPassword());
                // this section will add our information as a usernamefolder with information as text in it
                if(!acs.isEmpty()&&!username.isEmpty()&&!firstname.isEmpty()&&!lastname.isEmpty()&&!email.isEmpty()&&pass.equals(repass)){
                errorflag=1;
                if(acs.equals("Client")){
                    String dir = "C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+username;
                    String insidedir = "C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+username+"\\";
                    System.out.println(dir);
                    File clientfile = new File(dir);
                    File insideclientfile = new File(insidedir);
                    if(clientfile.exists()){
                        System.out.println("EROOR IN LINE 506");
                        JFrame errorframe = new JFrame();
                        errorframe.setBounds(400, 250, 300, 100);
                        errorframe.setBackground(Color.red);
                        errorframe.setForeground(Color.red);
                        JLabel eroor = new JLabel("This Username has been taken before");
                        eroor.setForeground(Color.red);
                        errorframe.setVisible(true);
                        errorframe.add(eroor);
                    }
                    else{
                    clientfile.mkdirs();
                    File usernamefile = new File(insidedir+"username.txt");
                    File firstnamefile = new File(insidedir+"firstname.txt");
                    File lastnamefile = new File(insidedir+"lastname.txt");
                    File emailfile = new File(insidedir+"email.txt");
                    File passwordfile = new File(insidedir+"password.txt");
                    File buyfolder = new File(insidedir+"\\buyfolder");
                    buyfolder.mkdirs();
                    File insidebuyfolder = new File(buyfolder +"\\buyworth.txt");
                    try {
                        FileWriter usernamefilewriter = new FileWriter(usernamefile);
                        usernamefilewriter.write(username);
                        usernamefilewriter.close();

                        FileWriter firstnamefilewriter = new FileWriter(firstnamefile);
                        firstnamefilewriter.write(firstname);
                        firstnamefilewriter.close();

                        FileWriter lastnamefilewriter = new FileWriter(lastnamefile);
                        lastnamefilewriter.write(lastname);
                        lastnamefilewriter.close();

                        FileWriter emailfilefilewriter = new FileWriter(emailfile);
                        emailfilefilewriter.write(email);
                        emailfilefilewriter.close();

                        FileWriter passwordfilefilewriter = new FileWriter(passwordfile);
                        passwordfilefilewriter.write(pass);
                        passwordfilefilewriter.close();

                        FileWriter firstbuywrite = new FileWriter(insidebuyfolder);
                        firstbuywrite.write("0");
                        firstbuywrite.close();


                        JFrame errorframe = new JFrame();
                        errorframe.setBounds(400, 250, 300, 100);
                        errorframe.setBackground(Color.green);
                        errorframe.setForeground(Color.green);
                        JLabel eroor = new JLabel("Added Well Done");
                        eroor.setForeground(Color.green);
                        errorframe.setVisible(true);
                        errorframe.add(eroor);
                        usernamearea.setText(null);
                        namearea.setText(null);
                        lastnamearea.setText(null);
                        emailarea.setText(null);
                        passwordarea.setText(null);
                        repasswordarea.setText(null);
                    } 
                    catch (Exception q) {
                        System.out.println("EROOR IN LINE 506");
                    }
                    }
                }
                if(acs.equals("Seller")){
                    String dir = "C:\\Java\\java\\src\\FinalProject\\data\\Seller\\"+username;
                    String insidedir = "C:\\Java\\java\\src\\FinalProject\\data\\Seller\\"+username+"\\";
                    System.out.println(dir);
                    File clientfile = new File(dir);
                    File insideclientfile = new File(insidedir);
                    if(clientfile.exists()){
                        System.out.println("EROOR IN LINE 559");
                        JFrame errorframe = new JFrame();
                        errorframe.setBounds(400, 250, 300, 100);
                        errorframe.setBackground(Color.red);
                        errorframe.setForeground(Color.red);
                        JLabel eroor = new JLabel("This Username has been taken before");
                        eroor.setForeground(Color.red);
                        errorframe.setVisible(true);
                        errorframe.add(eroor);
                    }
                    else{
                    clientfile.mkdirs();
                    File usernamefile = new File(insidedir+"username.txt");
                    File firstnamefile = new File(insidedir+"firstname.txt");
                    File lastnamefile = new File(insidedir+"lastname.txt");
                    File emailfile = new File(insidedir+"email.txt");
                    File passwordfile = new File(insidedir+"password.txt");
                    File sellfolder = new File (insidedir +"sellfolder");
                    sellfolder.mkdirs();
                    File sellfolderinsidefile = new File(sellfolder +"\\buy.txt");
                    try {
                        FileWriter usernamefilewriter = new FileWriter(usernamefile);
                        usernamefilewriter.write(username);
                        usernamefilewriter.close();

                        FileWriter firstnamefilewriter = new FileWriter(firstnamefile);
                        firstnamefilewriter.write(firstname);
                        firstnamefilewriter.close();

                        FileWriter lastnamefilewriter = new FileWriter(lastnamefile);
                        lastnamefilewriter.write(lastname);
                        lastnamefilewriter.close();

                        FileWriter emailfilefilewriter = new FileWriter(emailfile);
                        emailfilefilewriter.write(email);
                        emailfilefilewriter.close();

                        FileWriter insidebuybuytxt = new FileWriter(sellfolderinsidefile);
                        insidebuybuytxt.write("0");
                        insidebuybuytxt.close();

                        FileWriter passwordfilefilewriter = new FileWriter(passwordfile);
                        passwordfilefilewriter.write(pass);
                        passwordfilefilewriter.close();
                        usernamearea.setText(null);
                        namearea.setText(null);
                        lastnamearea.setText(null);
                        emailarea.setText(null);
                        passwordarea.setText(null);
                        repasswordarea.setText(null);
                    } 
                    catch (Exception q) {
                        System.out.println("EROOR IN LINE 598");
                    }
                    }
                }
                }
            } 

            catch (Exception w) {
                System.out.println("ERROR OCUURED IN SIGNUP ENTERBUTTON SECTION");
            }
            if(errorflag==0){
                System.out.println("ERROR OCUURED IN SIGNUP ENTERBUTTON SECTION");
                errorlabel.setVisible(true);
                errorlabel.setText("ERROR OCUURED PLEASE CHECK YOUR INPUTS ONCE AGGAIN");
                errorlabel.setForeground(Color.red);
            }
            if(errorflag==1){
                System.out.println("ADDED WELL DONE");
                errorlabel.setVisible(false);
            }
        });

        //biiiiii
        mainframe.add(backgroundlabel);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        mainframe.add(upperpanel,BorderLayout.NORTH);
        lowerpanel.add(homebutton);
        upperpanel.add(signinbutton);
        backgroundlabel.add(determination);
        backgroundlabel.add(usernameLabel);
        backgroundlabel.add(nameLabel);
        backgroundlabel.add(lastnamelabel);
        backgroundlabel.add(emailLabel);
        backgroundlabel.add(passwprdlLabel);
        backgroundlabel.add(repasswordlabel);

        backgroundlabel.add(usernamearea);
        backgroundlabel.add(namearea);
        backgroundlabel.add(lastnamearea);
        backgroundlabel.add(emailarea);
        backgroundlabel.add(passwordarea);
        backgroundlabel.add(repasswordarea);
        backgroundlabel.add(errorlabel);

        backgroundlabel.add(enterbutton);
        homebutton.addActionListener(e->{
            mainframe.dispose();
            homepage(0,"Anything");
        });
        signinbutton.addActionListener(e->{
            mainframe.dispose();
            user();
        });
    }
    public static void user(){
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon userspic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\users.png");
        ImageIcon background = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\userback.jpg");


        String pp[]={"Admin","Client","Seller"};
        JComboBox determination = new JComboBox(pp);
        determination.setBounds(345, 50, 100, 25);
        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setTitle("LOG");
        mainframe.setIconImage(userspic.getImage());
        mainframe.setVisible(true);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel backgroundlabel = new JLabel();
        backgroundlabel.setIcon(background);
        backgroundlabel.setLayout(null);
        JLabel usernameLabel = new JLabel("User Name :");
        usernameLabel.setBounds(250, 200, 100, 25);
        JTextArea usertexarea = new JTextArea();
        usertexarea.setBounds(350, 200, 100, 25);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        JLabel passlabel = new JLabel("Password :");
        passlabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passlabel.setBounds(250, 250, 100, 25);
        JPasswordField passiswhat = new JPasswordField();
        passiswhat.setBounds(350, 250, 100, 25);

        JButton enterbutton = new JButton("Enter");
        enterbutton.setBorderPainted(false);
        enterbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        enterbutton.setBounds(350, 300, 100, 50);
        enterbutton.setBackground(new Color(37,175,243));

        JLabel errorLabel = new JLabel();
        errorLabel.setBounds(250, 100, 200, 50);



        JButton signupbutton = new JButton("SIGN UP");
        signupbutton.setBorderPainted(false);
        signupbutton.setContentAreaFilled(false);
        signupbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        signupbutton.addActionListener(e->{
            mainframe.dispose();
            signup();
        });



        JPanel upperpanel = new JPanel();
        JPanel lowerpanel = new JPanel();
        upperpanel.setBackground(new Color(37,175,243));
        lowerpanel.setBackground(new Color(37,175,243));
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        mainframe.add(backgroundlabel);
        mainframe.add(upperpanel,BorderLayout.NORTH);


        backgroundlabel.add(determination);
        backgroundlabel.add(usernameLabel);
        backgroundlabel.add(usertexarea);
        backgroundlabel.add(passlabel);
        backgroundlabel.add(passiswhat);
        backgroundlabel.add(enterbutton);
        backgroundlabel.add(errorLabel);

        upperpanel.add(signupbutton);
        lowerpanel.add(homebutton);
        //centerpanel.add(passlabel);
        homebutton.addActionListener(e->{
            mainframe.dispose();
            homepage(0,"Anything");
        });
        enterbutton.addActionListener(e->{
            String checker = usertexarea.getText();
            String selected = determination.getSelectedItem().toString();
            if(selected.equals("Admin")){
                String passwordadmin = new String(passiswhat.getPassword());
                if(passwordadmin.equals("02i39") && checker.equals("Ali")){
                mainframe.dispose();
                adminpage();
                }
                else{
                    errorLabel.setText("Wrong Password or Username");
                }
            }
            //for cient and seller user and password checker will be got from datas
            if(selected.equals("Seller")){
                String usernamecheck = usertexarea.getText();
                File checkforuser = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller\\"+usernamecheck);
                if(checkforuser.exists()){
                    File checkforpassword = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller\\"+usernamecheck+"\\password.txt");
                    System.out.println(checkforpassword.getPath());
                    try {
                        Scanner passchecker = new Scanner(checkforpassword);
                        String userpassword = passchecker.nextLine();
                        passchecker.close();
                        String passwillbe = new String(passiswhat.getPassword());
                        if(userpassword.equals(passwillbe)){
                            mainframe.dispose();
                            sellerpage(checker);
                        }
                        else{
                            errorLabel.setText("Wrong password");
                        }
                    } catch (FileNotFoundException e1) {
                        System.out.println("ERROR IN LINE 754");
                        errorLabel.setText("Wrong Password Or User");
                        e1.printStackTrace();
                    }
                }
                else{
                    errorLabel.setText("this user doesn't exist");
                    System.out.println("ERROR LABEL LINE 765");
                }

            }
            //will be got from files like up one
            if(selected.equals("Client")){
                    String usernamecheck = usertexarea.getText();
                    File checkforuser = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+usernamecheck);
                    if(checkforuser.exists()){
                        File checkforpassword = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+usernamecheck+"\\password.txt");
                        System.out.println(checkforpassword.getPath());
                        try {
                            Scanner passchecker = new Scanner(checkforpassword);
                            String userpassword = passchecker.nextLine();
                            passchecker.close();
                            String passwillbe = new String(passiswhat.getPassword());
                            if(userpassword.equals(passwillbe)){
                               
                               mainframe.dispose();
                              clientpage(checker);
                            }
                            else{
                                errorLabel.setText("Wrong password");
                            }
                        } catch (FileNotFoundException e1) {
                            System.out.println("ERROR IN LINE 798");
                            errorLabel.setText("Wrong Password Or User");
                            e1.printStackTrace();
                        }
                    }
                    else{
                        errorLabel.setText("this user doesn't exist");
                        System.out.println("ERROR LABEL LINE 804");
                    }
    
                

            }
        });
    }
    public static void homepage(int x,String name){
        //x==3 contains home button of admin and seller homepage
        if(x==3){
            ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
            ImageIcon searchpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\search.png");

            JPanel upperpanel = new JPanel(new GridLayout(0,2));
            upperpanel.setBackground(Color.white);
            JPanel centerpanel = new JPanel();
            centerpanel.setLayout(null);
            centerpanel.setBackground(new Color(226,247,255));
            JPanel lowerpanel = new JPanel(new GridLayout(0,1));
            lowerpanel.setBackground(Color.white);
            String facilities[]={"All","Book","Electronic","Clothes","Toys And Entertainment","Supermarker","Health Care","Other Things"};
            JComboBox categorybox = new JComboBox(facilities);
            categorybox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            categorybox.setBackground(Color.white);
            JButton homebutton = new JButton();
            homebutton.setIcon(homepic);
            homebutton.setContentAreaFilled(false);
            homebutton.setBorderPainted(false);
            JButton searchbutton = new JButton();
            searchbutton.setIcon(searchpic);
            searchbutton.setContentAreaFilled(false);
            searchbutton.setBorderPainted(false);
            JLabel nofile = new JLabel();
            File howmanyproduct = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All");
            int counter = howmanyproduct.list().length;
            int algo = (counter/6)+1;
            centerpanel.setPreferredSize(new Dimension(10,algo*500));

            

            JScrollPane tr = new JScrollPane(centerpanel);
            tr.setBounds(50, 50, 650, 500);
            centerpanel.setAutoscrolls(true);

            JFrame mainframe = new JFrame();
            mainframe.setBounds(370, 100, 800, 600);
            mainframe.setTitle("Home");
            mainframe.setIconImage(homepic.getImage());
            mainframe.setVisible(true);
            mainframe.setResizable(false);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String username []={name,"Sign Out"};
            JComboBox situation = new JComboBox(username);
            situation.addActionListener(e->{
                if(situation.getSelectedItem().equals("Sign Out")){
                    mainframe.dispose();
                    user();
                }
                if(situation.getSelectedItem().equals(name)){
                    mainframe.dispose();
                    if(name.equals("Admin")){
                    adminpage();
                    }
                    else{
                    sellerpage(name);
                    }
                }
            });

            situation.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            situation.setBackground(Color.white);
            mainframe.add(upperpanel,BorderLayout.NORTH);
            mainframe.add(lowerpanel,BorderLayout.SOUTH);
            lowerpanel.add(situation);
            upperpanel.add(categorybox);
            upperpanel.add(searchbutton);
            mainframe.add(tr,BorderLayout.CENTER);

            
            

            searchbutton.addActionListener(e->{
                centerpanel.removeAll();
                if(categorybox.getSelectedItem().toString().equals("Toys And Entertainment")){
                    File howmanytoy = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Toys And Entertainment\\");
                    String productsnames[]=howmanytoy.list();
                    int toycounter = howmanytoy.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(toycounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(toycounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<toycounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Toys And Entertainment"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Toys And Entertainment"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
                }
                if(categorybox.getSelectedItem().toString().equals("Supermarket")){
                    File howmanymarket = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Supermarket\\");
                    String productsnames[]=howmanymarket.list();
                    int marketcounter = howmanymarket.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(marketcounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(marketcounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<marketcounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Supermarket"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Supermarket"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
                }
                if(categorybox.getSelectedItem().toString().equals("Other Things")){
                    File howmanyother = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Other Things\\");
                    String productsnames[]=howmanyother.list();
                    int othercounter = howmanyother.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(othercounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(othercounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<othercounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Other Things"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Other Things"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
                }
                if(categorybox.getSelectedItem().toString().equals("Health Care")){
                    File howmanyhealth = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Health Care\\");
                    String productsnames[]=howmanyhealth.list();
                    int healthcounter = howmanyhealth.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(healthcounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(healthcounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<healthcounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Health Care"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Health Care"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
                }
                if(categorybox.getSelectedItem().toString().equals("Electronic")){
                    File howmanyelectro = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Electronic\\");
                    String productsnames[]=howmanyelectro.list();
                    int electrocounter = howmanyelectro.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(electrocounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(electrocounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<electrocounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Electronic"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Electronic"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
    
                }
                if(categorybox.getSelectedItem().toString().equals("Clothes")){
                    File howmanyclothe = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Clothes\\");
                    String productsnames[]=howmanyclothe.list();
                    int clothecounter = howmanyclothe.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(clothecounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(clothecounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<clothecounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Clothes"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Clothes"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
    
                }
                if(categorybox.getSelectedItem().toString().equals("Book")){
                
                    File howmanybook = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Book\\");
                    String productsnames[]=howmanybook.list();
                    int bookcounter = howmanybook.list().length;
                    JButton btn[] = new JButton[counter];
                    JButton namelabel[]=new JButton[counter];
                    JButton pricelabel[]=new JButton[counter];
                    int horizonal;
                    if(bookcounter%3==0){
                        horizonal=counter/3;
                    }
                    else{
                        horizonal=(bookcounter/3)+1;
                    }
        
                    int z = 0;
                    int i =30;
                    int j = 10;
                    while(j<horizonal*180){
                        for (int k = 0;k<3&&z<bookcounter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Book"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Book"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
                }
                if(categorybox.getSelectedItem().toString().equals("All")){
                    String productsnames[]=howmanyproduct.list();
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(counter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(counter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                        for (int k = 0;k<3&&z<counter;k++){
                            File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All"+"\\"+productsnames[z]);
                            File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All"+"\\"+productsnames[z]+"\\image.txt");
                            try {
                                Scanner scanimage = new Scanner(thisisproductimage);
                                String p=scanimage.nextLine();
                                nofile.setText(p);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                            //trickkkkk
                            String dir;
                            dir=nofile.getText();
                            ImageIcon first = new ImageIcon(dir);
                            Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                            ImageIcon third = new ImageIcon(second);
                            JButton btns = new JButton(productsnames[z]);
                            File nameof = new File(comperhensive+"\\productname.txt");
                            try {
                                Scanner scannmae = new Scanner(nameof);
                                String zs = scannmae.nextLine();
                                nofile.setText(zs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dir=nofile.getText();
                            System.out.println(dir);
                            JButton nameofproduct = new JButton(dir);
                            nameofproduct.setText(dir);
                            btns.setBounds(i, j, 150, 150);
                            btns.setContentAreaFilled(false);
                            btns.setBorderPainted(false);
                            nameofproduct.setFocusPainted(false);
                            btns.setIcon(third);
                            nameofproduct.setBounds(i, j+160, 150, 25);
                            nameofproduct.setContentAreaFilled(false);
                            File priceof = new File(comperhensive+"\\price.txt");
                            try {
                                Scanner scanprice = new Scanner(priceof);
                                String gg = scanprice.nextLine();
                                nofile.setText(gg);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dir=nofile.getText();
                            JButton pricebtn = new JButton(dir);
                            pricebtn.setBounds(i, j+190, 150, 25);
                            pricebtn.setContentAreaFilled(false);
                            mainframe.setVisible(true);
                            pricebtn.addActionListener(e0->{
                                mainframe.dispose();
                                user();
                            });
    
                            pricelabel[k]=pricebtn;
                            btn[k]=btns;
                            namelabel[k]=nameofproduct;
                            centerpanel.add(btns);
                            centerpanel.add(nameofproduct);
                            centerpanel.add(pricebtn);
                            i+=260;
                            z++;
                    }
                    i=30;
                    j+=220;
                }
                mainframe.repaint();
            }
            });
        }
        if(x==0){
        ImageIcon shoppic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\shop.png");
        ImageIcon userpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\user.png");
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon searchpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\search.png");
        ImageIcon background = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\back.jpg");

    
        JButton searchbutton = new JButton();
        searchbutton.setIcon(searchpic);
        searchbutton.setContentAreaFilled(false);
        searchbutton.setBorderPainted(false);



        String facilities[]={"All","Book","Electronic","Clothes","Toys And Entertainment","Supermarker","Health Care","Other Things"};
        JComboBox categorybox = new JComboBox(facilities);
        categorybox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        categorybox.setBackground(Color.white);
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);




        JButton userbutton = new JButton();
        userbutton.setIcon(userpic);
        userbutton.setContentAreaFilled(false);
        userbutton.setBorderPainted(false);


        JButton shopbutton = new JButton();
        shopbutton.setIcon(shoppic);
        shopbutton.setContentAreaFilled(false);
        shopbutton.setBorderPainted(false);
        JLabel homepagebackground = new JLabel();
        homepagebackground.setIcon(background);
        JLabel nofile = new JLabel();
        File howmanyproduct = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All");
        int counter = howmanyproduct.list().length;
        int algo = (counter/6)+1;
        JPanel upperpanel = new JPanel(new GridLayout(0,2));
        upperpanel.setBackground(Color.white);
        JPanel centerpanel = new JPanel();
        JPanel lowerpanel = new JPanel(new GridLayout(0,2,50,0));
        lowerpanel.setBackground(Color.white);
        centerpanel.setLayout(null);

        centerpanel.setPreferredSize(new Dimension(10,algo*500));

        JScrollPane tr = new JScrollPane(centerpanel);
        tr.setBounds(50, 50, 650, 500);
        centerpanel.setAutoscrolls(true);

        centerpanel.setBackground(new Color(226,247,255));


        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setTitle("Home");
        mainframe.setIconImage(homepic.getImage());
        mainframe.setVisible(true);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.add(upperpanel,BorderLayout.NORTH);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        mainframe.add(tr,BorderLayout.CENTER);

        searchbutton.addActionListener(e->{
            centerpanel.removeAll();
            if(categorybox.getSelectedItem().toString().equals("Toys And Entertainment")){
                File howmanytoy = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Toys And Entertainment\\");
                String productsnames[]=howmanytoy.list();
                int toycounter = howmanytoy.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(toycounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(toycounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<toycounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Toys And Entertainment"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Toys And Entertainment"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();
            }
            if(categorybox.getSelectedItem().toString().equals("Supermarket")){
                File howmanymarket = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Supermarket\\");
                String productsnames[]=howmanymarket.list();
                int marketcounter = howmanymarket.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(marketcounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(marketcounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<marketcounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Supermarket"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Supermarket"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();
            }
            if(categorybox.getSelectedItem().toString().equals("Other Things")){
                File howmanyother = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Other Things\\");
                String productsnames[]=howmanyother.list();
                int othercounter = howmanyother.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(othercounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(othercounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<othercounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Other Things"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Other Things"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();
            }
            if(categorybox.getSelectedItem().toString().equals("Health Care")){
                File howmanyhealth = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Health Care\\");
                String productsnames[]=howmanyhealth.list();
                int healthcounter = howmanyhealth.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(healthcounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(healthcounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<healthcounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Health Care"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Health Care"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();
            }
            if(categorybox.getSelectedItem().toString().equals("Electronic")){
                File howmanyelectro = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Electronic\\");
                String productsnames[]=howmanyelectro.list();
                int electrocounter = howmanyelectro.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(electrocounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(electrocounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<electrocounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Electronic"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Electronic"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();

            }
            if(categorybox.getSelectedItem().toString().equals("Clothes")){
                File howmanyclothe = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Clothes\\");
                String productsnames[]=howmanyclothe.list();
                int clothecounter = howmanyclothe.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(clothecounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(clothecounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<clothecounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Clothes"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Clothes"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();

            }
            if(categorybox.getSelectedItem().toString().equals("Book")){
            
                File howmanybook = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Book\\");
                String productsnames[]=howmanybook.list();
                int bookcounter = howmanybook.list().length;
                JButton btn[] = new JButton[counter];
                JButton namelabel[]=new JButton[counter];
                JButton pricelabel[]=new JButton[counter];
                int horizonal;
                if(bookcounter%3==0){
                    horizonal=counter/3;
                }
                else{
                    horizonal=(bookcounter/3)+1;
                }
    
                int z = 0;
                int i =30;
                int j = 10;
                while(j<horizonal*180){
                    for (int k = 0;k<3&&z<bookcounter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Book"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\Book"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });

                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();
            }
            if(categorybox.getSelectedItem().toString().equals("All")){
                String productsnames[]=howmanyproduct.list();
            JButton btn[] = new JButton[counter];
            JButton namelabel[]=new JButton[counter];
            JButton pricelabel[]=new JButton[counter];
            int horizonal;
            if(counter%3==0){
                horizonal=counter/3;
            }
            else{
                horizonal=(counter/3)+1;
            }

            int z = 0;
            int i =30;
            int j = 10;
            int height = horizonal*180;
            while(j<=height){
                    for (int k = 0;k<3&&z<counter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        File priceof = new File(comperhensive+"\\price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            mainframe.dispose();
                            user();
                        });
                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                }
                i=30;
                j=j+220;
            }
            mainframe.repaint();
        }
        });
        mainframe.add(upperpanel,BorderLayout.NORTH);
        upperpanel.add(categorybox);
        upperpanel.add(searchbutton);
        lowerpanel.add(homebutton);
        lowerpanel.add(userbutton);
        shopbutton.addActionListener(e->{
            mainframe.dispose();
            shop(0,name);
        });
        userbutton.addActionListener(e->{
            user();
            mainframe.dispose();
        });
    }

    //only for client
    if(x==1){
        ImageIcon shoppic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\shop.png");
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon searchpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\search.png");
        ImageIcon background = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\back.jpg");
        ImageIcon trashpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\trash.png");

        JFrame mainframe = new JFrame();
        mainframe.setBounds(370, 100, 800, 600);
        mainframe.setTitle("Home");
        mainframe.setIconImage(homepic.getImage());
        mainframe.setVisible(true);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton searchbutton = new JButton();
        searchbutton.setIcon(searchpic);
        searchbutton.setContentAreaFilled(false);
        searchbutton.setBorderPainted(false);
        searchbutton.addActionListener(e->{
            //
        });

        String username []={name,"Sign Out"};

        JComboBox situation = new JComboBox(username);
        situation.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        situation.setBackground(Color.white);
        situation.addActionListener(e->{
            if(situation.getSelectedItem().equals("Sign Out")){
            mainframe.dispose();
            user();
            }
            if(situation.getSelectedItem().equals(name)){
                clientpage(name);
                mainframe.dispose();
            }
            
        });


        String facilities[]={"All"};
        JComboBox categorybox = new JComboBox(facilities);
        categorybox.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        categorybox.setBackground(Color.white);
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);


        JButton shopbutton = new JButton();
        shopbutton.setIcon(shoppic);
        shopbutton.setContentAreaFilled(false);
        shopbutton.setBorderPainted(false);
        shopbutton.addActionListener(e->{
            mainframe.dispose();
            shop(1,name);
        });
        JLabel homepagebackground = new JLabel();
        homepagebackground.setIcon(background);
        JPanel upperpanel = new JPanel(new GridLayout(0,2));
        upperpanel.setBackground(Color.white);
        JPanel centerpanel = new JPanel();
        JButton deletcart = new JButton();
        centerpanel.setBackground(new Color(226,247,255));
        deletcart.setContentAreaFilled(false);
        deletcart.setBorderPainted(false);
        JPanel lowerpanel = new JPanel(new GridLayout(0,3,50,0));
        lowerpanel.setBackground(Color.white);

        JLabel nofile = new JLabel();
        File howmanyproduct = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All");
        int counter = howmanyproduct.list().length;
        int algo = (counter/6)+1;

        centerpanel.setLayout(null);

        centerpanel.setPreferredSize(new Dimension(10,algo*500));

        JScrollPane tr = new JScrollPane(centerpanel);
        tr.setBounds(50, 50, 650, 500);
        centerpanel.setAutoscrolls(true);

        searchbutton.addActionListener(e->{
            if(categorybox.getSelectedItem().toString().equals("All")){
            String productsnames[]=howmanyproduct.list();
            JButton btn[] = new JButton[counter];
            JButton namelabel[]=new JButton[counter];
            JButton pricelabel[]=new JButton[counter];


            JButton productcode[] = new JButton[counter];
            JButton productnumber[]=new JButton[counter];
            JButton productseller[]=new JButton[counter];


            int horizonal;
            if(counter%3==0){
                horizonal=counter/3;
            }
            else{
                horizonal=(counter/3)+1;
            }

            int z = 0;
            int i =30;
            int j = 10;
            while(j<horizonal*180){
                    for (int k = 0;k<3&&z<counter;k++){
                        File comperhensive = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All"+"\\"+productsnames[z]);
                        File thisisproductimage = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All"+"\\"+productsnames[z]+"\\image.txt");
                        try {
                            Scanner scanimage = new Scanner(thisisproductimage);
                            String p=scanimage.nextLine();
                            nofile.setText(p);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        //trickkkkk
                        String dir;
                        dir=nofile.getText();
                        ImageIcon first = new ImageIcon(dir);
                        Image second = first.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
                        ImageIcon third = new ImageIcon(second);
                        JButton btns = new JButton(productsnames[z]);
                        File nameof = new File(comperhensive+"\\productname.txt");
                        try {
                            Scanner scannmae = new Scanner(nameof);
                            String zs = scannmae.nextLine();
                            nofile.setText(zs);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        dir=nofile.getText();
                        System.out.println(dir);
                        JButton nameofproduct = new JButton(dir);
                        nameofproduct.setText(dir);
                        btns.setBounds(i, j, 150, 150);
                        btns.setContentAreaFilled(false);
                        btns.setBorderPainted(false);
                        nameofproduct.setFocusPainted(false);
                        btns.setIcon(third);
                        nameofproduct.setBounds(i, j+160, 150, 25);
                        nameofproduct.setContentAreaFilled(false);
                        JButton productcodebtn = new JButton(productsnames[z]);
                        JButton productnumberbtn = new JButton();
                        JButton productsellerx = new JButton();
                        File o = new File(comperhensive+"\\"+"count.txt");
                        File oo = new File(comperhensive+"\\"+"sellername.txt");
                        try {
                            Scanner xp = new Scanner(o);
                            productnumberbtn.setText(xp.nextLine());
                            xp.close();
                        } catch (Exception e10) {
                        }
                        try {
                            Scanner seven = new Scanner(oo);
                            productsellerx.setText(seven.nextLine());
                            seven.close();
                        } catch (Exception e11) {
                        }

                        File priceof = new File(comperhensive+"\\"+"price.txt");
                        try {
                            Scanner scanprice = new Scanner(priceof);
                            String gg = scanprice.nextLine();
                            nofile.setText(gg);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        dir=nofile.getText();
                        JButton pricebtn = new JButton(dir);
                        pricebtn.setBounds(i, j+190, 150, 25);
                        pricebtn.setContentAreaFilled(false);
                        mainframe.setVisible(true);
                        pricebtn.addActionListener(e0->{
                            if(Integer.parseInt(productnumberbtn.getText())>=1){
                            JFrame shoppy = new JFrame();
                            shoppy.setBounds(300, 300, 300, 300);
                            shoppy.setVisible(true);
                            shoppy.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JLabel added = new JLabel("ADDED TO YOUR CART",JLabel.CENTER);
                            added.setForeground(Color.green);
                            shoppy.add(added,BorderLayout.CENTER);
                            File letsmakecartforuser = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client"+"\\"+name+"\\buyfolder\\cart"+"\\"+productcodebtn.getText());
                            if(letsmakecartforuser.exists()){
                                File insideofmarked = new File(letsmakecartforuser+"\\number.txt");
                                try {
                                    Scanner read = new Scanner(insideofmarked);
                                    String firstii = read.nextLine();
                                    try {
                                        FileWriter change = new FileWriter(insideofmarked);
                                        int ch = Integer.parseInt(firstii);
                                        if(ch<Integer.parseInt(productnumberbtn.getText())){
                                        ch++;
                                        String next = String.valueOf(ch);
                                        change.write(next+"\n");
                                        read.close();
                                        }
                                        else{
                                            System.out.println("reached here");
                                            try {
                                                change.write(productnumberbtn.getText());
                                                added.setText("you have all availability of this product in your cart");
                                                added.setForeground(Color.red);
                                            } catch (Exception e01) {
                                            }
                                        }
                                        change.close();
                                    } catch (Exception e91) {
                                    }
                                } catch (Exception e90) {
                                }
                            }
                            else{
                                letsmakecartforuser.mkdirs();
                                //need array for seller
                                File sellername = new File(letsmakecartforuser+"\\sellername.txt");
                                File pcode = new File(letsmakecartforuser+"\\productcode.txt");
                                File pname = new File(letsmakecartforuser+"\\productname.txt");
                                File pnumber = new File(letsmakecartforuser+"\\number.txt");
                                File pprice = new File(letsmakecartforuser+"\\x1price.txt");
                                try {
                                    FileWriter sellerwriter = new FileWriter(sellername);
                                    sellerwriter.write(productsellerx.getText());
                                    sellerwriter.close();
                                } catch (Exception e5) {
                                }
                                try {
                                    FileWriter codewriter = new FileWriter(pcode);
                                    codewriter.write(productcodebtn.getText());
                                    codewriter.close();
                                } catch (Exception e6) {
                                }
                                try {
                                    FileWriter namewriter = new FileWriter(pname);
                                    namewriter.write(nameofproduct.getText());
                                    namewriter.close();
                                } catch (Exception e7) {
                                }
                                try {
                                    FileWriter numbewriter = new FileWriter(pnumber);
                                    numbewriter.write("1");
                                    numbewriter.close();
                                } catch (Exception e8) {
                                }
                                try {
                                    FileWriter pricewriter = new FileWriter(pprice);
                                    pricewriter.write(pricebtn.getText());
                                    pricewriter.close();
                                } catch (Exception e9) {
                                }
                            }
                        }
                        else{
                            JFrame shoppy = new JFrame();
                            shoppy.setBounds(300, 300, 300, 300);
                            shoppy.setVisible(true);
                            shoppy.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            JLabel added = new JLabel("OUT OF STOCK!",JLabel.CENTER);
                            added.setForeground(Color.red);
                            shoppy.add(added,BorderLayout.CENTER);
                        }
                        });
                        productcode[k]=productcodebtn;
                        productnumber[k]=productnumberbtn;
                        productseller[k]=productsellerx;
                        pricelabel[k]=pricebtn;
                        btn[k]=btns;
                        namelabel[k]=nameofproduct;
                        centerpanel.add(btns);
                        centerpanel.add(nameofproduct);
                        centerpanel.add(pricebtn);
                        i+=260;
                        z++;
                        
                }
                i=30;
                j+=220;
            }
            mainframe.repaint();
        }
        });
        mainframe.add(upperpanel,BorderLayout.NORTH);
        upperpanel.add(categorybox);
        upperpanel.add(searchbutton);
        mainframe.add(lowerpanel,BorderLayout.SOUTH);
        lowerpanel.add(shopbutton);
        lowerpanel.add(homebutton);
        lowerpanel.add(situation);
        mainframe.add(tr);
        centerpanel.add(homepagebackground);
        deletcart.setIcon(trashpic);
    }
}

    public static  void shop(int x,String name){
        //nothing
        if(x==0){
        ImageIcon userpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\user.png");
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon background = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\shopback.png");
        JLabel backgroundlLabel = new JLabel();
        backgroundlLabel.setIcon(background);
        JButton userbutton = new JButton();
        userbutton.setIcon(userpic);
        userbutton.setContentAreaFilled(false);
        userbutton.setBorderPainted(false);
        JFrame mainframe2 = new JFrame();
        mainframe2.setBounds(370, 100, 800, 600);
        mainframe2.setVisible(true);
        mainframe2.setResizable(false);
        mainframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel lowerpanel = new JPanel(new GridLayout(0,2,50,0));
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);
        mainframe2.add(lowerpanel,BorderLayout.SOUTH);
        mainframe2.add(backgroundlLabel);
        lowerpanel.add(homebutton);
        lowerpanel.add(userbutton);
        homebutton.addActionListener(e->{
            mainframe2.dispose();
            homepage(0,"Anything");
        });
        userbutton.addActionListener(e->{
            user();
            mainframe2.dispose();
        });
    }
    if(x==1){
        ImageIcon homepic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\home.png");
        ImageIcon trashpic = new ImageIcon("C:\\Java\\java\\src\\FinalProject\\pics\\trash.png");
        JFrame mainframe2 = new JFrame();
        mainframe2.setBounds(370, 100, 800, 600);
        mainframe2.setVisible(true);
        mainframe2.setResizable(false);
        mainframe2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel pricelabel = new JLabel("You Must Pay :");
        //////////////////////////////////////////
        JLabel money = new JLabel(" ");
        //////////////////////////////////////////
        JButton buybutton = new JButton("Buy");
        buybutton.setContentAreaFilled(false);
        buybutton.setBorderPainted(false);
        File howmanyfolder = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+name+"\\buyfolder\\cart");
        if(!howmanyfolder.exists()){
            howmanyfolder.mkdirs();
        }
        int sum = 0;
        int counter = howmanyfolder.list().length;
        System.out.println(counter);
        String data[][]=new String[counter][4];   
        String column[]={"Product Name","Number","X1 Price","Sum"};    
        String insideofcart []=howmanyfolder.list();
        int i = 0;
        while(i<counter){
            File specificcode = new File(howmanyfolder+"\\"+insideofcart[i]);
            File pname = new File(specificcode+"\\productname.txt");
            File pcount = new File(specificcode+"\\number.txt");
            File pprice = new File(specificcode+"\\x1price.txt");
            // sum 
            try {
                Scanner writepname = new Scanner(pname);
                data[i][0]=writepname.nextLine();
                writepname.close();
            } catch (Exception e1) {
            }
            try {
                Scanner writepcount = new Scanner(pcount);
                data[i][1]=writepcount.nextLine();
                writepcount.close();
            } catch (Exception e2) {
            }
            try {
                Scanner writepprice = new Scanner(pprice);
                data[i][2]=writepprice.nextLine();
                writepprice.close();
            } catch (Exception e3) {
            }
            data[i][3]=String.valueOf(Integer.parseInt(data[i][1])*Integer.parseInt(data[i][2]));
            sum+=Integer.parseInt(data[i][3]);
            i++;
        }    
        JTable jt=new JTable(data,column); 
        JScrollBar bar = new JScrollBar();
        money.setText(String.valueOf(sum));
        JButton hiddenbutton = new JButton("hello");
        JButton hiddenbutton2 = new JButton("hello");
        JButton hiddenselelr = new JButton();
        JScrollPane js=new JScrollPane(jt);
        js.setVisible(true);
        buybutton.addActionListener(e->{
            File buyworthchanger = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+name +"\\buyfolder\\buyworth.txt");
            File codes = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+name +"\\buyfolder\\cart\\");
            String codescontetn[] = codes.list();
            int q = 0;
            while(q<codescontetn.length){
                File getmeseller = new File(codes+"\\"+codescontetn[q]+"\\sellername.txt");
                System.out.println(getmeseller);
                File getmenumber = new File(codes+"\\"+codescontetn[q]+"\\number.txt");
                System.out.println(getmenumber);
                try {
                    Scanner scanseller = new Scanner(getmeseller);
                    String helpstring = scanseller.nextLine();
                    hiddenselelr.setText(helpstring);
                    scanseller.close();
                    File changesellerworth = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller\\" +helpstring +"\\sellfolder\\buy.txt");
                    System.out.println(changesellerworth);
                    try {
                        File priceone = new File(codes +"\\"+codescontetn[q]+"\\x1price.txt");
                        try {
                            Scanner givemeprice = new Scanner(priceone);
                            String mmm = givemeprice.nextLine();
                            hiddenbutton.setText(mmm);
                            givemeprice.close();
                        } catch (Exception e213) {
                            System.out.println("e213");
                        }
                        try {
                            Scanner givemecount = new Scanner(getmenumber);
                            String sss = givemecount.nextLine();
                            hiddenbutton2.setText(sss);
                            givemecount.close();
                        } catch (Exception e214) {
                           System.out.println("e214");
                        }
                        Scanner firstsaleworth = new Scanner(changesellerworth);
                        String one = firstsaleworth.nextLine();
                        try {
                            String ss1 = hiddenbutton.getText();
                            String ss2 = hiddenbutton2.getText();
                            int two = Integer.parseInt(ss1);
                            int three = Integer.parseInt(ss2);
                            int sumof = two*three;
                            FileWriter changesell = new FileWriter(changesellerworth);
                            int xone = Integer.parseInt(one);
                            xone+=sumof;
                            String nexti = String.valueOf(xone);
                            changesell.write(nexti +"\n");
                            changesell.close();
                            firstsaleworth.close();
                        } catch (Exception e48) {
                            e48.printStackTrace();
                            System.out.println("e48");
                        }
                    } catch (Exception e49) {
                        e49.printStackTrace();
                        System.out.println("e49");
                    }
                    scanseller.close();
                } catch (Exception e50) {
                    e50.printStackTrace();
                    System.out.println("e50");
                }

                File changecounter = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All\\"+codescontetn[q]+"\\count.txt");
                File changecountforsllerfolder = new File("C:\\Java\\java\\src\\FinalProject\\data\\Seller"+"\\"+(hiddenselelr.getText()+"\\products\\"+codescontetn[q]+"\\count.txt"));
                File tellmecountofchoosen = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client\\"+name +"\\buyfolder\\cart\\" +codescontetn[q]+"\\number.txt");
                try {
                    Scanner scanfirstcount = new Scanner(changecounter);
                    String help = scanfirstcount.nextLine();
                    Scanner scansecondcount = new Scanner(tellmecountofchoosen);
                    String help2 = scansecondcount.nextLine();
                    try {
                        FileWriter thiswritesnewcount = new FileWriter(changecounter);
                        int io = Integer.parseInt(help);
                        io=io-(Integer.parseInt(help2));
                        String end = String.valueOf(io);
                        thiswritesnewcount.write(end +"\n");
                        FileWriter forseller = new FileWriter(changecountforsllerfolder);
                        forseller.write(end +"\n");
                        scanfirstcount.close();
                        scansecondcount.close();
                        thiswritesnewcount.close();
                        forseller.close();
                    } catch (Exception e53) {
                        e53.printStackTrace();
                        System.out.println("e53");
                    }
                } catch (Exception e52) {
                e52.printStackTrace();
                System.out.println("e52");
                }
            q++;
            }
            try {
                Scanner scanfirstworth = new Scanner(buyworthchanger);
                String firstone = scanfirstworth.nextLine();
                try {
                    int secnod = Integer.parseInt(money.getText());
                    FileWriter changer = new FileWriter(buyworthchanger);
                    int x1 = Integer.parseInt(firstone);
                    x1=x1+secnod;
                    String next = String.valueOf(x1);
                    changer.write(next +"\n");
                    scanfirstworth.close();
                    changer.close();
                } catch (Exception e78) {
                    e78.printStackTrace();
                    System.out.println("e78");
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                System.out.println("e12");
            }

                JFrame welldone = new JFrame();
                welldone.setBounds(0, 150, 300, 200);
                JLabel hope = new JLabel("SUCCESSFUL OPERATION,GOOD LUCK!");
                hope.setForeground(Color.GREEN);
                welldone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                welldone.setVisible(true);
                welldone.add(hope,BorderLayout.CENTER);
                mainframe2.dispose();
                File newone = new File(howmanyfolder+"\\");
                File lastdir = new File("C:\\Java\\java\\src\\FinalProject\\data\\Client"+"\\"+name+"\\finalbuy");
                if (!lastdir.exists()){
                    lastdir.mkdirs();
                }
                try {
                    copyDir(newone.toPath(), lastdir.toPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    deleter(newone.toPath());
                } catch (Exception e124) {
                }
                homepage(1, name);
        });

        JButton deletcart = new JButton();
        deletcart.setIcon(trashpic);
        deletcart.setContentAreaFilled(false);
        deletcart.setBorderPainted(false);
        JPanel lowerpanel = new JPanel(new GridLayout(2,1));
        JPanel lowerpaneldown = new JPanel(new GridLayout(1,2));
        JPanel lowerpanelup = new JPanel(new GridLayout(1,3));
        JButton homebutton = new JButton();
        homebutton.setIcon(homepic);
        homebutton.setContentAreaFilled(false);
        homebutton.setBorderPainted(false);
        mainframe2.add(lowerpanel,BorderLayout.SOUTH);
        mainframe2.add(js);
        lowerpanel.add(lowerpanelup);
        lowerpanel.add(lowerpaneldown);
        lowerpanelup.add(pricelabel);
        lowerpanelup.add(money);
        lowerpanelup.add(buybutton);
        lowerpaneldown.add(homebutton);
        lowerpaneldown.add(deletcart);
        homebutton.addActionListener(e->{
            js.removeAll();
            mainframe2.dispose();
            homepage(1,name);
        });
        deletcart.addActionListener(e->{
            File newone = new File(howmanyfolder+"\\");
            try {
                deleter(newone.toPath());
                mainframe2.dispose();
                shop(1, name);
            } catch (Exception e124) {
            }

        });

    }
}
        public static void productsreport(){
            JFrame mainframe = new JFrame();
            mainframe.setBounds(370, 100, 800, 600);
            mainframe.setVisible(true);
            mainframe.setResizable(true);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            JButton backbutton = new JButton("Back");
            backbutton.addActionListener(e->{
                mainframe.dispose();
                adminpage();
            });
            File insideproducts = new File("C:\\Java\\java\\src\\FinalProject\\data\\products\\All");
            int counter = insideproducts.list().length;

            String data[][]=new String[counter][7];  
            String column[]={"Product Code","Product Category","Product Name","Product Count","Product Price","Seller Username","Product Image Directory"};
            int i = 0;
            String[] productscodes = insideproducts.list();
            while(i<counter){
                File specificproduct = new File(insideproducts+"\\"+productscodes[i]);
                System.out.println(specificproduct);
                //product code is available from folder text
                File productcategory = new File(specificproduct+"\\productcategory.txt");
                File productname = new File(specificproduct+"\\productname.txt");
                File productcount = new File(specificproduct+"\\count.txt");
                File productprice = new File(specificproduct+"\\price.txt");
                File productseller = new File(specificproduct+"\\sellername.txt");
                File productimagedir = new File(specificproduct+"\\image.txt");
                data[i][0]=productscodes[i];
                try {
                    Scanner writecategory = new Scanner(productcategory);
                    data[i][1]=writecategory.nextLine();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    Scanner writeproductname = new Scanner(productname);
                    data[i][2]=writeproductname.nextLine();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    Scanner writeproductcount = new Scanner(productcount);
                    data[i][3]=writeproductcount.nextLine();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    Scanner writeproductprice = new Scanner(productprice);
                    data[i][4]=writeproductprice.nextLine();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    Scanner writeproductseller = new Scanner(productseller);
                    data[i][5]=writeproductseller.nextLine();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                try {
                    Scanner writeproductimagedirectory = new Scanner(productimagedir);
                    data[i][6]=writeproductimagedirectory.nextLine();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                i++;
            }         
            JTable jt=new JTable(data,column); 
            JScrollBar bar = new JScrollBar();
            JPanel uppanel = new JPanel(new GridLayout(1,1));
            JPanel centeralpanel = new JPanel(new BorderLayout());
            JScrollPane js=new JScrollPane(jt);
            js.setVisible(true);
            mainframe.add(uppanel,BorderLayout.NORTH);
            mainframe.add(centeralpanel);
            uppanel.add(backbutton);
            centeralpanel.add(js);
        }
}