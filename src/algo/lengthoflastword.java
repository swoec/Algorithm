package algo;

public class lengthoflastword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLastWord(String s) {

        int index = s.length() - 1;

        // �Ӻ�����ǰ�ҵ�һ������' '���ַ�
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        if (index < 0) {
            return 0;
        }

        int tmp = index;

        // ִ�е�����˵���������һ������

        // �Ӻ�����ǰ�ҵ�һ����' '���ַ�
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
        }

        return tmp - index;
    }

}
