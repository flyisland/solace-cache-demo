#!/bin/bash
export LD_LIBRARY_PATH=/usr/local/solace/solclient/lib:/usr/local/solace/solcache/lib:$LD_LIBRARY_PATH
./solcache/bin/solCacheInstance -f /tmp/cacheConfig.conf