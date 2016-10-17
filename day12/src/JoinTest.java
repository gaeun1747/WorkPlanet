class Join extends Thread{
	int start, end,sum=0;
	Join(int start,int end){
		this.start=start;
		this.end=end;
	}
	public void run(){
		for(int i=start; i<=end; i++){
			sum += i;
		}
	}
}

public class JoinTest {
	public static void main(String[] args) {
		Join j1 = new Join(1,10); //start에 1, end에 10으로 초기화
		Join j2 = new Join(1, 100);
		/*j1.run();
		j2.run();*/
		j1.start();
		j2.start();
		try {
			j1.join();//main thread가 j1 thread의 작업이 끝날 때까지 기다림
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(j1.sum); // 0? 1? 3? 6?..55
		System.out.println(j2.sum); //0? ...5050
		System.out.println(j1.sum+j2.sum);
	}
}
