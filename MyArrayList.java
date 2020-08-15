package dataStructures;

public class MyArrayList {
    private int[] arr = new int[1];
    private int elementCount = 0;

    public void increaseCapacity() {
        int newCapacity = arr.length * 2;

        int[] newArr = new int[newCapacity];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void add(int data) {
        if (elementCount == arr.length) {
            increaseCapacity();
        }

        arr[elementCount] = data;
        elementCount++;
    }

    public int size() {
        return elementCount;
    }

    public int get(int index) throws Exception {
        if (index < 0 || index >= size()) {
            throw new Exception("Index out of range");
        }

        return arr[index];
    }

    public void set(int data, int index) throws Exception {
        if (index < 0 || index >= size()) {
            throw new Exception("Index out of range");
        }
        arr[index] = data;
    }

    public void remove(int index) throws Exception {
        if (index < 0 || index >= size()) {
            throw new Exception("Index out of range");
        }

        // TODO: very IMP
        for (int i = index; i < size() - 2; i++) {
            arr[i] = arr[i + 1];
        }

        elementCount--;
    }

    public void print() {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // TODO: Driver Code
    // MyArrayList al = new MyArrayList();
    // try {
    // // al.remove(2);
    // al.add(1);
    // al.add(2);
    // al.add(3);
    // al.add(4);
    // al.add(5);
    // al.set(6, 4);
    // al.print();
    // // System.out.println(al.get(4));
    // // al.remove(3);
    // System.out.println(al.size());
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println(e);
    // }
}