import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;




public class FileTest {

	final String TEMP_LOCAL_IMAGE_PATH = System.getProperty("user.dir") + File.separator + "test";
	
	public static void main(String[] args) {
		
		String imageUrl = "http://upload2.inven.co.kr/upload/2017/01/02/bbs/m15913140097.jpg";
		//String imageUrl = "http://data.named.com/data/file/photo/editor/1701/9f95a04042dd42948a7463ed2ff023c8_N2EAmcuhm.jpg";
		
		
		FileTest test = new FileTest();
		
		try {
			test.loadWebImageA(imageUrl,"loadWebImageA.jpg");
			test.loadWebImageB(imageUrl, "loadWebImageB.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadWebImageA(String imageUrl, String fileName){
		
		System.out.println("loadWebImageA");
		
		
		
		try{
			//이미지를 못받음.
			byte[] bytes = Jsoup.connect(imageUrl).maxBodySize(1048576 * 10)
					.ignoreContentType(true)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.referrer("http://www.google.com")
					.timeout(10000)
					.followRedirects(true)
					.execute().bodyAsBytes();
			
			System.out.println(bytes.length);
			
			ByteBuffer buffer = ByteBuffer.wrap(bytes);
			
			System.out.println(buffer.capacity());
			
			System.out.println(buffer.limit());
			
			saveByteBufferImage(buffer, TEMP_LOCAL_IMAGE_PATH, fileName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void saveByteBufferImage(ByteBuffer imageDataBytes, String rootTargetDirectory, String savedFileName )  {
		  
		
		System.out.println("saveByteBufferImage");
		
		String uploadInputFile = rootTargetDirectory + File.separator +savedFileName;
		
		File rootTargetDir = new File(rootTargetDirectory);
		if (!rootTargetDir.exists()) {
		    boolean created = rootTargetDir.mkdirs();
		    if (!created) {
		        System.out.println("Error while creating directory for location- "+rootTargetDirectory);
		    }
		}
		String[] fileNameParts = savedFileName.split("\\.");
		String format = fileNameParts[fileNameParts.length-1];
		File file = new File(uploadInputFile);
		BufferedImage bufferedImage;
		InputStream in = new ByteArrayInputStream(imageDataBytes.array());
		
		try{
			bufferedImage = ImageIO.read(in);
			ImageIO.write(bufferedImage, format, file);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    
	}
	
	public void loadWebImageB(String imageUrl, String fileName){
		
		int pos = fileName.lastIndexOf( "." );
		String format = fileName.substring( pos + 1 );
		
    	URL imgUrl;
		ReadableByteChannel rbc = null;
		FileOutputStream fos = null;
		
		File file = null;
		
		try{
			imgUrl = new URL(imageUrl);
		    rbc = Channels.newChannel(imgUrl.openStream());
		    fos = new FileOutputStream(TEMP_LOCAL_IMAGE_PATH + File.separator + fileName);
		    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
			file = new File(TEMP_LOCAL_IMAGE_PATH + File.separator + fileName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	   
		
	}
	
	
}
