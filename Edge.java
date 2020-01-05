import java.util.*;

public class Edge implements Comparable<Edge> {
  int s, d;
  long w;

  public Edge(int s, int d, long w) {
    this.s = s;
    this.d = d;
    this.w = w;
  }

  public int getS() { return s; }
  public int getD() { return d; }
  public long getW() { return w; }

  @Override
  public int compareTo(Edge other) {
    if(this.w > other.getW()) return 1;
    else if(this.w < other.getW()) return -1;
    else return 0;
  }

  public String toString() {
    return s + " " + d + " " + " " + w;
  }
}
