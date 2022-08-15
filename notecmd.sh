mvn archetype:generate -DgroupId=com.uservice -DartifactId=user -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.uservice -DartifactId=fraud -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.uservice -DartifactId=eureka-server -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.uservice -DartifactId=client -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.uservice -DartifactId=notification -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.uservice -DartifactId=apigw -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.uservice -DartifactId=amqp -DinteractiveMode=false
mvn clean compile jib:build # build docker
