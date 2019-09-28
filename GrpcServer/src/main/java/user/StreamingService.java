package user;

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
    return new StreamObserver<Message>() {
      int size=0;
      @Override
      public void onNext(Message message) {
        System.out.println(message.getStreamMessage());
      }

      @Override
      public void onError(Throwable throwable) {
        responseObserver.onError(throwable);
      }

      @Override
      public void onCompleted() {
        responseObserver.onNext(APIResponse.newBuilder().setResponseMessage("The greet data has " + size+" byte").build());
      }
    };
  }
}
