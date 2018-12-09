import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton buttonLogin, buttonSignup;


    public Login() {
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
        panelNorth.add(new JLabel("Welcome back to word shuffle!"), BorderLayout.WEST);

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

        c.gridx=1;
        c.gridy=0;
        panelCenter.add(new JTextField(8),c);
        c.gridy++;
        panelCenter.add(new JTextField(8),c);
        c.gridy++;

//        add in action later
//        JLabel labelMessage = new JLabel("Incorrect username!");
//        panel.add(labelMessage);


        //South
        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);

        buttonLogin = new JButton("login");
        panelSouth.add(buttonLogin);

        buttonSignup = new JButton("signup");
        panelSouth.add(buttonSignup);
        buttonSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
            }
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }

        });
    }

}
