import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    static JPanel buttons_panel = new JPanel();
    static JLabel textfield = new JLabel();
    static JButton[] buttons = new JButton[64];
    int randomButton = ThreadLocalRandom.current().nextInt(0, 63 + 1);
    int randomNum1 = ThreadLocalRandom.current().nextInt(0, 255 + 1);
    int randomNum2 = ThreadLocalRandom.current().nextInt(0, 255 + 1);
    int randomNum3 = ThreadLocalRandom.current().nextInt(0, 255 + 1);
    int rand1 = randomNum1 + 20;
    int rand2 = randomNum2 + 20;
    int rand3 = randomNum3 + 20;
    static int score = 0;

    public static void setScore(){
        textfield.setText("Score = " + score + " Timer = " + Timer.minute);
    }
    public static void gameOver(){
        textfield.setText("Game Over. Your score was " + score);
        buttons_panel.setVisible(false);
    }
    Game(){

        Timer minuteTime = new Timer();
        Thread myThread = new Thread(minuteTime);
        myThread.start();
        if(rand1>255){
            rand1-=40;
        }
        if(rand2>255){
            rand2-=40;
        }
        if(rand3>255){
            rand3-=40;
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("Arial",Font.BOLD,50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        //score
        textfield.setText("Score = " + score + " Timer = " + Timer.minute);
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,750,100);
        buttons_panel.setLayout(new GridLayout(8,8,2,2));
        buttons_panel.setBackground(Color.black);
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(buttons_panel);
        for(int i = 0; i < 64 ; i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(new Color(randomNum1,randomNum2,randomNum3));
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false); //removes border
            buttons_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial",Font.PLAIN,120));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(buttons[randomButton]==e.getSource()) {
                        score++;
                        textfield.setText("Score = " + score + " Timer = " + Timer.minute);
                        newColor();
                    }
                    else{
                        score--;
                        textfield.setText("Score = " + score + " Timer = " + Timer.minute);
                    }
                }
            });
        }
        buttons[randomButton].setBackground(new Color(rand1,rand2,rand3));
    }
    public void newColor(){
            int one = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int two = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int three = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int random1 = one + 20;
            int random2 = two + 20;
            int random3 = three + 20;
            if(random1>255){
                random1-=40;
            }
            if(random2>255){
                random2-=40;
            }
            if(random3>255){
                random3-=40;
            }

            for(int i = 0; i < 64 ; i++){

                buttons[i].setBackground(new Color(one,two,three));
                buttons[i].setOpaque(true);
                buttons[i].setBorderPainted(false); //removes border
                buttons_panel.add(buttons[i]);
                buttons[i].setFont(new Font("Arial",Font.PLAIN,120));
                buttons[i].setFocusPainted(false);

            }
            randomButton = ThreadLocalRandom.current().nextInt(0, 63 + 1);
            buttons[randomButton].setBackground(new Color(random1,random2,random3));

    }
}
