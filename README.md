### Description

Here we implemented several types of sorts. They are:
* [Quick sort](ball-sort/src/main/java/com/innowise/ball_factory/sorts/quick/QuickSort.java)
* [Merge sort](ball-sort/src/main/java/com/innowise/ball_factory/sorts/merge/MergeSort.java)
* [Binary tree sort](ball-sort/src/main/java/com/innowise/ball_factory/sorts/binarytree/TreeSort.java)
* [Heap sort](ball-sort/src/main/java/com/innowise/ball_factory/sorts/heap/HeapSort.java)
* [Odd even sort](ball-sort/src/main/java/com/innowise/ball_factory/sorts/oddeven/OddEvenSort.java)

To observe how sort algorithms works here:
* [Test for quick sort](test/src/test/java/com/innowise/ball_factory/quick)
* [Test for merge sort](test/src/test/java/com/innowise/ball_factory/merge)
* [Test for binary tree sort](test/src/test/java/com/innowise/ball_factory/tree)
* [Test for heap sort](test/src/test/java/com/innowise/ball_factory/heap)
* [Test for odd even sort](test/src/test/java/com/innowise/ball_factory/oddeven)

Mostly that sorts are useful for our custom [Ball class](ball-sort/src/main/java/com/innowise/ball_factory/entity/Ball.java) but still u can use it wherever you wanna.<br>
Our [Ball class](ball-sort/src/main/java/com/innowise/ball_factory/entity/Ball.java) has such fields: 
* Name
* [Color](ball-sort/src/main/java/com/innowise/ball_factory/entity/ball_const_field_types/Color.java)
* [Type](ball-sort/src/main/java/com/innowise/ball_factory/entity/ball_const_field_types/Type.java)
* Circumference
* Weight

Here we have different kinds of Comparators, to compare balls between each other.<br>
Moreover, u can create comparator chain, to compare by several attributes.<br>
U can compare balls according to Color|Type priority. It signifies that u can sort balls according to your color preferences.<br>
Example:
```java
    //We want to obtain balls with BLACK color, after RED color and PINK color as the last one.
    // All remain balls will be randomly ordered cause all other colors except these 3 make no sens for us.

    Map<Color, Integer> colorPriorityMap = Map.of(
        Color.BLACK, 1,
        Color.RED, 2,
        Color.PINK, 3
    ); // PriorityMap with colors we prefer -> leverage it when we call sort.
        
    // Evoke sort
    SortingService<Ball> service = new SortingService<>();
    service.sort(new TreeSort<>(), BALLS,
    new BallComparatorBuilder().colorPriorityComparator(colorPriorityMap));
    // Here we obtain colorPriorityComparator, according to our colorPriorityMap.
```

The same situation with typePriorityMap.

Among other things u can observe default implementation of some common comparators.
```java
    public BallComparator colorPriorityComparator(boolean toLightColor) {
        return new BallColorPriorityComparator(new ColorPriorityBuilder(), toLightColor);
    } // Color comparator sort balls from DARK to LIGHT color

    public BallComparator nameComparator() {
        return new BallNameComparator();
    } // Sort balls by NAME `ASC`

    public BallComparator weightComparator() {
        return new BallWeightComparator();
    } // Sort balls by Weight `ASC`
```

If u want to change order from ASC -> DESC u should invoke native `.reversed()` method in  Comparator.
Example:
```java
    SortingService<Ball> service = new SortingService<>();
    SortingService<Ball> service = new SortingService<>();
        service.sort(new QuickSort<>(), BALLS, new BallComparatorBuilder().nameComparator().reversed());
        // Here we invoke .reversed() and our balls will be sorted by DEFAULT implementation of NAME comparator DESC
```
