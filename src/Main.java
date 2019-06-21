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
        for(Device d: devices){
            Resource resource = d.getFirstElement();
            resource.setRequests(d);
        }


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
