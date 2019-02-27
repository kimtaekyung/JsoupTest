import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.handshake.ServerHandshake;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ChatParseTest1 {
	
	
	public static void main(String[] args) throws URISyntaxException {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 WebSocketClient mWs = new WebSocketClient( new URI( "ws://wschat.named.com:8080/chat" ), new Draft_10()){

			@Override
			public void onClose(int arg0, String arg1, boolean arg2) {
				System.out.println("onClose");
			}

			@Override
			public void onError(Exception arg0) {
				// TODO Auto-generated method stub
				System.out.println("onError()");
			}

			@Override
			public void onMessage(String json) {
				// TODO Auto-generated method stub
				JSONParser jsonParser = new JSONParser();
	            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
	            try {
	            	
	            	
					JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
					
					if(jsonObject.get("header") != null && jsonObject.get("body") != null){
						
						JSONObject header =  (JSONObject) jsonObject.get("header");
						JSONObject body =  (JSONObject) jsonObject.get("body");
						
						if(!header.isEmpty() && !body.isEmpty()){
							if(header.get("type").equals("LOBBY") && body.get("cmd").equals("MSG")){
								
								ArrayList<JSONObject> arr = (ArrayList<JSONObject>)body.get("messages");
								
								if(!arr.isEmpty()){
									String msg = arr.get(0).toString();
									System.out.println(msg);
								}
							}
						}
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void onOpen(ServerHandshake arg0) {
				// TODO Auto-generated method stub
				System.out.println("onOpen()");
				
				JSONObject login_packet = new JSONObject();

				JSONObject header = new JSONObject();

				header.put("version","1.1");
				header.put("type" ,"LOGIN");
				header.put("direction" ,"server");

				JSONObject body = new JSONObject();

				body.put("cmd" ,"LOGIN_USER");
				body.put("site_id" ,"localhost");
				body.put("userid" ,"GUEST_mob8N7");
				body.put("session_id" ,"");
				body.put("connect_mode" ,"normal");
				body.put("browser_type" , "pc");
				body.put("version" ,"1.1");


				login_packet.put("header", header);
				login_packet.put("body", body);

				//send message
				this.send(login_packet.toString());
			}
		
		 };
		 mWs.connect();
	}
}
