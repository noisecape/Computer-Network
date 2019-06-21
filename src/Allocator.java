import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Allocator {

	private List<Device> devices;
	private LinkedList<Resource> resources;
	
	Allocator(List<Device> devices, LinkedList<Resource> resources){
		this.devices = devices;
		this.resources = resources;
	}
	
	public void sortDeviceByPriority() {
		devices.sort(new CompareByPriority());
	}
	
	//crea la classifica di gradimento sui nodi di computazione per ogni dispositivo in base alla distanza
	public void createChartForDevices() {
        for(Device d : devices){
            d.setChart(resources);
        }
	}
	
	public void executeFirstFase(){
        int k = 0;
        List<Device> devicesFirstFase = cloneDevices(devices);
        
        while(!devicesFirstFase.isEmpty()) {
        	 for(Device d: devicesFirstFase){
        	 	Resource resource = d.getElement(k);
        	 	resource.setRequests(d);
             }
        	 for (Resource r: resources) {
        		 if(!r.isEmpty()) {
        			 Device firstElement = r.getMaxPriorityDevice();
        			 firstElement.allocateResource();
        			 r.UpdateRequests();
        			 removeAllocatedDevice(firstElement, devicesFirstFase);
        		 }
        	 }
        	 if(k >= 9) k = 0;
        	 else k++;
        }
	}
	
	public void executeSecondFase() {
		Random random = new Random();
		int i = 0;
        while(!devices.isEmpty()) {
        	Device d = devices.get(random.nextInt(devices.size()));
        	Resource r = resources.get(random.nextInt(resources.size()));
        	r.setRequests(d);
        	d.allocateResource();
        	r.UpdateRequests();
        	removeAllocatedDevice(d, devices);
        	System.out.println("Round-> " + Integer.toString(i++) + d.toString());
        }
	}
	
	
	
	 private LinkedList<Device> cloneDevices(List<Device> devices){
	    	LinkedList<Device> devicesFirstFase = new LinkedList<>(devices);
	        return devicesFirstFase;
	    }
	    
	 private void removeAllocatedDevice(Device device, List<Device> devices ) {
	    	for(Device d: devices) {
	    		if(d.equals(device)) {
	    			devices.remove(d);
	    			break;
	    		}
	    	}
	    }
}
