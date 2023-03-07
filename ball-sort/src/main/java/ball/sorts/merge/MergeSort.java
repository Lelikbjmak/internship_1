package ball.sorts.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * MergeSort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class MergeSort<T> {

    private final Comparator<T> comparator;

    public MergeSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @param objects Initial List with objects
     * @method mergeSort() Divide initial List with balls recursively into several subLists to sort them separately
     */
    public void mergeSort(List<T> objects) {

        List<T> leftSubList = new ArrayList<>();
        List<T> rightSubList = new ArrayList<>();

        int mid;

        if (objects.size() != 1) {
            mid = objects.size() / 2;

            for (int i = 0; i < mid; i++) {
                leftSubList.add(objects.get(i));
            }

            for (int i = mid; i < objects.size(); i++) {
                rightSubList.add(objects.get(i));
            }

            mergeSort(leftSubList);
            mergeSort(rightSubList);
            merge(leftSubList, rightSubList, objects);
        }
    }

    /**
     * @param leftList  Left SubList with balls
     * @param rightList Right SubList with balls
     * @param initial   Initial List with balls
     * @method merge() Merge 2 lists into one
     */
    private void merge(List<T> leftList, List<T> rightList, List<T> initial) {

        int left = 0;
        int right = 0;

        int res = 0;

        while (left < leftList.size() && right < rightList.size()) {

            if (comparator.compare(leftList.get(left), rightList.get(right)) < 0) {
                initial.set(res, leftList.get(left));
                left++;
            } else {
                initial.set(res, rightList.get(right));
                right++;
            }
            res++;
        }

        while (left < leftList.size()) {
            initial.set(res, leftList.get(left));
            res++;
            left++;
        }
        while (right < rightList.size()) {
            initial.set(res, rightList.get(right));
            res++;
            right++;
        }
    }

}
