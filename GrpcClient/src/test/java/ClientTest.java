import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Yuxin Fan
 * @create 2019-09-29
 */
@Ignore
public class ClientTest {

  String host = "";

  @Test
  public void testGreetClientRunOnce(){
    GreetClient client = new GreetClient(host,9090);
    long[] times = new long[100];
    for (int i = 0; i<100; i++){
      client.run(1);
      times[i] = client.rrt;
    }
    Utils.formatRawResult(times, "TCP-Q5-RawData", "A1-2");
    Utils.formatResult(times, "TCP-Q4", "A1-2");
  }

  @Test
  public void testStreamingClient() throws InterruptedException {
    GreetClient greetClient = new GreetClient(host,9090);
    long[] times = new long[100];
    for (int i = 0; i<100; i++){
      greetClient.run(1024*1024);
      times[i] = greetClient.rrt;
    }
    Utils.formatResult(times, "TCP-Q7-E1", "A1-2");

    StreamingClient streamingClient = new StreamingClient(host,9000);
    for (int i = 0; i<100; i++){
      streamingClient.run(1024*1024);
      times[i] = streamingClient.rrt;
    }
    Utils.formatResult(times,"TCP-Q7-E2", "A1-2");
  }
}
