import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean pressed;
    public BufferedImage image;

    public Button(int x, int y, int width, int height, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public static boolean checkCollision(int mouseX, int mouseY, Button button) {
        if (mouseX >= button.x && mouseX <= button.x + button.width) {
            if (mouseY >= button.y && mouseY <= button.y + button.height) {
                return true;
            }
        }
        return false;
    }

    public void render(Graphics g) {
        if (pressed) {
            g.drawImage(image, x + 1, y + 1, width - 2, height - 2, null);
        } else {
            g.drawImage(image, x, y, null);
        }
    }
}
