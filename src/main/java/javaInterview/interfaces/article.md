
### Types of Interfaces

#### Normal
* More than one method

####Marker Interface
* Does not have any method

####Single Abstract Method/ Functional Interface 
  * Just one method. Conceptually, a functional interface has exactly one abstract
  * Instances of functional interfaces can be created with lambda expressions, method references, 
  or constructor references. 
  * Example: `Supplier, Consumer, Predicate`
  
  
####Supplier Interface
Represents a supplier of result that does not take any value but returns and object of type T  

####Consumer Interface
Represents an operation which takes a single argument of type T but doesn't return anything. Also
performs the operation represented by abstract method `accept()` 



