import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Weighted_Graph {
    public int[][]graph;
    public int[]additional_info;

    public Weighted_Graph(String input){
        try{
            File f=new File(input);
            Scanner sc=new Scanner(f);
            //int n=Integer.parseInt(sc.nextLine());
            additional_info=new int[3];
            int n=sc.nextInt();
            graph=new int[n+1][n+1];
            for(int[] ar: graph){
                Arrays.fill(ar, 10000);
            }
            //for(int[] g: graph) System.out.println(Arrays.toString(g));
            n=sc.nextInt();
            additional_info[0]=n;
            additional_info[1]=sc.nextInt();
            additional_info[2]=sc.nextInt();
            for(int i=0; i<n; i++){
                graph[sc.nextInt()][sc.nextInt()]=sc.nextInt();
            }
            //for(int[] g: graph) System.out.println(Arrays.toString(g));
        }catch (Exception e){
            System.out.println("Input file not found!");
        }
    }
    public int[][] getGraph(){
        return graph;
    }

    public int[] getAdditional_info() {
        return additional_info;
    }
}
