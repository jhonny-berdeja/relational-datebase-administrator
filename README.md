curl https://start.spring.io/starter.tgz -d dependencies=web,data-jpa -d language=java -d groupId=com.jberdeja -d artifactId=relational-database-administrator -d type=maven-project | tar -xzvf -  

cd relational-datebase-administrator  

dicker compose up  

debe haber por lo menos una conexion a DB para que se pueda ejecutar lo mas basico posible.
