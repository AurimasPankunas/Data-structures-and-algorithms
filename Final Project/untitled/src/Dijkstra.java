/*************************************************************************
 *  Dijkstra's algorithm.
 *
 *************************************************************************/

import java.awt.Color;
import java.util.*;


public class Dijkstra {
    private static double INFINITY = Double.MAX_VALUE;
    private static double EPSILON  = 0.000001;

    private EuclideanGraph G;
    private double[] dist;
    private int[] pred;


    public Dijkstra(EuclideanGraph G) {
        this.G = G;
    }

    // return shortest path distance from s to d
    public double distance(int s, int d) {
        dijkstra(s, d);
        return dist[d];
    }

    // print shortest path from s to d  (interchange s and d to print in right order)
    public void showPath(int d, int s) {
        dijkstra(s, d);
        if (pred[d] == -1) {
            System.out.println(d + " is unreachable from " + s);
            return;
        }
        for (int v = d; v != s; v = pred[v])
            System.out.print(v + "-");
        System.out.println(s);
    }

    // plot shortest path from s to d
    public void drawPath(int s, int d) {
        dijkstra(s, d);
        if (pred[d] == -1) return;
        Turtle.setColor(Color.red);
        for (int v = d; v != s; v = pred[v])
            G.point(v).drawTo(G.point(pred[v]));
        Turtle.render();
    }

    private void dijkstra(int s, int d) {
        int V = G.V();
        dist = new double[V];
        pred = new int[V];
        double[] heuristic = new double[V];
        IndexPQ pq = new IndexPQ(V);

        for (int v = 0; v < V; v++) {
            dist[v] = INFINITY;
            pred[v] = -1;
            heuristic[v] = G.distance(v, d);
            pq.insert(v, dist[v] + heuristic[v]);
        }

        dist[s] = 0.0;
        pred[s] = s;
        pq.change(s, dist[s] + heuristic[s]);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            if (v == d) break;

            IntIterator i = G.neighbors(v);
            while (i.hasNext()) {
                int w = i.next();
                double newDist = dist[v] + G.distance(v, w);
                if (newDist < dist[w] - EPSILON) {
                    dist[w] = newDist;
                    pq.change(w, dist[w] + heuristic[w]);
                    pred[w] = v;
                }
            }
        }
    }
}