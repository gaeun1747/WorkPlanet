import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;

public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://post.naver.com/viewer/postView.nhn?volumeNo=4612689&memberNo=5356431&mainMenu=GAMEAPP");
		InputStream is = url.openStream();
		int readValue = -1;
		//1byte 씩읽어서 (char)로출력
		/*
		while((readValue=is.read())!=-1){
			System.out.print((char)readValue);
		}
		*/
		
		Reader r = new InputStreamReader(is);
		while((readValue=r.read())!=-1){
			System.out.print((char)readValue);
		}
	}
}
	