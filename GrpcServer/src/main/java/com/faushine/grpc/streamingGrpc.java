package com.faushine.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: streaming.proto")
public final class streamingGrpc {

  private streamingGrpc() {}

  public static final String SERVICE_NAME = "streaming";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.faushine.grpc.Streaming.Message,
      com.faushine.grpc.Streaming.APIResponse> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hello",
      requestType = com.faushine.grpc.Streaming.Message.class,
      responseType = com.faushine.grpc.Streaming.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.faushine.grpc.Streaming.Message,
      com.faushine.grpc.Streaming.APIResponse> getHelloMethod() {
    io.grpc.MethodDescriptor<com.faushine.grpc.Streaming.Message, com.faushine.grpc.Streaming.APIResponse> getHelloMethod;
    if ((getHelloMethod = streamingGrpc.getHelloMethod) == null) {
      synchronized (streamingGrpc.class) {
        if ((getHelloMethod = streamingGrpc.getHelloMethod) == null) {
          streamingGrpc.getHelloMethod = getHelloMethod = 
              io.grpc.MethodDescriptor.<com.faushine.grpc.Streaming.Message, com.faushine.grpc.Streaming.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "streaming", "hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.faushine.grpc.Streaming.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.faushine.grpc.Streaming.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new streamingMethodDescriptorSupplier("hello"))
                  .build();
          }
        }
     }
     return getHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static streamingStub newStub(io.grpc.Channel channel) {
    return new streamingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static streamingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new streamingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static streamingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new streamingFutureStub(channel);
  }

  /**
   */
  public static abstract class streamingImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.faushine.grpc.Streaming.Message> hello(
        io.grpc.stub.StreamObserver<com.faushine.grpc.Streaming.APIResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHelloMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.faushine.grpc.Streaming.Message,
                com.faushine.grpc.Streaming.APIResponse>(
                  this, METHODID_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class streamingStub extends io.grpc.stub.AbstractStub<streamingStub> {
    private streamingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private streamingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected streamingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new streamingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.faushine.grpc.Streaming.Message> hello(
        io.grpc.stub.StreamObserver<com.faushine.grpc.Streaming.APIResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class streamingBlockingStub extends io.grpc.stub.AbstractStub<streamingBlockingStub> {
    private streamingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private streamingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected streamingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new streamingBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class streamingFutureStub extends io.grpc.stub.AbstractStub<streamingFutureStub> {
    private streamingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private streamingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected streamingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new streamingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final streamingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(streamingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.hello(
              (io.grpc.stub.StreamObserver<com.faushine.grpc.Streaming.APIResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class streamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    streamingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.faushine.grpc.Streaming.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("streaming");
    }
  }

  private static final class streamingFileDescriptorSupplier
      extends streamingBaseDescriptorSupplier {
    streamingFileDescriptorSupplier() {}
  }

  private static final class streamingMethodDescriptorSupplier
      extends streamingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    streamingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (streamingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new streamingFileDescriptorSupplier())
              .addMethod(getHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
