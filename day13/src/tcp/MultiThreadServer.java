package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
class ServerThread extends Thread{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	String clientName;
	public ServerThread(Socket s) throws IOException{
		this.s = s;
		clientName = s.getInetAddress().getHostAddress();
		System.out.println(clientName+"가 접속함");	
		dis = new DataInputStream( s.getInputStream() );
		dos = new DataOutputStream(s.getOutputStream());
	}
	public void run() {		
		String receiveValue = "quit";
		try{
			while( !(receiveValue = dis.readUTF()).equals("quit")){
				dos.writeUTF(clientName+ ">" + receiveValue);
			}
		}catch(Exception e){		
		}finally{
			try{
				s.close();
			}catch(Exception e){}
			System.out.println(clientName+" 접속해제.");
		}
	}
}
public class MultiThreadServer {
	int port=5432;
	ServerSocket ss;
	Socket s;
	public MultiThreadServer(){
		try {
			ss = new ServerSocket(port);
			while(true){
				System.out.println("클라이언트 기다림");
				try{
					s = ss.accept();
					ServerThread t = new ServerThread(s);
					t.start();
				}catch(Exception e){					
				}
			}
		} catch (BindException e){
			System.out.println(port+"포트가 이미 사용중입니다.");
		} catch (SocketException e){
			System.out.println("클라이언트와 연결 해제.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultiThreadServer();		
	}
}