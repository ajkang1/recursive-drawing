import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Recursion extends JPanel implements ActionListener{
	
	/* this method should recursive draw concentric rings */
	public void concentricCircles(Graphics g, int width, int x, int y) {
		 
		if(width <= 1) {
			return;
		}else {
			
			g.setColor(new Color((int)(Math.random()*255), 0, 255));
			g.fillOval(x, y, width, width);
			
			concentricCircles(g, width - 10, x + 5, y + 5);
			
		}
		
		
	}	
	
	public void squares(Graphics g, int width, int x, int y) {
		//add the additional parameters (arguments) so that you can call
		//on the method recursively
		if(width <= 2) {
			return;
		}else {
			
			//g.fillRect(int x, int y, int width, int height);
			
			g.setColor(new Color(50, (int)(Math.random()*255), 255));
			g.fillRect(x, y, width, width);
			
			squares(g, width/3, x - width / 3 * 2, y - width/3 * 2);
			squares(g, width/3, width + (x - width / 3 * 2), y - width/3 * 2);
			squares(g, width/3, 2 * width + (x - width / 3 * 2), y - width/3 * 2);
			squares(g, width/3, x - width / 3 * 2, width + (y - width/3 * 2));
			squares(g, width/3, x - width / 3 * 2, 2 * width + (y - width/3 * 2));
			squares(g, width/3, 2 * width + (x - width / 3 * 2), 2 * width + (y - width/3 * 2));
			squares(g, width/3, width + (x - width / 3 * 2), 2 * width + (y - width/3 * 2));
			squares(g, width/3, width * 2 + (x - width / 3 * 2), width + (y - width/3 * 2));
			
		}
		
	}
	
	public void snail(Graphics g) {
		
	}
	
	public void snowflake(Graphics g, int x1, int y1, int x2, int y2) {
			
		double distance = Math.sqrt(Math.pow(x2 - x1, 2) - Math.pow(y2 - y1, 2));
		
		if(distance <= 2) {
			return;
		}else {
			
			g.setColor(Color.white);
			g.drawLine(x1, y1, x2, y2);
				
				
			snowflake(g, x1, y1, x2 - 4, y2 - 3); //finish
			
		}
		
	}
	
	public void tree(Graphics g, int width, int x, int y) {
		
		
		
	}
	
	public void clover(Graphics g, int width, int x, int y) { //What additional variables will you need to draw the shape?
		
		if(width <= 2) {
			return;
		}else {
			
			//top-left portion
			g.setColor(Color.white);
			g.drawOval(x, y, width, width);
			
			//top-right portion
			//shifted to the right, y is the same as top-left
			g.setColor(Color.white);
			g.drawOval(x + width, y, width, width);
			
			//bottom-left portion
			g.setColor(Color.white);
			g.drawOval(x, y + width, width, width);
			
			//bottom-right portion
			g.setColor(Color.white);
			g.drawOval(x + width, y + width, width, width);
			
			clover(g, width - 10, x + 10, y + 10);
			
		}
		
	}
	


	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 2000, 2000);
		
//		this.concentricCircles(g, 200, 50, 50);
//		this.clover(g, 150, 225, 175);
		this.squares(g, 200, 225, 300);
		
	} //my code should go above this bracket unless I know about classes
	
	public static void main(String[] arg) {
		
		// line of code to create a MethodPractice object
		Recursion m = new Recursion();
	
	}// end of main method body 
	
	
	//constructor for the class
	//kind of looks like a method but no return type!!!
	public Recursion() {
		JFrame f = new JFrame("Recursive Methods");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		f.setSize(800,600);
		f.add(this);
		f.setVisible(true);
		
	}
	Timer t = new Timer(16, this);
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}//last curly - do not delete