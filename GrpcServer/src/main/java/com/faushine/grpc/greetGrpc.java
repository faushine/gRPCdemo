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
    comments = "Source: greet.proto")
public final class greetGrpc {

  private greetGrpc() {}

  public static final String SERVICE_NAME = "greet";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.faushine.grpc.Greet.LoginRequest,
      com.faushine.grpc.Greet.APIResponse> getHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "hello",
      requestType = com.faushine.grpc.Greet.LoginRequest.class,
      responseType = com.faushine.grpc.Greet.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.faushine.grpc.Greet.LoginRequest,
      com.faushine.grpc.Greet.APIResponse> getHelloMethod() {
    io.grpc.MethodDescriptor<com.faushine.grpc.Greet.LoginRequest, com.faushine.grpc.Greet.APIResponse> getHelloMethod;
    if ((getHelloMethod = greetGrpc.getHelloMethod) == null) {
      synchronized (greetGrpc.class) {
        if ((getHelloMethod = greetGrpc.getHelloMethod) == null) {
          greetGrpc.getHelloMethod = getHelloMethod = 
              io.grpc.MethodDescriptor.<com.faushine.grpc.Greet.LoginRequest, com.faushine.grpc.Greet.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "greet", "hello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.faushine.grpc.Greet.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.faushine.grpc.Greet.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new greetMethodDescriptorSupplier("hello"))
                  .build();
          }
        }
     }
     return getHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static greetStub newStub(io.grpc.Channel channel) {
    return new greetStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static greetBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new greetBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static greetFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new greetFutureStub(channel);
  }

  /**
   */
  public static abstract class greetImplBase implements io.grpc.BindableService {

    /**
     */
    public void hello(com.faushine.grpc.Greet.LoginRequest request,
        io.grpc.stub.StreamObserver<com.faushine.grpc.Greet.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.faushine.grpc.Greet.LoginRequest,
                com.faushine.grpc.Greet.APIResponse>(
                  this, METHODID_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class greetStub extends io.grpc.stub.AbstractStub<greetStub> {
    private greetStub(io.grpc.Channel channel) {
      super(channel);
    }

    private greetStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected greetStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new greetStub(channel, callOptions);
    }

    /**
     */
    public void hello(com.faushine.grpc.Greet.LoginRequest request,
        io.grpc.stub.StreamObserver<com.faushine.grpc.Greet.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class greetBlockingStub extends io.grpc.stub.AbstractStub<greetBlockingStub> {
    private greetBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private greetBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected greetBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new greetBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.faushine.grpc.Greet.APIResponse hello(com.faushine.grpc.Greet.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class greetFutureStub extends io.grpc.stub.AbstractStub<greetFutureStub> {
    private greetFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private greetFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected greetFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new greetFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.faushine.grpc.Greet.APIResponse> hello(
        com.faushine.grpc.Greet.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final greetImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(greetImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HELLO:
          serviceImpl.hello((com.faushine.grpc.Greet.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.faushine.grpc.Greet.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class greetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    greetBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.faushine.grpc.Greet.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("greet");
    }
  }

  private static final class greetFileDescriptorSupplier
      extends greetBaseDescriptorSupplier {
    greetFileDescriptorSupplier() {}
  }

  private static final class greetMethodDescriptorSupplier
      extends greetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    greetMethodDescriptorSupplier(String methodName) {
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
      synchronized (greetGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new greetFileDescriptorSupplier())
              .addMethod(getHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
