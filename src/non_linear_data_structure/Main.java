package non_linear_data_structure;

public class Main {
    public static void main(String[] args){
        WeightedGraph w_graph = new WeightedGraph();
        w_graph.addNode("A");
        w_graph.addNode("B");
        w_graph.addNode("C");
//        w_graph.addNode("D");
//        w_graph.addNode("E");

        w_graph.addEdge("A", "B", 3);
        w_graph.addEdge("A", "C", 4);
//        w_graph.addEdge("B", "C", 4);

//        w_graph.addEdge("A", "D", 2);
//        w_graph.addEdge("D", "C", 1);
//        w_graph.addEdge("D", "B", 6);
//        w_graph.addEdge("D", "E", 5);
//        w_graph.addEdge("B", "E", 1);

//        Path shortest_path = w_graph.getShortestPath("A", "E");
//        System.out.println(shortest_path);
//        w_graph.print();
        System.out.println(w_graph.hasCycle());
    }
}
