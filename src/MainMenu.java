import javax.swing.*;

public class MainMenu extends JFrame{
    private JPanel mainPanel;
    private JLabel title;
    private JButton exitButton;
    private JButton controlsButton;
    private JButton twoPlayerButton;
    private JButton singlePlayerButton;

    public MainMenu(){
        setContentPane(mainPanel);
        setTitle("test1");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
