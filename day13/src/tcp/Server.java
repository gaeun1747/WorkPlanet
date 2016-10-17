package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
public class Server {
	int port=5432;
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	String clientName;
	public Server(){
		try {
			ss= new ServerSocket(port);
			while(true){
				System.out.println("클라이언트 기다림");
				try{
					s= ss.accept();
					clientName=s.getInetAddress().getHostName();
					System.out.println(clientName+"가 접속함");
					dis= new DataInputStream(s.getInputStream());
					dos = new DataOutputStream(s.getOutputStream());
					String receiveValue= "quit";
					while (!(receiveValue=dis.readUTF()).equals("quit")) {
						dos.writeUTF(clientName+">"+receiveValue);
						}
				}catch (Exception e) {
				}finally{
					try {
						s.close();
					}catch (Exception e) {}
						System.out.println(clientName+"가 접속해제");
				}
			}
		}catch (BindException e) {
			System.out.println(port+"포트가 이미 사용중");
		}catch (SocketException e) {
			System.out.println("클라이언트와 연결해제");
		}catch (IOException e) {
			System.out.println("");
		}
	}
	public static void main(String[] args) {
				new Server();
	}
}
