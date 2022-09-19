The task will does the following items 

1. a Jenkins groovy file that creates jobs ( look for job DSL plugin ). 

Items : 

a. Jenkins groovy file creates a pipeline job that pulls code from your GitHub repo.

b. Build a docker container and push it to the docker hub. 

c. The docker it builds is a python ( flask simple web application that talks to the local docker engine and gets the list of running containers ) 

d. Another job that takes a default Nginx docker file and modifies it and pushes a proxy pass to the first container (and injects in the request headers a source IP ) then push the container to docker hub  

e. A third job that runs the two containers and exposes the Nginx container ports only on the local Jenkins machine then sends a request to verify the  request has gone ok  and finishes successfully
