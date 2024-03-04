import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private SoundManager wingSound;

    public KeyHandler() {
        wingSound = new SoundManager("wing.wav");
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Game.bird.setVelY(-8);
            wingSound.play();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
