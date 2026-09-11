package com.grpc.demo.service;

import com.grpc.product.proto.Product;
import com.grpc.product.proto.ProductRequestById;
import com.grpc.product.proto.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;
import reactor.core.publisher.Flux;

import java.time.Duration;

@GrpcService
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void getProductsByType(ProductRequestById request, StreamObserver<Product> responseObserver) {

        String productTypeId = request.getTypeId();

        // Flux with Response Observer is used .

        //Flux.range(1, 100).delayElements(Duration.ofMillis(100));
        Flux.interval(Duration.ofMillis(100)).take(100)
                .map(i -> Product.newBuilder().setId("P-" + i).setTitle("Product Item #" + i)
                        .setPrice(49.99 * i)
                        .setTypeId(productTypeId)
                        .setStockQuantity(10 * i)
                        .build())
                .subscribe(
                        responseObserver::onNext,
                        responseObserver::onError,
                        responseObserver::onCompleted
                );

    }
}
