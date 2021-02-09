REST

are a type of we services that are light weight web services which use a lot of concepts behind http.
Other type of web services are like soap web services.

Web Services Characteristics:

1. Client sends a request and server sends a response containing some data
2. Client can do whatever it wants to do with the data
3. Protocol used for data: Messages transmitted from client to server need to follow a protocol or in layman terms - format. For ex. SOAP web services uses a standard protocol called SOAP. RESTful web services can send messages in XML/JSON/Text format. Its upto the contract between client and server. The popular format is JSON.
4. How the communication happens? RESTful web services are web services so the communication happens over HTTP protocol. There are different methods available in HTTP like GET, PUT, POST. The messages can be exchanged using any of these methods under some guidelines but there are no strict rules.
5. Service Definition: In the SOAP web services there is a standard service definition called WSDL. Its a document which defines the service, like request/response structure etc. In case of REST there is no such standard. The best designed web services may not need a documentation, the definition ideally should be implicit.


SOAP web services follow the SOAP specification which dictate what every SOAP web service should be like. If they dont follow these rules then it's not a SOAP web service.
RESTful web service on other hand has nosuch specification. Its basically more of a concept.
REST stands for Representational State Transfer. 

Roy Fielding who is one of the authors of HTTP spec is the on who coined term REST. Which means REST has a lot of concepts coming from HTTP.

HTTP: Hyper Text Transfer Protocol. Hyper Text is a structured form of text which has links to other texts and these links are called Hyperlinks. A common and a popular way to write Hyper Text is HTML.

1. Web addresses
The practice is to have resource based web address. A resource may be like and item and query parameter or further path may tell the item id.
weatherapp.com/zipcode/<zipcode>
Resources should be nouns not verbs. Resource name must be plural.

    In case where one resource depends on other resource. Ex. Comments on messages where messages to comments is a one to many relationship. In this case our resource URI could be
/messages/{messageId}/comments/{commentId}
/messages/{messageId}/likes/{likeId}
This URI establishes the relation between comment and messages very clearly.

    But clearly all these are just guidelines and its upto the developer to think and decide what suits the best.

2. HTTP methods: The uri tells the resource or entity we are operating on and the method tells what we want to do  
    GET: A simple access to the resource
    PUT: To update or change any resource and the content needs to be sent in the body of the message
    POST: To create a new entity and body contains the content to be created and the response in the resource id
    DELETE: Simply deleting a resource and no content required here 
    etc. 

3. HTTP Status Codes: Defines things like if the request was successful, or no found or service not available.

4. Format Of Data: Could be XML or json or anything else. But to know the type of data we can take information from HEADER Content type. ex. application/json for json and the client can parse the information accordingly. 

5. Pagination and filtering should also be taken care of and can be achieved using query parameters


Method Idempotence: PUT vs POST

GET/DELETE/PUT are repeatable methods i.e. idempotent. Making multiple same requests have no side effect.
Although POST is not idempotent. Repeating the same call creates a new resource. 
HTTP specification requires GET PUT and DELETE to be idempotent. Hence resource creation must happen via POST because POST calls are not idempotent.