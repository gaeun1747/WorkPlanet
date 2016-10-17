package tcp;
import java.awt.Event;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket s;
	String ip;
	int port;
	DataOutput dos;
	DataInputStream dis;
	public Client(){
		ip="192.168.0.6";
		port=5432;
		try {
			s= new Socket(ip, port);
			System.out.println("서버와 접속 성공");
			
			dos = new DataOutputStream(s.getOutputStream());
			//dos.writeUTF("hello");
			Scanner sc = new Scanner(System.in);
			String sendValue="quit";
			do{
				sendValue=sc.nextLine();
				dos.writeUTF(sendValue);
			}
			while (!sendValue.equals("quit"));
			
			s.close();
			System.out.println("서버와 접속 해제");
		}catch (ConnectException e) {
			System.out.println("서버와 접속실패. 서버확인.");
		}catch (SocketException e) {
			System.out.println("서버와 연결해제");
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Client();
	}
}
