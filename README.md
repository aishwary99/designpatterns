## SOLID + Design Patterns

### SOLID -

#### Single Responsibility Principle : 
There should never be more than one reason for a class to change.

It means ->
    1. Focus single functionality.
    2. Address a specific concern.

Example :
    1. Protocol Change
    2. Message Format Change
    3. Communication Security Change such as Authentication Introduced


#### Open Closed Principle : 
- Classes should be open for extension, but closed for modification (in order to avoid potential bugs).
- Avoid modifying base classes and with the help of inheritance, override the existing functionalities from the base class in order to achieve extension.

Note : Its purely based on the inheritance.

Idea : 
- Carry out all the common functionalities from sub-classes.
- Create one abstract class / interface (based on the requirement).
- Put all the common functionalities in abstract class / interface.
- Inherit the functionalities and provide implementation in child-classes.

#### Liskov Substitution Principle :
- It states that the objects of base class should be substitutable / replaceable with objects of its subclasses without breaking the application.

Consider a Shape interface with a method getArea() that calculates the area of the shape. Now, we have two classes: Rectangle and Square, both implementing the Shape interface.

```
interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }
}

```

According to LSP, we should be able to substitute an object of the superclass (Shape) with an object of any of its subclasses (Rectangle or Square) without breaking the program's functionality.

However, if we violate LSP by making Square a subclass of Rectangle, problems can arise. Suppose Rectangle has a method setWidth() and setHeight() to modify its dimensions. In a Rectangle, you can set its width and height independently. But in a Square, since all sides must be equal, setting the width should also automatically set the height and vice versa to maintain the square's properties.

```

class Rectangle implements Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    // Square should not have setWidth and setHeight methods
}


```

In this case, substituting a Rectangle with a Square can lead to unexpected behavior. If you try to set the width of a Square, it should also adjust the height to maintain the square's properties. But in the context of the Rectangle class, this behavior doesn't hold, violating the LSP.

To adhere to LSP, it's better to have Rectangle and Square as separate classes, both implementing the Shape interface, without any inheritance relationship between them. This way, substituting one for the other won't cause unexpected behavior.

#### Interface Segregation Principle :
- Clients should not be forced to be dependent upon interfaces they don't use.
- This is also termed as "Interface Pollution".
- Issues -
        : Large Interfaces
        : Unrelated Methods

- Sign of polluted interface -
        - Classes have empty method implementations.
        - Method implementations throw UnsupportedOperationException.
        - Method implementations return null or default / dummy values.

- This principle says -
    - Write cohesive interfaces.

- Example :
    - Segregating common behaviour of a persistence service.
    - Applying individual implementations by overriding persistence service functionalities in UserPersistenceService & OrderPersistenceService.
    - This way, all the common functionalities are carried out from concrete classes and via the interface, its given as a guideline.


#### Dependency Inversion Principle :
It's based on two rules -
- High level modules should not depend on low level modules, both should depend on abstractions.
- Abstractions should not depend upon details, details should depend upon abstractions.

- Dependency :
```
public void writeReport() {
    Report report = new Report();

    // build the report in json format
    JSONFormatter jsonFormatter = new JSONFormatter();
    String reportInJSON = jsonFormatter.format(report);

    // write the json string in file
    FileWriter fileWriter = new FileWriter("report.json");
    fileWritter.write(reportInJSON);
}
```
In the above example, jsonFormatter & fileWriter are the key dependencies of writeReport().

- Dependency Inversion :
Instead of instantiating dependencies ourselves, let somebody give us the dependencies and we shall use it in our functionality.

```
public void writeReport(Formatter formatter, Writer writer) {
    Report report = new Report();

    // build the report in json format
    String reportInJSON = formatter.format(report);

    // write the json string in file
    writer.write(reportInJSON);
}
```
In the above example, the provider can decide upon what formatter & writer to use and our shell function (core logic) will continue to implement the same functionality.

This way we have inverted the dependency to the caller.