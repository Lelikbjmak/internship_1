package ball.sorts.binary_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * TreeSort algorithm
 * @param <T> Type of sorted object
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class TreeSort<T> {

    private final Tree<T> tree;

    private final List<T> sortedObjects; //empty List of objects -> fill it after sort a tree

    public TreeSort(Comparator<T> comparator) {
        this.tree = new Tree<>(comparator);
        this.sortedObjects = new ArrayList<>();
    }

    /**
     *
     * @param root Root of Binary Tree to obtain correct sequence of Nodes (left -> right)
     */
    private void order(Node<T> root) {
        if (root != null) {
            order(root.getLeftNode());
            sortedObjects.add(root.getObject());
            order(root.getRightNode());
        }
    }

    public void treeSort(List<T> objects) {
        tree.fillTree(objects);
        objects.clear();
        order(this.tree.getRoot());
        objects.addAll(this.sortedObjects); // replace sorted List with sorted elements
    }
}
