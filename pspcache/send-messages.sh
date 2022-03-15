#!/bin/bash

currencies=("CNY/USD" "CNY/JPY" "CNY/EUR" "USD/EUR" "USD/GBP" "USD/CAD" "USD/CNY" "USD/JPY")

while true; do 
    for match in "${currencies[@]}"
    do
        msgbody=$(date +'%Y-%m-%d-%H:%M:%S')
        echo "Sending '${msgbody}' to topic 'fx/rt/${match}'"
        curl -X POST -d "${msgbody}" http://localhost:9000/fx/rt/${match} -H "content-type: text/plain"
        sleep 1
    done
done