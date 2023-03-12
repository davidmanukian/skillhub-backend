# SkillHub
### The application allows you to evaluate the skills of employees, calculate the overall coefficient of an employee based on collaborative evaluation, and also select the most suitable candidates for specific projects based on the underlying algorithms.

## Features

- Authentication & Authorization based on JWT token (super secure way)
- Enrich Profile with Picture, Skills, Certs, and About
- Creating an assessment for a selected person (autocomplete based on existing profiles).
- Evaluate candidate's skills
- Track the status of any assessment
- Add project with required skills.
- PerfectMatch Algorithm that shows perfect candidates for the project with its required skills

## Project Structure
Backend structure:
**app** - main code is located here.
**app-db** - I'm using FlywayDB for database migration. All scripts are going to be located here. Database Migration allows to keep all ENVs consistent.
**app-specs** - I'm using [**API-First-Approach**](https://swagger.io/resources/articles/adopting-an-api-first-approach/#:~:text=An%20API%2Dfirst%20approach%20means,be%20consumed%20by%20client%20applications.) that allows to focus API first then on its implementation. The spec is located here.

Frontend structure:
**src** - all code is located here.

## Tech
Application has divided on two parts: frontend project and backend project. It uses NGINX as a reverse proxy for connection between frontend abd backend.

Backend stack:
- Java 17 - programming language
- Spring Boot Framework - main framework with its submodules
- PostgresSQL - main sql database
- FlywayDB - data migration tool that allows to keep consistent all ENV databases (DEV,TST, PRD)
- Redis - cache
- JWT Security - security mechanism
- Gradle - build automation tool

Frontend Stack:
- VueJS 3 - main frotnend framework
- TypeScript - programming language
- Vuetify - main UI conponents library that provides very rich components for VUEJS
- Vite - package builder

## Installation

Git clone frontend & backend projects via:
```git clone [PROJECT]```

Go to frontend project:
``` cd FRONTEND-PROJECT```
And make ```npm install``` inside the root of the project.

Then open backend project and find **application.yaml** file.
In this file there are some properties that we need to change if you have different values, for example:
`datasource.username` - Postgres username
`datasource.password` - Postgres password
`datasource.url` - Postgres URL
`data.redis.host` - Redis host
`data.redis.password` - Redis password

There are more properties that if you want you can change but if you adjust all connections with DB will be enought to run the application.

Backend is running on **8080** port.
Frontend is running on **3000** port

**IMPORTANT!!!**
It's very important to run NGINX with such **nginx.conf**:
```
events {
}
http {

    server {
        listen 80;
        server_name skillhub;
	    client_max_body_size 128M;
	    client_body_buffer_size 128M;
	    location /SkillHub {
		    proxy_pass	http://127.0.0.1:8080;
	    }
        location / {
            proxy_pass	http://127.0.0.1:3000;
        }
    }
}
````
## How To Run

Backend - ```gradle/gradlew bootRun``` - it will run the application on port **8080**.
Frontend - ```vite dev``` - it will run the application on port **3000**.

If you want to run tests you can do ```gradle/gradlew test``` it runs all unit tests in the application.

