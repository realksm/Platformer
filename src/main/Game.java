package main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET;
    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
        FPS_SET = 120;
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = (1_000_000_000.0 / FPS_SET);
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastcheck = System.currentTimeMillis();
        while (true) {
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastcheck >= 1000) {
                lastcheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames );
                frames = 0;
            }
        }
    }
}
