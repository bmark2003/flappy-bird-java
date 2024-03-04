import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {
    private int x, y;
    private int currentImage;

    private long delay, starTime;

    private boolean loop, running;

    private GameObject target;
    private BufferedImage[] images;

    public Animation(GameObject target, long delay, boolean loop, BufferedImage[] images) {
        this.x = target.getX();
        this.y = target.getY();
        this.currentImage = 0;
        this.delay = delay;
        this.starTime = 0;
        this.loop = loop;
        this.setTarget(target);
        this.images = images;
    }

    public void render(Graphics g) {
        if (target == null) {
            g.drawImage(images[currentImage], x, y, null);
        } else {
            g.drawImage(images[currentImage], target.x, target.y, null);
        }
    }

    public void tick() {
        long lastTime = (System.nanoTime() - starTime) / 1000000;
        if (lastTime >= delay && running) {
            currentImage++;
            starTime = System.nanoTime();
        }
        if (currentImage == images.length) {
            currentImage = 0;
            if (!loop) {
                stop();
            }
        }
    }

    public void start() {
        this.running = true;
        this.currentImage = 0;
        this.starTime = 0;
    }

    public void stop() {
        this.running = false;
        this.currentImage = 0;
        this.starTime = 0;
    }

    public GameObject getTarget() {
        return target;
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(int currentImage) {
        this.currentImage = currentImage;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public BufferedImage[] getImages() {
        return images;
    }

    public void setImages(BufferedImage[] images) {
        this.images = images;
    }
}
