import java.util.LinkedList;
import java.util.List;

public class Device {

    private int x;
    private int y;
    private int priority;
    private List<Resource> chart;
    private int resourcesAssigned;

    Device(int x, int y, int priority){
        this.x = x;
        this.y = y;
        this.priority = priority;
        chart = new LinkedList<Resource>();
        resourcesAssigned = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPriority() {
        return priority;
    }

    public void setChart(List<Resource> resources){
        for(Resource r : resources){
            addElement(r);
        }
    }

    public Resource getElement(int k) {
        return this.chart.get(k);
    }

    public void addElement(Resource resource) {
        chart.add(resource);
        resource.setDistance(Math.sqrt(Math.pow(resource.getX()-this.getX(),2)+ Math.pow(resource.getY()-this.getY(),2)));
        chart.sort(new CompareByDistance());
    }

    public void allocateResource(){
        this.resourcesAssigned++;
    }

    public int getAllocatedResource(){
        return this.resourcesAssigned;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    @Override
    public String toString() {
    	return (" (x: " + this.getX() + " y: " + this.getY() + ") resources assigned:" + this.getAllocatedResource());
    }
}
