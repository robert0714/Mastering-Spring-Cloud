# Building the Docker Images 
Run the following maven command.  This command will execute the [Spotify docker plugin](https://github.com/spotify/docker-maven-plugin) defined in the pom.xml file.  
     
   **mvn clean package docker:build**
    
# Running the services for Developing

Now we are going to use docker-compose to start the actual image.  To start the docker image,
change to the directory containing  your   source code.  Issue the following docker-compose command:

   **docker-compose -f docker/common/docker-compose.yml up**
   
#  For windows developer　＃
eclipse plugins 
https://www.eclipse.org/community/eclipse_newsletter/2016/july/article2.php
# Example #
### Account Service ###

   http://localhost:8091/1
   
   http://localhost:8080/account/1
   
   http://localhost:8091/2
   
   http://localhost:8080/account/2 