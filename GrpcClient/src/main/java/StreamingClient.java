import com.faushine.grpc.Streaming;
import com.faushine.grpc.Streaming.APIResponse;
import com.faushine.grpc.Streaming.Message;
import com.faushine.grpc.streamingGrpc;
import com.faushine.grpc.streamingGrpc.streamingStub;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @author Yuxin Fan
 * @create 2019-09-28
 */
public class StreamingClient {

  public static void main(String[] args) throws InterruptedException {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 10090).usePlaintext().build();
    streamingStub streamingStub = streamingGrpc.newStub(channel);
    StreamObserver<Message> collect = streamingStub.hello(new StreamObserver<APIResponse>() {
      @Override
      public void onNext(APIResponse apiResponse) {
        System.out.println(apiResponse.getResponseMessage());
      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
      }

      @Override
      public void onCompleted() {
      }
    });
    Stream.of("1","3","2","4").map(l->
        Streaming.Message.newBuilder().setStreamMessage(l).build()).forEach(collect::onNext);
    collect.onCompleted();
  }
}
