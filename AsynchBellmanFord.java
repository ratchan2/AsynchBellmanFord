import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Channel{
	int weight;
  	LinkedList<Message> messageQueue = new LinkedList<>();
  	Channel(int w){
  		weight = w;
  	}
}
class Message{
	int dist;
	public int getDist(){
		return dist;
	}
    
}
class Process implements Runnable{
	public static ArrayList<HashMap<Integer,Channel>> channelsMap = new ArrayList<>();

	public void run(){
	}
}
public class AsynchBellmanFord {
	 static int distinguishedNode;
	 static int numProcesses;
	 public static void readFile(String path) throws FileNotFoundException{
		 Scanner s = new Scanner(new File(path));  
         numProcesses = s.nextInt();
         distinguishedNode = s.nextInt();
         for(int i = 0; i < numProcesses ; i++){
        	    Process.channelsMap.add(new HashMap<Integer,Channel>());
         }
         for(int i = 1; i <= numProcesses; i++){
            for(int j = 1; j <= numProcesses; j++){
            	   int w = s.nextInt();
            	   if(w >= 0){
            		    Process.channelsMap.get(j-1).put(i, new Channel(w));
            	   }
            } 	 
         }
         
		 
 	 
	 }
     public static void main(String args[]) throws Exception{
    	    readFile(args[0]); 
    	    System.out.println("read file done");
     }
}
