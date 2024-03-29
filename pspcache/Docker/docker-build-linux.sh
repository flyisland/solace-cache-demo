#!/bin/bash
ver=$(ls -i solclient* | grep -Eo '([0-9]+\.)+')
solclient_ver=${ver:0:$((${#ver}-1))}
ver=$(ls -i SolaceCache* | grep -Eo '([0-9]+\.)+')
SolaceCache_ver=${ver:0:$((${#ver}-1))}

sed -i "s/ENV SOLCLIENT_VER.*$/ENV SOLCLIENT_VER=$solclient_ver/" ./Dockerfile
sed -i "s/ENV SOLCACHE_VER.*$/ENV SOLCACHE_VER=$SolaceCache_ver/" ./Dockerfile

sudo docker build . -t island/pspcache:0.1