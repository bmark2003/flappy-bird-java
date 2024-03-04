import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.ServerSocket;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 288, HEIGHT = 512;
    public static int score;
    public boolean running;
    public static boolean gameOver;
    public static BufferedImage background;
    public SoundManager music;
    public Menu menu;
    public static BufferedImage gameOverImage;
    public static Base base;
    public static Bird bird;
    public static Button startButton;
    Thread thread;
    ServerSocket serverSocket;

    public static void main(String[] args) {
        new Window(WIDTH, HEIGHT, "Flappy Bird", new Game());
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
        menu = new Menu(this);
        //run();
    }

    public void init() {
        addKeyListener(new KeyHandler());
        addMouseListener(new MouseHandler());

        gameOverImage = GraphicsLoader.loadGraphics("gameover.png");
        base = new Base();
        background = GraphicsLoader.loadGraphics("background.png");
        bird = new Bird(50, 50, 34, 24);

        startButton = new Button(Game.WIDTH / 2 - 100, 120, 184, 267, GraphicsLoader.loadGraphics("start.png"));

        music = new SoundManager("music.wav");
        music.play();
    }

    public void tick() {
        if (!gameOver) {
            ObjectHandler.tick();
            base.tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(background, 0, 0, null);
        base.render(g);

        ObjectHandler.render(g);

        if (gameOver) {
            g.drawImage(gameOverImage, 50, 50, null);
            Game.startButton.render(g);
        }

        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.setColor(Color.WHITE);
        String s = Integer.toString(score / 2);
        int textWidth = g.getFontMetrics().stringWidth(s);
        g.drawString(s, WIDTH / 2 - textWidth / 2, 50);


        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        init();
        this.requestFocus();

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta > 0) {
                tick();
                updates++;

                render();
                frames++;

                delta--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Ticks: " + updates + " | FPS: " + frames);
                PipeHandler.tick();
                updates = 0;
                frames = 0;
            }
        }
    }
}
