package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOver extends MouseAdapter {
	private Game game;
	private Handler handler;
	private HUD hud;
	private Spawner spawner;
	private Menu menu;

	public GameOver(Game game, Handler handler, HUD hud, Spawner spawner,
			Menu menu) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.spawner = spawner;
		this.menu = menu;
	}

	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();

		if (game.gameState == STATE.End) {
			if (mouseOver(mx, my, 115, 300, 170, 60)) {
				game.ki.dP = false;
				game.ki.lP = false;
				game.ki.rP = false;
				game.ki.uP = false;
				game.gameState = STATE.Game;
				spawner.setCleared(true);
				spawner.restart();
				handler.addObject(new Player(30, 200, ID.player, handler, hud,
						game, spawner, menu));
				AudioPlayer.pause("main music");
				AudioPlayer.getSound("game start sound").play();
				AudioPlayer.getMusic("game music").loop(1, 0.2f);
			}

			if (mouseOver(mx, my, 340, 300, 170, 60)) {
				game.gameState = STATE.Menu;
				AudioPlayer.getSound("cancel sound").play();
			}

		}
	}

	public void mouseReleased() {

	}

	public void tick() {

	}

	public void render(Graphics g) {

		Font font = new Font("arial", 1, 55);
		Font font2 = new Font("arial", 1, 30);
		Font font3 = new Font("arial", 1, 40);
		Font font4 = new Font("arial", 1, 35);

		g.setColor(Color.black);
		g.fillRect(185, 135, 250, 130);

		if (hud.getWon() == true) {
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("YOU WON!", 165, 100);
			g.setFont(font2);
			g.drawString("Congratulations!", 195, 175);
			g.drawString("Score: " + hud.getFinScore(), 205, 225);
		} else {
			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 145, 100);

			g.setFont(font4);
			g.setColor(Color.gray);
			g.drawString("You lost on ", 195, 165);

			g.setFont(font2);
			g.drawString("Stage: " + hud.getStage(), 210, 195);
			g.drawString("Level: " + hud.getLevel(), 210, 225);
			g.drawString("Score: " + hud.getFinScore(), 210, 255);
		}
		g.setColor(Color.black);
		g.drawRect(115, 300, 170, 60);
		g.drawRect(114, 299, 170, 60);
		g.setColor(new Color(0, 0, 80));
		g.fillRect(115, 300, 170, 60);
		g.setColor(Color.black);
		g.setFont(font2);
		g.drawString("RESTART", 130, 340);
		g.drawRect(340, 300, 170, 60);
		g.drawRect(339, 299, 170, 60);
		g.setColor(new Color(80, 0, 0));
		g.fillRect(340, 300, 170, 60);
		g.setColor(Color.black);
		g.setFont(font3);
		g.drawString("MENU", 365, 345);

	}

	public boolean mouseOver(int mx, int my, int x, int y, int width,
			int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}

}
