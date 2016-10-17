import java.util.Scanner;

public class LopTest {
	public static void main(String[] args) {
	/*	System.out.println("java");
		System.out.println("java");
		System.out.println("java");
		System.out.println("java");
		System.out.println("java");*/
		int cnt=0;
		while(cnt<5){
			System.out.println("java");
		cnt++;
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("java");
		}
		int sum1=0;
		for (int i = 1; i<= 100; i++) {
			sum1=sum1+i;
		}
		System.out.println(sum1);
		int sum2=0;
		int cnt2=0;
		while(cnt2<=100){
			sum2=sum2+cnt2;
			cnt2++;
		}
		System.out.println(sum2);
		//1부터의 합을 계한할때 합이 200이상이 되는 숫자를 출력
		for (int i = 0,sum=0; i <=100; i++) {
			sum=sum+i;
			if (sum>=200) {
				System.out.println("합이 200이상 "+i+":"+sum);
			}
		}
		
		Scanner sc =new Scanner(System.in);
		/*
		System.out.println("입력하세요");
		String line = sc.nextLine();
		if (line.equals("yes")) {
			System.out.println("yes를 입력하셨습니다.");
			
		}	
		*/
		/*
		String line ="";
		while(!line.equals("quit")){
			System.out.println(line+"값을 출력합니다.");
			System.out.println("입력하세요[중지하려면 quit을 입력하세요]:");
			line = sc.nextLine();	
		}*/
		/*
		line="quit";
		System.out.println("do while 반복문");
		do {
			System.out.println(line+"값을 출력합니다.");
			System.out.println("입력하세요[중지하려면 quit을 입력하세요]:");
			line = sc.nextLine();	
		} while (!line.equals("quit"));
		*/

		
		danLoop:for(int dan=2; dan<=9; dan++){
			System.out.println(dan+"단");
			iLoop:for (int i = 1; i <= 12; i++) {
				if(dan*i%3==0){
					//break;
					//continue;
					//break danLoop;
					continue danLoop;
				}
				System.out.print(dan*i+"\t");
			}
			System.out.println("");
		}
		
		
	}
}
