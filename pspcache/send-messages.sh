#!/bin/bash

currencies=("CNY/USD" "CNY/JPY" "CNY/EUR" "USD/EUR" "USD/GBP" "USD/CAD" "USD/CNY" "USD/JPY")

while true; do 
    msgbody=$(date +'%Y-%m-%d-%H:%M:%S')
    for match in "${currencies[@]}"
    do
        echo "Sending '${msgbody}' to topic 'fx/rt/${match}'"
        curl -X POST -d "${msgbody}" http://localhost:9000/fx/rt/${match} -H "content-type: text/plain"
    done
    echo
    sleep 1
done