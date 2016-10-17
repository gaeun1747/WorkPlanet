

public class IfTest {
 public static void main(String[] args) {
	int year;
	year=2000;
			
	int mod = year%12;
	//mod=0 이면 원숭이해입니다.
	if(mod==0){
		System.out.println("원숭이해입니다.");
	}else if(mod==1){
		System.out.println("닭의 해입니다");
	}else if(mod==2){
		System.out.println("개의 해입니다");
	}else{
		System.out.println("그외의 동물입니다.");
	}
	
	int salary=15600;
	if(salary>=20000){
		System.out.println("A등급");
	}else if(salary>=10000){
		System.out.println("B등급");
	}else{
		System.out.println("C등급");
	}
			
 }
}
