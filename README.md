# kafkademo

1. Download kafka src from https://www.apache.org/dyn/closer.cgi?path=/kafka/3.2.0/kafka-3.2.0-src.tgz
2. Start zokeeper first before starting kafka<br>

		> cd C:\sandeep\devenv\kafka-3.2.0-src\bin\windows
		> zookeeper-server-start.bat C:\sandeep\devenv\kafka-3.2.0-src\config\zookeeper.properties 

   		If zookeeper start fails and asks for building project first, in gitbash run below command

		> cd /c/sandeep/devenv/kafka-3.2.0-src 
		>./gradlew jar -PscalaVersion=2.13.6

   		Once above is completed, then again run above start command

3. Start Kafka server in another cmd,
		
		> cd C:\sandeep\devenv\kafka-3.2.0-src\bin\windows
		> kafka-server-start.bat C:\sandeep\devenv\kafka-3.2.0-src\config\server.properties

4. Checking if messages are published, we can run consumer command

	> cd C:\sandeep\devenv\kafka-3.2.0-src\bin\windows
	> kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic FIRST-KAFKA-TOPIC
	
	9092 is default kafka server port

5. For publishing Raw(other than string) objects we need to configure key serializer, value serializer, boostrap configurations.