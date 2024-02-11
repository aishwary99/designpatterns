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

#### Examples :
- java.util.Collection class has a method - iterator(), which is a factory method.
- The most defining characteristic of factory method pattern is - "subclasses providing the actual instance".

#### Issues :
- More complex to implement. More classes involved and need unit testing.
- Not easy to refactor.
- Forces to create subclass to create appropriate object instance.

#### Summary :
- Used when you want to delegate object instantiation to subclasses, you would want to do this when you have "product" heirarchy and possibility of future additions to that.
- We can end up creating conrete classes based on the new requirements of object instantitation.
- For each product concrete class, its corresponding creator class will be added.
    - JSONMessage -> JSONMessageCreator
    - TextMessage -> TextMessageCreator


#### Prototype Design Pattern :
- We have a complex object that is costly to create.
- To create more instances of such classes, we can use existing instances as our prototype.
- Prototype allows us to clone existing objects, and hence saves cost of creating such objects again.

![github-small](images/prototype_one.png)

#### Steps :
- A class implementing Cloneable interface.
- Class should override clone() and return copy of itself.
- The method should declare CloneNotSupportedException.
- Clone method implementation should consider the deep & shallow copy and choose whichever is applicable.

![github-small](images/prototype_second.png)

#### Considerations :
- Making sure deep copy & shallow copy of references, immutable fields on clones should save the trouble of deep copy.
- Making sure to reset the state of object before returning its prototype.
- clone() method is protected in Object class and must be overridden to be public to be callable from child class.
- Cloneable is a marker interface, an indication that the class supports cloning.

#### Design Considerations :
- Prototypes are useful when you have large objects where majority of state is unchanged between instances and you can easily identify the state.
- A prototype registry is a class where you can register various prototypes which other code can access to clone out instances. This solves the issue of getting access to initial instance.

#### Example :
- Object.clone() itself is an example of Prototype.

#### Comparison with Singleton :

![github-small](images/prototype_third.png)

#### Pitfalls :
- Deep copy is by default not supported by Object.clone(), you have to implement it.
- Subclasses may not be able to support clone and so the code becomes complicated as you have to implement wherever it is not supported.

#### Summary :
- Think of prototype when object construction is costly or not possible.
- In Java, its typically implemented within clone().
- Objects which have majority of fields as immutable are good candidates for prototypes.
- Whenever implementing clone(), pay attention to the choice of shallow & deep copy.

#### Abstract Factory Design Pattern :

![github-small](images/abstract-factory-one.png)

- Abstract Factory makes use of factory method pattern.
- You can think of AF as an object with multiple factory methods.

![github-small](images/abstract-factory-two.png)

#### Implementation Considerations :
- Factories can be singleton, we typically ever need only one instance of it anyway.
- Adding a new product type requries changes to the base factory as well as implementation of factory.
- We provide the client code with concrete factory.
- Abstract Factory itself uses factory method pattern.
- If objects are too expensive to create, then you can transparently switch factory implementations to use prototype design pattern to create objects.

![github-small](images/abstract-factory-three.png)

#### Pitfalls :
- Complex to implement than factory method.
- Adding a product requires changes to all the factory implementations.
- Difficult to visualize the need at start of development and usually starts as factory method.
- Abstract factory design pattern is very specific to the problem of "product families".

#### Singleton Design Pattern :
- A class that has only one instance, accessible globally through a single point.
- Main problem this DP solves is to ensure only a single instance of class exist.
- Any state you add in singleton becomes part of "global state" of your application.
- Singleton pattern is used for logging, drivers objects, caching, and thread pool.
- Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade, etc.

#### Types of Singleton :
* Eager Initialization
* Lazy Initialization
* Static Block Initialization
* Thread Safe Singleton
* Bill Pugh Singleton
* Using Reflection to destroy Singleton
* Enum Singleton
* Serialization & Singleton

#### Example :
- Singleton design pattern is used in core Java classes also (for example, java.lang.Runtime, java.awt.Desktop).

#### Considerations :
- Always go for eager/lazy singleton approaches, as its the best and preferred way.
- The "classic" singleton pattern uses double check locking and volatile field.
- Singleton creation doesn't need any parameters. If you find yourself in need of support for constructor arguments, you simply need a factory method or simple factory design pattern.

