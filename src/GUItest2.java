import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUItest2 implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JButton exitButton;
    private JButton controlsButton;
    private JButton twoPlayerButton;
    private JButton singlePlayerButton;

    public GUItest2() {
        frame = new JFrame();
        panel = new JPanel();
        title = new JLabel("Two Player");
        singlePlayerButton = new JButton("Normal");
        twoPlayerButton = new JButton("Timed");
        controlsButton = new JButton("Friendly Match");
        exitButton = new JButton("Exit");
        int frameWidth = 600;
        frame.setSize(frameWidth, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        title.setBounds(225, 20, 200, 25);
        panel.add(title);
        singlePlayerButton.setBounds(200, 100, 200, 50);
        singlePlayerButton.addActionListener(this);
        panel.add(singlePlayerButton);
        twoPlayerButton.setBounds(200, 175, 200, 50);
        twoPlayerButton.addActionListener(this);
        panel.add(twoPlayerButton);
        controlsButton.setBounds(200, 250, 200, 50);
        controlsButton.addActionListener(this);
        panel.add(controlsButton);
        exitButton.setBounds(200, 325, 200, 50);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        frame.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}