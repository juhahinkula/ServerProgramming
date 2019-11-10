To test this application go to:

http://localhost:8080/graphiql

Sample GraphQL query:

{
   students {
     email
     firstName
     lastName
     department {name}
   }   
}
