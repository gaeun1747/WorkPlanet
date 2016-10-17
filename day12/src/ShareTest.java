class Share {
	int value;

	void push() {
		for (int i = 0; i < 100; i++) {
			synchronized (this) { // 잠금장치 //임계영역 설정
				this.notify();//wait()된 스레드를 해지시키려면 필요
				System.out.print("Before push:" + value);
				value++;
				System.out.println(" After push:" + value);
			}
		}
	}

	void pop() {
		for (int i = 0; i < 100; i++) {
			synchronized (this) {
				if (value == 0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Before pop:" + value);
				value--;
				System.out.println(" After pop:" + value);
			}
		}
	}
}

class A extends Thread {
	Share s;

	A(Share s) {
		this.s = s;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			s.push();
		}
	}
}

class B extends Thread {
	Share s;

	B(Share s) {
		this.s = s;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			s.pop();
		}
	}
}

public class ShareTest {
	public static void main(String[] args) {
		Share s = new Share();
		A a = new A(s);
		B b = new B(s);
		a.start();
		b.start();
	}

}
