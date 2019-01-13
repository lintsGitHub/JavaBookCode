package 高效并发_线程安全;

import java.util.Vector;

public class VectorDome {
    public static void main(String[] args) {
        /*
        * 学习JDK中Vector类
        * 这是一个集合类，继承AbstractList类
        * 但是这个类中暴露在外的方法都加上了synchronized关键字
        * 可以在一定程度上可以说是线程安全的
        * 写一个例子来学习Vector，测试Vector是否是线程安全的
        * */
        LeanVector();
    }

    public static void LeanVector(){
        /*
        * 通过看API我们可以知道，这个类是一个线程安全的集合类
        * 它的构造函数有四个：
        * Vector()
        * 构造一个空向量，使其内部数据数组的大小为 10 ，标准容量增量为零。
        * Vector(Collection<? extends E> c)
        * 构造一个包含指定集合元素的向量，按照集合的迭代器返回的顺序。
        * Vector(int initialCapacity)
        * 构造具有指定初始容量并且其容量增量等于零的空向量。
        * Vector(int initialCapacity, int capacityIncrement)
        * 构造具有指定的初始容量和容量增量的空向量。
        * */
//        Vector vector = new Vector();
//        Vector vector1 = new Vector(6);
//        Vector vector2 = new Vector(1, 3);
//        Vector vector3 = new Vector(vector);

        /*
        * API中也描述了它的一些方法：
        * boolean add(E e)
        * 将指定的元素追加到此Vector的末尾。
        * void add(int index, E element)
        * 在此Vector中的指定位置插入指定的元素。
        * boolean addAll(Collection<? extends E> c)
        * 将指定集合中的所有元素追加到该向量的末尾，按照它们由指定集合的迭代器返回的顺序。
        * boolean addAll(int index, Collection<? extends E> c)
        * 将指定集合中的所有元素插入到此向量中的指定位置。
        * void addElement(E obj)
        * 将指定的组件添加到此向量的末尾，将其大小增加1。
        * int capacity()
        * 返回此向量的当前容量。
        * void clear()
        * 从此Vector中删除所有元素。
        * Object clone()
        * 返回此向量的克隆。
        * boolean contains(Object o)
        * 如果此向量包含指定的元素，则返回 true 。
        * boolean containsAll(Collection<?> c)
        * 如果此向量包含指定集合中的所有元素，则返回true。
        * void copyInto(Object[] anArray)
        * 将此向量的组件复制到指定的数组中。
        * E elementAt(int index)
        * 返回指定索引处的组件。
        * Enumeration<E> elements()
        * 返回此向量的组件的枚举。
        * void ensureCapacity(int minCapacity)
        * 如果需要，增加此向量的容量，以确保它可以至少保存最小容量参数指定的组件数。
        * boolean equals(Object o)
        * 将指定的对象与此向量进行比较以获得相等性。
        * E firstElement()
        * 返回此向量的第一个组件（索引号为 0的项目）。
        * void forEach(Consumer<? super E> action)
        * 对 Iterable的每个元素执行给定的操作，直到所有元素都被处理或动作引发异常。
        * E get(int index)
        * 返回此向量中指定位置的元素。
        * int hashCode()
        * 返回此Vector的哈希码值。
        * int indexOf(Object o)
        * 返回此向量中指定元素的第一次出现的索引，如果此向量不包含元素，则返回-1。
        * int indexOf(Object o, int index)
        * 返回此向量中指定元素的第一次出现的索引，从 index向前 index ，如果未找到该元素，则返回-1。
        * void insertElementAt(E obj, int index)
        * 在指定的index插入指定对象作为该向量中的一个 index 。
        * boolean isEmpty()
        * 测试此矢量是否没有组件。
        * Iterator<E> iterator()
        * 以正确的顺序返回该列表中的元素的迭代器。
        * E lastElement()
        * 返回向量的最后一个组件。
        * int lastIndexOf(Object o)
        * 返回此向量中指定元素的最后一次出现的索引，如果此向量不包含元素，则返回-1。
        * int lastIndexOf(Object o, int index)
        * 返回此向量中指定元素的最后一次出现的索引，从 index ，如果未找到元素，则返回-1。
        * ListIterator<E> listIterator()
        * 返回列表中的列表迭代器（按适当的顺序）。
        * ListIterator<E> listIterator(int index)
        * 从列表中的指定位置开始，返回列表中的元素（按正确顺序）的列表迭代器。
        * E remove(int index)
        * 删除此向量中指定位置的元素。
        * boolean remove(Object o)
        * 删除此向量中指定元素的第一个出现如果Vector不包含元素，则它不会更改。
        * boolean removeAll(Collection<?> c)
        * 从此Vector中删除指定集合中包含的所有元素。
        * void removeAllElements()
        * 从该向量中删除所有组件，并将其大小设置为零。
        * boolean removeElement(Object obj)
        * 从此向量中删除参数的第一个（最低索引）出现次数。
        * void removeElementAt(int index)
        * 删除指定索引处的组件。
        * boolean removeIf(Predicate<? super E> filter)
        * 删除满足给定谓词的此集合的所有元素。
        * protected void removeRange(int fromIndex, int toIndex)
        * 从此列表中删除所有索引为 fromIndex （含）和 toIndex之间的元素。
        * void replaceAll(UnaryOperator<E> operator)
        * 将该列表的每个元素替换为将该运算符应用于该元素的结果。
        * boolean retainAll(Collection<?> c)
        * 仅保留此向量中包含在指定集合中的元素。
        * E set(int index, E element)
        * 用指定的元素替换此Vector中指定位置的元素。
        * void setElementAt(E obj, int index)
        * 设置在指定的组件 index此向量的要指定的对象。
        * void setSize(int newSize)
        * 设置此向量的大小。
        * int size()
        * 返回此向量中的组件数。
        * void sort(Comparator<? super E> c)
        * 使用提供的 Comparator对此列表进行排序以比较元素。
        * Spliterator<E> spliterator()
        * 在此列表中的元素上创建late-binding和故障切换 Spliterator 。
        * List<E> subList(int fromIndex, int toIndex)
        * 返回此列表之间的fromIndex（包括）和toIndex之间的独占视图。
        * Object[] toArray()
        * 以正确的顺序返回一个包含此Vector中所有元素的数组。
        * <T> T[] toArray(T[] a)
        * 以正确的顺序返回一个包含此Vector中所有元素的数组; 返回的数组的运行时类型是指定数组的运行时类型。
        * String toString()
        * 返回此Vector的字符串表示形式，其中包含每个元素的String表示形式。
        * void trimToSize()
        * 修改该向量的容量成为向量的当前大小。
        * ================================
        * 我就简单的进行使用
        * */
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        System.out.println(vector.size());
        System.out.println(vector.elementAt(2));
        System.out.println(vector.firstElement());
        System.out.println(vector.get(2));
        vector.clear();
        System.out.println(vector.isEmpty());
    }
}
