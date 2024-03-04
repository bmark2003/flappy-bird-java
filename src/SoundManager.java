import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager {
    private Clip clip;

    public SoundManager(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    getClass().getResourceAsStream(soundFilePath));

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
