package src;

public class Node {

    public String data;  //data at each node
    public Node left, right;

    public Node(String word) { //construct node
        data = word;
        left = right = null;
    }

}


