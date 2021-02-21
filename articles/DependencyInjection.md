Objects which we have in our software application depends on other objects. This is called a Dependency. For ex.
class Laptop{
 Hardrive obj1;
 Ram obj2;
}

Dependency Injection mainly helps in reducing the coupling between components. It also helps in testing. Like injecting mock objects to unit test the component which we are testing.
If there is tight coupling then its difficult to test our component without touching various parts of dependencies.

When we make a laptop object we want to provide it with dependencies like harddrive and ram. Now these har drives and ram could be coming from different companies.
One way to create laptop is initiate the dependencies in laptop's constructor. But then it is too tight coupling. If you want to change hard drive or ram you need to
change you code. Now here comes the dependency injection. If there is some external service which injects the dependencies like dependency injection containers which 
create the object and inject those into our service classes.

There are various frameworks which have dependency injection systems embedded in them. Spring achieves this using the xml configurations of mapping the dependencies. 
We also have spring boot which eliminates the need of xml configurations as well. 
