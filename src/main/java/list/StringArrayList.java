package list;

public class StringArrayList {
    int last;
    String[] array;

    public StringArrayList(int capacity) {
        array = new String[capacity]; //- tworzenie tablicy
        last = -1;
    }


    public boolean isEmpty() {
       /*
        if(last == -1) {
      return true;

        } else {
            return false;
        }
        */

        return last == -1;

    }

    public boolean isFull() {

        return last == array.length - 1;
    }

    public boolean add(String item) {
        if (isFull()) {
            return false;
        } else {
        /*
        ++last -> last =last+1 a potem pobierz last

            last = last+1;
            array[last]=item;
        */
            array[++last] = item;
            return true;
        }
    }
    public boolean add(String item, int index) {
        if (isFull()) {
            return false;
        }
        if (index < 0 || index > last + 1) {
            return false;
        }
        shiftRight(index);
        array[index] = item;
        last++;
        return true;
    }
//TODO uzupełnić metodę remove aby działały testy

    public boolean remove(int index){

        if (isEmpty()){
            return false;
        }
        if (index < 0 || index > last) { //weryfikuje poprawność indeksu
            return false;
        }
        shiftLeft(index);
        //array[index] = item;
        last--;
        return true;
    }

    void shiftLeft(int index) {
        for (int i = index; i <= last-1; i++) {
            array[i] = array[i+1];
        }
    }




    public int size() {
        return last + 1;


    }

    void shiftRight(int index) {
        for (int i = last; i >= index; i--) {
            array[i + 1] = array[i];
        }
    }

    public String get(int index) {
        return array[index];

    }


}
