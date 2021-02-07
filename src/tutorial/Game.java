package tutorial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.*;

//Game class with the elements to run the Volcano Escape 2 Game. 

public class Game extends Canvas implements Runnable {

	/*
	 * Initializes all enum states and instance variables. Add the key and mouse
	 * listeners. Creates new window instance to run game on.
	 */

	private static final long serialVersionUID = 827744610503843301L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Spawner spawn;
	private Player a;
	private Menu menu;
	protected STATE gameState;
	protected MODE difficulty;
	private GameOver go;
	private Shop shop;
	protected KeyInput ki;

	public Game() {

		// Sets the initial game state and default difficulty.

		gameState = STATE.Menu;
		difficulty = MODE.Normal;

		// Create new instance of each necessary class.

		hud = new HUD(this);
		handler = new Handler();
		spawn = new Spawner(handler, hud, a, this);
		menu = new Menu(this, handler, hud, spawn);
		go = new GameOver(this, handler, hud, spawn, menu);
		ki = new KeyInput(handler, this, hud);
		shop = new Shop(this, handler, hud, spawn, menu);

		/*
		 * Loads all the needed sound and music onto the corresponding HashMap.
		 * Then, as the game begins at the main menu, loop the main music at .2f
		 * volume.
		 */
		AudioPlayer.load();
		AudioPlayer.getMusic("main music").loop(1, 0.2f);

		/*
		 * Adds the needed KeyListener for user player control. Adds the needed
		 * MouseListeners for mouse input during menu, shop, and game over
		 * screen.
		 */
		this.addKeyListener(ki);
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		this.addMouseListener(go);

		/*
		 * Generates instance of new Window object using the instance variables
		 * of WIDTH and HEIGHT as its dimensions. The window is called
		 * "Volcano Escape 2" which is the game's name.
		 */
		new Window(WIDTH, HEIGHT, "Volcano Escape 2", this);
	}

	/*
	 * Start method to begin program. Creates new thread, starts it, and sets
	 * running boolean to true.
	 */
	public synchronized void start() {
		thread = new Thread(this, "Volcano Escape 2 thread");
		thread.start();
		running = true;
	}

	/*
	 * stop method to terminate program processing. Joins the thread and sets
	 * running to false. Catches any exceptions.
	 */
	public synchronized void stop() {

		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Complex method to run the program. Since the game class implements
	 * Runnable, the run method will activate whenever a Thread has started and
	 * has not been stopped. While running boolean is true (started),
	 * updates/ticks the game every specific duration and renders the game.
	 * While not running, call stop.
	 */

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	/*
	 * tick/update method. Updates each specific class based on the current
	 * state the program is in. Handler of gameObjects gets updated unless the
	 * game is paused.
	 */
	public void tick() {
		if (gameState != STATE.Pause) {
			handler.tick();
			if (gameState == STATE.Game || gameState == STATE.Boss) {
				hud.tick();
				spawn.tick();

			} else if (gameState == STATE.Menu) {
				menu.tick();
			} else if (gameState == STATE.Shop) {
				shop.tick();
			}
		}

	}

	// Render method to provide the images of the program.

	public void render() {
		/*
		 * Creates a BufferStrategy with game instance. If buffer is null (first
		 * time ran), create a BufferStrategy.
		 */
		BufferStrategy buffer = this.getBufferStrategy();

		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		/*
		 * Makes new Graphics instance using buffer.getDrawGraphics. Sets the
		 * background of the game as dark gray.
		 */
		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// Sets the images based off the game mode the program is in.

		if (gameState == STATE.Game || gameState == STATE.Boss) {
			handler.render(g);
			hud.render(g);
		} else if (gameState == STATE.Menu || gameState == STATE.Help
				|| gameState == STATE.Settings || gameState == STATE.Pause) {
			menu.render(g);
		} else if (gameState == STATE.End) {
			handler.render(g);
			go.render(g);

		} else if (gameState == STATE.Shop) {
			handler.render(g);
			shop.render(g);
		}
		/*
		 * Ends off by disposing the previous made graphics and showing next
		 * buffer.
		 */
		g.dispose();
		buffer.show();
	}

	/*
	 * Static method used in different parts of this project to make sure
	 * certain variables stay within given bounds.
	 */
	public static float clamp(float var, float max, float min) {
		if (var <= min)
			return min;
		if (var >= max)
			return max;
		else
			return var;
	}

	// Main method to create new Game instance.

	public static void main(String[] args) {
		new Game();

	}

}
