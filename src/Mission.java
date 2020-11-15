import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Mission{
    public static void main(String[]args){
        Weighted_Graph g= new Weighted_Graph("Input\\mission.txt");
        int[][] graph=g.getGraph();
        int[] additional_info=g.getAdditional_info();
        int[] distance=new int[graph.length];
        for(int i=1; i<=additional_info[2]; i++){
            Arrays.fill(distance, 10000);
            try {
                String str= Files.lines(Paths.get("Input\\mission.txt")).skip(additional_info[0]+i).findFirst().get();
                String[] s=str.split(" ");
                int source= Integer.parseInt(s[0]);
                int destination= Integer.parseInt(s[1]);
                new Dijkstra(graph, source, distance).search();
                System.out.println("Case: "+i);
                System.out.println(distance[destination]);
            } catch (IOException e) {
                System.out.println("File not found!");
            }
        }
        //for(int[] g: graph) System.out.println(Arrays.toString(g));
        //System.out.println(Arrays.toString(distance));
    }
}