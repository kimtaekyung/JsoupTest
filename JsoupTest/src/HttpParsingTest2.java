import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HttpParsingTest2 {
	
	public static void main(String[] args) {
		
		//http://dkbnews.donga.com/Board?no=14821&m=view&tcode=bbs_dkbnews
		String viewUrl = "http://www.bobaedream.co.kr/view?code=girl&No=838759&bm=1";
		String type = "4";
		
		try{
			Document doc = Jsoup.connect(viewUrl).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
			
			String articleSelector = ""; 
			String imageSelector = "";
			String textSelector = ""; 
			
			//네임드 게시판 일경우
			if(viewUrl.indexOf("named.com") > 0){
				
				//포토와 프로토 게시판일 경우
				if(type.equals("4") || type.equals("9")){
					
					articleSelector = "div#artcBody > pre";
					imageSelector = "p > img.picker-photo";
					textSelector = "p";
					
				}else{
					
					articleSelector = "div#artcBody > pre";
					imageSelector = "img.picker-photo";
					textSelector = "p";
				}
				
				//게시물 콘텐츠
				Elements target = doc.select(articleSelector);
				
				if(!target.isEmpty()){
					
					ArrayList<String> imagePathList = new ArrayList<String>();
					ArrayList<String> textList = new ArrayList<String>();
					
					for(Element element : target.select(imageSelector)){
						
						String imagePath = element.attr("src");
						if(imagePath.indexOf("named.com") < 0){
							imagePath = "http://named.com" + imagePath;
						}
						imagePathList.add(imagePath);
					}
					for(Element element : target.select(textSelector)){
						String text = element.ownText();
						textList.add(text);
					}
					
					System.out.println("이미지 리스트");
					for(String imageName : imagePathList){
						System.out.println(imageName);
					}
					System.out.println("텍스트 리스트");
					for(String text : textList){
						System.out.println(text);
					}
					
				}
				
			//올윈티비 게시판일 경우
			}else if(viewUrl.indexOf("tongkitv.com") > 0){
				
				
				articleSelector = "div#bo_v_con";
				imageSelector = "p img";
				textSelector = "p";
				
				//게시물 콘텐츠
				Elements target = doc.select(articleSelector);
				
				if(!target.isEmpty()){
					
					ArrayList<String> imagePathList = new ArrayList<String>();
					ArrayList<String> textList = new ArrayList<String>();
					
					for(Element element : target.select(imageSelector)){
						
						String imagePath = element.attr("src");
						imagePathList.add(imagePath);
					}
					for(Element element : target.select(textSelector)){
						String text = element.ownText();
						textList.add(text);
					}
					
					
					System.out.println("이미지 리스트");
					for(String imageName : imagePathList){
						System.out.println(imageName);
					}
					System.out.println("텍스트 리스트");
					for(String text : textList){
						System.out.println(text);
					}
				}
			//보배드림.
			}else if(viewUrl.indexOf("bobaedream.co.kr") > 0){
				
				articleSelector = "div#print_area2";
				imageSelector = "a > img";
				textSelector = "p";
				
				String articleSelector_type2 = "div#print_area > div.content02 > div.bodyCont";
				String imageSelector_type2 = "p > a > img";
				String textSelector_type2 = "P";
						
				
				ArrayList<String> imagePathList = new ArrayList<String>();
				ArrayList<String> textList = new ArrayList<String>();
				
				//게시물 콘텐츠
				Elements target = doc.select(articleSelector);
				
				if(!target.isEmpty()){
					
					for(Element element : target.select(imageSelector)){
						String imagePath = element.attr("src");
						imagePathList.add(imagePath);
					}
					for(Element element : target.select(textSelector)){
						String text = element.ownText();
						textList.add(text);
					}
					
				}
				
				Elements target2 = doc.select(articleSelector_type2);
				
				if(!target2.isEmpty()){
					
					for(Element element : target2.select(imageSelector_type2)){
						String imagePath = element.attr("src");
						imagePathList.add(imagePath);
					}
					for(Element element : target2.select(textSelector_type2)){
						String text = element.ownText();
						textList.add(text);
					}
				}
				
				System.out.println("이미지 리스트");
				for(String imageName : imagePathList){
					System.out.println(imageName);
				}
				System.out.println("텍스트 리스트");
				for(String text : textList){
					System.out.println(text);
				}
				
			}else if(viewUrl.indexOf("donga.com") > 0){
				
			}
		}catch(Exception e){
			
		}
	}
}
