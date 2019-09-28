import java.io.IOException;

/**
 * @author Yuxin Fan
 * @create 2019-09-28
 */
public class App {

  public static void main(String[] args) throws IOException, InterruptedException {
    String server = args[0];
    if (server.equals("greet")){
      GreetServer.run();
    }
    if (server.equals("stream")){
      StreamingServer.run();
    }
  }

}
