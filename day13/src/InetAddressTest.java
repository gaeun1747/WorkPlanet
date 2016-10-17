import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip;
		ip = InetAddress.getLocalHost();
		String ipValue = ip.getHostAddress();
		System.out.println(ipValue);
				
		InetAddress naverIp;
		naverIp= InetAddress.getByName("www.naver.com");
		String naverIpValue= naverIp.getHostAddress();
		System.out.println(naverIpValue);
	}
}