#### Comparison with Factory Method Pattern :

![github-small](images/singleton-one.png)

#### Pitfalls :
- Singletons can be difficult to extend or modify later on, especially if they are used extensively throughout your codebase. Changing the behavior of a singleton often requires modifying its implementation directly, which can lead to ripple effects throughout your code.

- Since singletons often rely on static methods or global accessors to retrieve the instance, it can be difficult to mock or stub the singleton instance during testing. This can make unit testing more challenging and can lead to tests that are tightly coupled to the singleton implementation.

- Using singletons can hide dependencies between different components of your application. This can make it harder to understand the relationships between different parts of your code and can lead to tightly coupled and difficult to maintain code.

#### Object Pool Design Pattern :
- If cost of creating an instance is very high and we need a large number of such objects of this class for short duration, then we can use object pool.
- Here, either we pre-create objects of the class or collect unused instances in an in-memory cache.
- It is one of the most complicated patterns to implement efficiently.

![github-small](images/object-pool-one.png)

#### Implementation :
- A class shall be created with following considerations :
    * A thread safe caching of objects should be done in pool.
    * Methods to release & acquire of objects should be provided.
    * Pool should reset cached objects before giving them out.
    * The pooled objects should provide methods to reset its state upon "release" by code.
    * Decision - Whether to create new objects for pool when pool is empty or wait until an object becomes available.

#### Design Considerations :
- Resetting objects in pool should not be costly otherwise we may end up losing performance of our application.
- Pre-caching objects could provide add-up benefit.
- Object pool's synchronization should consider the reset time needed & avoid resetting in synchronized context if possible.

#### Example :
- java.util.concurrent.ThreadPoolExecutor used for pooling threads. Its often used via ExecutorService interface using methods like newCachedThreadPool().

- Example :: ExecutorService service = Executors.newCachedThreadPool();

- Apache commons dbcp is used for db connection pooling. BasicDataSource in dbcp package uses this DP to pool db connection objects.

#### Comparison with Prototype :

![github-small](images/object-pool-two.png)

### Structural Design Patterns
- Structural patterns deals with how objects and classes are composed & arranged.

#### Adapter Design Pattern :
- We have an existing object which provides functionality that client needs.
- But client code can't use this object because it expects an object with different interface.
- Using adapter DP, we make this existing object work with client by adapting the object to client's expected interface.
- This pattern is also called as wrapper as it wraps the existing objects.
- Types : [Class Adapter, Object Adapter]

![github-small](images/adapter-one.png)

#### Implementation :

![github-small](images/adapter-two.png)

![github-small](images/adapter-three.png)

#### Scenario :
- Employee (existing class) -> Customer (used by client code to design business cards).
- To convert employee to customer, we need an adapter, which uses Employee's information and convert it to Customer.

#### Implementation Considerations :
- How much work the adapter does, depends upon the differences between target interface & object being adapted.
- If method arguments & parameters are same, the amount of work done by adapter will also be less.
- Fixing defects in case of adapters is difficult, so keeping method delegations simple is a way to win.

#### Example :
- java.io.InputStreamReader & java.io.OutputStreamWriter are examples of object adapters.
- These classes adapt existing InputStream / OutputStream object to Reader / Writer interfaces.

#### Comparison with Decorator :

![github-small](images/adapter-four.png)

#### Pitfalls :
- Complexity: Introducing adapters can sometimes add complexity to the codebase, especially if multiple adapters are used to adapt different interfaces.

- Overuse: It's possible to overuse the Adapter pattern, especially in cases where a simpler solution might suffice. This can lead to unnecessary abstraction layers and decreased code readability.

- Performance Overhead: Depending on the implementation, using adapters might introduce a performance overhead, especially if the adaptation process involves heavy transformations or computations.

- Tight Coupling: If not designed carefully, adapters can lead to tight coupling between components, making the codebase less flexible and harder to maintain.

#### Difference between Class Adapter & Object Adapter :

* Object Adapter:

Composition: In the Object Adapter pattern, the adapter contains an instance of the adaptee class. It uses this instance to perform the necessary adaptation.

Flexibility: Object Adapter is more flexible than the Class Adapter because it allows adapting subclasses of the adaptee and multiple adaptee classes through polymorphism.

