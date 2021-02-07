/**
 * 
 */
package tutorial;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Mao49
 *
 */
/*
 * Abstract gameObject class that acts as the parent class for all moving game
 * objects.
 */
public abstract class gameObject {
	/*
	 * Each gameObject subclass will have an x and y float representing the
	 * objects location, a velX and velY representing its movement, and a enum
	 * ID identifier representing the specific gameObject subclass.
	 */
	protected float x, y, velX, velY;
	protected ID id;

	/*
	 * constructor to pass in the x, y, and id.
	 */
	public gameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	/*
	 * Each gameObject subclass will have a tick instance method that determines
	 * and updates the gameObject behavior every tick.
	 */
	public abstract void tick();

	/*
	 * Each gameObject subclass will have a render instance method to draw the
	 * actual gameObject onto the program.
	 */
	public abstract void render(Graphics g);

	/*
	 * Each gameObject subclass will have a getBounds instance method that
	 * returns a Rectangle corresponding to the object's bounds.
	 */
	public abstract Rectangle getBounds();

	// Setters and getters.

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setID(ID id) {
		this.id = id;
	}

	public ID getID() {
		return id;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return velY;
	}

}
