package com.innowise.ball_factory.sorts.binary_tree;

import com.innowise.ball_factory.sorts.Sortable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * TreeSort algorithm
 *
 * @param <T> Type of sorted object
 * @author Denis Solovey
 * @version 1.0
 */
public class TreeSort<T> implements Sortable<T> {

    private final Tree<T> tree;

    private final List<T> sortedObjects; //empty List of objects -> fill it after sort a tree

    public TreeSort() {
        this.tree = new Tree<>();
        this.sortedObjects = new ArrayList<>();
    }

    /**
     * @param root Root of Binary Tree to obtain correct sequence of Nodes (left -> right)
     */
    private void iterateNodesFromMinToMax(Node<T> root) {
        if (root != null) {
            iterateNodesFromMinToMax(root.getLeftNode());
            sortedObjects.add(root.getObject());
            iterateNodesFromMinToMax(root.getRightNode());
        }
    }

    private List<T> treeSort(List<T> nodeList, Comparator<T> nodeComparator) {
        tree.fillTree(nodeList, nodeComparator);
        nodeList.clear();
        iterateNodesFromMinToMax(tree.getRoot());
        nodeList.addAll(this.sortedObjects); // replace sorted List with sorted elements
        return nodeList;
    }

    @Override
    public List<T> sort(List<T> objectList, Comparator<T> objectComparator) {
        return treeSort(objectList, objectComparator);
    }
}
