# Cache Proxy

A microservice to work as a proxy to accept cache requests from non-SMF clients then forwards those cache requests to the PS+ broker with SMF protocol, then forwards the cache reply messages back to the non-SMF clients.

![](images/design.svg)

## Configuration

This is a spring boot application, please modify the [./src/main/resources/application.properties](./src/main/resources/application.properties) file according to your environment before compiling, or use the [Command line arguments](https://docs.spring.io/spring-boot/docs/1.4.1.RELEASE/reference/html/boot-features-external-config.html) while running the application.
