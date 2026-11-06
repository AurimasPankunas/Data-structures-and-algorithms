/*************************************************************************
 *  Compilation:  javac Paths.java
 *  Execution:    java Paths file < input.txt
 *  Dependencies: EuclideanGraph.java Dijkstra.java In.java StdIn.java
 *
 *  Reads in a map from a file, and repeatedly reads in two integers s
 *  and d from standard input, and prints the shortest path from s
 *  to d to standard output.
 *
 ****************************************************************************/

public class Paths {

    public static void main(String[] args) {
        In graphin = new In(args[0]);
        EuclideanGraph G = new EuclideanGraph(graphin);
        System.err.println("Done reading the graph " + args[0]);
        System.err.println("Enter query pairs from stdin");

        // Read in the s-d pairs from standard input
        Dijkstra dijkstra = new Dijkstra(G);
        long startTime = 0;
        int i = 0;
        boolean flag = true;
        while(!StdIn.isEmpty()) {
            if(flag){ startTime = System.nanoTime(); flag = false; }

            int s = StdIn.readInt();
            int d = StdIn.readInt();
            dijkstra.showPath(s, d);
            System.out.println();
            i++;
            if(i == 100) break;
        }
        System.err.println("App's time: " + (System.nanoTime() - startTime) + " nano");
    }
}
