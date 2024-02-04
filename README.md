## SOLID + Design Patterns

### SOLID -

#### Single Responsibility Principle : There should never be more than one reason for a class to change.

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

