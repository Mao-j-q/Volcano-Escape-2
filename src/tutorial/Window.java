package tutorial;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/*
 * Window class that extends Canvas. This class creates the basic properties of the JFrame window that will be used for the game.
 */
public class Window extends Canvas {

	private static final long serialVersionUID = -6542576121873011820L;

	/*
	 * Constructor for window. The window will be provided a width, height,
	 * title, and actual game instance.
	 */
	public Window(int width, int height, String title, Game game) {

		/*
		 * Instantiates new JFrame with the given String title as the name of
		 * the JFrame.
		 */
		JFrame frame = new JFrame(title);

		/*
		 * Sets size of JFrame with the given width and height. Sets the JFrame
		 * as visible, unresizable, centered, terminatable, packed, and adds
		 * game to JFrame.
		 */
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.add(game);

		/*
		 * Sets game Focusable to true so game is automatically able to receive
		 * user input without clicking on the window beforehand. Calls game
		 * start method to begin game.
		 */
		game.setFocusable(true);
		game.start();
	}
}
