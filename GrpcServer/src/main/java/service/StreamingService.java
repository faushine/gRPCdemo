package service;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

import com.faushine.grpc.Streaming.APIResponse;
import com.faushine.grpc.Streaming.Message;
import com.faushine.grpc.streamingGrpc.streamingImplBase;

import io.grpc.stub.StreamObserver;

/**
 * @author Yuxin Fan
 * @create 2019-09-27
 */
public class StreamingService extends streamingImplBase {

  @Override
  public StreamObserver<Message> hello(StreamObserver<APIResponse> responseObserver) {
    return  new StreamObserver<Message>() {
      int size=0;
      @Override
      public void onNext(Message message) {
        size +=message.getStreamMessage().size();
        System.out.println(size);
      }

      @Override
      public void onError(Throwable throwable) {
        responseObserver.onError(throwable);
        System.out.println("1");
      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(APIResponse.newBuilder().setResponseMessage("data: "+size).build());
        responseObserver.onCompleted();
        System.out.println("Receive all messages");
      }
    };
  }
}