Ease of Use: It's easier to implement Object Adapter as it doesn't rely on multiple inheritance or interface implementation, making it suitable for languages like Java that do not support multiple inheritance.

Example: In Java, you might have an interface Target that your client expects to use. The Adapter class would implement this Target interface and contain an instance of the Adaptee class. It delegates the requests from the client to the Adaptee instance, adapting them as necessary.

* Class Adapter:

Inheritance: In the Class Adapter pattern, the adapter inherits from both the target interface and the adaptee class.

Multiple Inheritance: Class Adapter relies on multiple inheritance, which is not supported in languages like Java (though it can be emulated with interfaces and delegation).

Limitations: Due to the use of multiple inheritance or interfaces with delegation, the Class Adapter might be less flexible and more complex than the Object Adapter.

Example: In Java, the Adapter class would extend the Adaptee class and implement the Target interface. It overrides or extends methods from the Adaptee class to adapt them to the interface expected by the client.

#### Bridge Design Pattern :
- Our implementation class & its abstraction are generally coupled to each other in normal inheritance.
- Using bridge pattern, we decouple them so they can change without affecting each other.
- We achieve this by creating two separate inheritance heirarchies, one for implementation and another for abstraction.
- We use composition to bridge these heirarchies.

#### Implementation :
- Determine common operations and define them in abstraction.
- Define our implementor, implementor methods do not have to match with abstractor methods.
- Then we write one or more implementors providing implementations.
- Abstraction can carry out its work by using implementor methods.

- Note : Abstractions are created by composing them with an instance of concrete implementor (used by methods in abstractor).

#### UML :

![github-small](images/bridge-one.png)

#### Implementation Considerations :
- In case, we are gonna have single implementor (for example : SinglyLinkedList), then we can skip creating abstract implementor.
- Abstractor gives decouple feeling, as it do not know which implementor client is referring.

#### Design Considerations :
- Bridge design pattern gives great flexibility to change abstraction & implementation separately, you can package & build them separately to modularize overall system.
- We can also make use of abstract factory design pattern to create abstraction objects with correct implementation, you can decouple concrete implementors from abstraction.

#### Example :
- java.sql.DriverManager class with java.sql.Driver interface forms a bridge pattern.
- The actual implementation for Driver class defers to the use of databases (Driver, OracleDriver).
- Collections.newSetFromMap() method returns a set which is backed from a given map.

#### Comparison with Bridge Design Pattern :

![github-small](images/bridge-two.png)

#### Pitfalls :
- Fairly complex to understand.
- Need to have a well thought & fairly comprehensive design in front of you before you can decide on bridge pattern.
- Needs to be designed upfront, adding bridge to the legacy code is difficult. Even for ongoing project, adding bridge later in time may require fair amount of rework.

#### Decorator Design Pattern :
- When we want to enhance behaviour of our existing object dynamically, then we use decorator design pattern.
- Decorator wraps an object within itself, provides the same interface as wrapped object, so the client code of original object does not need to change.
- An alternative to subclassing, making existing classes extend their functionalities.

#### Implementation Steps :
- Start with Component (any interface).
- Component defines interface that is already being used by Client.
- We define our Decorator. Decorator implements Component & also needs reference to Concrete Component.
- In Decorator methods, we provide additional behaviour on top of that provided by Concrete Component interface.
- Decorator can be abstract as well, depending on subclasses to provide functionality.

#### UML :

![github-small](images/decorator-one.png)

#### Implementation & Design Considerations :
- Pay attention to hashCode() and equals() as you have to decide if object is equal to same instance with decorator.
- Decorators support recursive composition, and so this pattern leads to creation of lots of small objects that leads "small functionalities". This becomes difficult to debug after certain extent.
- Decorators are more flexible and powerful than inheritance. Inheritance are static by definition but decorators allows you to dynamically compose behaviours at runtime.
- Decorators should act like additional skin to your object, They should add helpful small behaviours to object's original behaviour. Do not change meaning of operations.

#### Example :
- java.io package is great example of decorator pattern.
- BufferedOutputStream decorates java.io.OutputStream object. 
- To the existing OutputStream object, BufferedOutputStream object adds additional buffering capability to file writing operation, thus improving the disk i/o performance by reducing the number of writes.

#### Comparison with Composite :

![github-small](images/decorator-two.png)

### Behavioural Design Patterns