import java.util.LinkedList;
import java.util.List;

public class Resource {
    private int x;
    private int y;
    private LinkedList<Device> requests;
    private double distance;
    private int c;

    Resource(int x, int y){
        this.x = x;
        this.y = y;
        this.requests = new LinkedList<>();
        this.c = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRequests(Device device){
        if(device.getAllocatedResource() == 0){
            this.requests.add(device);
            c++;
        }
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}
