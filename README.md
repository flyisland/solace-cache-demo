# Solace PubSub+ Cache Demos

## [pspcache](./pspcache/)

Build Solace PubSub+ Cache Docker Image and start the Solace PubSub+  broker and cache instances.

## [smfcacheclient](./smfcacheclient/)

Solace Java Client to consume cached messages

## [cacheproxy](./cacheproxy/)

A microservice that acts as a proxy to receive cache requests from non-SMF clients, forwards those requests to the PS+ broker using the SMF protocol, and then forwards the cache reply messages back to the non-SMF clients.
