import java.util.Random;

public class PipeHandler {
    private static Random random = new Random();
    public static int baseSize = 112;
    public static int area = Game.HEIGHT - baseSize;
    public static int spacing = 120;
    public static int minSize = 40;
    public static int maxSize = area - spacing - minSize;
    public static int delay = 1;
    public static int now;

    public static void spawnPipe() {
        int heightTop = random.nextInt(maxSize) + 1;
        while (heightTop < minSize) {
            heightTop = random.nextInt(maxSize) + 1;
        }

        int heightBottom = area - heightTop - spacing;
        Pipe pipeTop = new Pipe(295, 0, 52, heightTop);
        Pipe pipeBottom = new Pipe(295, heightTop + spacing, 52, heightBottom);

        ObjectHandler.addObject(pipeTop);
        ObjectHandler.addObject(pipeBottom);
    }

    public static void tick() {
        if (now < delay) {
            now++;
        } else {
            spawnPipe();
            now = 0;
        }
    }
}
