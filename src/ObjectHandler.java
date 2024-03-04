import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {
    public static LinkedList<GameObject> list = new LinkedList<>();

    public static void addObject(GameObject object) {
        list.add(object);
    }

    public static void removeObject(GameObject object) {
        list.remove(object);
    }

    public static void render(Graphics g) {
        GameObject temp = null;

        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            temp.render(g);
        }
    }

    public static void tick() {
        GameObject temp = null;

        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            temp.tick();
        }
    }
}
