# Spring-Fatecha
## Project Configuration
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/app.PNG)

## · Action Context
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/context.PNG) ![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/context2.PNG)
 This class defines the way in which we will obtain access to the context of our application
### Variables

  - `private final ApplicationContext appContext;`
 This gives us context of the application provided by Spring
 This interface provides us with access to defined beans, publishing and listening to events, access to internationalized messages, access to resources, configuration inheritance, and bean lifetime.

 - `private Action principal`
 This object is responsible for representing the information of the user who performs an action.

### Methods
 - `public <T> T getService(Class<T> serviceClass)`
 This method uses the Spring context to get a service bean of the specified type.
 - `public PersistenceManager getPersistences()`
 This method creates and returns a new PersistenceManager using the current context.

## · Abstract Action
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractAction.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractAction2.PNG)

This class is generic and has two types of parameters: 'A' and 'R'
### Variables
 - `private ActionContext context`: A context for the action.
 - `private A argument`: A generic argument of type A.
 - `private R result`: A generic result of type R.
### Methods
 - `public void perform()`: This appears to be the main execute method that performs the action. Within this method, three other methods are invoked.
 - `checkArgument()`: Possibly used to validate the argument before executing the action.
 - `doAction()`: This is where the main action would be performed. For now, it is empty and appears to be expected to be implemented by subclasses.
 - `setResultOnly()`: Set the result after performing the action.

## · Action Principal
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/actionPrinpical.PNG)
Identity or principal of a user or actor in the system. Contains information about the user, such as username, email, roles, and other relevant details.
### Variables
 - `private String autToken`: Appears to be an authentication token.
 - `private String username`: Username.
 - `private String name`: Full name or display name.
 - `private String description`: Description of the principal.
 - `private String email`: Email address.
 - `private boolean emailVerified`: Indicates whether the email has been verified.
 - `private List<String> roles`: A list of roles associated with this principal.
 - `private boolean anonymous`: Indicates whether the principal is anonymous.
 - `private String userId`: A user ID, possibly used in Keycloak for sending verification emails.

### Methods
`public static ActionPrincipal newAnonymous()`: It is a factory method that creates and returns an anonymous instance of ActionPrincipal.

## Actions
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/actions.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/actions2.PNG)
Utility class that provides static methods for creating and executing actions. These methods simplify the creation of contexts and actions and the execution of these actions.

- Use ActionContext to create contexts that are passed to actions.
- It uses AbstractAction as a base class for the actions it creates and executes.
- You can optionally use ActionPrincipal to set the principal or identity associated with an action.

### Methods

 - `public static ActionContext newContext(ApplicationContext appCtxt)`: Creates and returns a new ActionContext using the provided ApplicationContext.  
 - `public static ActionContext newContext(ApplicationContext appCtxt, ActionPrincipal main)`: Creates and returns a new ActionContext using the provided ApplicationContext and ActionPrincipal. 
 - `public static <A extends AbstractAction> A newAction(Class<A> aClass, ApplicationContext appCtxt)`: Creates and returns a new action of the specified type using the provided ApplicationContext. 
 - `public static <A extends AbstractAction> A newAction(Class<A> aClass, ActionContext ac)`: Creates and returns a new action of the specified type using the provided ActionContext. 
 - `public static <A extends AbstractAction, P> A perform(Class<A> aClass, ApplicationContext appCtxt, P argument)`: Executes an action of the specified type using the provided ApplicationContext and argument. 
 - `public static <A extends AbstractAction, P> A perform(Class<A> aClass, ActionContext ac, P argument)`: Performs an action of the specified type using the provided ActionContext and argument.

## Abstract Endpoint
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/configEndpoint.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractEndpoint.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractEndpoint2.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractEndpoint3.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractEndpoint4.PNG)
Base class for endpoints in a Spring application. Provides utility methods to handle actions and return responses. Concrete subclasses will likely implement specific endpoints and use these utility methods to handle actions and return responses.

### Variables

- `private static final Logger logger`: A logger to log messages.
- `protected ApplicationContext appContext`: An application context provided by Spring.

