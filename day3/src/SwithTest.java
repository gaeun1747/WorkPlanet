
public class SwithTest {
	public static void main(String[] args) {
		int year =2016;
		int mod = year%12;
		switch (mod) {
		case 0:System.out.println("원숭이해입니다.");
		break;
		case 1:System.out.println("닭의 해입니다");
		break;
		case 2:System.out.println("개의 해입니다");
		break;
		default:
		System.out.println("그외의 동물입니다.");
		break;
		}
	}
}
