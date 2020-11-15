import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra extends Search {
    int[] distance;
    int[] previous;
    public Dijkstra(int[][] graph, int source, int[] distance){
        this.graph=graph;
        this.source=source;
        this.distance=distance;
        previous=new int[graph.length];
        Arrays.fill(previous, -1);
    }
    public void search(){
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        distance[source]=0;
        previous[source]=source;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int i= 0; i<graph[0].length; i++){
                if(graph[node][i]<10000 && (distance[i]>(graph[node][i]+distance[node]))){
                    q.add(i);
                    distance[i]=graph[node][i]+distance[node];
                    previous[i]=node;
                    //System.out.println(i+"   "+node+"   "+previous[i]);
                }
            }
        }
        //for(int i: previous) System.out.println(i);
    }
    public int[] getPrevious() {
        return previous;
    }
}
