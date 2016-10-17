package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Vector;
class BroadcastServerThread extends Thread{
	Socket s;
	List<BroadcastServerThread> list;
	DataInputStream dis;
	DataOutputStream dos;
	String clientName;
	public BroadcastServerThread(Socket s, 
			                     List<BroadcastServerThread> list) throws IOException{
		this.s = s;
		this.list = list;
		clientName = s.getInetAddress().getHostAddress();
		
		//System.out.println(clientName+"가 접속함");	
		dis = new DataInputStream( s.getInputStream() );
		dos = new DataOutputStream(s.getOutputStream());
		broadcast(clientName+"가 접속함");
	}
	public void broadcast(String message){
		for(int i=0; i<list.size(); i++){
			try{
				BroadcastServerThread target = list.get(i);
				target.dos.writeUTF(message);
			}catch(Exception e){
				list.remove(i);
			}
		}
	}
	public void run() {		
		String receiveValue = "quit";
		try{
			while( !(receiveValue = dis.readUTF()).equals("quit")){
				//dos.writeUTF(clientName+ ">" + receiveValue);
				broadcast(receiveValue);
				/*for(int i=0; i<list.size(); i++){
					try{
						BroadcastServerThread target = list.get(i);
						target.dos.writeUTF(clientName+ ">" + receiveValue);
					}catch(Exception e){
						list.remove(i);
					}
				}*/
			}
		}catch(Exception e){		
		}finally{
			try{
				s.close();
			}catch(Exception e){}
			//System.out.println(clientName+" 접속해제.");
			broadcast(clientName+" 접속해제.");
			
		}
	}
}
public class BroadcastServer {
	int port=5432;
	ServerSocket ss;
	Socket s;
	List<BroadcastServerThread> list;
	public BroadcastServer(){
		try {
			ss = new ServerSocket(port);
			//list = new ArrayList<BroadcastServerThread>();
			list = new Vector<BroadcastServerThread>();
			while(true){
				System.out.println("클라이언트 기다림");
				try{
					s = ss.accept();
					BroadcastServerThread t = 
							new BroadcastServerThread(s, list);
					list.add(t);
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
		new BroadcastServer();		
	}
}