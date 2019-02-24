package com.bing.lib;

/**
 * 二次封装数组，自制一个数组
 */
public class Array<E> {
    private E[] data;
    private int size;//数组中一共有多少个有效元素

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity 数组的容量
     */
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];  //new一个泛型需要先new出Object然后类型转化为泛型
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    //向所有元素前添加一个新元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败,需要index < 0 || index > size");
        }
        if (size == data.length) {
           resize(data.length * 2);
        }
        //index之后的元素从最后开始一次往后移动，让出第index的位置来
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }



    //获取index索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("查询失败,需要index < 0 || index > size");
        }
        return data[index];
    }

    //修改index索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("设置失败,需要index < 0 || index > size");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找数组元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //数组中删除第一个的元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //数组中删除最后一个的元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }
    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    //数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败,需要index < 0 || index > size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] =null;
        if(size == data.length / 4 && data.length /2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
         }
         data = newData;
    }
}
