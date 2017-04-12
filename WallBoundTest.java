import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class WallBoundTest extends JFrame{
	WallBoundTest(){
		add(new BallPanel());
		//add(new BallPanel());
	}
	static class BallPanel extends JPanel{
		private Timer timer = new Timer(5,new TimerListener());
		private ArrayList<Ball> myBallList = new ArrayList<Ball>();
		BallPanel(){
			timer.start();
			this.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent e){
					myBallList.add(new Ball(e.getX(),e.getY()));
				}
			});
			
			
		}
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			for(Ball b:myBallList){
				b.move();
				b.wallBound(getWidth(), getHeight());
				b.spin();
				g.setColor(Color.black);
				//g.drawOval(b.cirX+b.rad,b.cirY+b.rad,2*b.rad,2*b.rad);
				//g.drawOval(b.cirX,b.cirY,4*b.rad,4*b.rad);
				g.setColor(Color.black);
				g.fillArc(b.cirX,b.cirY,4*b.rad,4*b.rad,b.ang,30);
				g.setColor(Color.red);
				g.fillArc(b.cirX+b.rad,b.cirY+b.rad,2*b.rad,2*b.rad,b.ang2,30);
				g.fillArc(b.cirX,b.cirY,4*b.rad,4*b.rad,b.ang+90,30);
				g.setColor(Color.black);
				g.fillArc(b.cirX+b.rad,b.cirY+b.rad,2*b.rad,2*b.rad,b.ang2+90,30);
				g.fillArc(b.cirX,b.cirY,4*b.rad,4*b.rad,b.ang+180,30);
				g.setColor(Color.red);
				g.fillArc(b.cirX+b.rad,b.cirY+b.rad,2*b.rad,2*b.rad,b.ang2+180,30);
				g.fillArc(b.cirX,b.cirY,4*b.rad,4*b.rad,b.ang+270,30);
				g.setColor(Color.black);
				g.fillArc(b.cirX+b.rad,b.cirY+b.rad,2*b.rad,2*b.rad,b.ang2+270,30);
			}
			
			
			
			
			
		}
		
		class TimerListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				repaint();
			}
		}
	}
	public static void main(String[] args){
		WallBoundTest frame = new WallBoundTest();
		frame.setTitle("Ball Bound Test");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}

}
