import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.GreetService;

/**
 * @author Yuxin Fan
 * @create 2019-09-27
 */
public class GRPCServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(9090).addService(new GreetService()).build();
    server.start();
    System.out.println("Server started at " + server.getPort());
    server.awaitTermination();
  }
}
