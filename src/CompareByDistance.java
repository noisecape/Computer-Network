import java.util.Comparator;
import java.lang.Math;


public class CompareByDistance implements Comparator<Resource> {

    public int compare(Resource a, Resource b)
    {

        if(a.getDistance()-b.getDistance() < 0){
            return -1;
        }else{
            return +1;
        }
    }
}
