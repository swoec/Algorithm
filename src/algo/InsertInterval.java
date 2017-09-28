package algo;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // �������ļ���
        List<Interval> result = new LinkedList<>();

        // ���뼯�ǿ�
        if (intervals != null) {
            // ����Ԫ��
            for (Interval item : intervals) {
                // newInterval == null ��ʾ����������Ѿ���������
                // ���Ȳ�������С���������������
                if (newInterval == null || item.end < newInterval.start) {
                    result.add(item);
                }
                // ���Ȳ���������������������У�ͬʱ������������������
                else if (item.start > newInterval.end) {
                    result.add(newInterval);
                    result.add(item);
                    newInterval = null;
                }
                // �����������ص������²�������
                else {
                    newInterval.start = Math.min(newInterval.start, item.start);
                    newInterval.end = Math.max(newInterval.end, item.end);
                }
            }
        }

        // �����������ǿ�˵���������仹δ������
        if (newInterval != null) {
            result.add(newInterval);
        }

        return result;
    }

}
