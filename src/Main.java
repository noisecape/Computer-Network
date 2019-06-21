import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();


        Random random = new Random();
        LinkedList<Resource> resources = m.createResources(random);
        List<Device> devices = m.createDevices(random);
        devices.sort(new CompareByPriority());

        //crea la classifica di gradimento sui nodi di computazione per ogni dispositivo in base alla distanza
        for(Device d : devices){
            d.setChart(resources);
        }

        //ogni dispositivo effettua una richiesta al nodo di computazione che preferisce
        int k = 0;
        List<Device> devicesFirstFase = m.cloneDevices(devices);
        
        while(!devicesFirstFase.isEmpty()) {
        	 for(Device d: devices){
        		 if(d.getAllocatedResource() == 0){
        			 Resource resource = d.getElement(k);
        			 resource.setRequests(d);
        		 }
             }
        	 for (Resource r: resources) {
        		 if(!r.isEmpty()) {
        			 Device firstElement = r.getMaxPriorityDevice();
        			 firstElement.allocateResource();
        			 r.UpdateRequests();
        			 m.removeAllocatedDevice(firstElement, devicesFirstFase);
        		 }
        	 }
        	 if(k > 9) k = 0;
        	 else k++;
        }

        //Fase2
        List<Device> devicesNotAllocated = m.cloneDevices(devices);
        while(!devicesNotAllocated.isEmpty()) {
        	Device d = devicesNotAllocated.get(random.nextInt(devicesNotAllocated.size()));
        	Resource r = resources.get(random.nextInt(resources.size()));
        	r.setRequests(d);
        	d.allocateResource();
        	r.UpdateRequests();
        	m.removeAllocatedDevice(d, devicesNotAllocated);
        }
        System.out.println("");

    }

    LinkedList<Device> createDevices(Random r){
        LinkedList<Device> devices = new LinkedList<>();
        for(int i = 0; i<30; i++){
            Device device = new Device(r.nextInt(100),r.nextInt(100), r.nextInt(5) + 1);
            devices.add(device);
        }
        return devices;
    }

    LinkedList<Resource> createResources(Random r){
        LinkedList<Resource> resources = new LinkedList<>();
        for(int i = 0; i<10; i++){
            Resource resource = new Resource(r.nextInt(100), r.nextInt(100));
            resources.add(resource);
        }
        return resources;
    }
    
    LinkedList<Device> cloneDevices(List<Device> devices){
    	LinkedList<Device> devicesFirstFase = new LinkedList<>(devices);
        return devicesFirstFase;
    }
    
    void removeAllocatedDevice(Device device, List<Device> devices ) {
    	for(Device d: devices) {
    		if(d.equals(device)) {
    			devices.remove(d);
    			break;
    		}
    	}
    }

}
