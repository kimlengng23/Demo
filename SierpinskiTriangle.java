import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class SierpinskiTriangle extends JApplet{
	private JTextField tbOrder = new JTextField("0",5);
	private SierpinskiTrianglePanel trianglePanel = 
			new SierpinskiTrianglePanel();
	public SierpinskiTriangle(){
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter an order (should not excend 10): "));
		panel.add(tbOrder);
		tbOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		add(trianglePanel);
		add(panel,BorderLayout.SOUTH);
		tbOrder.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				trianglePanel.setOrder(Integer.parseInt(tbOrder.getText()));
				
			}
		});
		
	}
	static class SierpinskiTrianglePanel extends JPanel{
		private int order = 0;
		public void setOrder(int order){
			this.order = order;
			repaint();
		}
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			Point p1 = new Point(getWidth()/2,10);
			Point p2 = new Point(10,getHeight()-10);
			Point p3 = new Point(getWidth()-10,getHeight()-10);
			displayTriangles(g,order,p1,p2,p3);
			
		}
		private static void displayTriangles(Graphics g,int order,Point p1,Point p2,Point p3){
			if(order==0){
				
				g.drawLine(p1.x,p1.y,p2.x,p2.y);
				g.drawLine(p1.x,p1.y,p3.x,p3.y);
				g.drawLine(p2.x,p2.y,p3.x,p3.y);
				
			}
			else{
				Point p12 = midpoint(p1,p2);
				Point p23 = midpoint(p2,p3);
				Point p31 = midpoint(p3,p1);
				
				displayTriangles(g,order-1,p1,p12,p31);
				
				displayTriangles(g,order-1,p12,p2,p23);
				
				displayTriangles(g,order-1,p31,p23,p3);
				
			}
		
		}
		private static Point midpoint(Point p1,Point p2){
			return new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
		}
	}
}
