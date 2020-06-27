#RESTful Web Services

In this case, one user can make many posts

-Retrieve all users     - /users
-Create a User          -POST /users
-Retrieve on User       -GET /users/{id} -> /users/1
-Delete a User          -DELETE /users/{id} -> /users/1

-Retrieve all posts for a User -  GET /users/{id}/posts

-Create a post for a User   -POST /users/{id}/posts

-Retrieve details of a post     -GET /users/{id}/posts/{id}