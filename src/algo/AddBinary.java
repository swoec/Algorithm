package algo;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String addBinary(String a, String b) {
	        a=a.trim();
	        b=b.trim();
	        
	        int alen= a.length();
	        int blen= b.length();
	        
	        int d=0;
	        if(alen>blen)d=alen;
	        else d=blen;
	        
	        boolean pd=false;
	        char []achar =a.toCharArray();
	        char[]bchar  =b.toCharArray();
	        StringBuffer sdb= new StringBuffer();
	        
	        while(d>=0){
	            int i1=0;
	            if(alen>0)
	             i1=achar[alen-1]-'0';
	            else i1=0;
	            
	            System.out.println(blen);
	            int i2=0;
	            if(blen>0){
	               i2=bchar[blen-1]-'0';
	            }else{ 
	                i2=0;
	                 }
	            
	            int i3 = (pd==true)?1:0;
	            System.out.println(i3+"---------");
	            int sum =i1+i2+i3;
	            System.out.println(i1+"--"+i2+"555"+i3);
	            System.out.println(sum+"*****");
	            int sum2= sum%2;
	            if(d>0)sdb.append(sum2);
	            else if(d==0&&pd==true)sdb.append(sum2);
	            
	            if(sum>=2){
	                pd=true;
	            }else{
	                pd=false;
	            }
	            System.out.println(pd);
	            alen--;
	            blen--;
	            d--;
	            
	        }
	        
	        return sdb.reverse().toString();
	        
	        
	    }

	public String addBinary2(String a, String b) {
	    if(a==null || a.length()==0)
	        return b;
	    if(b==null || b.length()==0)
	        return a;
	    int i=a.length()-1;
	    int j=b.length()-1;
	    int carry = 0;
	    StringBuilder res = new StringBuilder();
	    while(i>=0&&j>=0)
	    {
	        int digit = (int)(a.charAt(i)-'0'+b.charAt(j)-'0')+carry;
	        carry = digit/2;
	        digit %= 2;
	        res.append(digit);
	        i--;
	        j--;
	    }
	    while(i>=0)
	    {
	        int digit = (int)(a.charAt(i)-'0')+carry;
	        carry = digit/2;
	        digit %= 2;
	        res.append(digit);
	        i--;
	    }
	    while(j>=0)
	    {
	        int digit = (int)(b.charAt(j)-'0')+carry;
	        carry = digit/2;
	        digit %= 2;
	        res.append(digit);
	        j--;
	    }      
	    if(carry>0)
	    {
	        res.append(carry);
	    }
	    return res.reverse().toString();
	}
}
