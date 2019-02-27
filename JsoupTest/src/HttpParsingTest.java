import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HttpParsingTest {
	
	
	public static void main(String[] args) {
		
		String type = "3";
		String url = "http://www.bobaedream.co.kr/list?code=girl";
		
		
		try{
			
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			
			//view url 셀렉터
			String listSelector = "";
			String listRowSelector = "";
			String listHrefSelector = "";
			
			
			//네임드 글일 경우
			if(url.indexOf("named.com") > 0){
				
				//포토,프로토 (갤러리 게시판 형식) 글일때
				if(type.equals("4") || type.equals("9")){
					listSelector = "#gall-list";
					listRowSelector = "li:eq(0)";	
					listHrefSelector = "p.artc_tit > a.txt_tit";
				}else{
					listSelector = "tbody#artc_list";
					listRowSelector = "tr:not(.row_noti,.item_notice)";
					listHrefSelector = "td:eq(0) > p.artc_tit > a.txt_tit";
				}
				
				Elements target = doc.select(listSelector);
				
				if(!target.isEmpty()){
					
					for (Element element : target.select(listRowSelector).eq(0)) {
						String href = element.select(listHrefSelector).attr("href").replace("..", "http://named.com").split("&sca")[0];
						String title = element.select(listHrefSelector).text();
						
						System.out.println(href);
						System.out.println(title);
						
					}
				}
			//올윈티비 게시판일 경우
			}else if(url.indexOf("tongkitv.com") > 0){
				listSelector = "#fboardlist > div.tbl_head01.tbl_wrap > table > tbody";
				listRowSelector = "tr:not(.bo_notice)";	
				listHrefSelector = "td.td_subject > a";
				
				Elements target = doc.select(listSelector);
				
				if(!target.isEmpty()){
					
					for (Element element : target.select(listRowSelector).eq(0)) {
						String href = element.select(listHrefSelector).attr("href").split("&sfl")[0];
						String title = element.select(listHrefSelector).text();
						
						System.out.println(href);
						System.out.println(title);
					}
				}
			//보배드림
			}else if(url.indexOf("bobaedream.co.kr") > 0){
				listSelector = "table#boardlist > tbody";
				listRowSelector = "tr:not(.best)";	
				listHrefSelector = "td:eq(1) > a";
				
				Elements target = doc.select(listSelector);
				
				if(!target.isEmpty()){
					 
					for (Element element : target.select(listRowSelector).eq(0)) {
						String href = element.select(listHrefSelector).attr("href");
						href = "http://www.bobaedream.co.kr" + href;
						String title = element.select(listHrefSelector).text();
						
						System.out.println(href);
						System.out.println(title);
					}
				}
			}
		}catch(Exception e){
			
		}
	}
}
