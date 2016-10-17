import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port=5432;
			ServerSocket ss;
			Socket s;
			public Server(){
				try {
					ss= new ServerSocket(port);
					System.out.println("클라이언트 기다림");
					s= ss.accept();
					System.out.println("클라이언트가 접속함");
					
					
					
					s.close();
					System.out.println("클라이언트와 접속해제.");
				}catch (BindException e) {
					System.out.println(port+"포트가 이미 사용중");
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			public static void main(String[] args) {
				new Server();
			}
}
