package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

class ClientThread extends Thread{
	Socket s;
	DataInputStream dis;
	public ClientThread(Socket s) throws IOException{		
		dis = new DataInputStream( s.getInputStream() );		
	}
	public void run(){
		try{
			while(true){
				String receiveValue = dis.readUTF();
				System.out.println(receiveValue);
			}
		}catch(Exception e){			
		}finally{
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
				}
			}
			System.out.println("서버와 접속 해제.");
		}
	}
}
public class MultiThreadClient {
	Socket s;
	String ip;//서버IP
	int port;//서버port
	DataOutputStream dos;
	
	public MultiThreadClient(){
		ip ="localhost"; //"192.168.0.17"; //"localhost";
		port=5432;
		try {
			s = new Socket(ip, port);
			System.out.println("서버와 접속 성공.");
			dos = new DataOutputStream( s.getOutputStream() );
			ClientThread t=  new ClientThread(s);
			t.start();
			
			Scanner sc = new Scanner(System.in);			
			String sendValue = "quit";
			do{
				sendValue =sc.nextLine();
				dos.writeUTF(sendValue);				
			}while( !sendValue.equals("quit"));			
			
		} catch (ConnectException e){
			System.out.println("서버와 접속실패. 서버확인.");
		} catch (SocketException e) {
			System.out.println("서버와 연결 해제.");	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		new MultiThreadClient();
	}
}
