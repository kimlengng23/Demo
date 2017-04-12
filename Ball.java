import java.util.Random;

public class Ball {
	public int xC,yC;
	public int uX,uY;
	public int cirX,cirY;
	public int rad = 50;
	public int ang = 0;
	public int ang2 = 360;
	public boolean mid = false;
	private Random rand= new Random();
	Ball(int xxC,int yyC){
		xC = xxC;
		yC = yyC;
		cirX = xC-(2*rad);
		cirY = yC-(2*rad);
		do{
			uX = rand.nextInt(3)-1;
		}while(uX==0);
		
		do{
			uY = rand.nextInt(3)-1;
		}while(uY==0);
		System.out.println(uX+ " "+uY);
		System.out.println(xC+ " "+yC);
	}
	public void wallBound(int width,int height){
		
		if (xC-2*rad<0){
			uX=1;
		}
		else if(xC+2*rad>width){
			uX=-1;
		}
			
		if (yC-2*rad<0){
			uY=1;
		}
		else if(yC+2*rad>=height){
			uY=-1;
		}
		
	}
	public void move(){
		xC+=uX;
		yC+=uY;
		ang++;
		ang2--;
		cirX = xC-(2*rad);
		cirY = yC-(2*rad);
	}
	public void spin(){
		if(ang==360){
			ang=0;
	
		}
		if(ang2==0){
			ang2=360;
		}
	}
}
