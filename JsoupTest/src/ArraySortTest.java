import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


public class ArraySortTest {
	
	public static void main(String[] args) {
		
		
		ArrayList<HashMap<String,Object>> testList =  new ArrayList<HashMap<String,Object>>();
		
		
		HashMap<String,Object> paramMap1 = new HashMap<String,Object>();
		paramMap1.put("이름", "종료");
		paramMap1.put("상태", 3);//종료
		paramMap1.put("날짜", "201711160900");
		
		HashMap<String,Object> paramMap2 = new HashMap<String,Object>();
		paramMap2.put("이름", "경기전");
		paramMap2.put("상태", 2);//경기전
		paramMap2.put("날짜", "201711161500");
		
		HashMap<String,Object> paramMap3 = new HashMap<String,Object>();
		paramMap3.put("이름", "경기중");
		paramMap3.put("상태", 1);//경기중
		paramMap3.put("날짜", "201711161100");
		
		HashMap<String,Object> paramMap5 = new HashMap<String,Object>();
		paramMap5.put("이름", "경기중2");
		paramMap5.put("상태", 1);//경기중
		paramMap5.put("날짜", "201711161000");
		
		
		HashMap<String,Object> paramMap4 = new HashMap<String,Object>();
		paramMap4.put("이름", "종료");
		paramMap4.put("상태", 3);//종료
		paramMap4.put("날짜", "201711160700");
		
		testList.add(paramMap1);
		testList.add(paramMap2);
		testList.add(paramMap3);
		testList.add(paramMap4);
		testList.add(paramMap5);
		
		System.out.println(testList);
		
		/*CollectionSorter<ArrayList<HashMap<String,Object>>> sorter = new CollectionSorter<ArrayList<HashMap<String,Object>>>(testList);*/
		
		testList.sort(new Comparator<HashMap<String,Object>>(){
			@Override
			public int compare(HashMap<String, Object> paramMap1,
					HashMap<String, Object> paramMap2) {
				
				if(Integer.parseInt(paramMap1.get("상태").toString()) ==  Integer.parseInt(paramMap2.get("상태").toString())){
					if(Long.parseLong(paramMap1.get("날짜").toString()) >  Long.parseLong(paramMap2.get("날짜").toString()) ){
						return 1;
					}else{
						return -1;
					}
				}else{
					if(Integer.parseInt(paramMap1.get("상태").toString()) > Integer.parseInt(paramMap2.get("상태").toString())){
						return 1;
					}else{
						return -1;
					}
				}
			}
		});
		System.out.println(testList);
		
	}
}
