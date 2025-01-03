
  // Q. Flood fill Algorithm (leetcode 733)

  public class FloodFillAlgo733{
    // helper function 
    public void helper(int image[][], int sr, int sc, int color, boolean vis[][], int orgColor){  // tc O(M*N)

      // base case 
      if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColor){
           return;
      }
      image[sr][sc] = color;
      // left 
      helper(image, sr, sc-1, color, vis, orgColor);

      //right 
      helper(image, sr, sc+1, color, vis, orgColor);

      // up 
      helper(image, sr+1, sc, color, vis, orgColor);

      // down
      helper(image, sr-1, sc, color, vis, orgColor);

      return;

    }
    public int[][] floodfill(int image[][], int sr, int sc, int color){  
      boolean vis[][] = new boolean[image.length][image[0].length];
      helper(image, sr, sc, color, vis, image[sr][sc]);
      return image; 

    }
    public static void main(String[] args) {
      
    }
  }

