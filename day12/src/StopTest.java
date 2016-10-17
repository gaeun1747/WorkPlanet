import java.util.Scanner;

class Stop extends Thread{
	boolean flag=true;
	public void run(){
		while(flag){
			System.out.println(getName());
		}
	}
}
public class StopTest {

	public static void main(String[] args) {
		Stop s=new Stop();
		s.start();
		//int i=new Scanner(System.in).nextInt();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.flag=false;
	}

}
