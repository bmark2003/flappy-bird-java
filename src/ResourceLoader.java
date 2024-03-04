import java.io.InputStream;

public class ResourceLoader {
    public static InputStream load(String path) {
        InputStream input = ResourceLoader.class.getResourceAsStream(path);
        if (input == null) {
            throw new IllegalArgumentException("Resource not found: " + path);
        }
        return input;
    }
}
