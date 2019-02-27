import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class DateCheckTest {
	
	public boolean isParseableDate(Object o){
		boolean dateValidity = true;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd"); //20041102101244
		df.setLenient(false);
		if(o instanceof java.lang.String || o instanceof java.lang.Integer){
			
			if(o instanceof java.lang.String){
				try {
					@SuppressWarnings("unused")
					Date dt = df.parse((String) o);
				}catch(ParseException pe){
					dateValidity = false;
				}catch(IllegalArgumentException ae){
					dateValidity = false;
				}
			}else{
				try {
					@SuppressWarnings("unused")
					Date dt = df.parse(String.valueOf(o));
				}catch(ParseException pe){
					dateValidity = false;
				}catch(IllegalArgumentException ae){
					dateValidity = false;
				}
			}
		}else{
			dateValidity = false;
		}
		return dateValidity;
	}
	
	public boolean isParseableDate(Object o, String format){
		boolean dateValidity = true;
		SimpleDateFormat df = new SimpleDateFormat(); //20041102101244
		df.applyPattern(format);
		df.setLenient(false);
		if(o instanceof java.lang.String || o instanceof java.lang.Integer){
			
			if(o instanceof java.lang.String){
				try {
					@SuppressWarnings("unused")
					Date dt = df.parse((String) o);
				}catch(ParseException pe){
					dateValidity = false;
				}catch(IllegalArgumentException ae){
					dateValidity = false;
				}
			}else{
				try {
					@SuppressWarnings("unused")
					Date dt = df.parse(String.valueOf(o));
				}catch(ParseException pe){
					dateValidity = false;
				}catch(IllegalArgumentException ae){
					dateValidity = false;
				}
			}
		}else{
			dateValidity = false;
		}
		return dateValidity;
	}
	
	
	
	
	public static void main(String[] args) {
		
		DateCheckTest t =  new DateCheckTest();
		ArrayList<Object> arr = new ArrayList<Object>();
		
		arr.add(20170216);
		arr.add(20170245);
		arr.add("20161432");
		arr.add("20161111");
		arr.add("2016");
		arr.add("99999999");
		arr.add("1234");
		arr.add("20120231");
		arr.add("20170228");
		arr.add("2016년");
		arr.add("3월5일");
		arr.add("ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ");
		arr.add("asd");
		arr.add("!!@#!@#");
		arr.add("");
		arr.add(null);
		arr.add("2012");
		arr.add(2012);
		arr.add(0102);
		arr.add(2014);
		arr.add(20124);
		arr.add(-1);
		arr.add(1.564);
		
		for(Object s : arr){
			System.out.println(s + "    ::        " + t.isParseableDate(s));
		}
	}
}
