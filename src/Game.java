import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Game /*implements ActionListener*/ {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel buttons_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[64];
    int randomButton = ThreadLocalRandom.current().nextInt(0, 63 + 1);

    int randomNum1 = ThreadLocalRandom.current().nextInt(0, 255 + 1);
    int randomNum2 = ThreadLocalRandom.current().nextInt(0, 255 + 1);
    int randomNum3 = ThreadLocalRandom.current().nextInt(0, 255 + 1);
    int score = 0;


    Game(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("Arial",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        //score
        textfield.setText("Score = " + score);
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,750,100);
        buttons_panel.setLayout(new GridLayout(8,8));
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
                        textfield.setText("Score = " + score);
                        newColor();
                    }
                }
            });
        }
        buttons[randomButton].setBackground(new Color(0,0,0));

    }
    public void newColor(){

            int one = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int two = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int three = ThreadLocalRandom.current().nextInt(0, 255 + 1);

            for(int i = 0; i < 64 ; i++){

                buttons[i].setBackground(new Color(one,two,three));
                buttons[i].setOpaque(true);
                buttons[i].setBorderPainted(false); //removes border
                buttons_panel.add(buttons[i]);
                buttons[i].setFont(new Font("Arial",Font.PLAIN,120));
                buttons[i].setFocusPainted(false);

            }
            randomButton = ThreadLocalRandom.current().nextInt(0, 63 + 1);
            buttons[randomButton].setBackground(new Color(0,0,0));

    }


}
