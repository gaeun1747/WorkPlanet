import java.text.SimpleDateFormat;
import java.util.Date;

class First extends Thread{
	public void run() {
		for(int i=1;i<100;i++){
		System.out.println(getName()+":FIRST"+i);
		}
	}
}

class Second extends Thread{
	SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
	public void run() { //부모 메서드에서 선언한 예외만 자식 메서드에서 선언할 수 있다. throws로 예외처리하지 못함.
		
		for(int i=0;i<10;i++){
			System.out.println(sdf.format(new Date()));
			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Play extends Thread{
	public void run() {
		for(int i=1;i<100;i++){
		System.out.println("동영상...");
		}
	}
}
class Sound extends Thread{
	public void run() {
		for(int i=1;i<100;i++){
		System.out.println("음악...");
		}
	}
}
class Caption extends Thread{
	public void run() {
		for(int i=1;i<100;i++){
		System.out.println("자막...");
		}
	}
}
public class ThreadTest {
	public static void m(){
		Thread curr=Thread.currentThread();//현재 사용중인 스레드
		System.out.println(curr.getName());
	}
	
	public static void main(String[] args) {
		m();
		First one = new First();
		First two = new First();
		Second three = new Second();
		//one.run();
		//Sound s=new Sound();
		//Play p=new Play();
		//Caption c=new Caption();
		//s.start();
		//p.start();
		//c.start();
		one.start(); //스레드 시작시키려면 start()!!
		two.start();
		three.start();
		System.out.println("END MAIN");
	}
	
}

// 1-thread 내에서는 순차 일처리
//main
//FIRST
//END MAIN


//2-thread 내에서는 병렬 작업
//main
//END MAIN
//FIRST
//스레드 스케줄링은 JVM과 OS에서 하는 일이므로
//어느 스레드가 먼저 cpu를 점령할지 아무도 모른다
//그때 그때 결과값이 달라진다. 
//규칙이 없음. 결과값 예측 불가.