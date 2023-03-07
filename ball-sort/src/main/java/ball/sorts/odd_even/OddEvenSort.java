package ball.sorts.odd_even;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * OddEvenSort algorithm
 *
 * @author Denis Solovey
 * @version 1.0
 */
public class OddEvenSort<T> {

    private final Comparator<T> comparator;

    public OddEvenSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * @param objects objects we are sorting
     * @method oddEvenSort() sort function
     */
    public void oddEvenSort(List<T> objects) {

        boolean flag = false;
        int n = objects.size();

        while (!flag) {

            flag = true;

            for (int i = 1; i < n - 1; i += 2) {
                if (comparator.compare(objects.get(i), objects.get(i + 1)) > 0) {
                    Collections.swap(objects, i, i + 1);
                    flag = false;
                }
            }

            for (int i = 0; i < n - 1; i += 2) {
                if (comparator.compare(objects.get(i), objects.get(i + 1)) > 0) {
                    Collections.swap(objects, i, i + 1);
                    flag = false;
                }
            }
        }
    }
}
