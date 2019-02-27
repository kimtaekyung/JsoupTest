import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class HttpParsingTest3 {

	public static void main(String[] args) {
		
		//String imageUrl = "http://file1.bobaedream.co.kr/multi_image/girl/2016/12/27/14/ABY5862009a2e4a6.jpg";
		
	    	
	    	//String imgPath = "http://file1.bobaedream.co.kr/multi_image/girl/2016/12/27/14/ABY5862009a2e4a6.jpg";
		
		
			String imgPath = "http://simg.donga.com/ugc/MLBPARK/Board/14/96/38/39/1496383924620.jpg";
			
			String imgFilePath = System.getProperty("user.dir") + File.separator + "test" + File.separator + "test2.jpg";
				
			System.out.println(imgFilePath);
			
			URL imgUrl;
			ReadableByteChannel rbc = null;
			FileOutputStream fos = null;
			try {
			   imgUrl = new URL(imgPath);
			   rbc = Channels.newChannel(imgUrl.openStream());
			   fos = new FileOutputStream(imgFilePath);
			   // setState(EXTRACTING + imgFilePath);
			   fos.getChannel().transferFrom(rbc, 0, 1 << 24);
			
			} catch (MalformedURLException e) {
			   e.printStackTrace();
			} catch (FileNotFoundException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			   e.printStackTrace();
			} finally {
			   if (rbc != null) {
			      try {
			         rbc.close();
			      } catch (IOException e) {
			         e.printStackTrace();
			      }
			   }
			   if (fos != null) {
			      try {
			         fos.close();
			      } catch (IOException e) {
			         e.printStackTrace();
			      }
			   }
		    }
	}
}
