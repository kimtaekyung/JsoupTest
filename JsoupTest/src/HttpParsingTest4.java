import java.io.IOException;
import java.nio.ByteBuffer;

import org.jsoup.Jsoup;


public class HttpParsingTest4 {

	public static void main(String[] args) {
		String url = "http://thumbnews.nateimg.co.kr/view610/http://news.nateimg.co.kr/orgImg/nn/2017/06/05/201706050837046710_1.jpg";
		
		
		//이미지를 못받음.
	    try {
	       byte[] bytes = Jsoup.connect(url)
	        				.ignoreContentType(true)
	        				.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
	        				.referrer("http://dkbnews.donga.com")
	        				.timeout(12000)
	        				.followRedirects(true)
	        				.execute().bodyAsBytes();
	        ByteBuffer buffer = ByteBuffer.wrap(bytes);
	        System.out.println(buffer.toString());
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
	}
}
