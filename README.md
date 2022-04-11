# Group6_CST438_Project3_Backend
## Team Members

1. Alfredo Hernandez
2. Jose Barroso A.
3. Rakery Cheng
4. Ryan Trinh

## App Description
This is a web based "story time" application using modern web frameworks. This will require the development of a Representational state transfer (REST) Application Programming Interface (API), a constant integration, constant development (CICD) pipeline, and a persistence (Database) layer. The website will be deployed to a Platform as a Service (PaaS) such as Heroku or Google App Engine, and will also have a mobile front-end (android)
- [Link to Web Front-end Repo](https://github.com/rltsystems/Group6_CST438_Project03_Web)
- [Link to Mobile Front-end Repo](https://github.com/rakcheng/Group6_CST438_Project03_Android)


## Resources
- [Using OAuth 2.0 to Access Google APIs ](https://developers.google.com/identity/protocols/oauth2)
- [Spring Boot CRUD operations](https://www.geeksforgeeks.org/spring-boot-crud-operations-using-mysql-database/)
- [How to interact with REST APIs from JavaScript](https://blog.teclado.com/how-to-interact-with-rest-apis-from-javascript/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Generating Code Snippets on Postman API](https://learning.postman.com/docs/sending-requests/generate-code-snippets/)

## Entity Relationship Diagram(s)
![image](https://user-images.githubusercontent.com/10646650/162261351-ffe7e6cf-ac44-474d-812a-5f8ad5578b7c.png)

## API Endpoints
**List all Items**
- GET [URL]/items

**Show a specific list/story**
- GET [URL]/items?list={list name || list ID}

**Add a new post to a story**
- POST [URL]/items?item_name={item name}&url={url}

**Delete a story post**
- DELETE [URL]/items?item_name={item id}

**Create new User Account**
- POST:[url]/newuser?username={username}&password={password}

**Update Story Item**
- PATCH [URL]/items?item_name={item id}

**Delete Account (Must ask for Confirmation)**
- DELETE: [URL]/users?username={username}

**Show a Specific Story**
- GET [URL]/items?list={list name || list ID}

**Logout of Account**
- POST/GET [url]/logout?username={username}

**Login to Account**
- POST:[url]/login?username={username}&password={password}
