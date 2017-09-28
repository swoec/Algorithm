package algo;

public class lengthoflastword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLastWord(String s) {

        int index = s.length() - 1;

        // 从后面向前找第一个不是' '的字符
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        if (index < 0) {
            return 0;
        }

        int tmp = index;

        // 执行到下面说明存在最后一个单词

        // 从后面向前找第一个是' '的字符
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
        }

        return tmp - index;
    }

}
