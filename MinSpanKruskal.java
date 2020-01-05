import java.util.*;
import java.io.*;

// implementation for finding the weight of the minimum spanning tree using Kruskals algorithm
public class MinSpanKruskal {
  public static void main(String[] args) {
    int E = Integer.parseInt(args[0]);
    String path = args[1];

    // minPQ for getting min weight edge
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    int V = 0;

    try {
      // created fastread class for reading in graph input, might come in handy later
      FastRead f = new FastRead(path);

      while(!f.reachedEnd()) {
        int s = f.nextInt();
        int d = f.nextInt();
        int w = f.nextInt();

        pq.add(new Edge(s, d, w));
        // since vertices are sequentially numbered, the largest value + 1 is the
        // number of vertices in the graph
        if(s > V || d > V) V = s > V ? s : d;
        f.advanceToNextLine();
      }

      UF uf = new UF(V+1);
      long weight = 0;

      while(!pq.isEmpty()) {
        Edge e = pq.poll();
        int s = e.getS();
        int d = e.getD();

        // s-d does not create a cycle, merge s and d components, add to weight
        if (!uf.connected(s, d)) {
          uf.union(s, d);
          weight += e.getW();
          if(uf.spanning()) break;
        }
      }

      System.out.println(weight);
    } catch(FileNotFoundException e) {
      System.out.println("File not found");
    } catch(IOException e) {
      System.out.println("Exception from reader");
    }
  }
}
