import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

public class Window extends JFrame {
    public Window(int width, int height, String title, Game game) {
        try {
            game.serverSocket = new ServerSocket(9898);
        } catch (IOException e) {
            throw new RuntimeException(e);
            //System.exit(1);
        }

        setTitle(title);
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(game);
        game.start();
    }
}
