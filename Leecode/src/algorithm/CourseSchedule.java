package algorithm;

import java.util.*;

/**
 * @author zjn
 **/
public class CourseSchedule {
    // 节点的入度：使用数组保存每个节点的入度
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 课号和对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        // 将所有的课程先放入
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
        }
        // 2. 依赖关系，依赖当前课程的后续课程
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // 初始化入度和依赖关系
        for (int[] relate : prerequisites) {
            int cur = relate[1];
            int next = relate[0];
            // 更新入度
            inDegree.put(next, inDegree.get(next) + 1);
            // 当前节点的邻接表
            if (!adj.containsKey(cur)) {
                adj.put(cur, new ArrayList<>());
            }
            adj.get(cur).add(next);
        }

        // 3. BFS，将入度为0的课程放入队列，队列中的课程就是没有先修，可以学的课程
        Deque<Integer> deque = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                deque.offer(key);
            }
        }

        // 取出一个节点，对应学习这门课程
        // 遍历当前邻接表，更新其入度，更新之后查看入度，如果为0，加入到队列
        while (!deque.isEmpty()) {
            int cur = deque.pollLast();
            // 遍历当前课程的邻接表，更新后继节点的入度
            if (!adj.containsKey(cur)) {
                continue;
            }
            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                inDegree.put(k, inDegree.get(k) - 1);
                if (inDegree.get(k) == 0) {
                    deque.offer(k);
                }
            }
        }

        // 4. 遍历入队，如果还有课程的入度不为0，返回false
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(6, new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 2}, {5, 3}, {5, 4}}));
    }
}
