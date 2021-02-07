package tutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * Enemy class that extends gameObject.
 */
public class Enemy extends gameObject {

	private Game game;
	private HUD hud;
	private Handler handler;

	public Enemy(float x, float y, ID id, float velX, float velY, Game game,
			HUD hud, Handler handler) {
		super(x, y, id);

		this.velX = velX;
		this.velY = velY;
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}

	@Override
	/*
	 * Tick method that controls the movement and behavior of the Enemy object
	 * every tick.
	 */

	public void tick() {
		/*
		 * the x and y coordinates of the object should be incremented each tick
		 * by the x velocity and y velocity.
		 */
		x += (int) velX;
		y += (int) velY;

		/*
		 * the x and y coordinates should "bounce" whenever an Enemy object hits
		 * the boundaries of the window. If the game state is at game, allow
		 * both X velocity and Y velocity to inverse, creating a repetitive back
		 * and forth bounce. Else, only one variable inverses depending if the x
		 * boundary or y boundary was hit.
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
	}

	// Creates the images of Enemy object.
	@Override
	public void render(Graphics g) {
		/*
		 * In game state, set Enemy as lighter toned red. In boss state, set as
		 * darker toned red.
		 */
		if (game.gameState == STATE.Game) {
			g.setColor(new Color(110, 0, 0));
		} else if (game.gameState == STATE.Boss) {
			g.setColor(new Color(60, 0, 0));
		}
		/*
		 * Fill a rectangle at the x and y coordinates of the Enemy instance.
		 * The default enemy's height and width is set at 36 and modified by the
		 * HUD class's ESizeDec variable.
		 */
		g.fillRect((int) x, (int) y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
		g.setColor(Color.orange);
		g.drawRect((int) x, (int) y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
	}

	/*
	 * Enemy's Rectangle boundary is set at the instance's x and y coordinates.
	 * The size is set by the 36 default size and also modified by the HUD
	 * class's ESizeDec variable.
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 36 - hud.getESizeDec(),
				36 - hud.getESizeDec());
	}

}
