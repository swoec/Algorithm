package algo;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.Map;  
  
  
public class CreateIndex {  
      
    private Map<String, ArrayList<String>> map=new HashMap<>();  
    private ArrayList<String> list;  
    private Map<String, Integer> nums=new HashMap<>();  
      
    public String CreateIndex(String ss,String topics){  
  
        String[] words = null;  
        //File file=new File(filepath);  
		//BufferedReader reader=new BufferedReader(new FileReader(file));  
		String s=null;  
         // while((s=reader.readLine())!=null){  
		    //获取单词  
		    words=ss.split(" ");  
		      
		//}  
		    
		    for(int i=0;i<words.length-1;i++){
		    	if(!map.containsKey(words[i])){
		    		list= new ArrayList<String>();
		    		list.add(words[i+1]);
		    		map.put(words[i], list);
		    		nums.put(words[i],1);
		    		
		    	}else{
		    		list=map.get(words[i]);
		    		list.add(words[i+1]);
		    		int count=nums.get(words[i])+1;
		    		nums.put(words[i], count);
		    	}
		    	
		    }
		    
		    
		    ArrayList news = (ArrayList)map.get(topics);
		    int tem=0;
		    String itm="";
		    for(int j=0;j<news.size();j++){
		    	String cus =(String)news.get(j);
		    	ArrayList pros = map.get(cus);
		    	for(int k=0;k<pros.size();k++){
		    		int itmsnum=nums.get((String)pros.get(k));
		    		String curitm=(String)pros.get(k);
		    		if(tem<itmsnum&&!curitm.equals(topics)){
			    		tem=itmsnum;
			    		itm=(String)pros.get(k);
			    	}else{
			    		continue;
			    	}
			    	return itm;
		    	}
		    	
		    	
		    	
		    }
		    
		    
		  /*
		for (String string : words) {  
		  
		    if (!map.containsKey(string)) {  
		        list=new ArrayList<String>();  
		        
		        //list.add(filepath);  
		        map.put(string, list);  
		        nums.put(string, 1);  
		    }else {  
		        list=map.get(string);  
		        //如果没有包含过此文件名，则把文件名放入  
		        //if (!list.contains(filepath)) {  
		         //   list.add(filepath);  
		        //}  
		        //文件总词频数目  
		        int count=nums.get(string)+1;  
		        nums.put(string, count);  
		    }  
		}  
         // reader.close();   */ 
      return "";
          
    }  
    public static void main(String[] args) {  
        CreateIndex index=new CreateIndex();  
          
        //for(int i=1;i<=3;i++){  
            //String path="E:\\data\\"+i+".txt"; 
        String ss ="custA item1 custB item1 custA item2 custB item3 custC item1 custC item3 custD item2";
           String its= index.CreateIndex(ss,"item1");  
           System.out.println(its);
       // }  
        for (Map.Entry<String, ArrayList<String>> map : index.map.entrySet()) {  
            System.out.println(map.getKey()+":"+map.getValue());  
        }  
  
        for (Map.Entry<String, Integer> num : index.nums.entrySet()) {  
            System.out.println(num.getKey()+":"+num.getValue());  
        }  
    }  
}  
