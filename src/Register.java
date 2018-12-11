import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Register extends JFrame {
    private JButton buttonSubmit;


    public Register() {
        createView();

        setTitle("word shuffle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        //North
        JPanel panelNorth = new JPanel(new BorderLayout());
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(new JLabel("Welcome to word shuffle!"), BorderLayout.WEST);

        //Center
        JPanel panelCenter = new JPanel(new GridBagLayout());
        panel.add(panelCenter);

        GridBagConstraints c= new GridBagConstraints();
        c.gridx =0;
        c.gridy=0;
        c.anchor=GridBagConstraints.LINE_END;

        panelCenter.add(new JLabel("username: "), c);
        c.gridy++;
        panelCenter.add(new JLabel("password: "),c);
        c.gridy++;
        panelCenter.add(new JLabel("confirm password: "),c);
        c.gridy++;

        c.gridx=1;
        c.gridy=0;
        c.anchor=GridBagConstraints.LINE_START;
        JTextField userName = new JTextField(8)
        panelCenter.add(userName,c);
        String uName = userName.getText();


        c.gridy++;
        JTextField passWord1 = new JTextField(8);
        panelCenter.add(passWord1,c);
        int pas1 = Integer.parseInt(passWord1.getText());

        c.gridy++;
        JTextField passWord2 = new JTextField(8);
        panelCenter.add(passWord2,c);
        int pas2 = Integer.parseInt(passWord2.getText());
        c.gridy++;

        c.gridx=2;
        c.gridy=0;
        c.anchor=GridBagConstraints.LINE_START;
        panelCenter.add(new JLabel("(only letters, please) "), c);
        c.gridy++;
        panelCenter.add(new JLabel("(only numbers, please) "), c);
        c.gridy++;


//        add in action later
//        JLabel labelMessage = new JLabel("please enter the same password");
//        panel.add(labelMessage);


        //South
        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);

        buttonSubmit = new JButton("submit");
        panelSouth.add(buttonSubmit);
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pas1==pas2){
                    addUser(uName, pas1);
                }else{
                    System.out.println("sorry, wrong input, check your info");
                }
            }
        });



    }

    private static void addUser(String userName, int userPassword) {
        File file = new File("User.txt");
        try {

            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(userName);
            writer.println(userPassword);
            writer.close();
        } catch (Exception e) {
            System.out.println("Problem writing the file.Please make sure the path is corret");
        }


    }



}
