import javax.swing.*;
import java.awt.*;

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
        panelCenter.add(new JTextField(8),c);
        c.gridy++;
        panelCenter.add(new JTextField(8),c);
        c.gridy++;
        panelCenter.add(new JTextField(8),c);
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

    }



}
