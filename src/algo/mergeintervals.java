package algo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class mergeintervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();

        if (intervals == null || intervals.size() < 1) {
            return result;
        }

        // �ȶ������������ʹ��һ�������ڲ���
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        //Collections.sort(arg0, arg1);

        // ����󣬺�һ��Ԫ�أ���Ϊnext����startһ���ǲ�С��ǰһ������Ϊprev��start�ģ�
        // ��������ӵ����䣬���next.start����prev.end��˵�������������Ƿֿ��ģ�Ҫ��
        // ��һ���µ����䣬����˵��next.start��[prev.start, prev.end]�ڣ���ֻҪ��
        // next.end�Ƿ��Ǵ���prev.end��������ھ�Ҫ�ϲ����䣨����
        Interval prev = null;
        for (Interval item : intervals) {

            if (prev == null || prev.end < item.start) {
                result.add(item);
                prev = item;
            } else if (prev.end < item.end) {
                prev.end = item.end;
            }
        }

        return result;
    }

}
