import org.server.WorkerServer;
import org.server.org.config.WorkerConfiguration;
import org.server.org.config.WorkerConfigurationBuilder;
import org.server.org.config.WorkerServerConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String [ ] args){

        WorkerServerConfiguration serverConfiguration=new WorkerServerConfiguration();

        serverConfiguration.setName("WorkerServer-1");
        serverConfiguration.setSocket(8080);

        List<WorkerConfiguration> workerConfigurations;
        workerConfigurations = new ArrayList<WorkerConfiguration>();

        workerConfigurations.add(new WorkerConfigurationBuilder().name("Worker-1").buildWorkerConfiguration());
        workerConfigurations.add(new WorkerConfigurationBuilder().name("Worker-2").buildWorkerConfiguration());
        workerConfigurations.add(new WorkerConfigurationBuilder().name("Worker-3").buildWorkerConfiguration());
        workerConfigurations.add(new WorkerConfigurationBuilder().name("Worker-4").buildWorkerConfiguration());

        serverConfiguration.setWorkerConfigurations(workerConfigurations);

        WorkerServer workerServer=new WorkerServer(serverConfiguration);


    }
}
