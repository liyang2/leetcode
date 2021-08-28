package graph;

// graph + dp/memoization
public class _787_cheapest_flights_k_stops {
    int n, src, dst, k;
    int[][] adjMatrix;
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        this.n = n;
        this.src = src;
        this.dst = dst;
        this.k = k+1;
        adjMatrix = new int[n][n];
        memo = new int[n][this.k+1]; // stores cost from city to dst

        for(int[] flight: flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        int res = dfs(src, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int dfs(int city, int stops) {
        if(city == dst && stops <= k) {
            return 0;
        }
        if(stops > k) return Integer.MAX_VALUE;
        if(memo[city][stops] != 0) return memo[city][stops];

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < adjMatrix[city].length; j++) {
            if(adjMatrix[city][j] != 0) {
                int d = dfs(j, stops+1);
                if(d != Integer.MAX_VALUE) {
                    res = Math.min(res, d + adjMatrix[city][j]);
                }
            }
        }
        memo[city][stops] = res;
        return memo[city][stops];
    }
}
