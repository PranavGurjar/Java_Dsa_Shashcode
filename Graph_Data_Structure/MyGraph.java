package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.List;

public class MyGraph {

    class Pair{
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        //(node, weight)
        @Override
        public String toString() {
            return "("+node+","+weight+")";
        }
    }

    int [][]adjMatrix;

    List<List<Integer>> adjList;

    List<List<Pair>> adjListWithWeight;

    MyGraph(int nodes) {
        this.adjMatrix = new int[nodes][nodes];     //4*4 [0...]
        this.adjList = new ArrayList<>();
        this.adjListWithWeight = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
            adjListWithWeight.add(new ArrayList<>());
        }
    }

    // -> [[0,2][0,1][2,0]]
    public void addEdgesInMatrix(int edges[][], boolean isDirected){
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if (isDirected){
                //directed
                adjMatrix[u][v] = 1;
            }
            else {
                //undirected
                adjMatrix[u][v] = 1;
                adjMatrix[v][u] = 1;
            }
        }
    }

    // -> [[0,2][0,1][2,0]]
    public void addEdgesWithWeightInMatrix(int edges[][], boolean isDirected){
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (isDirected){
                //directed
                adjMatrix[u][v] = w;
            }
            else {
                //undirected
                adjMatrix[u][v] = w;
                adjMatrix[v][u] = w;
            }
        }
    }


    // -> [[0,2][0,1][2,0]]
    public void addEdgesInList(int edges[][], boolean isDirected){
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if (isDirected){
                //directed
                adjList.get(u).add(v);
            }
            else {
                //undirected
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
    }

    // -> [[0,2][0,1][2,0]]
    public void addEdgesWithWeightInList(int edges[][], boolean isDirected){
        for (int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];


            if (isDirected){
                //directed
                Pair pair = new Pair(v, w);
                adjListWithWeight.get(u).add(pair);
            }
            else {
                //undirected
                Pair pair1 = new Pair(v, w);
                adjListWithWeight.get(u).add(pair1);
                Pair pair2 = new Pair(u, w);
                adjListWithWeight.get(v).add(pair2);
            }
        }
    }

    public void findDegreeUndirected(int [][]edges, int nodes){

        int []degree = new int[nodes];
        for (int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }

        //print
        for (int i = 0; i < nodes; i++) {
            System.out.println("nodes -> "+i+" degree -> "+degree[i]);
        }
    }

    public void findDegreeDirected(int [][]edges, int nodes){

        int []inDegree = new int[nodes];
        int []outDegree = new int[nodes];
        for (int []edge : edges){
            int from = edge[0];
            int to = edge[1];
            outDegree[from]++;
            inDegree[to]++;
        }

        //print
        for (int i = 0; i < nodes; i++) {
            System.out.println("nodes -> "+i+" inDegree -> "+inDegree[i]+" outDegree -> "+outDegree[i]);
        }
    }

    public void findDegreeUsingAdjMatrixOfDirectedGraph(int [][]edges, int nodes){
        addEdgesInMatrix(edges, true);
        //for an edge (u,v): edge goes from uth row and vth column
        int []inDegree = new int[nodes];
        int []outDegree = new int[nodes];

        for (int from = 0; from < adjMatrix.length; from++) {
            for (int to = 0; to < adjMatrix[from].length; to++) {
                //if 1, the edge is there "from" -> "to"
                if (adjMatrix[from][to] == 1) {
                    outDegree[from]++;
                    inDegree[to]++;
                }
            }
        }

        //print
        for (int i = 0; i < nodes; i++) {
            System.out.println("nodes -> "+i+" inDegree -> "+inDegree[i]+" outDegree -> "+outDegree[i]);
        }
    }

    public void findDegreeUsingAdjMatrixOfUnDirectedGraph(int [][]edges, int nodes){
        addEdgesInMatrix(edges, false);
        //for an edge (u,v): edge goes from uth row and vth column
        int []degree = new int[nodes];

        for (int from = 0; from < adjMatrix.length; from++) {
            for (int to = 0; to < adjMatrix[from].length; to++) {
                //if 1, the edge is there "from" -> "to"
                if (adjMatrix[from][to] == 1){
                    degree[from]++;
                }
            }
        }

        //print
        for (int i = 0; i < nodes; i++) {
            System.out.println("nodes -> "+i+" degree -> "+degree[i]);
        }
    }


    public void findDegreeUsingAdjListOfDirectedGraph(int [][]edges, int nodes){
        addEdgesInList(edges, true);
        //for an edge (u,v): edge goes from uth row and vth column
        int []inDegree = new int[nodes];
        int []outDegree = new int[nodes];

        for (int from = 0; from < adjList.size(); from++) {
            for (int j = 0; j < adjList.get(from).size(); j++) {
                int to = adjList.get(from).get(j);
                outDegree[from]++;
                inDegree[to]++;
            }
        }

        //print
        for (int i = 0; i < nodes; i++) {
            System.out.println("nodes -> "+i+" inDegree -> "+inDegree[i]+" outDegree -> "+outDegree[i]);
        }
    }

    public void findDegreeUsingAdjListOfUnDirectedGraph(int [][]edges, int nodes){
        // clear old data (important when same graph object is reused)
        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).clear();
        }

        addEdgesInList(edges, false);
        //for an edge (u,v): edge goes from uth row and vth column
        int []degree = new int[nodes];

        for (int from = 0; from < adjList.size(); from++) {
            for(int to : adjList.get(from)) {
                degree[from]++;
            }
        }

        //print
        for (int i = 0; i < nodes; i++) {
            System.out.println("nodes -> "+i+" degree -> "+degree[i]);
        }
    }



    public void printMatrix(){
        for (int i = 0; i < adjMatrix.length; i++) {
            System.out.print("row "+i+"-> ");
            for (int j = 0; j < adjMatrix[0].length; j++) {
                System.out.print(adjMatrix[i][j]+", ");
            }
            System.out.println();
        }
    }

    public void printList(){
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j));
                if (j != adjList.get(i).size()-1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public void printWeightedList(){
        for (int i = 0; i < adjListWithWeight.size(); i++) {
            System.out.print(i + " -> ");
            System.out.print("[");
            for (int j = 0; j < adjListWithWeight.get(i).size(); j++) {
                System.out.print(adjListWithWeight.get(i).get(j));
                if (j != adjListWithWeight.get(i).size()-1){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int [][]edges1 = {{0, 2}, {0, 1}, {1, 3}};
        int [][]edges2 = {{0, 2, 10}, {0, 1, 20}, {1, 3, 30}};
        int nodes = 4;

        MyGraph graph1 = new MyGraph(nodes);
        System.out.println("Undirected Graph : ");
        graph1.addEdgesInMatrix(edges1, false);
        graph1.printMatrix();
        System.out.println("*********************************");

        MyGraph graph2 = new MyGraph(nodes);
        System.out.println("Directed Graph : ");
        graph2.addEdgesInMatrix(edges1, true);
        graph2.printMatrix();
        System.out.println("*********************************");

        MyGraph graph3 = new MyGraph(nodes);
        System.out.println("Weighted Undirected Graph : ");
        graph3.addEdgesWithWeightInMatrix(edges2, false);
        graph3.printMatrix();
        System.out.println("*********************************");

        MyGraph graph4 = new MyGraph(nodes);
        System.out.println("Weighted Directed Graph : ");
        graph4.addEdgesWithWeightInMatrix(edges2, true);
        graph4.printMatrix();
        System.out.println("*********************************");

        MyGraph graph5 = new MyGraph(nodes);
        System.out.println("Undirected Graph List : ");
        graph5.addEdgesInList(edges1, false);
        graph5.printList();
        System.out.println("*********************************");

        MyGraph graph6 = new MyGraph(nodes);
        System.out.println("Directed Graph List : ");
        graph6.addEdgesInList(edges1, true);
        graph6.printList();
        System.out.println("*********************************");

        MyGraph graph7 = new MyGraph(nodes);
        System.out.println("Weighted Undirected Graph List : ");
        graph7.addEdgesWithWeightInList(edges2, false);
        graph7.printWeightedList();
        System.out.println("*********************************");

        MyGraph graph8 = new MyGraph(nodes);
        System.out.println("Weighted Directed Graph List : ");
        graph8.addEdgesWithWeightInList(edges2, true);
        graph8.printWeightedList();
        System.out.println("****************************************************************");

        MyGraph graph = new MyGraph(nodes);
        System.out.println("Undirected Graph : ");
        graph.findDegreeUndirected(edges1, nodes);
        System.out.println("----------------------------------------------------------------");

        System.out.println("Directed Graph : ");
        graph.findDegreeDirected(edges1, nodes);
        System.out.println("****************************************************************");

        System.out.println("AdjMatrix Of Directed Graph : ");
        graph.findDegreeUsingAdjMatrixOfDirectedGraph(edges1, nodes);
        System.out.println("****************************************************************");

        System.out.println("AdjMatrix Of UnDirected Graph : ");
        graph.findDegreeUsingAdjMatrixOfUnDirectedGraph(edges1, nodes);
        System.out.println("****************************************************************");

        System.out.println("AdjList Of Directed Graph : ");
        graph.findDegreeUsingAdjListOfDirectedGraph(edges1, nodes);
        System.out.println("****************************************************************");

        System.out.println("AdjList Of UnDirected Graph : ");
        graph.findDegreeUsingAdjListOfUnDirectedGraph(edges1, nodes);
        System.out.println("****************************************************************");

    }
}
