package com.grpc.demo.service;

import com.grpc.product.proto.Product;
import com.grpc.product.proto.ProductRequestById;
import com.grpc.product.proto.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    @Override
    public void getProductsByType(ProductRequestById request, StreamObserver<Product> responseObserver) {

        Integer productTypeId = request.getTypeId();

        // Flux with Response Observer is used .

        Flux.range(1, 100).interval(Duration.ofMillis(100))
                .map(i -> Product.newBuilder().setId("P-" + i).setTitle("Product Item #" + i)
                        .setPrice(49.99 * i)
                        .setTypeId(String.valueOf(productTypeId))
                        .setStockQuantity(10 * i)
                        .build())
                .subscribe(
                        responseObserver::onNext,
                        responseObserver::onError,
                        responseObserver::onCompleted
                );

    }
}
