import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Dhaka{
    public static void main(String[]args){
        Path g= new Path("Input\\dhaka.txt");
        int[][] graph=g.getGraph();
        int[] additional_info=g.getAdditional_info();
        int[] distance=new int[graph.length];
        Arrays.fill(distance, 10000);
        String str;
        String[] s = new String[0];
        try{
            File f=new File("Input\\Mapping.txt");
            Scanner sc=new Scanner(f);
            str= sc.nextLine();
            s=str.split(",");
        }catch(Exception e){
            System.out.println("Mapping file not found!");
        }
        Dijkstra d= new Dijkstra(graph, additional_info[0], distance);
        d.search();
        int[] previous=d.getPrevious();
        str="";
        //for(int i: previous) System.out.println(i);
        //for(String st:s) System.out.println(st);
        for(int i=additional_info[1]; i!=previous[i]; i=previous[i]){
            //System.out.println(i);
            str=str+s[i]+",";
        }
        String[] st=str.split(",");
        str="";
        for(int i=st.length-1; i>=0; i--){
           str=str+st[i];
           if(i!=0) str=str+"->";
        }
        System.out.println(str);
        System.out.println("Path cost: "+distance[additional_info[1]]);
        //for(int[] g: graph) System.out.println(Arrays.toString(g));
        //System.out.println(Arrays.toString(distance));
    }
}