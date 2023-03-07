package ball.sorts.binary_tree;

/**
 * @param <T> - generic for provided Object in Node of Binary Tree
 */
public class Node<T> {

    private final T object;

    private Node<T> leftNode;

    private Node<T> rightNode;

    public Node(T object) {
        this.object = object;
        leftNode = null;
        rightNode = null;
    }

    public T getObject() {
        return object;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }
}
