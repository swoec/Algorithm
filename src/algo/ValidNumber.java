package algo;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("10.99+9999"));
	}
	
    public boolean isNumber(String s) {
    	if(s==null||"".equals(s))return false;
    	s=s.trim();
    	char []acr = s.toCharArray();
    	boolean bln=true;
    	int dot=0;
    	
    	for(int i=acr.length-1;i>=0;i--){
    		
    		if(i==0){
    			if(acr[i]=='+'||acr[i]=='-'||(acr[i]-'0'<=9&&acr[i]-'0'>=0)){
    				//return true;
    				continue;
    			}else if(acr[i]=='.'){
    				dot++;   				
    			}else{
    			
    				bln=false;
    				//return false;
    			} 		
    	     }
    		
    		int sub =acr[i]-'0';
    		int subtra= acr[i]-'.';
    		if(sub<=9){
    			//turn true;
    			continue;
    		
    		}else if(subtra==0){
    			if(dot!=0){
    				bln=false;
    			}else{
    			    continue;
    			}
    			//return true;
    		}else{
    			bln=false;
    			//return false;
    		}

      }
    	return bln;
    }
    
    public boolean isNumber1(String s) {
        if(s==null)
            return false;
        s = s.trim();
        if(s.length()==0)
            return false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for(int i=0;i<s.length();i++)
        {
            switch(s.charAt(i))
            {
                case '.':
                    if(dotFlag || eFlag 
                    || ((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9')) 
                        && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'))))
                        return false;
                    dotFlag = true;
                    break;
                case '+':
                case '-':
                    if((i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))
                      || (i==s.length()-1 || !(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'||s.charAt(i+1)=='.')))
                        return false;
                    break;
                case 'e':
                case 'E':
                    if(eFlag || i==s.length()-1 || i==0)
                        return false;
                    eFlag = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
    
    
    public boolean isNumber3(String s) {
        s = s.trim();
        
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }
}
