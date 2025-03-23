# Exploring Algebraic Data Types in Java
## With Bonus Domain Driven Design with Functional Programming

This demo project aims to explore the newer features of Java, representing algebraic data types with records, sealed 
interfaces and enhanced pattern matching.

Furthermore, I was curious to see if principles of Domain Driven Design could also be applied with a functional approach.
With my experience lying primarily in OOP, and having only a cursory grasp of DDD concepts, I was quite pleased with the results.

### The Project
I designed a relatively simple Order domain entity, with multiple properties represented by a sealed interfaces that facilitate pattern matching features.
The order service demonstrates a potential use case for this.

### Order Entity
The `Order` entity is a Java Record, which is an immutable class. It is designed to be rich, where the methods encapsulate 
the business logic specific to the domain. The methods represent some meaningful action rather than opening up the properties
for raw modification. This combination of meaningful actions and immutability complement each other quite well.
The benefit of this in modern systems, since we are often passing data across systems is the integrity of the data is safer.
If an action needs to make some change to an object, we return a new instance of the object to represent the new state, 
which is a more functional approach.

### Order Status
The `OrderStatus` & `PaymentMethod` properties of the Order Entity are sealed interfaces, which allows us to define what
classes can implement it.

### Order Service
Finally, the `OrderService` demonstrates how we can use pattern matching to exhaustively check the status of an order with
the improved switch statement. Since we used a sealed interface, we don't need to handle any default case, since the compiler
is aware of all the possible cases. It will even fail the build if a case is missing, ensuring our checks are exhaustive.
