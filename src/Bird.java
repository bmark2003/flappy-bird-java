import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird extends GameObject {
    public SoundManager dieSound;
    Animation animation;
    public float gravity;
    public float maxSpeed;

    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);
        gravity = 0.6f;
        maxSpeed = 10;

        BufferedImage[] images = new BufferedImage[3];
        for (int i = 0; i < images.length; i++) {
            images[i] = GraphicsLoader.loadGraphics("bird" + i + ".png");
        }

        animation = new Animation(this, 200, true, images);
        animation.start();

        ObjectHandler.addObject(this);
    }

    @Override
    public void tick() {
        velY += gravity;
        y += velY;

        if (velY > maxSpeed) {
            velY = maxSpeed;
        }

        if (y + height > Game.HEIGHT - 112) {
            y = Game.HEIGHT - 112 - height;
            setVelY(0);
        }
        if (y < 0) {
            y = 0;
            setVelY(0);
        }
        animation.tick();

        GameObject temp = null;
        for (int i = 0; i < ObjectHandler.list.size(); i++) {
            temp = ObjectHandler.list.get(i);
            if (temp instanceof Pipe) {
                if (this.getBounds().intersects(temp.getBounds())) {
                    dieSound = new SoundManager("die.wav");
                    Game.gameOver = true;
                    dieSound.play();
                }
            }
        }
    }

    public void die() {
        animation.stop();
        ObjectHandler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        animation.render(g);
    }
}
