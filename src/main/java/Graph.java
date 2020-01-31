import java.util.*;

public class Graph {

    private int v; // number of vertices
    private LinkedList adjList[]; // adjacency list with all edges

    private Graph(int v) {
        this.v = v;
        this.adjList = new LinkedList[v];
        for(int i = 0; i < v; i++)
            adjList[i] = new LinkedList();
    }

    private void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    public List<Integer> DFS(int v) {
        //initialize visited array
        boolean[] visited = new boolean[this.v];
        return DFSHelper(v, visited, new ArrayList<>());
    }

    private List<Integer> DFSHelper(int v, boolean[] visited, List<Integer> result) {
        // 1. mark visited for vertex v as true
        visited[v] = true;

        // 2. add into result list
        result.add(v);

        // 3. create iterator and iterate over the edges for the vertex v
        ListIterator list = adjList[v].listIterator();
        while(list.hasNext()) {
            int curr = (Integer)list.next();
            // 4. if the vertex is not visited then call DFS again
            if(!visited[curr])
                DFSHelper(curr, visited, result);
        }
        return result;

    }

    public List<Integer> BFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[v];//visited array
        visited[start] = true;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int vertex = queue.poll();
                if(vertex == end) {
                    res.add(vertex);
                    return res;
                } else {
                    Iterator iterator = adjList[vertex].iterator();
                    //for each neighbor
                    while(iterator.hasNext()) {
                        int next = (int)iterator.next();
                        if(!visited[next]) {
                            queue.offer(next); //add to queue
                            visited[next] = true; //mark the node as visited
                        }
                    }
                    res.add(vertex);//add to path
                }
            }
        }
        return res;
    }

    public List<Integer> TopologicalSort() {
        int[] visited = new int[this.v];//for detecting cycles
        Stack<Integer> s = new Stack<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        //for each vertex - if not visited - call helper
        for(int i = 0; i < this.v; i++)
            if(!topologicalSortHelper(i, visited, s))
                return result;

        //at the end - pop everything
        while(!s.isEmpty()) {
            result.add(s.pop());
        }

        return result;
    }

    private boolean topologicalSortHelper(int v, int[] visited, Stack<Integer> s) {
        //mark visited to true
        if(visited[v] == 1)
            return true;
        if(visited[v] == -1)
            return false;
        visited[v] = -1;
        //iterate over all the edges
        ListIterator list = adjList[v].listIterator();
        while(list.hasNext()) {
            int curr = (int)list.next();
            if (!topologicalSortHelper(curr, visited, s)) {
                return false;
            }
        }
        visited[v] = 1;
        //push the parent at the last - so that while pop parent comes before children
        s.push(v);
        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5,2);
        g.addEdge(5,0);
        g.addEdge(4,0);
        g.addEdge(4,1);
        g.addEdge(2,3);
        g.addEdge(3,1);

        System.out.println("DFS Traversal :: ");
        System.out.println(g.DFS(5));

        System.out.println("Topological Sort :: ");
        System.out.println(g.TopologicalSort());

        System.out.println("BFS Traversal :: "+g.BFS(2,4));
    }
}


