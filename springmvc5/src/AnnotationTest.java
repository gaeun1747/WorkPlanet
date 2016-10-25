import java.util.ArrayList;
import java.util.List;

class Parent{
	void m(){ }
}
class Child extends Parent{
	@Override //어노테이션밑에 선언한 메서드가 오버라이딩 안된경우 
	          //컴파일시에 영향을 미쳐서 오류를 발생시키는 어노테이션	
	//void m1(){ }
	void m(){  }
	
	@Deprecated
	void print(){ }
	
	@SuppressWarnings("rawtypes")
	List selectAll(){
		return new ArrayList();
	}
}
public class AnnotationTest {
	public static void main(String[] args) {
		Child c = new Child();
		c.print();
	}
}
