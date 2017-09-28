package algo;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // 保存结果的集合
        List<Interval> result = new LinkedList<>();

        // 输入集非空
        if (intervals != null) {
            // 遍历元素
            for (Interval item : intervals) {
                // newInterval == null 表示插入的区间已经处理完了
                // 将比插入区间小的区间加入结果集中
                if (newInterval == null || item.end < newInterval.start) {
                    result.add(item);
                }
                // 将比插入区间大的区间加入结果集中，同时将插入的区间加入结果集
                else if (item.start > newInterval.end) {
                    result.add(newInterval);
                    result.add(item);
                    newInterval = null;
                }
                // 插入区间有重叠，更新插入区间
                else {
                    newInterval.start = Math.min(newInterval.start, item.start);
                    newInterval.end = Math.max(newInterval.end, item.end);
                }
            }
        }

        // 如果插入区间非空说明插入区间还未被处理
        if (newInterval != null) {
            result.add(newInterval);
        }

        return result;
    }

}
