package tutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SmartEnemy extends gameObject {

	private Handler handler;
	private gameObject player;

	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		// TODO Auto-generated constructor stub
		for (int i = 0; i < handler.list.size(); i++) {
			if (handler.list.get(i).getID() == ID.player)
				player = handler.list.get(i);
		}

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float) Math
				.sqrt((x - player.getX()) * (x - player.getX())
						+ (y - player.getY()) * (y - player.getY()));
		velX = (float) ((-1.0 / distance) * diffX);
		velY = (float) ((-1.0 / distance) * diffY);
		if (x <= 0 || x >= Game.WIDTH - 50)
			velX *= -1;
		if (y <= 0 || y >= Game.HEIGHT - 65)
			velY *= -1;

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillOval((int) x, (int) y, 20, 20);
		g.drawOval((int) x, (int) y, 20, 20);

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 20, 20);
	}

}
