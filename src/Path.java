import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Path {
    public int[][]graph;
    public int[]additional_info;

    public Path(String input){
        try{
            File f=new File(input);
            Scanner sc=new Scanner(f);
            //int n=Integer.parseInt(sc.nextLine());
            additional_info=new int[2];
            int n=sc.nextInt();
            graph=new int[n][n];
            for(int[] ar: graph){
                Arrays.fill(ar, 10000);
            }
            //for(int[] g: graph) System.out.println(Arrays.toString(g));
            n=sc.nextInt();
            for(int i=0; i<n; i++){
                int p=sc.nextInt();
                int q=sc.nextInt();
                int r=sc.nextInt();
                //System.out.println(p+"   "+q+"   "+r);
                graph[p][q]=r;
            }
            additional_info[0]= sc.nextInt();
            additional_info[1]= sc.nextInt();
            String str= Files.lines(Paths.get(input)).skip(n+4).findFirst().get();
            //System.out.println(str);
            String[] s= str.split(",");
            //int[] yellow=new int[s.length];
            for(int i=0; i<s.length; i++){
                int x= Integer.parseInt(s[i]);
                //System.out.println(graph.length);
                for(int j=0; j<graph.length; j++){
                    //System.out.println(j+"    "+x);
                    //System.out.println(x+"    "+j);
                    graph[j][x]=10000;
                    graph[x][j]=10000;
                }
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
