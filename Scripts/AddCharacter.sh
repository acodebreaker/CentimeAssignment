#!/usr/bin/env bash
#!/usr/bin/env bash

curl --header "Content-Type: application/json" \
  --request POST \
  --data '{
  	"parentId":1,
  	"name" :"Ankit",
  	"color":"Red"
}' \
http://localhost:8080/comicCharacter