# New York Times API Demo

Built using Spring Web, Security, Data, Thymeleaf, Bootstrap, and MySQL.

Articles retrieved from the Most Popular API are presented in a grid on the home page.

To access the Article Search API, a user must first register an account and be currently logged in.

<br />
<p align="center">
<img width="400" alt="nyt1" src="https://user-images.githubusercontent.com/64601713/117218910-fc18bf00-adb8-11eb-9e14-85825ef69c2d.png">
<img width="400" alt="nyt2" src="https://user-images.githubusercontent.com/64601713/117218956-194d8d80-adb9-11eb-8400-5605a539d246.png">
</p>

## Installation

The package is configured for WAR deployment using an external Tomcat server and MySQL installation.  
Set these inside application.properties ->
```
MySQL path and user information
NYT API Key
```
Build using Maven 
```
./mvnw package
```
Use scp or similar to transfer nyt.war to your server, then deploy using Tomcat.

## Usage

Once deployed, access http://your.server/nyt  
Register a new user and login to access search.

## Info
Feedback, advice, kind words are all accepted at any time :)

This demo was written as a learning project and proof-of-concept.  
It is by no means complete, secure, or ready to be used for any production environment.

## License
[MIT](https://github.com/uuufo/nyt-api-demo/blob/main/LICENSE)
