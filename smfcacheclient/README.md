# Solace Java Client to consume cached messages

1. Run `./gradlew build` to build this project.
1. Stop sending messages to the broker and wait for one minute
1. Run `java -jar build/libs/cacheclient.jar -h localhost:44444 -t "fx/rt/>"` to get cached messages.You can check the message content to see if it's a cached message sent one minute before.
