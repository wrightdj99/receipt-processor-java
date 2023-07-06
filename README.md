# Receipt Processor Challenge in Java
My name is Dan Wright, and this is my code repo for Fetch's Back-End Apprenticeship coding assessment.

# Things you need to know before running:

 1. This project was written using Java 17. Whether you have Java on your machine or not, it's not a problem. I have provided a Dockerfile that can help you regardless of OS or language.
 2. Something you will need to run this app is some kind of API Platform, or command-line based tool to make HTTP requests. I personally am a fan of [Postman](https://www.postman.com/), but if you have another API testing tool you like working with then go ahead and use that.

# Running the program:

1. Clone the git repo to a local repository on your machine.
2. If you have Docker Desktop installed, open it to start the daemon. If you have a way of starting Docker from the command line instead, then do that.
3. Next, run the following commands, both might take a minute. Make sure that you're at the main project directory (receipt-processor-java), and that after the build command, receipt-processing-challenge-java shows up under the **images** response.
```agsl
    docker build -t receipt-processing-challenge-java .
    docker images 
    docker run -p 8000:8080 receipt-processing-challenge-java
```
4. Next, open up your API testing tool of choice (ex: Postman) and make a **POST** request with the below url. Note the port forwarding that took place with the last Docker command.
```agsl
URL: http://localhost:8000/receipts/processes
```
-    Include this JSON in the request body:
```agsl
{
  "retailer": "Barry's",
  "purchaseDate": "2023-07-10",
  "purchaseTime": "08:24",
  "items": [
    {
      "shortDescription": "Cheese",
      "price": "11.99"
    },
    {
       "shortDescription": "Milk",
       "price": "6.40"
    }
  ],
  "total": "18.39"
}
```
5. If all went well, you should get back a single line of JSON with a UUID string that looks something like what's shown below. 
```agsl
{
    "id": "85c76622-6b1b-3701-b1db-3172ca96a015"
}
```
6. Now, whatever UUID you got back in the response, copy it to your clipboard. Now, create a **GET** request using this new URL format. The id variable in curly braces is where your UUID gets pasted in.
```agsl
URL: http://localhost:8000/receipts/{id}/points
```
7. After sending this **GET** request, the in-memory library of receipts will be queried to find the receipt that matches the UUID you passed in. If one is found, it will a single line of JSON with the corresponding amount of points awarded.:
```agsl
{
    "points": "20"
}
```