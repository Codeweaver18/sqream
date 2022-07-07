#!/bin/bash

sudo docker run -d --name nginx-base -p 80:80 nginx:latest
sudo docker cp ./default.conf nginx-base:/etc/nginx/conf.d/
sudo docker exec nginx-base nginx -t #Test configuration
sudo docker exec nginx-base nginx -s reload #Reload Nginx contaner
