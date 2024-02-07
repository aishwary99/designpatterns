## Design Patterns

### Creational Design Patterns

#### Builder :
- We have a complex process to construct an object involving multiple steps, then builder pattern can help us.

- In builder, we remove the logic related to object construction from "client" code & abstract it in a separate class.

![github-small](images/builder-first.png)

- Implement a builder :
* We start by creating a builder, identifying the parts of the product & provide methods to create those parts.
* It should provide a method to assemble or build the product/object.
* It must provide a way (method) to get fully built object out.
* Optionally - builder can keep reference to a product it has built so the same can be returned again in future.

- Implement a director : 
* A director can be a separate class or client can play the role of director.

![github-small](images/builder-second.png)

#### Problem Builder Design Pattern Solves -
The Builder design pattern solves the problem of constructing complex objects step by step while allowing different variations or representations of the object to be created. It is useful when an object has a complex construction process with many optional parameters or configurations, and you want to separate the construction logic from the object's main business logic.

With the Builder pattern, you can create an object piece by piece, specifying only the components you need, and then use a director (optional) to orchestrate the construction process. This helps in making the construction process more flexible, maintainable, and easier to understand, especially when dealing with objects with multiple configurations or variations.

##### Example -
- StringBuilder class in java.lang.StringBuilder is a builder design pattern implemented class according to GoF definition.
- Builder has potential to build different representations of product interface step by step.
- Calendar class is also a builder design pattern implemented class.

#### Comparison with Prototype design pattern -
![github-small](images/builder-third.png)

#### Consideration -
- Think of builder dp when you have a complex constructor or an object is built in multiple steps.


#### Simple Factory Design Pattern :
![github-small](images/simple-factory-one.png)

- Separate class will be created to implement Simple Factory.
- A method will be created which will return desired object instance.
- This method will typically accept some argument to decide which class to instantitate.
- You can also provide additional arguments which will be used to instantitate objects.

##### Examples -
- java.text.NumberFormat class has getInstance method, which is an example of Simple Factory.

#### Comparison with Factory Method Pattern :
![github-small](images/simple-factory-two.png)

#### Issues :
- The criteria used by Simple Factory to decide which object to instantitate can get more convoluted / complex over time. If you find yourself in such situation then use factory method design pattern.

#### Factory Method Design Pattern :
- Used when we want to move object creation logic out , in a separate class.
- We use this DP, when we don't know in advance which class we may need to instantitate beforehand & also to allow new classes to be added to system and handle their creation without affecting client code.
- We let subclasses decide which object to instantiate by overriding the factory method.

![github-small](images/factory-method-one.png)

![github-small](images/factory-method-two.png)

### Structural Design Patterns

### Behavioural Design Patterns