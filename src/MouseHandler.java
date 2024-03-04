import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    private SoundManager restartSound;

    public MouseHandler() {
        restartSound = new SoundManager("swoosh.wav");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Button.checkCollision(e.getX(), e.getY(), Game.startButton)) {
            if (Game.gameOver) {
                Game.startButton.pressed = true;
                ObjectHandler.list.clear();
                ObjectHandler.addObject(Game.bird);
                Game.gameOver = false;
                Game.score = 0;
                Game.startButton.pressed = false;
                restartSound.play();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
