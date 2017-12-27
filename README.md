# hand-sample-vertx-webapi
Basic webapi server base on vert.x in java lang

This is a basic program which show you how to create a webapi server with vert.x and java 8.
There is only two http routes "/" and "/api".
The route "/" will response 'Hello world'.
Another route "/api" will response a json format data {"errorCode": 0, "message": "", "result": "Hello world"}

Requirement:
1. JAVA 8
2. Maven 3.3
3. vert.x 3.5.0
4. Intellij or Eclipse
5. postman

Step:
1. We need two dependencies vertx-core and vertx-web
2. Add a class file named 'ServerVerticle' and inherit an abstract module named 'AbstractVerticle' and override a method 'start(Future<Void> startFuture)'
** Verticle is actor-like, the minimum operating unit in vert.x **
3. Create a http server and listen to 8080.
4. Define router and add routes "/", "/api" and it's response data.
5. http server accept defined router.
6. start http server.
Now we have a basic http server with two routes "/", "/api", but it's not working, we have to deploy it in main function.
Step:
1. Add a class file named 'App' and add a static main function for entry point.
2. Define a vert.x instance and deploy 'ServerVerticle'.
3. start running program.
Now we'll see our http server running on 8080.
Use postman to test http request: http://localhost:8080 and http://localhost:8080/api and you would see the response.

Notice: No mater what http method you use (post, get, put...), the request would always direct to "/".
Because of we define "/" route using mainRouter.route("/"), it means that this route would accept any http method

