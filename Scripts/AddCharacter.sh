#!/usr/bin/env bash
#!/usr/bin/env bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
  	"parentId":0,
  	"name" :"warrior",
  	"color":"red"
}' \
http://localhost:8080/comicCharacter