package com.innowise.ball_factory.sorts.binary_tree;

import java.util.Comparator;
import java.util.List;

/**
 * Tree of Nodes for {@link TreeSort}
 *
 * @param <T> - generic for Object in Node
 */
public class Tree<T> {

    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    /**
     * @param objectList Initial data
     * @method fillTree Fill tree with initial data
     */
    public void fillTree(List<T> objectList, Comparator<T> objectComparator) {
        for (T object : objectList) {
            insert(object, objectComparator);
        }
    }

    /**
     * @param object Inserted object in Node
     */
    private void insert(T object, Comparator<T> objectComparator) {
        this.root = insertNode(root, object, objectComparator);
    }

    /**
     * @param root         Root of our Tree
     * @param insertedNode Object we put into Node
     * @return Inserted node
     */
    private Node<T> insertNode(Node<T> root, T insertedNode, Comparator<T> nodeComparator) {

        if (root == null) {
            root = new Node<>(insertedNode);
            return root;
        }

        if (nodeComparator.compare(insertedNode, root.getObject()) < 1) {
            root.setLeftNode(insertNode(root.getLeftNode(), insertedNode, nodeComparator));
        } else if (nodeComparator.compare(insertedNode, root.getObject()) > -1)
            root.setRightNode(insertNode(root.getRightNode(), insertedNode, nodeComparator));

        return root;
    }

    public Node<T> getRoot() {
        return root;
    }
}
