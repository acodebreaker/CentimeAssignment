swagger UI:-

http://localhost:8080/swagger-ui.html#/

to build :-

Scripts/build.sh

to run :-

Scripts/run.sh


to add and remove data curl scripts are present in script folder

Health Endpoint :-

curl -X GET --header 'Accept: application/json' 'http://localhost:8080/health'

Please use below property to control persistance :-

spring.jpa.hibernate.ddl-auto=create