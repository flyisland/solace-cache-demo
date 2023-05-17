#!/bin/bash
export LD_LIBRARY_PATH=/usr/local/solace/solclient/lib:/usr/local/solace/SolaceCache/lib:$LD_LIBRARY_PATH
./SolaceCache/bin/SolaceCache -f /tmp/cacheConfig.conf