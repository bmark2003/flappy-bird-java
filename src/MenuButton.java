import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuButton extends JPanel {
    private Game game;

    public MenuButton(Game game) {
        this.game = game;

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenu();
            }
        });

        this.add(menuButton);
    }

    private void showMenu() {
        Menu menu = new Menu(game);
        menu.setVisible(true);
    }
}
