package algo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class scantest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("E:\\1.txt");
		String []strs ={"C://","E://","F://","G://"};
		HashMap set = new HashMap();
		HashMap map = new HashMap();
		for(int i=0;i<strs.length;i++){
			File file = new File(strs[i]);
	        scan(file,set);
		}
		Iterator iter = set.entrySet().iterator();
		while (iter.hasNext()) {
	        Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            String keystr =(String)key;
            String valstr=(String)val;
            if(map.containsKey(valstr)){
            	List alist = (List)map.get(valstr);
            	alist.add(keystr);
            	map.put(valstr, alist);
            }else{
            	List newlist = new ArrayList();
            	newlist.add(keystr);
            	map.put(valstr, newlist);
                 }
            }
		
		
		/*
		Iterator iterm = map.entrySet().iterator();
		while (iterm.hasNext()) {
	        Map.Entry entrym = (Map.Entry) iterm.next();
            Object keym = entrym.getKey();
            Object valm = entrym.getValue();
            System.out.println(keym);
            System.out.println(valm);
            fw.write(keym+":"+valm); 
            fw.write("\r\n"); 
		}
		 fw.close(); */
	}
	
	public static void scan(File file,HashMap set){
		
		if(file!=null){
			if(file.isDirectory()){
				File []flist = file.listFiles();
				if(flist!=null&&flist.length>0){
					for(int i=0;i<flist.length;i++){
						//System.out.println(flist[i].getAbsolutePath()+flist[i].getName());
						//set.put(flist[i].getAbsolutePath(),flist[i].getName());
						scan(flist[i],set);
					}
				}
			}else{
				set.put(file.getAbsolutePath(),file.getName());
			}
		}
		
	}

}
