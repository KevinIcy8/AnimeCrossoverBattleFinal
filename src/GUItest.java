import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUItest implements ActionListener {
    private JFrame frame;
    private JPanel twoPlay;
    private JPanel menu;
    private JLabel title;
    private JButton exitButton;
    private JButton controlsButton;
    private JButton twoPlayerButton;
    private JButton singlePlayerButton;

    public GUItest(){
        frame = new JFrame();
        menu = new JPanel();
        title = new JLabel("Multiversal Anime Battle");
        singlePlayerButton = new JButton("Single Player");
        twoPlayerButton = new JButton("2 Player");
        controlsButton = new JButton("Controls");
        exitButton = new JButton("Exit");
        int frameWidth = 600;
        frame.setSize(frameWidth,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu.setLayout(null);
        title.setBounds(225,20,200,25);
        menu.add(title);
        singlePlayerButton.setBounds(200,100,200,50);
        singlePlayerButton.addActionListener(this);
        menu.add(singlePlayerButton);
        twoPlayerButton.setBounds(200,175,200,50);
        twoPlayerButton.addActionListener(this);
        menu.add(twoPlayerButton);
        controlsButton.setBounds(200,250,200,50);
        controlsButton.addActionListener(this);
        menu.add(controlsButton);
        exitButton.setBounds(200,325,200,50);
        exitButton.addActionListener(this);
        menu.add(exitButton);
        frame.add(menu);

        frame.setVisible(true);
        /*twoPlay = new JPanel();
        JLabel title2 = new JLabel("Two Player");
        JButton normal = new JButton("Normal");
        JButton timed = new JButton("Timed");
        JButton friendly_match = new JButton("Friendly Match");
        JButton exit = new JButton("Exit");


        title2.setBounds(225, 20, 200, 25);
        twoPlay.add(title2);
        normal.setBounds(200, 100, 200, 50);
        normal.addActionListener(this);
        twoPlay.add(normal);
        timed.setBounds(200, 175, 200, 50);
        timed.addActionListener(this);
        twoPlay.add(timed);
        friendly_match.setBounds(200, 250, 200, 50);
        friendly_match.addActionListener(this);
        twoPlay.add(friendly_match);
        exit.setBounds(200, 325, 200, 50);
        exit.addActionListener(this);
        twoPlay.add(exit);

        frame.add(twoPlay);

        twoPlay.setVisible(false);
        menu.setVisible(true);

         */
    }
    int count = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton){
            JButton button = (JButton) source;
            String text = button.getText();
            if(text.equals("2 Player")){
                title.setText("2 Player");
                System.out.println(frame.getWidth()/2 -title.getWidth());
                title.setLocation(275, 20);
                twoPlayerButton.setText("Timed");
                singlePlayerButton.setText("Normal");
                controlsButton.setText("Friendly Battle");
            }
            if(text.equals("Exit")){
                title.setText("Multiversal Anime Battle");
                title.setLocation(225,20);
                twoPlayerButton.setText("2 Player");
                singlePlayerButton.setText("Single Player");
                controlsButton.setText("Controls");
            }
        }

    }
}
