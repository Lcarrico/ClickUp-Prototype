import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Ball {
	double xAcc = 0;
	double yAcc = 0;
	double xVel = 0;
	double yVel = 0;
	Color color;
	
	
	Ellipse2D.Double body;
	
	/***
	 * 
	 * @param startXPos is the x-value of the top-left of the ball.
	 * @param startYPos is the y-value of the top-left of the ball.
	 * @param radius is the radius of the ball.
	 * @param color is the color of the ball.
	 */
	public Ball(double startXPos, double startYPos, double radius, Color color) {
		body = new Ellipse2D.Double(startXPos, startYPos, radius * 2, radius * 2);
		this.color = color;
	}
	
	public Ball() {
		body = new Ellipse2D.Double(0,0,100,100);
		this.color = Color.GREEN;
		
	}
	
	public void update(InputHandler input) {
		if (input.wasClicked()) {
			kickBall(input);
		}
		
		xVel += xAcc;
		yVel += yAcc;
		body.x += xVel;
		body.y += yVel;
	}
	
	private void kickBall(InputHandler input) {
		Point2D.Double click = new Point2D.Double(input.MouseX(), input.MouseY());
		
		if (body.contains(click)) {
			yVel = -1;
		}
		
	}

	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fill(body);
	}
	

}
