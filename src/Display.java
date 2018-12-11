import java.awt.*;
import javax.swing.*;

public class Display extends JFrame{
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;


    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(width,height));

        createDisplay();
        setVisible(true);
    }

    private void createDisplay(){

        JPanel panel= new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        //North
        JPanel panelNorth = new JPanel();
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(new JLabel("Instruction: spell the word correctly with the letters below You'll earn one " +
                "point for one correctly spelled word!"));

        //center
        JPanel panelCenter = new JPanel();
        panel.add(panelCenter, BorderLayout.CENTER);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(800,600));
        panelCenter.add(canvas);
        this.pack();


        //south
        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.add(new JLabel("input: "));
        panelSouth.add(new JTextField(8));
        JButton buttonExit = new JButton("Submit");
        panelSouth.add(buttonExit);
        //if correct jlabel contratualtions! you earned 1 point
        JButton buttonNext = new JButton("Try next one");
        panelSouth.add(buttonNext);



    }

    public Canvas getCanvas() {
        return canvas;
    }
}
