/*************************************************************************
 *  Compilation:  javac ShortestPath.java
 *  Execution:    java ShortestPath file < input.txt
 *  Dependencies: EuclideanGraph.java Dijkstra.java In.java StdIn.java Turtle.java
 *
 *  Reads in a map from a file, and two integers s and d from standard input,
 *  and plots the shortest path from s to d using turtle graphics.
 *
 *  % java ShortestPath usa.txt < usa-10.txt
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShortestPath {

    public static void main(String[] args) {
        // Check if the main graph file path is provided
        if (args.length < 1) {
            System.err.println("Usage: java ShortestPath <graph file> < <input file>");
            return;
        }

        String graphFilePath = args[0];

        try {
            Turtle.create(1000, 700);

            // Read in the graph from the file
            In graphin = new In(graphFilePath);
            EuclideanGraph G = new EuclideanGraph(graphin);
            System.err.println("Done reading the graph " + graphFilePath);
            G.draw();

            Dijkstra dijkstra = new Dijkstra(G);

            // Read and process each input pair from the input file
            String inputFilePath = "data/usa-100short.txt";
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            System.err.println("Done reading the input file" + inputFilePath);
            String line;
            double average = 0;
            long wholetime = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int s = Integer.parseInt(parts[0]);
                int d = Integer.parseInt(parts[1]);

                // Measure execution time
                long startTime = System.nanoTime();
                dijkstra.showPath(s, d); // Find and print the shortest path
                long endTime = System.nanoTime();

                // Print execution time
                double elapsedTime = (endTime - startTime) / 1_000_000.0; // Convert to ms
                wholetime += elapsedTime;
                System.out.println("Source: " + s + ", Destination: " + d + " - Time taken: " + elapsedTime + " ms");
                average += elapsedTime;
                // Draw the shortest path
                dijkstra.drawPath(s, d);
                Turtle.render();
            }
            br.close();
            System.out.println("Average time taken: " + average / 100 + " ms");
            System.out.println("Whole time taken: " + wholetime + " ms");
        } catch (IOException e) {
            System.err.println("Error reading the input file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error processing the graph or input file.");
            e.printStackTrace();
        }
    }
}
