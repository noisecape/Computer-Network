import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();


        Random random = new Random();
        LinkedList<Resource> resources = m.createResources(random);
        List<Device> devices = m.createDevices(random);
        
        Allocator allocator = new Allocator(devices, resources);
        allocator.sortDeviceByPriority();

        allocator.createChartForDevices();

        allocator.executeFirstFase();
        allocator.executeSecondFase();
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

}
