package graph;

public class _733_flood_fill {
    int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        int oldColor = image[sr][sc];
        if(oldColor != newColor)
            dfs(sr, sc, newColor, oldColor);
        return image;
    }

    void dfs(int i, int j, int newColor, int oldColor) {
        if(i < 0 ||i == image.length || j < 0 || j == image[0].length ||
                image[i][j] != oldColor) return;


        image[i][j] = newColor;
        dfs(i+1, j, newColor, oldColor);
        dfs(i-1, j, newColor, oldColor);
        dfs(i, j+1, newColor, oldColor);
        dfs(i, j-1, newColor, oldColor);
    }
}
