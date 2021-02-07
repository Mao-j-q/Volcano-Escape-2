package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

	private Game game;
	private Handler handler;
	private HUD hud;
	private Spawner spawner;
	protected boolean start;
	private String colorStr = "White";
	private Color color = Color.white;
	private boolean White = true;
	private boolean Blue;
	private boolean Cyan;
	private boolean Green;
	private boolean Magneta;
	private boolean Black;

	public Menu(Game game, Handler handler, HUD hud, Spawner spawner) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.spawner = spawner;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if (game.gameState == STATE.Menu) {
			if (mouseOver(mx, my, 170, 150, 270, 65)) {
				game.gameState = STATE.Settings;
				game.difficulty = MODE.Normal;
				colorUpdate();
				White = true;
				color = Color.white;
				colorStr = "White";
				AudioPlayer.getSound("cancel sound").play();
			}

			if (mouseOver(mx, my, 170, 330, 270, 65)) {
				game.gameState = STATE.Help;
				AudioPlayer.getSound("cancel sound").play();
			}
			if (mouseOver(mx, my, 170, 240, 270, 65)) {

			}
		} else if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 185, 350, 230, 65)) {
				game.gameState = STATE.Menu;
				AudioPlayer.getSound("cancel sound").play();
			}
		} else if (game.gameState == STATE.Settings) {
			if (mouseOver(mx, my, 15, 190, 80, 50)) {
				game.difficulty = MODE.Easy;
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 110, 190, 80, 50)) {
				game.difficulty = MODE.Normal;
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 205, 190, 80, 50)) {
				game.difficulty = MODE.Hard;
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 195, 350, 230, 65)) {
				game.gameState = STATE.Game;
				start = true;
				spawner.setCleared(true);
				spawner.restart();
				handler.addObject(new Player(30, 200, ID.player, handler, hud,
						game, spawner, this));
				AudioPlayer.getSound("game start sound").play();
				AudioPlayer.pause("main music");
				AudioPlayer.getMusic("game music").loop(1, 0.2f);
			}
			if (mouseOver(mx, my, 340, 190, 80, 50)) {
				colorUpdate();
				White = true;
				color = Color.white;
				colorStr = "White";
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 435, 190, 80, 50)) {
				colorUpdate();
				Blue = true;
				color = Color.blue;
				colorStr = "Blue";
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 530, 190, 80, 50)) {
				colorUpdate();
				Cyan = true;
				color = Color.cyan;
				colorStr = "Cyan";
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 340, 280, 80, 50)) {
				colorUpdate();
				Green = true;
				color = Color.green;
				colorStr = "Green";
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 435, 280, 80, 50)) {
				colorUpdate();
				Magneta = true;
				color = Color.magenta;
				colorStr = "Magenta";
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 530, 280, 80, 50)) {
				colorUpdate();
				Black = true;
				color = Color.black;
				colorStr = "Black";
				AudioPlayer.getSound("menu select sound").play();
			}
		} else if (game.gameState == STATE.Pause) {
			if (mouseOver(mx, my, 210, 140, 180, 70)) {
				game.gameState = STATE.Game;
				AudioPlayer.getSound("menu select sound").play();
			}
			if (mouseOver(mx, my, 210, 230, 180, 70)) {
				game.ki.dP = false;
				game.ki.lP = false;
				game.ki.rP = false;
				game.ki.uP = false;
				game.gameState = STATE.Game;
				spawner.setCleared(true);
				spawner.clearAll();
				spawner.restart();
				handler.addObject(new Player(30, 200, ID.player, handler, hud,
						game, spawner, this));
				AudioPlayer.getSound("game start sound").play();
				AudioPlayer.pause("game music");
				AudioPlayer.getMusic("game music").loop(1, .2f);
			}
			if (mouseOver(mx, my, 210, 320, 180, 70)) {
				spawner.clearAll();
				game.gameState = STATE.Menu;
				AudioPlayer.getSound("cancel sound").play();
				AudioPlayer.pause("game music");
				AudioPlayer.getMusic("main music").loop(1, 0.2f);
			}
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width,
			int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (game.gameState == STATE.Menu) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 80);
			g.setColor(new Color(90, 0, 0));
			g.fillRect(170, 150, 270, 65);
			g.setColor(new Color(0, 0, 90));
			g.fillRect(170, 240, 270, 65);
			g.setColor(new Color(0, 90, 0));
			g.fillRect(170, 330, 270, 65);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("MENU", 190, 100);
			g.setFont(font);
			g.setColor(Color.orange);
			g.drawString("PLAY", 240, 200);

			g.setColor(Color.orange);
			g.drawString("SURVIVAL", 180, 290);

			g.setColor(Color.orange);
			g.drawString("HELP", 240, 380);
			g.setColor(Color.black);
			g.drawRect(170, 150, 270, 65);

			g.drawRect(170, 240, 270, 65);

			g.drawRect(170, 330, 270, 65);
		} else if (game.gameState == STATE.Help) {
			Font font = new Font("arial", 1, 50);
			g.setColor(Color.gray);
			g.fillRect(185, 350, 230, 65);
			g.setColor(Color.black);
			g.drawRect(185, 350, 230, 65);
			g.setFont(font);
			g.setColor(Color.darkGray);
			g.drawString("BACK", 230, 400);
			Font summary = new Font("arial", 1, 20);
			g.setColor(Color.white);
			g.setFont(summary);
			g.drawString("The controls for the game are WASD. There are", 10,
					30);
			g.drawString("3 stages in the game with 5 levels each. The ", 10,
					60);
			g.drawString("goal of the first four levels of each stage is to ",
					10, 90);
			g.drawString("reach the green goal without being touched by enemy ",
					10, 120);
			g.drawString(
					"blocks. You have 3 lives for these levels. The fifth ", 10,
					150);
			g.drawString("level for each stage is a survival level where you",
					10, 180);
			g.drawString("are given a health bar and must reach a certain", 10,
					210);
			g.drawString(
					"score to advance. After each stage, you will be sent to a",
					10, 240);
			g.drawString(
					"store where you can buy upgrade items and heal up. The",
					10, 270);
			g.drawString(
					"credits are determined by how well you do before entering",
					10, 300);
			g.drawString("the shop. Press escape to pause the game. Have fun!",
					10, 330);

		} else if (game.gameState == STATE.Settings) {
			Font font = new Font("arial", 1, 50);
			Font font3 = new Font("arial", 1, 25);
			Font font4 = new Font("arial", 1, 22);

			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Customization", 140, 50);
			g.setFont(font3);
			g.setColor(Color.gray);
			g.drawString("Difficulty: " + game.difficulty, 15, 130);
			g.drawString("Player Color: " + colorStr, 340, 130);
			g.setColor(Color.yellow);
			g.fillRect(15, 190, 80, 50);
			g.setColor(Color.orange);
			g.fillRect(110, 190, 80, 50);
			g.setColor(Color.red);
			g.fillRect(205, 190, 80, 50);
			g.setColor(Color.black);
			g.drawRect(15, 190, 80, 50);
			g.drawRect(110, 190, 80, 50);
			g.drawRect(205, 190, 80, 50);
			g.setColor(Color.black);
			g.setFont(font4);
			g.drawString("Easy", 30, 223);
			g.drawString("Normal", 113, 223);
			g.drawString("Hard", 220, 223);
			g.setColor(Color.gray);
			g.fillRect(195, 350, 230, 65);
			g.setColor(Color.black);
			g.drawRect(195, 350, 230, 65);
			g.setFont(font);
			g.setColor(Color.darkGray);
			g.drawString("START", 230, 400);

			g.setColor(Color.white);
			g.fillRect(340, 190, 80, 50);
			g.setColor(Color.blue);
			g.fillRect(435, 190, 80, 50);
			g.setColor(Color.cyan);
			g.fillRect(530, 190, 80, 50);
			g.setColor(Color.green);
			g.fillRect(340, 280, 80, 50);
			g.setColor(Color.MAGENTA);
			g.fillRect(435, 280, 80, 50);
			g.setColor(Color.black);
			g.fillRect(530, 280, 80, 50);
			g.setColor(Color.black);
			g.drawRect(340, 190, 80, 50);
			g.drawRect(435, 190, 80, 50);
			g.drawRect(530, 190, 80, 50);
			g.drawRect(340, 280, 80, 50);
			g.drawRect(435, 280, 80, 50);
			g.drawRect(530, 280, 80, 50);
			if (game.difficulty == MODE.Easy) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 10, 185);
			} else if (game.difficulty == MODE.Normal) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 105, 185);
			} else if (game.difficulty == MODE.Hard) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 200, 185);
			}
			if (White) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 335, 185);
			} else if (Blue) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 430, 185);
			} else if (Cyan) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 525, 185);
			} else if (Green) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 335, 275);
			} else if (Magneta) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 430, 275);
			} else if (Black) {
				g.setFont(font4);
				g.setColor(Color.white);
				g.drawString("Selected", 525, 275);
			}
		} else if (game.gameState == STATE.Pause) {
			Font font = new Font("arial", 1, 42);
			Font font2 = new Font("arial", 1, 33);
			Font font3 = new Font("arial", 1, 55);
			g.setColor(Color.gray);
			g.setFont(font3);
			g.drawString("Paused", 203, 85);
			g.setFont(font);
			g.setColor(new Color(0, 0, 70));
			g.fillRect(210, 140, 180, 70);
			g.setColor(new Color(70, 0, 0));
			g.fillRect(210, 230, 180, 70);
			g.setColor(new Color(0, 70, 0));
			g.fillRect(210, 320, 180, 70);
			g.setColor(Color.black);
			g.drawRect(210, 140, 180, 70);
			g.drawRect(210, 230, 180, 70);
			g.drawRect(210, 320, 180, 70);
			g.setColor(Color.orange);
			g.drawString("Resume", 220, 190);
			g.drawString("Restart", 225, 280);
			g.setFont(font2);
			g.drawString("Main Menu", 215, 370);
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void colorUpdate() {
		White = false;
		Blue = false;
		Cyan = false;
		Green = false;
		Magneta = false;
		Black = false;
	}
}
