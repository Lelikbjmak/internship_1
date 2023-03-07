package ball.sorts.binary_tree;

import java.util.Comparator;
import java.util.List;

/**
 * Tree of Nodes for {@link TreeSort}
 * @param <T> - generic for Object in Node
 */
public class Tree<T> {

    private Node<T> root;

    private final Comparator<T> comparator;

    public Tree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    /**
     * @method fillTree Fill tree with initial data
     * @param objects Initial data
     */
    public void fillTree(List<T> objects) {
        for (T object : objects) {
            insert(object);
        }
    }

    /**
     *
     * @param object Inserted object in Node
     */
    private void insert(T object) {
        this.root = insertNode(root, object);
    }

    /**
     *
     * @param root Root of our Tree
     * @param object Object we put into Node
     * @return Inserted node
     */
    private Node<T> insertNode(Node<T> root, T object) {

        if (root == null) {
            root = new Node<>(object);
            return root;
        }

        if (comparator.compare(object, root.getObject()) < 1) {
            root.setLeftNode(insertNode(root.getLeftNode(), object));
        } else if (comparator.compare(object, root.getObject()) > -1)
            root.setRightNode(insertNode(root.getRightNode(), object));

        return root;
    }

    public Node<T> getRoot() {
        return root;
    }
}
