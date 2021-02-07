package tutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//enemyBoss class which extends gameObject
public class enemyBoss extends gameObject {

	private Game game;
	private Handler handler;
	private gameObject curr = this;
	private HUD hud;
	private boolean stuck;

	public enemyBoss(float x, float y, ID id, float velX, float velY, Game game,
			Handler handler, HUD hud) {
		super(x, y, id);

		this.velX = velX;
		this.velY = velY;
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}

	@Override
	/*
	 * Tick method that controls the movement and behavior of the enemyBoss
	 * object every tick.
	 */
	public void tick() {

		/*
		 * the x and y coordinates of the object should be incremented each tick
		 * by the x velocity and y velocity.
		 */
		x += (int) velX;
		y += (int) velY;

		x = Game.clamp(x, (float) Game.WIDTH - 50, 0);
		y = Game.clamp(y, (float) Game.HEIGHT - 65, 0);
		/*
		 * the x and y coordinates should "bounce" whenever an enemyBoss object
		 * hits the boundaries of the window. If the game state is at game,
		 * allow both X velocity and Y velocity to inverse, creating a
		 * repetitive back and forth bounce. Else, only one variable inverses
		 * depending if the x boundary or y boundary was hit.
		 */
		if (x <= 0 || x >= Game.WIDTH - 50) {
			velX *= -1;
			if (game.gameState == STATE.Game) {
				velY *= -1;
			}
		}
		if (y <= 0 || y >= Game.HEIGHT - 65) {
			velY *= -1;
			if (game.gameState == STATE.Game) {
				velX *= -1;
			}
		}

		/*
		 * Uses a for loop to go through handler's list. If the gameObject is
		 * another enemyBoss, is not the current instance, and intersects
		 * current instance, the enemyBoss bounces off.
		 */
		for (int i = 0; i < handler.list.size(); i++) {
			gameObject temp = handler.list.get(i);

			if ((temp.getID() == ID.enemyBoss) && (temp != curr)
					&& (temp.getBounds().intersects(curr.getBounds()))
					&& !stuck) {
				velY *= -1;
				velX *= -1;
				stuck = true;
				return;
			} else {
				stuck = false;
			}

		}

	}

	// Creates the images of enemyBoss object.
	@Override
	public void render(Graphics g) {
		g.setColor(new Color(110, 0, 0));
		g.fillRect((int) x, (int) y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
		g.setColor(Color.orange);
		g.drawRect((int) x, (int) y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
	}

	/*
	 * enemyBoss's Rectangle boundary is set at the instance's x and y
	 * coordinates. The size is set by the 36 default size and also modified by
	 * the HUD class's ESizeDec variable.
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
	}

}