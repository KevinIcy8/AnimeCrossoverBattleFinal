import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUItest implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JButton exitButton;
    private JButton controlsButton;
    private JButton twoPlayerButton;
    private JButton singlePlayerButton;

    public GUItest(){
        frame = new JFrame();
        panel = new JPanel();
        title = new JLabel("Multiversal Anime Battle");
        singlePlayerButton = new JButton("Single Player");
        twoPlayerButton = new JButton("2 Player");
        controlsButton = new JButton("Controls");
        exitButton = new JButton("Exit");
        int frameWidth = 600;
        frame.setSize(frameWidth,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        title.setBounds(225,20,200,25);
        panel.add(title);
        singlePlayerButton.setBounds(200,100,200,50);
        singlePlayerButton.addActionListener(this);
        panel.add(singlePlayerButton);
        twoPlayerButton.setBounds(200,175,200,50);
        twoPlayerButton.addActionListener(this);
        panel.add(twoPlayerButton);
        controlsButton.setBounds(200,250,200,50);
        controlsButton.addActionListener(this);
        panel.add(controlsButton);
        exitButton.setBounds(200,325,200,50);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        frame.setVisible(true);
    }
    int count = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        if(count % 2 !=0) {
            title.setText("2 Player");
            twoPlayerButton.setText("Timed");
            singlePlayerButton.setText("Normal");
            controlsButton.setText("Friendly Battle");
        }
        else{
            title.setText("Multiversal Anime Battle");
            twoPlayerButton.setText("2 Player");
            singlePlayerButton.setText("Single Player");
            controlsButton.setText("Controls");
        }
    }
}
