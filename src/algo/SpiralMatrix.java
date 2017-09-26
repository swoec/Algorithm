package algo;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix sm = new SpiralMatrix();
		int [][] ma={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		sm.spiralOrder(ma);
	}
	
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
         if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
        //每一圈左上角数字的坐标为（top,left）,右下角的数字的坐标为（bottom，right）
        int top = 0, left = 0;
        int bottom = matrix.length - 1, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            outEdge(res, matrix, left++, top++, right--, bottom--);
        }
        System.out.println(res.toString());
        return res; 
    }
      private static void outEdge(List<Integer> res, int[][] matrix, int left, int top, int right, int bottom) {
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
        } else if (left == right) {
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][left]);
            }
        } else {
            int curRow = top;
            int curCol = left;
            while (curCol < right) {
                res.add(matrix[top][curCol++]);
            }
            while (curRow < bottom) {
                res.add(matrix[curRow++][right]);
            }
            while (curCol > left) {
                res.add(matrix[bottom][curCol--]);
            }
            while (curRow > top) {
                res.add(matrix[curRow--][left]);
            }
        }
    }

}
