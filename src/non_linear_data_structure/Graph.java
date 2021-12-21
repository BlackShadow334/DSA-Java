package non_linear_data_structure;

import java.util.*;

public class Graph {
    private static class Node {
        private final String label;
        public Node(String label) {
            this.label = label;
        }
        @Override
        public String toString(){
            return label;
        }
    }
    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacency_list = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacency_list.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node from_node = nodes.get(from);
        Node to_node = nodes.get(to);
        if (from_node == null || to_node == null)
            throw new IllegalStateException();

        adjacency_list.get(from_node).add(to_node);

    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) return;

        for (var n : adjacency_list.keySet())
            adjacency_list.get(n).remove(node);

        adjacency_list.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node from_node = nodes.get(from);
        Node to_node = nodes.get(to);
        if (from_node == null || to_node == null)
            return;

        adjacency_list.get(from_node).remove(to_node);
    }

    public void traverseDepthFirst(String label){
        Node node = nodes.get(label);
        if (node == null)
            return;
        HashSet<Node> visited = new HashSet<>();

        traverseDepthFirstRecurse(node, visited);
//        traverseDepthFirstIterate(node, visited);
//        System.out.println(visited);
    }

    private void traverseDepthFirstRecurse(Node node, HashSet<Node> visited){
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.println(node);

        for (Node n : adjacency_list.get(node)){
            traverseDepthFirstRecurse(n, visited);
        }
    }

    private void traverseDepthFirstIterate(Node node, HashSet<Node> visited){
        Stack<Node> call_stack = new Stack<>();
        call_stack.push(node);

        while (!call_stack.isEmpty()){
            Node current = call_stack.pop();
            if (visited.contains(current))
                continue;

            visited.add(current);
            System.out.println(current);
            for (Node neighbour: adjacency_list.get(current))
                call_stack.push(neighbour);
        }
    }

    public void traverseBreadthFirst(String label){
        Node node = nodes.get(label);
        if (node == null)
            return;
        HashSet<Node> visited = new HashSet<>();
        traverseBreadthFirst(node, visited);
    }

    private void traverseBreadthFirst(Node node, HashSet<Node> visited){
        Queue<Node> call_queue = new ArrayDeque<>();
        call_queue.add(node);

        while (!call_queue.isEmpty()){
            Node current = call_queue.remove();
            if (visited.contains(current))
                continue;
            visited.add(current);
            System.out.println(current);

            for (Node neighbour: adjacency_list.get(current))
                call_queue.add(neighbour);
        }
    }

    public List<String> topologicalSort(){
        HashSet<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (Node node: nodes.values())
            topologicalSort(node, stack, visited);

        List<String> sorted_result = new ArrayList<>();
        while(!stack.isEmpty())
            sorted_result.add(stack.pop().label) ;

        return sorted_result;
    }

    private void topologicalSort(Node node, Stack<Node> stack, HashSet<Node> visited){
        if (visited.contains(node))
            return;
        visited.add(node);

        for (Node n : adjacency_list.get(node))
            topologicalSort(n, stack, visited);
        stack.push(node);
    }

    public boolean hasCycle(){
        Set<Node> all = new HashSet<>(nodes.values());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()){
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        if (visiting.contains(node)){
            return true;
        }

        all.remove(node);
        visiting.add(node);

        for (Node neighbour: adjacency_list.get(node)){
            if (visited.contains(neighbour))
                continue;
            if (hasCycle(neighbour, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }

    public void print() {
        for (Node source : adjacency_list.keySet()){
            var target = adjacency_list.get(source);
            if (!target.isEmpty())
                System.out.println(source + " is connected to " + target);
        }
    }
}
