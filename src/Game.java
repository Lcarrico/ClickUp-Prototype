import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
public class Game extends GameEngine {

	Ball ball;
	public static void main(String[] args) {
		Game g = new Game();
		windowWidth = 540;
		windowHeight = 960;
		g.setVisible(true);
		g.init();
		g.run();
		System.exit(0);
	}

	void init() {
		ball = new Ball();
		
		ball.body.x = windowWidth/2 - ball.body.width/2;
		ball.body.y = windowHeight - ball.body.height;
	}

	void update() {
		ball.update(input, windowWidth, windowHeight);
		
		
		if (input.isKeyDown(KeyEvent.VK_ESCAPE)) {
			isRunning = false;
		}
	}

	void draw(Graphics g) {
		//adds Graphics2D cast to g for easier graphics rendering
		Graphics2D g2d = (Graphics2D) g;
		
		//set game background to black
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, windowWidth, windowHeight);
		
		g2d.setColor(Color.WHITE);
		ball.draw(g2d);
	}
}