package second;

import java.util.ArrayList;
import java.util.List;

public class ArrayAvg {

    public long getArrayAvg(ArrayList<Integer> list){
        if(list.size() == 0){
            return 0;
        }
        long total = 0;
        for( int ll : list){
            total += ll;
        }
        return total/list.size();


    }
    public static void main(String[] args) {
        ArrayAvg arrayAvg = new ArrayAvg();
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(6);
        System.out.println(arrayAvg.getArrayAvg(arrayList));

    }
}
