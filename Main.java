import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Node {
        private String name;
        private ArrayList<Node> nodeList = new ArrayList<>();

        public Node() {
        }

        public void addNode(Queue queue) {
            if (queue.size() == 0) return;

            String queue_name = (String)queue.poll();

            for (Node node:nodeList) {
                if (node.name.equals(queue_name)) {
                    node.addNode(queue);
                    return;
                }
            }
            // not being
            Node new_node = new Node();
            new_node.name = queue_name;
            nodeList.add(new_node);
            new_node.addNode(queue);
        }

        public Node get(String name) {
            for(Node n:nodeList) {
                if(n.name.equals(name))
                    return n;
            }
            return null;
        }
    }

    public static void main(String[] args) {

        System.out.println("Hello World!" + "");

        ArrayList<String[]> data = new ArrayList<>();
        data.add(new String[]{"A1", "B1", "C1"});
        data.add(new String[]{"A2", "B1", "C1"});
        data.add(new String[]{"A2", "B1", "C2"});
        data.add(new String[]{"A3", "B1", "C1"});
        data.add(new String[]{"A3", "B1", "C1"});
        data.add(new String[]{"A3", "B2", "C1"});
        data.add(new String[]{"A4", "B1", "C1"});
        data.add(new String[]{"A4", "B2", "C1"});
        data.add(new String[]{"A4", "B3", "C1"});

        Node root = new Node();
        for (int i=0;i<data.size();i++) {
            Queue<String> queue = new LinkedList<>();
            queue.add(data.get(i)[0]);
            queue.add(data.get(i)[1]);
            queue.add(data.get(i)[2]);

            root.addNode(queue);
        }

        // result all
        for (Node node1:root.nodeList) {
            for(Node node2:node1.nodeList) {
                for(Node node3:node2.nodeList) {
                    System.out.println(node1.name + " " + node2.name + " " + node3.name);
                }
            }
        }

        // result A2->B1->??
        for(Node node:root.get("A2").get("B1").nodeList) {
            System.out.println(node.name);
        }

    }
}

