import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Horse extends Canvas implements Runnable{
	String name;//말이름
	int x, y; //말의 위치
	Horse(String name){
		this.name = name;
		x =10; y=10;
	}
	@Override
	public void paint(Graphics g) { 
		g.drawString(name, x, y);//말그리기
	}	
	@Override
	public void run() {
		Random r= new Random();
		for(int i=0;i<10;i++){
			this.x+=r.nextInt(80);
			this.repaint();
			try {
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
/*class ReadyHandler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("준비....");
	}
}*/
class Race{
	JFrame f;
	JButton btStart, btReady;
	Horse[] horses;
	
	class ReadyHandler implements ActionListener{ //이너클래스 = 중첩클래스
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("준비....");
			for(Horse h:horses){       //Thread클래스 객체 생성
				h.x=0;
				h.repaint();//graphic영역 clear되고 말의 paint() 메소드 자동호출됨
			}
		}
	}
	class StartHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			for(Horse h:horses){
				Thread thread=new Thread(h);
			    thread.start();     
			}
		}
	}
	Race(){
		f = new JFrame(); //프레임만들기 e.g)액자
		Container c = f.getContentPane(); //e.g)액자종이
		c.setLayout(new GridLayout(4, 1)); //e.g)표형태 배치 
		horses = new Horse[3];
		for(int i=0; i<horses.length; i++){
			horses[i] = new Horse(i+1+"번 말");
			c.add(horses[i]);//액자종이에 배치			
		}
		btStart = new JButton("달려");
		btReady = new JButton("준비");
		
		btReady.addActionListener(new ReadyHandler());
		btStart.addActionListener(new StartHandler());
		JPanel p = new JPanel();
		p.add(btStart);p.add(btReady);
		c.add(p); //액자종이에 배치		//paint()자동호출
		
		f.setSize(500, 300);//프레임크기지정
		f.setVisible(true);//프레임 화면에 출력
	}
}
public class RaceTest {
	public static void main(String[] args) {
		new Race();
	}

}
