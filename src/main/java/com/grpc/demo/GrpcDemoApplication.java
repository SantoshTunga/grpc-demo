package com.grpc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcDemoApplication {

    static void main(String[] args) {
        SpringApplication.run(GrpcDemoApplication.class, args);
    }

}

/**
 *
 * | REST                        | gRPC                         |
 * | --------------------------- | ---------------------------- |
 * | `200 OK`                    | `OK`                         |
 * | `400 Bad Request`           | `INVALID_ARGUMENT`           |
 * | `401 Unauthorized`          | `UNAUTHENTICATED`            |
 * | `403 Forbidden`             | `PERMISSION_DENIED`          |
 * | `404 Not Found`             | `NOT_FOUND`                  |
 * | `409 Conflict`              | `ALREADY_EXISTS` / `ABORTED` |
 * | `429 Too Many Requests`     | `RESOURCE_EXHAUSTED`         |
 * | `500 Internal Server Error` | `INTERNAL`                   |
 * | `503 Service Unavailable`   | `UNAVAILABLE`                |
 * | `504 Gateway Timeout`       | `DEADLINE_EXCEEDED`          |
 */