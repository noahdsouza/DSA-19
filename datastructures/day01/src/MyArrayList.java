public class MyArrayList {
    private Cow[] elems;
    private int size;
//  size is the amount of cows

    // TODO: Runtime: O(1)
    public MyArrayList() {
        // TODO
        elems = new Cow[10];
        size = 0;
    }

    // TODO: Runtime: O(n)
    public MyArrayList(int capacity) {
//      capacity is the actual size of the array
        // TODO
        elems = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(1)*
    public void add(Cow c) {
        // TODO
        if (elems.length==size){
            Cow[] elems_copy = new Cow[(elems.length)*2];
            System.arraycopy(elems,0,elems_copy,0,size);
            elems = elems_copy;
        }

        elems[size] = c;
        size = size+1;
    }

    // TODO: Runtime: O(1)
    public int size() {
        // TODO
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        // TODO
        if (elems[index] != null) {
            return elems[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // TODO: Runtime: O(n)
    public Cow remove(int index) {
        // TODO
        if (elems.length > size*4) {
            Cow[] elems_copy = new Cow[(elems.length)/2];
            System.arraycopy(elems,0,elems_copy,0,size);
            elems = elems_copy;
        }

        Cow removed = elems[index];
        for (int i = index; i < elems.length-1; i=i+1) {
            elems[i] = elems[i+1];
        }
        size = size-1;
        return removed;
    }

    // TODO: Runtime: O(n)
    public void add(int index, Cow c) {
        // TODO
        if (index==size){
            Cow[] elems_copy = new Cow[(elems.length)*2];
            System.arraycopy(elems,0,elems_copy,0,size);
            elems = elems_copy;
        }

        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = index; i < elems.length-1; i=i+1) {
                elems[i+1] = elems[i];
            }
            elems[index] = c;
            size = size+1;
        }
    }
}