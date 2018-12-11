import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Font;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    //private BufferedImage endImage;
    private String prompt;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);

    }


    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);

        int i = 0;
        Question q = Question.readQuestion().get(i);
        prompt = q.getShuffled();


        if (prompt.length() == 4) {
            g.setColor(Color.ORANGE);
            g.fillRect(300, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(350, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(300, 300, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(350, 300, 150, 150);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            String firstLetter = prompt.substring(0,1);
            g.drawString(firstLetter, 320, 250);

            String secondLetter = prompt.substring(1,2);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(secondLetter, 420, 250);

            String thirdLetter = prompt.substring(2,3);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(thirdLetter, 320, 370);

            String fourthLetter = prompt.substring(3,4);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(fourthLetter, 420, 370);


        } else {
            g.setColor(Color.ORANGE);
            g.fillRect(300, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(350, 150, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(225, 300, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(375, 300, 150, 150);
            g.setColor(Color.ORANGE);
            g.fillRect(425, 300, 150, 150);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            String firstLetter = prompt.substring(0,1);
            g.drawString(firstLetter, 320, 250);


            g.setFont(new Font("Cambria", Font.BOLD, 100));
            String secondLetter = prompt.substring(1,2);
            g.drawString(secondLetter, 420, 250);

            String thirdLetter = prompt.substring(2,3);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(thirdLetter, 270, 390);

            String fourthLetter = prompt.substring(3,4);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(fourthLetter, 370, 390);

            String fifthLetter = prompt.substring(4,5);
            g.setFont(new Font("Cambria", Font.BOLD, 100));
            g.drawString(fifthLetter, 470, 390);
        }


        bs.show();
        g.dispose();


//        endImage = ImageLoader.loadImage("/res/pikachu.png");
//        g.drawImage(endImage, 20,20 , null);

    }

    public void run() {
        init();
        while (running) {
            render();
        }
        stop();
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