### Methods

 - `protected <A extends AbstractAction, T> ResponseEntity handle(Class<A> actionClass, T arg)`: A method to handle actions. Performs an action and returns a response based on the result of the action.
 - `protected ActionContext actionContext()`: Creates and returns a new ActionContext using the injected ApplicationContext.
 - `protected <T> ResponseEntity responseOk(T body)`: Creates and returns a successful response with the given body.
 - `protected <T> ResponseEntity responseError(Throwable t)`: Creates and returns an error response based on the provided exception.

## Persistence
## Abstract Persistence
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/modelsConfig.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/abstractPersistence.PNG)
Base class for persistence operations in the application. Provides a context for action and a way to access services through that context. Concrete subclasses will likely implement specific operations related to the database or other data sources.

### Variables
- `private ActionContext ac`: An action context.

### Methods
 - `public ActionContext getActionContext()`: Returns the associated action context.
 - `protected <T> T getService(Class<T> tClass)`: A method that uses the action context to get a service of the specified type.

## Persistence Manager 
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/persistenceManager.PNG)
Utility class that facilitates access to different persistence classes in the application. In this case, it provides access to Ztest-related persistence.

### Variables
 - `private ActionContext ac`: An action context.

### Methods
 - `public ZtestPersistence getZtestPersistence()`: `Returns a new instance of ZtestPersistence using the associated action context.

## App Constants
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/appError.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/appConstants.PNG)
Utility class that provides global constants for the application. Constants are values that do not change and are used throughout the application to ensure consistency.

### Variables
 - `APP_CODE`: It is an integer constant with the value 0.
 - `APP_NAME`: It is a constant of type String with the value "project".
 - `MOD_TEST_CODE`: It is an integer constant with the value 90000.

## App Errors
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/appErrors.PNG)
The values listed represent different types of errors. Each one has an associated code that is passed as an argument to the enumeration constructor.

### Variables

 - `none(0)`: No error.
 - `unknown(1)`: Unknown error.
 - `private final int code`: This variable stores the error code. It is a final private variable, which means it cannot be modified after initialization.

### Methods
 
 - `AppErrors(int code)`: This is the constructor of the enumeration. Takes a code as an argument and adds it to the APP_CODE of AppConstants to initialize the code variable.
 - `getCode()`: This method returns the error code.
 - `getName()`: This method returns the name of the error, which is the name of the enumeration.

The AppErrors enumeration implements the ExceptionPrototype interface, which means that it must provide implementations for the methods defined in that interface. In this case, the getCode() and getName() methods are the required implementations.
The enumeration also references the AppConstants class to get the value of APP_CODE.
In short, AppErrors provides a standardized way to represent and handle errors in your application using error codes and friendly names.

## Validation Configuration
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/lib.PNG)
## CLT Exception
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/cltException.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/cltException2.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/cltException3.PNG)
Is a custom exception

### Variables

 - `code (int type)`: Appears to represent an error code, with a default value of 1.
 - `name (type String)`: A name for the exception, with a default value of "unknown".
 - `extra (type Map<String, ?>)`: This appears to be a map that could contain additional information related to the exception.

### Methods

 - `getCode()`: Returns the value of the code variable.
 - `getName()`: Returns the value of the name variable.
 - `getExtra()`: Returns the value of the extra variable.
 - `setExtra(Map<String, ?> extra)`: Sets the value of the extra variable.

### Constructors

 - Constructor that takes a Throwable called cause.
 - Constructor that takes an ExceptionPrototype called proto and a String called msg.
 - Constructor that takes an ExceptionPrototype called proto, a String called msg, and a Throwable called cause.
 - Constructor that takes an int called code and a String called name.
 - Constructor that takes an int called code, a String called name and a String called msg.
 - Constructor that takes an int called code, a String called name, a String called msg, and a Throwable called cause.

## Exception Prototype
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/exceptionPrototype.PNG)
Define a prototype or contract for exceptions, to ensure that any custom exception implements certain methods that return a code and a name.

### Methods

 - `getCode()`: This method should return a value of type int, which represents an error code.
 - `getName()`: This method should return a value of type String, which represents the name of the exception. 

## Thrower
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/thrower.PNG)
Make it easy to throw these custom exceptions by providing several static methods with different argument combinations.

### Methods

 - `throwException(ExceptionPrototype proto)`: Throws a CLTException using only an exception prototype.
 - `throwException(ExceptionPrototype proto, String msg)`: Throws a CLTException using an exception prototype and a message.
 - `throwException(ExceptionPrototype proto, String msg, Throwable cause)`: Throws a CLTException using an exception prototype, a message, and a cause.
 - `throwException(ExceptionPrototype proto, String msg, Throwable cause, Map extra)`: Throws a CLTException using an exception prototype, a message, a cause, and a map of additional information.

## V
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/v.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/v2.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/v3.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/v4.PNG)
Validation tool that provides several static methods to check common conditions and, if met, throw custom exceptions.

### Methods

 - `ifTrue(boolean o, ExceptionPrototype proto)`: Throws an exception if the given condition (a boolean value) is true.
 - `ifFalse(boolean o, ExceptionPrototype proto)`: Throws an exception if the given condition (a boolean value) is false.
 - `ifNull(Object o, ExceptionPrototype proto)`: Throws an exception if the given object is null.
 - `ifNotNull(Object o, ExceptionPrototype proto)`: Throws an exception if the given object is not null.
 - `ifEmpty(Object o, ExceptionPrototype proto)`: Throws an exception if the given object is null, an empty string, or an empty collection.
 - `ifNotEmpty(Object o, ExceptionPrototype proto)`: Throws an exception if the given object is not null and is not an empty string or collection.
 - `isNull(Object o)`: Returns true if the given object is null, otherwise returns false.
 - `isEmpty(Object o)`: Returns true if the given object is null, an empty string, or an empty collection, otherwise returns false.

## How to use Configuration / MOD
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/mod.PNG)

First of all, define our enums for errors in this module.
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestConstants.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestErrors.PNG)

Then `ZtestConstants` should go to the global error handling module, which is the `AppConstants`
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/appConstantsZtest.PNG)

We then define our entity to be mapped to the database.
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestEntity.PNG)

We then create the repository for the entity, making it extend `JPArepostory`
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestRepo.PNG)

We create the service for the repository where we will call the methods generated by JPA or by our specific queries.
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestService.PNG)

We create a persistence for the `Ztest` module where all the services of that module will go. Making it extend `AbstractPersistence` to be able to use getService
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestPersistence.PNG)

Said persistence of that module must be called in the global persistence manager of our Persistence Managet project
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestPersistenceGlobal.PNG)

We begin to give logic and validation to what we want to do, we create the Argument of the Action that we will execute

![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestActions.PNG)

#### Argument
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestArgument.PNG)

In the Argument we only define those variables to be used in the action

#### Action
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestAction.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestAction2.PNG)

The action extends the `AbstractAction`, which I mean that we can use the context of our project, and thus also the global persistence and other global modules to be added in the context
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestActionAbs.PNG)

Here we also see that we give the argument of the action and result that waits to be shown

We define our variable and bring those methods of the `AbstractAction`
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestActionAbs2.PNG)

#### checkArgument
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/checkArgument.PNG)

Here we handle errors that are expected before any action logic is executed.
As you can see, we used the ztest module enum and the `V` tool that was configured to wait for the expected error enum argument.

#### doAction
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/doAction.PNG)

here those methods to be executed and controlled in the Action will be called
Only the methods should be called, refrain from adding too much logic since that is another section of the doAction

#### setResutlOnly
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/setResultOnly.PNG)

In this section we only wait for the result of the Action once it has passed to the checkArgument and the doAction
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestActionAbs.PNG)

and the result is expected, once it is extended to the AbstractAction in the Action the argument and the expected result are already declared

#### internals
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestActionAbs3.PNG)
This is the place where all the logic should go in methods to be executed and it is only called in the doAction
Here we also see how the context is called, then the global persistence followed by the persistence of the module that you want to call and the service
Then return or use the method of the service you want to use

#### Finally we reach the controller or the endpoint
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestEndpointAbs.PNG)
![](https://github.com/Ernestolop/spring-doc/blob/master/readmeImg/ztestEndpoint.PNG)
First of all we see that the class extends AbstractEndpoint
to be able to use the method which we can use the argument and the action


## You are now ready to use the Spring-Fatecha, Let's Get it Started!



