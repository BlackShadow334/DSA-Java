package non_linear_data_structure;

public class Main {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("D", "A");

//        graph.traverseDepthFirst("A");
//        graph.traverseBreadthFirst("K");
        System.out.println(graph.topologicalSort());
        System.out.println(graph.hasCycle());
//        graph.print();
    }
}
