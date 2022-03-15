# [Solace PubSub+ Cache](https://docs.solace.com/Solace-PubSub-Cache/PubSub-Cache-Overview.htm) Demo Setup

## Build Solace PubSub+ Cache Docker Image

1. [Contact Solace](https://docs.solace.com/get-support.htm) to get the PubSub+ Cache installation package and put them under the `./Docker` folder.

```textile
total 35704
-rw-r--r--  1 ichen  staff   813B Mar 15 11:28 Dockerfile
-rwxr-xr-x  1 ichen  staff   377B Mar 15 11:18 docker-build-linux.sh
-rwxr-xr-x  1 ichen  staff   378B Mar 15 10:48 docker-build-macos.sh
-rw-r--r--@ 1 ichen  staff   3.9M Mar 15 09:29 solcache_Linux26-x86_64_opt_7.2.2.20.tar.gz
-rw-r--r--@ 1 ichen  staff    13M Mar 15 08:49 solclient_Linux26-x86_64_opt_7.21.0.5.tar.gz
-rw-r--r--  1 ichen  staff   206B Mar 15 11:11 startCache.sh
```

2. Under folder `Docker`, run `./docker-build-macos.sh` to build the docker image
3. Verify the image is successfully built.

```textfile
❯ docker image ls island/pspcache
REPOSITORY        TAG       IMAGE ID       CREATED          SIZE
island/pspcache   0.1       d6a9983f4a2e   10 minutes ago   209MB
```