package hw3;

import java.util.*;

public class Problem_5_12 {
    public static void main(String[] args) {
        // Input adjacency matrix for graph G
        int[][] matrix = new int[][] {
                {0, 0, 1, 1},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };

        printSquaredMatrix(convertToGSquaredMatrix(matrix));

        // Input adjacency list for graph G
        LinkedList<Integer>[] list = new LinkedList[] {
                new LinkedList<>(Arrays.asList(0, 2, 3)),
                new LinkedList<>(Arrays.asList(1, 1, 3)),
                new LinkedList<>(Arrays.asList(2, 0, 2)),
                new LinkedList<>(Arrays.asList(3, 0, 1)),
        };

        System.out.println();

        printSquaredList(convertToGSquaredList(list));

    }

    public static void printSquaredMatrix(int[][] squaredMatrix) {
        System.out.println("ADJACENCY MATRIX FOR G-SQUARED:");
        for(int i = 0; i < squaredMatrix.length; i++) {
            for(int j = 0; j < squaredMatrix.length; j++) {
                System.out.print(squaredMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printSquaredList(LinkedList<Integer>[] squaredList) {
        System.out.println("ADJACENCY LIST FOR G-SQUARED:");
        Arrays.stream(squaredList).forEach(System.out::println);
    }

    public static int[][] convertToGSquaredMatrix(int[][] matrix) {
        int[][] squared = new int[matrix.length][matrix[0].length];

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == 1 && r != c) {
                    list.add(c);
                }
            }

            for(int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(i) != list.get(j)) {
                        squared[list.get(i)][list.get(j)] = 1;
                    }
                }
            }

            list.clear();
        }

        return squared;
    }

    public static LinkedList<Integer>[] convertToGSquaredList(LinkedList<Integer>[] adjacencyList) {
        LinkedList<Integer>[] squared = new LinkedList[adjacencyList.length];

        // Initialize the squared adj-list with each vertex of the original adj-list.
        int index = 0;
        for(LinkedList<Integer> linkedList: adjacencyList) {
            if(linkedList != null) {
                LinkedList<Integer> init = new LinkedList<>();
                init.add(linkedList.getFirst());

                squared[index++] = init;
            }
        }

        List<Integer> adjNodes = new ArrayList<>();
        for(LinkedList<Integer> linkedList: adjacencyList) {
            // Avoids adding (a, a) if two edges are like this: (a, b) and (b, a)
            boolean notSquared = linkedList.getFirst() == linkedList.get(1) || linkedList.getFirst() == linkedList.getLast();

            if(linkedList.size() == 3 && notSquared) {
                continue;
            } else {
                if(linkedList.size() > 1) {
                    for(int node : linkedList) {
                        if(linkedList.getFirst() != node) {
                            adjNodes.add(node);
                        }
                    }
                }
                for(int i = 0; i < adjNodes.size(); i++) {
                    for(int j = 0; j < adjNodes.size(); j++) {
                        if (adjNodes.get(j) != squared[adjNodes.get(i)].getFirst()) {
                            squared[adjNodes.get(i)].add(adjNodes.get(j));
                        }
                    }
                }
                adjNodes.clear();
            }

        }
        return squared;
    }
}
