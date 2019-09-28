import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.StreamingService;

/**
 * @author Yuxin Fan
 * @create 2019-09-28
 */
public class StreamingServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(10090).addService(new StreamingService()).build();
    server.start();
    System.out.println("Server started at " + server.getPort());
    server.awaitTermination();
  }

}
