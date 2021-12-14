package linear_data_structure;

public class UserArray {
    private int length;
    private int count = 0;
    private int[] array;

    UserArray(int length){
        this.length = length;
        array = new int[length];
    }

    public void insert(int item){
        if (count < length){
            array[count] = item;
            count++;
        }
        else{
            length = length + 2 * length/2;
            int[] temp_arr = new int[length];
            if (count >= 0) System.arraycopy(array, 0, temp_arr, 0, count);
            array = temp_arr;
            array[count++] = item;
        }
    }

    public void removeAt(int index){
        if (index >= count || index < 0){
            // System.out.println("Index out of Range.");
            throw new IllegalArgumentException();
        }
        else if (index == count - 1) count--;
        else{
            for (int i = index; i < count; i++){
                array[i] = array[i + 1];
                System.out.println(array[i]);
            }
            count--;
        }
    }

    public int indexOf(int item){
        for (int i = 0; i < count; i++)
            if (array[i] == item) return  i;
        return -1;
    }

    public void printArray(){
        System.out.print("[ ");
        for (int i = 0; i < count; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.print("]");
    }

}
