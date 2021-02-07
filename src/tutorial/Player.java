package tutorial;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends gameObject {

	private Handler handler;
	private HUD hud;
	private Game game;
	private Menu menu;
	private Spawner spawner;

	public Player(float x, float y, ID id, Handler handler, HUD hud, Game game,
			Spawner spawner, Menu menu) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		this.spawner = spawner;
		this.menu = menu;
	}

	public void tick() {
		x += velX;
		y += velY;
		x = Game.clamp(x, (float) Game.WIDTH - 40, 0);
		y = Game.clamp(y, (float) Game.HEIGHT - 62, 0);
		for (int i = 0; i < handler.list.size(); i++) {
			gameObject temp = handler.list.get(i);
			if (temp.getID() == ID.enemy || temp.getID() == ID.smartEnemy
					|| temp.getID() == ID.enemyBoss) {
				if (getBounds().intersects(temp.getBounds())) {
					if (game.gameState == STATE.Game) {
						hud.setLives(hud.getLives() - 1);
						AudioPlayer.getSound("hit sound").play();
						try {
							Thread.sleep(500);
							update();
						} catch (Exception e) {
							e.printStackTrace();
						}

					}

					else if (game.gameState == STATE.Boss) {
						if (HUD.HEALTH <= 0) {
							update();
						}
						if (hud.getDefense() == 1) {
							HUD.HEALTH -= 6;
							AudioPlayer.getSound("hit sound").play();
						} else if (hud.getDefense() == 2) {
							HUD.HEALTH -= 5;
							AudioPlayer.getSound("hit sound").play();
						} else if (hud.getDefense() == 3) {
							HUD.HEALTH -= 4;
							AudioPlayer.getSound("hit sound").play();
						} else if (hud.getDefense() == 4) {
							HUD.HEALTH -= 3;
							AudioPlayer.getSound("hit sound").play();
						} else if (hud.getDefense() == 5) {
							HUD.HEALTH -= 2;
							AudioPlayer.getSound("hit sound").play();
						}
					}
				}
			}
		}
		if (game.gameState == STATE.Game) {
			if (getBounds().intersects(hud.getGoalBounds())) {
				try {
					AudioPlayer.getSound("win sound").play();
					Thread.sleep(300);
					update();
				} catch (Exception e) {
					e.printStackTrace();
				}
				won();
			}
		}
		if (game.gameState == STATE.Boss) {
			if (game.difficulty == MODE.Easy) {
				if (hud.getScore() == 75 + stageBoost()) {
					if (hud.getStage() == 3) {
						AudioPlayer.getSound("game start sound").play();
						hud.setWon(true);
					} else {
						try {
							Thread.sleep(400);
						} catch (Exception e) {
							e.printStackTrace();
						}
						won();
						spawner.setCleared(false);
						spawner.setShop(true);
						hud.setCredits(hud.getCredits() + hud.findCredits());
						hud.setScore(0);

					}
				}
			} else if (game.difficulty == MODE.Normal) {
				if (hud.getScore() == 100 + stageBoost()) {
					if (hud.getStage() == 3) {
						AudioPlayer.getSound("game start sound").play();
						hud.setWon(true);

					} else {
						try {
							Thread.sleep(400);
						} catch (Exception e) {
							e.printStackTrace();
						}
						won();
						spawner.setCleared(false);
						spawner.setShop(true);
						hud.setCredits(hud.getCredits() + hud.findCredits());
						hud.setScore(0);

					}
				}
			} else if (game.difficulty == MODE.Hard) {
				if (hud.getScore() == 125 + stageBoost()) {
					if (hud.getStage() == 3) {
						AudioPlayer.getSound("game start sound").play();
						hud.setWon(true);

					} else {
						try {
							Thread.sleep(400);
						} catch (Exception e) {
							e.printStackTrace();
						}
						won();
						spawner.setCleared(false);
						spawner.setShop(true);
						hud.setCredits(hud.getCredits() + hud.findCredits());
						hud.setScore(0);

					}
				}
			}
		}

	}

	public void render(Graphics g) {
		g.setColor(menu.getColor());
		g.fillRect((int) x, (int) y, 25, 25);
		g.setColor(Color.gray);
		g.drawRect((int) x, (int) y, 25, 25);
	}

	public void won() {

		hud.setLevel(hud.getLevel() + 1);
		update();
		spawner.setCleared(true);

	}

	public int stageBoost() {
		if (hud.getStage() == 1) {
			return 0;
		} else if (hud.getStage() == 2) {
			return 25;
		} else
			return 50;
	}

	public void update() {
		velX = 0;
		velY = 0;
		game.ki.dP = false;
		game.ki.uP = false;
		game.ki.lP = false;
		game.ki.rP = false;
		y = 200;
		x = 20;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 25, 25);
	}

}
