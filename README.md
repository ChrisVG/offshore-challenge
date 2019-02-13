# Event Management System

Coding challenge to create an application to manage events using Spring boot, Spring Data and AngularJS.

## Run UnitTest
```bash
gradlew test
```
## Build


```bash
gradlew build
```


## Usage
The next command will deploy the application, by default you just have to access to  <http://localhost:8080>
```bash
$java -jar partnerships-offshore-challenge-master\build\libs\interview-0.0.1.jar
```
##### Check the data on database

To check the database data use this link:
<http://localhost:8080/h2>

| Propertie | Value|
| ------ | ------ |
| JDBC URL | jdbc:h2:mem:testdb |
| Username | sa |
| Password | Leave this empty |

### Docker
This app is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 8080, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
docker build -t <<yourDockerUser>>/eventInterviewChallenge .
```

Once done, run the Docker image and map the port to whatever you wish on your host. In this example, we simply map port 8080 of the host to port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8080:8080 --restart="always" <<yourDockerUser>>/eventInterviewChallenge
```

Verify the deployment by navigating to your server address in your preferred browser.

```sh
Windows 10, Mac, Linux
http://127.0.0.1:8080

DockerToolbox
http://192.168.99.100:8080
```