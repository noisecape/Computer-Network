import java.util.Comparator;
import java.lang.Math;


public class CompareByDistance implements Comparator<Resource> {

    public int compare(Resource a, Resource b) {
        return (int) (a.getDistance()-b.getDistance());
    }
}
