import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.StreamingService;

/**
 * @author Yuxin Fan
 * @create 2019-09-28
 */
public class StreamingServer {

  public static void run() throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(9000).addService(new StreamingService()).build();
    server.start();
    System.out.println("Server started at " + server.getPort());
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        server.shutdown();
        System.err.println("*** server shut down");
      }
    });
    server.awaitTermination();
  }
}
