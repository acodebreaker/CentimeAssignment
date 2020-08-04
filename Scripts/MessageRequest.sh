#!/usr/bin/env bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
  	"name":"Ankit",
  	"surname" :"Rawat"
}' \
http://localhost:8080/message