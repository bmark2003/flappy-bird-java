import java.awt.*;
import java.awt.image.BufferedImage;

public class Pipe extends GameObject {
    BufferedImage pipe;

    public Pipe(int x, int y, int width, int height) {
        super(x, y, width, height);

        this.velX = 3;

        pipe = GraphicsLoader.loadGraphics("pipe.png");
    }

    @Override
    public void tick() {
        x -= velX;

        if (x + width < 0) {
            ObjectHandler.removeObject(this);
            Game.score += 1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(pipe, x, y, 52, height, null);
        g.drawImage(pipe, x, y, 52, height, null);
    }
}
