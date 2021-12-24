package non_linear_data_structure;

import java.util.*;

// Weighted + un-directed;
public class WeightedGraph {
    private static class Node {
        private final String label;
        private final List<Edge> edges = new ArrayList<>();

        public Node (String label){
            this.label = label;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges (){
            return edges;
        }

        @Override
        public String toString(){
            return label;
        }
    }

    private static class Edge {
        Node from;
        Node to;
        int weight;
        public Edge (Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return from + "-->" + to;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label){
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight){
        Node from_node = nodes.get(from);
        Node to_node = nodes.get(to);
        if (from_node == null || to_node == null)
            throw new IllegalStateException();

        // we are assuming this graph is un-directed, that's why we added edge vice-versa.
        from_node.addEdge(to_node, weight);
        to_node.addEdge(from_node, weight);
    }

    //================================================================
    // Dijkstra's Algorithm for finding shortest distance......

    private static class NodeEntry {
        private final Node node;
        private final int priority;
        public NodeEntry (Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }

    public Path getShortestPath(String from, String to){
        Node from_node = nodes.get(from);
        Node to_node = nodes.get(to);
        if (from_node == null || to_node == null)
            throw new IllegalStateException();

        Map<Node, Node> previous_nodes = new HashMap<>();
        Map<Node, Integer> distances = new HashMap<>();
        for (Node node: nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(from_node, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> p_queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        p_queue.add(new NodeEntry(from_node, 0));

        while (!p_queue.isEmpty()){
            Node current = p_queue.remove().node;
            visited.add(current);

            for(Edge edge: current.getEdges()){
                if (visited.contains(edge.to))
                    continue;
                int new_distance = distances.get(current) + edge.weight;
                if (new_distance < distances.get(edge.to)){
                    distances.replace(edge.to, new_distance);
                    previous_nodes.put(edge.to, current);
                    p_queue.add(new NodeEntry(edge.to, new_distance));
                }
            }
        }

//        for (Node node: distances.keySet()){
//            System.out.println(node + "---" + distances.get(node));
//        }
        return buildPath(to_node, previous_nodes);
    }

    private Path buildPath(Node to_node, Map<Node, Node> previous_nodes){
        Stack<Node> stack = new Stack<>();
        stack.push(to_node);
        Node previous = previous_nodes.get(to_node);
        while (previous != null){
            stack.push(previous);
            previous = previous_nodes.get(previous);
        }

        Path path = new Path();
        while (!stack.isEmpty()){
            path.add(stack.pop().label);
        }
        return path;
    }
    //=============================================================

    public boolean hasCycle(){
        if (nodes.isEmpty()) return false;

        Set<Node> visited = new HashSet<>();
        for (Node node: nodes.values()){
            if (!visited.contains(node) && hasCycle(node, null, visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited){
        visited.add(node);

        for (Edge edge: node.getEdges()){
            Node next_node = edge.to;
            if (next_node == parent)
                continue;
            if (visited.contains(next_node) || hasCycle(next_node, node, visited))
                return true;
        }

        return false;
    }

    // Using Prims Algorithm...
    public WeightedGraph getMinimumSpanningTree(){
        var tree = new WeightedGraph();

        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        var start_node = nodes.values().iterator().next();
        edges.addAll(start_node.getEdges());
        tree.addNode(start_node.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() != nodes.size()){
            var min_edge = edges.remove();
            var next_node = min_edge.to;
            if (tree.containsNode(next_node.label))
                continue;
            tree.addNode(next_node.label);
            tree.addEdge(min_edge.from.label, next_node.label, min_edge.weight);

            for (var edge: next_node.getEdges()){
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
            }
        }

        return tree;
    }

    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }

    public void print(){
        for (Node node: nodes.values()){
            System.out.println(node + " has edges " + node.getEdges());
        }
    }
}













