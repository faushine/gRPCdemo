import com.google.protobuf.ByteString;

import com.faushine.grpc.Streaming;
import com.faushine.grpc.Streaming.APIResponse;
import com.faushine.grpc.Streaming.Message;
import com.faushine.grpc.streamingGrpc;
import com.faushine.grpc.streamingGrpc.streamingStub;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 * @author Yuxin Fan
 * @create 2019-09-28
 */
public class StreamingClient {

  private final ManagedChannel channel;
  private final streamingStub asyncStub;
  public long rrt;

  /**
   * Construct client for accessing RouteGuide server at {@code host:port}.
   */
  public StreamingClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
  }

  /**
   * Construct client for accessing RouteGuide server using the existing channel.
   */
  public StreamingClient(ManagedChannelBuilder<?> channelBuilder) {
    channel = channelBuilder.build();
    asyncStub = streamingGrpc.newStub(channel);
  }

  public void run(int size) throws InterruptedException {
    byte[] buff = new byte[size];
    System.out.println("Start sending data...");
    final CountDownLatch finishLatch = new CountDownLatch(1);
    StreamObserver<APIResponse> responseObserver = new StreamObserver<APIResponse>() {
      long startTime = System.currentTimeMillis();

      @Override
      public void onNext(APIResponse response) {
        System.out.println("Finished trip with " + response.getResponseMessage());
      }

      @Override
      public void onError(Throwable t) {
        System.out.println("Streaming Failed:" + Status.fromThrowable(t));
        t.printStackTrace();
        finishLatch.countDown();
      }

      @Override
      public void onCompleted() {
        rrt = System.currentTimeMillis() - startTime;
        System.out.println("Finished trip in: " + rrt + " ms");
        finishLatch.countDown();
      }
    };

    StreamObserver<Message> requestObserver = asyncStub.hello(responseObserver);
    try {
      // Send numPoints points randomly selected from the features list
      Message message = Streaming.Message.newBuilder().setStreamMessage(ByteString.copyFrom(buff))
          .build();
      System.out.println("Send data with " + buff.length + " bytes");
      requestObserver.onNext(message);
      // Sleep for a bit before sending the next one.
      if (finishLatch.getCount() == 0) {
        // RPC completed or errored before we finished sending.
        // Sending further requests won't error, but they will just be thrown away.
        return;
      }
    } catch (RuntimeException e) {
      // Cancel RPC
      requestObserver.onError(e);
      throw e;
    }
    // Mark the end of requests
    requestObserver.onCompleted();

    // Receiving happens asynchronously
    if (!finishLatch.await(1, TimeUnit.MINUTES)) {
      System.out.println("Streaming can not finish within 1 minutes");
    }
  }

//  public static void main(String[] args) throws InterruptedException {
//    StreamingClient client = new StreamingClient("localhost", 9000);
//    client.run(new byte[1024 * 1024]);
//  }
}
