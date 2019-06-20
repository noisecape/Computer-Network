import java.util.Comparator;

public class CompareByPriority implements Comparator<Device> {

    public int compare(Device a, Device b){
        return a.getPriority()-b.getPriority();
    }
}
