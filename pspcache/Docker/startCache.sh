#!/bin/bash
export LD_LIBRARY_PATH=/usr/local/solace/solclient/lib:/usr/local/solace/SolaceCache/lib:$LD_LIBRARY_PATH
python ./solcache/bin/keepalive ./solcache/bin/solCacheInstance -f /tmp/cacheConfig.conf