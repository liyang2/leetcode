package graph.topologicalSort;
import java.util.*;
public class _course_schedule_lintcode {
    public static void main(String[] args) {
        System.out.println(new _course_schedule_lintcode().canFinish(100, new int[0][]));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjLists = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjLists[i] = new ArrayList<>();
        }
        for (int[] prereq : prerequisites) {
            int preCourse = prereq[1];
            int course = prereq[0];
            adjLists[preCourse].add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        int nodeCount = 0;
        while (!q.isEmpty()) {
            int preCourse = q.poll();
            nodeCount++;
            for (int next : adjLists[preCourse]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return nodeCount == numCourses;
    }
}
