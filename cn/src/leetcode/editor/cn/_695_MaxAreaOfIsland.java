//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组


package leetcode.editor.cn;
public class _695_MaxAreaOfIsland{
  public static void main(String[] args) {
       Solution solution = new _695_MaxAreaOfIsland().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(grid[i][j] == 1) {
                    int area = getArea(i,j,grid,height,width);
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private int getArea(int i, int j, int[][] grid, int height, int width) {
        if(i >= height || i < 0) {
            return 0;
        }
        if(j >= width || j < 0) {
            return 0;
        }
        if(grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + getArea(i + 1, j, grid, height, width)
                   + getArea(i - 1, j, grid, height, width)
                   + getArea(i, j+1, grid, height, width)
                   + getArea(i, j-1, grid, height, width);
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}