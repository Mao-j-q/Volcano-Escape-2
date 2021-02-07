package tutorial;

import java.awt.Rectangle;
import java.util.ListIterator;
import java.util.Random;

public class Spawner {

	private Handler handler;
	private HUD hud;
	private Random r;
	public Player player;
	private boolean cleared = true;
	private Game game;
	private boolean shop = false;
	private int count = 0;

	public Spawner(Handler handler, HUD hud, Player player, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.player = player;
		r = new Random();
		this.game = game;
	}

	public void tick() {

		if (hud.getStage() == 1 && hud.getLevel() == 1 && isCleared()) {
			handler.addObject(new Enemy(200, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			handler.addObject(new Enemy(400, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			setCleared(false);
		}
		if (isCleared()) {
			for (ListIterator<gameObject> itr = handler.list.listIterator(); itr
					.hasNext();) {
				gameObject temp = itr.next();
				if (temp.getID() == ID.enemy || temp.getID() == ID.smartEnemy
						|| temp.getID() == ID.enemyBoss) {
					itr.remove();
				}
			}

		}

		if (hud.getStage() == 1 && hud.getLevel() == 2 && isCleared()) {
			handler.addObject(new Enemy(200, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			handler.addObject(new Enemy(400, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			handler.addObject(new Enemy(500, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 1 && hud.getLevel() == 3 && isCleared()) {
			handler.addObject(new Enemy(200, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			handler.addObject(new Enemy(300, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			handler.addObject(new Enemy(400, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			handler.addObject(new Enemy(500, r.nextInt(400) + 10, ID.enemy, 0,
					10, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 1 && hud.getLevel() == 4 && isCleared()) {
			handler.addObject(new Enemy(200, r.nextInt(400) + 10, ID.enemy, 0,
					15, game, hud, handler));
			handler.addObject(new Enemy(300, r.nextInt(400) + 10, ID.enemy, 0,
					15, game, hud, handler));
			handler.addObject(new Enemy(400, r.nextInt(400) + 10, ID.enemy, 0,
					15, game, hud, handler));
			handler.addObject(new Enemy(500, r.nextInt(400) + 10, ID.enemy, 0,
					15, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 1 && hud.getLevel() == 5 && isCleared()) {
			handler.addObject(new Enemy(150, r.nextInt(400) + 10, ID.enemy, 4,
					15, game, hud, handler));
			handler.addObject(new Enemy(300, r.nextInt(400) + 10, ID.enemy, 4,
					15, game, hud, handler));
			handler.addObject(new Enemy(450, r.nextInt(400) + 10, ID.enemy, 4,
					15, game, hud, handler));
			handler.addObject(new Enemy(550, r.nextInt(400) + 10, ID.enemy, 4,
					15, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 2 && hud.getLevel() == 1 && isCleared()) {
			handler.addObject(
					new Enemy(200, 100, ID.enemy, 4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(250, 200, ID.enemy, -4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(350, 200, ID.enemy, 4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(500, 300, ID.enemy, 4, 11, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 2 && hud.getLevel() == 2 && isCleared()) {
			handler.addObject(
					new Enemy(200, 100, ID.enemy, 4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(250, 200, ID.enemy, -4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(350, 200, ID.enemy, 4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(500, 300, ID.enemy, 4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(550, 300, ID.enemy, 3, 11, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 2 && hud.getLevel() == 3 && isCleared()) {
			handler.addObject(
					new Enemy(200, 100, ID.enemy, -4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(250, 200, ID.enemy, 4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(350, 200, ID.enemy, -4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(500, 300, ID.enemy, -4, 11, game, hud, handler));
			handler.addObject(
					new Enemy(550, 300, ID.enemy, 4, 11, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 2 && hud.getLevel() == 4 && isCleared()) {
			handler.addObject(
					new Enemy(200, 350, ID.enemy, -2, 10, game, hud, handler));
			handler.addObject(
					new Enemy(250, 200, ID.enemy, 4, 10, game, hud, handler));
			handler.addObject(
					new Enemy(350, 50, ID.enemy, -4, 10, game, hud, handler));
			handler.addObject(
					new Enemy(500, 300, ID.enemy, -4, 13, game, hud, handler));
			handler.addObject(
					new Enemy(550, 300, ID.enemy, 4, 10, game, hud, handler));
			handler.addObject(
					new Enemy(50, 20, ID.enemy, 15, 8, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 2 && hud.getLevel() == 5 && isCleared()) {
			handler.addObject(new Enemy(r.nextInt(350) + 60,
					r.nextInt(400) + 10, ID.enemy, r.nextInt(5) + 4,
					r.nextInt(5) + 7, game, hud, handler));
			handler.addObject(new Enemy(r.nextInt(350) + 60,
					r.nextInt(400) + 10, ID.enemy, r.nextInt(5) + 4,
					r.nextInt(5) + 7, game, hud, handler));
			handler.addObject(new Enemy(r.nextInt(350) + 60,
					r.nextInt(400) + 10, ID.enemy, r.nextInt(5) + 4,
					r.nextInt(5) + 7, game, hud, handler));
			handler.addObject(new Enemy(r.nextInt(350) + 60,
					r.nextInt(400) + 10, ID.enemy, r.nextInt(5) + 4,
					r.nextInt(5) + 7, game, hud, handler));
			handler.addObject(new SmartEnemy(300, 300, ID.smartEnemy, handler));
			setCleared(false);
		}
		if (hud.getStage() == 3 && hud.getLevel() == 1 && isCleared()) {
			handler.addObject(
					new Enemy(200, 100, ID.enemy, 0, 12, game, hud, handler));
			handler.addObject(
					new Enemy(200, 150, ID.enemy, 0, 13, game, hud, handler));
			handler.addObject(
					new Enemy(200, 330, ID.enemy, 15, 0, game, hud, handler));
			handler.addObject(
					new Enemy(200, 80, ID.enemy, 15, 0, game, hud, handler));
			handler.addObject(
					new Enemy(400, 100, ID.enemy, 0, 12, game, hud, handler));
			handler.addObject(
					new Enemy(400, 150, ID.enemy, 0, 13, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 3 && hud.getLevel() == 2 && isCleared()) {
			handler.addObject(new enemyBoss(200, 250, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 100, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 380, ID.enemyBoss, 15, 0, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 40, ID.enemyBoss, 15, 0, game,
					handler, hud));
			handler.addObject(new enemyBoss(400, 80, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(400, 300, ID.enemyBoss, 0, 10, game,
					handler, hud));
			setCleared(false);
		}
		if (hud.getStage() == 3 && hud.getLevel() == 3 && isCleared()) {

			handler.addObject(new enemyBoss(100, 0, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(100, 70, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(150, 370, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(150, 300, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(200, 60, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 130, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(250, 320, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(250, 390, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(300, 60, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(300, 130, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(350, 320, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(350, 390, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(400, 50, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(400, 120, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(450, 310, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(450, 380, ID.enemyBoss, 0, 10, game,
					handler, hud));

			handler.addObject(new enemyBoss(500, 30, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(500, 100, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(550, 290, ID.enemyBoss, 0, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(550, 370, ID.enemyBoss, 0, 10, game,
					handler, hud));
			setCleared(false);

		}
		if (hud.getStage() == 3 && hud.getLevel() == 4 && isCleared()) {
			handler.addObject(new enemyBoss(200, 80, ID.enemyBoss, 0, 7, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 300, ID.enemyBoss, 0, 7, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 380, ID.enemyBoss, 10, 0, game,
					handler, hud));
			handler.addObject(new enemyBoss(200, 40, ID.enemyBoss, 10, 0, game,
					handler, hud));
			handler.addObject(new enemyBoss(400, 80, ID.enemyBoss, 0, 7, game,
					handler, hud));
			handler.addObject(new enemyBoss(400, 300, ID.enemyBoss, 0, 7, game,
					handler, hud));
			handler.addObject(
					new Enemy(300, 300, ID.enemy, 10, 0, game, hud, handler));
			handler.addObject(
					new Enemy(300, 100, ID.enemy, 10, 0, game, hud, handler));
			handler.addObject(
					new Enemy(30, 30, ID.enemy, 12, 8, game, hud, handler));
			handler.addObject(
					new Enemy(550, 40, ID.enemy, -12, 8, game, hud, handler));
			handler.addObject(
					new Enemy(500, 270, ID.enemy, 2, 12, game, hud, handler));
			handler.addObject(
					new Enemy(540, 30, ID.enemy, -2, 12, game, hud, handler));
			setCleared(false);
		}
		if (hud.getStage() == 3 && hud.getLevel() == 5) {
			count++;
			int xRan = r.nextInt(300) + 50;
			int yRan = r.nextInt(300) + 50;
			if (count == 400) {
				while (!spaceAvailable(xRan, yRan)) {
					xRan = r.nextInt(300) + 50;
					yRan = r.nextInt(300) + 50;
				}
				handler.addObject(new enemyBoss(xRan, yRan, ID.enemyBoss,
						r.nextInt(5) + 4, r.nextInt(5) + 4, game, handler,
						hud));
				handler.addObject(new SmartEnemy(r.nextInt(430) + 30,
						r.nextInt(370) + 30, ID.smartEnemy, handler));
				count = 0;
			}
		}
		if (hud.getStage() == 3 && hud.getLevel() == 5 && isCleared()) {

			handler.addObject(new enemyBoss(200, 80, ID.enemyBoss, 10, 5, game,
					handler, hud));
			handler.addObject(new enemyBoss(300, 30, ID.enemyBoss, 10, 5, game,
					handler, hud));
			handler.addObject(new enemyBoss(140, 350, ID.enemyBoss, 5, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(190, 180, ID.enemyBoss, 5, 10, game,
					handler, hud));
			handler.addObject(new enemyBoss(80, 210, ID.enemyBoss, 5, 10, game,
					handler, hud));

			handler.addObject(new SmartEnemy(30, 30, ID.smartEnemy, handler));
			handler.addObject(new SmartEnemy(400, 400, ID.smartEnemy, handler));
			handler.addObject(new SmartEnemy(450, 30, ID.smartEnemy, handler));
			setCleared(false);
		}

		if (hud.getLevel() == 5) {
			game.gameState = STATE.Boss;
		}
		if (hud.getLevel() > 5 && hud.getStage() < 3 && isShop()) {
			hud.setLevel(1);
			hud.setStage(hud.getStage() + 1);
			game.gameState = STATE.Shop;
			AudioPlayer.pause("game music");
			AudioPlayer.getMusic("main music").loop(1, .2f);
			setCleared(false);
		}
		if ((hud.getLives() == 0 || (int) HUD.HEALTH < 0)) {

			try {
				AudioPlayer.pause("game music");
				AudioPlayer.getSound("game over sound").play();
				Thread.sleep(800);
				AudioPlayer.getMusic("main music").loop(1, 0.2f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			game.gameState = STATE.End;
		}

		if ((hud.getStage() == 3 && hud.getWon() == true)) {
			try {
				Thread.sleep(500);
				game.gameState = STATE.End;
				AudioPlayer.getSound("win game cheer").play(1, .25f);
				AudioPlayer.pause("game music");
				AudioPlayer.getMusic("main music").loop(1, 0.2f);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (game.gameState == STATE.End) {
			clearAll();
		}
		if (game.gameState == STATE.Shop) {
			clearAll();
		}
		if (hud.getWon() == true) {
			clearAll();
		}

		if (game.gameState == STATE.End) {
			hud.setFinScore(hud.findFinScore());
		}
		if (hud.getStage() == 3) {
			hud.setFinStage(true);
		}

	}

	public void clearAll() {
		for (ListIterator<gameObject> itr = handler.list.listIterator(); itr
				.hasNext();) {
			itr.next();
			itr.remove();
		}
	}

	public void restart() {
		if (game.difficulty == MODE.Easy) {
			hud.setDefense(3);
			hud.setLevel(1);
			hud.setLives(5);
			hud.setScore(0);
			hud.setStage(1);
			hud.setCredits(0);
			hud.setFinScore(0);
			hud.setSpeedBoost(3);
			hud.setESizeDec(2);
			hud.setWon(false);
			hud.setFinStage(false);
			HUD.HEALTH = 100;
		} else if (game.difficulty == MODE.Normal) {
			hud.setDefense(2);
			hud.setLevel(1);
			hud.setLives(3);
			hud.setScore(0);
			hud.setStage(1);
			hud.setCredits(0);
			hud.setFinScore(0);
			hud.setSpeedBoost(2);
			hud.setESizeDec(1);
			hud.setWon(false);
			hud.setFinStage(false);
			HUD.HEALTH = 100;
		} else if (game.difficulty == MODE.Hard) {
			hud.setDefense(1);
			hud.setLevel(1);
			hud.setLives(2);
			hud.setScore(0);
			hud.setStage(1);
			hud.setCredits(0);
			hud.setESizeDec(1);
			hud.setFinScore(0);
			hud.setSpeedBoost(1);
			hud.setWon(false);
			hud.setFinStage(false);
			HUD.HEALTH = 100;
		}
	}

	private boolean spaceAvailable(int x, int y) {
		boolean space = true;
		for (int num = 0; num < handler.list.size(); num++) {
			gameObject temp = handler.list.get(num);
			if (temp.getID() == ID.enemyBoss || temp.getID() == ID.player) {
				if (getEObj(x, y).intersects(temp.getBounds())) {
					space = false;
				}
			}
		}
		return space;
	}

	private Rectangle getEObj(int x, int y) {
		return new Rectangle(x, y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public boolean isShop() {
		return shop;
	}

	public void setShop(boolean shop) {
		this.shop = shop;
	}
}

// }

//}
