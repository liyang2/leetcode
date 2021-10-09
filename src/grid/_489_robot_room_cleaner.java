package grid;

// I have to admit that I don't fully understand the solution
import java.util.*;
class Robot {
    void clean() {}
    boolean move() {return false;}
    void turnRight() {}
    void turnLeft() {}
}
public class _489_robot_room_cleaner {
    Robot robot;
    Set<List<Integer>> set;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.set = new HashSet<>();
        dfs(0, 0, 0);
    }

    void dfs(int i, int j, int d) {
        robot.clean();
        set.add(Arrays.asList(i, j));

        for(int k = 0; k < 4; k++) {
            int newD = (d + k) % 4;
            int newI = i + dirs[newD][0];
            int newJ = j + dirs[newD][1];
            if(!set.contains(Arrays.asList(newI, newJ)) && robot.move()) {
                // now robot is positioned at (newI, newJ)
                dfs(newI, newJ, newD);
                goBack();
                // now robot is back at (i, j)
            }
            robot.turnRight();
        }
    }

    void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
