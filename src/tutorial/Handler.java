package tutorial;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<gameObject> list = new LinkedList<>();

	public void tick() {
		for (int i = 0; i < list.size(); i++) {
			gameObject temp = list.get(i);
			temp.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < list.size(); i++) {
			gameObject temp = list.get(i);
			temp.render(g);
		}
	}

	public void addObject(gameObject object) {
		this.list.add(object);
	}

	public void removeObject(gameObject object) {
		this.list.remove(object);
	}
}
