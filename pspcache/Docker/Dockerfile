FROM ubuntu:latest

ENV SOLCLIENT_VER=7.21.0.5
ENV SOLCACHE_VER=7.2.2.20
ENV SOLACE_INSTALL_DIR=/usr/local/solace

WORKDIR /tmp
COPY ./solclient_Linux26-x86_64_opt_${SOLCLIENT_VER}.tar.gz .
COPY ./SolaceCache_Linux26-x86_64_opt_${SOLCACHE_VER}.tar.gz .
RUN tar zxvf ./solclient_Linux26-x86_64_opt_${SOLCLIENT_VER}.tar.gz
RUN tar zxvf ./SolaceCache_Linux26-x86_64_opt_${SOLCACHE_VER}.tar.gz

RUN mkdir -p ${SOLACE_INSTALL_DIR}
COPY ./startCache.sh ${SOLACE_INSTALL_DIR}
RUN chmod +x ${SOLACE_INSTALL_DIR}/startCache.sh

RUN mv ./solclient-${SOLCLIENT_VER} ${SOLACE_INSTALL_DIR}/solclient
RUN mv ./SolaceCache ${SOLACE_INSTALL_DIR}/SolaceCache
RUN rm -f ./solclient_Linux26-x86_64_opt_${SOLCLIENT_VER}.tar.gz
RUN rm -f ./SolaceCache_Linux26-x86_64_opt_${SOLCACHE_VER}.tar.gz

WORKDIR ${SOLACE_INSTALL_DIR}
CMD ["./startCache.sh"]
