import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private Game game;

    public Menu(Game game) {
        this.game = game;

        setTitle("Menu");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton changeBackgroundButton = new JButton("Hatter megvaltoztatasa");
        changeBackgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackground();
            }
        });

        JPanel panel = new JPanel();
        panel.add(changeBackgroundButton);
        add(panel);

        setVisible(true);
    }

    private void changeBackground() {
        game.background = GraphicsLoader.loadGraphics("background2.png");
        game.render();
    }
}
