import java.util.LinkedList;
import java.util.List;

public class Resource {
    private int x;
    private int y;
    private LinkedList<Device> requests;
    private double distance;

    Resource(int x, int y){
        this.x = x;
        this.y = y;
        this.requests = new LinkedList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRequests(Device device){
        this.requests.add(device);
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
    
    public int getNumberElements() {
    	return requests.size();
    }
    
    public Device getMaxPriorityDevice() {
    	if (requests.size() > 1) {
    		requests.sort(new CompareByPriority());
    	}
      return requests.getFirst();
    }
    	
    public void updateRequests() {
    	requests.clear();
    }
    
    public boolean isEmpty() {
    	return requests.isEmpty();
    }
}
