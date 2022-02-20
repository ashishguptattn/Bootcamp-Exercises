import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//1) Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.
public class Q1 {
    public static void main(String[] as)
    {
        float sum=0;

        List<Float> list=new ArrayList<Float>();
        list.add(2.5f);
        list.add(3.5f);
        list.add(4.5f);
        list.add(5.5f);
        list.add(6.5f);
        Iterator<Float> it= list.iterator();
        while(it.hasNext())
        {
            sum+=it.next();
        }
        System.out.println("Sum: "+sum);

    }
}
