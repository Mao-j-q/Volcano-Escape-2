package tutorial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
	private Game game;
	private Handler handler;
	private HUD hud;
	private Spawner spawner;
	private Menu menu;

	public Shop(Game game, Handler handler, HUD hud, Spawner spawner,
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
		if (game.gameState == STATE.Shop) {
			if (mouseOver(mx, my, 220, 360, 180, 60)) {
				game.gameState = STATE.Game;
				handler.addObject(new Player(30, 200, ID.player, handler, hud,
						game, spawner, menu));
				spawner.setCleared(true);
				AudioPlayer.getSound("game start sound").play();
				AudioPlayer.pause("main music");
				AudioPlayer.getMusic("game music").loop(1, .3f);
			}
			if (mouseOver(mx, my, 70, 220, 70, 50)) {
				if (enoughC(450, hud.getCredits()) && hud.getLives() < 5) {
					hud.setCredits(hud.getCredits() - 450);
					hud.setLives(hud.getLives() + 1);
					AudioPlayer.getSound("purchase sound").play();
					;
				} else {
					AudioPlayer.getSound("error sound").play();
				}
			}
			if (mouseOver(mx, my, 280, 300, 70, 50)) {
				if (enoughC(350, hud.getCredits()) && HUD.HEALTH < 100) {
					hud.setCredits(hud.getCredits() - 350);
					HUD.HEALTH = newHealth((int) HUD.HEALTH, 100);
					AudioPlayer.getSound("purchase sound").play();
					;
				} else {
					AudioPlayer.getSound("error sound").play();
				}
			}
			if (mouseOver(mx, my, 490, 220, 70, 50)) {
				if (enoughC(550, hud.getCredits()) && hud.getDefense() < 5) {
					hud.setCredits(hud.getCredits() - 550);
					hud.setDefense(hud.getDefense() + 1);

					AudioPlayer.getSound("purchase sound").play();
					;
				} else {
					AudioPlayer.getSound("error sound").play();
				}
			}
			if (mouseOver(mx, my, 70, 370, 70, 50)) {
				if (enoughC(600, hud.getCredits()) && hud.getSpeedBoost() < 5) {
					hud.setCredits(hud.getCredits() - 600);
					hud.setSpeedBoost(hud.getSpeedBoost() + 1);
					AudioPlayer.getSound("purchase sound").play();
					;
				} else {
					AudioPlayer.getSound("error sound").play();
				}
			}
			if (mouseOver(mx, my, 490, 370, 70, 50)) {
				if (enoughC(650, hud.getCredits()) && hud.getESizeDec() < 3) {
					hud.setCredits(hud.getCredits() - 650);
					hud.setESizeDec(hud.getESizeDec() + 1);
					AudioPlayer.getSound("purchase sound").play();
					;
				} else {
					AudioPlayer.getSound("error sound").play();
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void tick() {

	}

	public void render(Graphics g) {
		Font font = new Font("arial", 1, 30);
		Font font2 = new Font("arial", 1, 40);
		Font font3 = new Font("arial", 1, 20);
		Font font4 = new Font("arial", 1, 17);

		g.setColor(Color.black);
		g.fillRect(225, 360, 180, 60);
		g.fillRect(190, 20, 250, 190);
		g.setFont(font);
		g.setColor(Color.gray);
		g.drawString("CONTINUE", 235, 400);
		g.setFont(font3);
		g.drawString("CREDITS: " + hud.getCredits(), 205, 90);
		g.setFont(font2);

		g.setColor(Color.white);
		g.drawString("SHOP", 260, 60);
		g.setFont(font4);
		g.drawString("Lives: " + hud.getLives(), 205, 115);
		g.drawString("Health: " + (int) HUD.HEALTH, 205, 135);
		g.drawString("Defense: " + hud.getDefense(), 205, 155);
		g.drawString("Speed: " + hud.getSpeedBoost(), 205, 175);
		g.drawString("Decrease Size: " + hud.getESizeDec(), 205, 195);
		g.setFont(font3);
		g.setColor(Color.black);
		g.fillRect(30, 150, 150, 100);
		g.fillRect(240, 230, 150, 100);
		g.fillRect(450, 150, 150, 100);
		g.fillRect(30, 300, 150, 100);
		g.fillRect(450, 300, 150, 100);
		g.setColor(Color.gray);
		g.drawString("Cost: 450", 50, 210);
		g.drawString("Cost: 350", 260, 290);

		g.setColor(Color.white);
		g.drawString("+1 life", 50, 180);

		g.drawString("+40 Health", 260, 260);
		g.setFont(font4);
		g.setColor(Color.gray);
		g.drawString("Cost: 550", 470, 210);
		g.drawString("Cost: 600", 50, 360);
		g.drawString("Cost: 700", 470, 360);
		g.setColor(Color.white);
		g.drawString("Upgrade", 470, 170);
		g.drawString("Defense", 470, 190);

		g.drawString("Upgrade", 50, 320);
		g.drawString("speed", 50, 340);

		g.drawString("Decrease", 470, 320);
		g.drawString("Enemy size", 470, 340);

		g.setFont(font3);
		g.fillRect(70, 220, 70, 50);
		g.fillRect(280, 300, 70, 50);
		g.fillRect(70, 370, 70, 50);
		g.fillRect(490, 370, 70, 50);
		g.fillRect(490, 220, 70, 50);
		g.setColor(Color.black);
		g.drawString("Buy", 85, 250);
		g.drawString("Buy", 295, 330);
		g.drawString("Buy", 505, 250);
		g.drawString("Buy", 85, 400);
		g.drawString("Buy", 505, 400);

		if (game.gameState == STATE.Shop && hud.getLives() == 5) {
			g.setFont(font4);
			g.setColor(Color.orange);
			g.drawString("MAXED!", 295, 115);
		}
		if (game.gameState == STATE.Shop && HUD.HEALTH == 100) {
			g.setFont(font4);
			g.setColor(Color.orange);
			g.drawString("MAXED!", 315, 135);
		}
		if (game.gameState == STATE.Shop && hud.getDefense() == 5) {
			g.setFont(font4);
			g.setColor(Color.orange);
			g.drawString("MAXED!", 310, 155);
		}
		if (game.gameState == STATE.Shop && hud.getSpeedBoost() == 5) {
			g.setFont(font4);
			g.setColor(Color.orange);
			g.drawString("MAXED!", 300, 175);
		}
		if (game.gameState == STATE.Shop && hud.getESizeDec() == 3) {
			g.setFont(font4);
			g.setColor(Color.orange);
			g.drawString("MAXED!", 350, 195);
		}
	}

	private boolean enoughC(int cost, int creds) {
		if (creds < cost) {
			return false;
		} else {
			return true;
		}
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

	private int newHealth(int val, int tot) {
		if (val + 40 > tot) {
			return tot;
		} else {
			return val + 40;
		}
	}
}
