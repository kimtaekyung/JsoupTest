import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class HttpParsingTest5 {

	public static void main(String[] args) {
		
		//String viewUrl = "http://score.named.com/gateway/basketball/basketball_schedule_gateway.php?date=2017-1-9";
		//kbojson.sports2i.com/ws/KBOGeneral.asmx/SetCPILogging
		//String viewUrl = "http://score.named.com/gateway/basketball/basketball_schedule_gateway.php?date=2016-11-15";
		String viewUrl = "http://kbojson.sports2i.com/ws/KBOGeneral.asmx/CheckCPILogging?nickname=축구쟁이차니&appname=ONLSPORTS";
		//String viewUrl2 = "ws://wschat.named.com:8080/chat";
		try {
			String result = Jsoup.connect(viewUrl)
						.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
						//.referrer("http://named.com/nlivechat/chat.php")
						.referrer("http://myonl.com")
						.get().body().text();
			
			System.out.println(result);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
