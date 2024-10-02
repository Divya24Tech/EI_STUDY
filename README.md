# EI_STUDY

## Behavioural design pattern

Use Case 1: Event Notification System
Observer Pattern: Users subscribe to different events (e.g., product launches, and system updates) and get notified when those events occur.
Strategy Pattern: The system uses different notification strategies (SMS, Email, Push) to send notifications based on the user’s preferred communication channel.


Use Case 2: Task Management System
Command Pattern: Users (managers, supervisors, employees) can assign tasks to the system processes based on their roles.
Chain of Responsibility Pattern: The system will delegate tasks to the appropriate department (IT, HR, Admin) based on the user’s role and permissions. If one department cannot handle the task, it passes it to the next one in the chain.


## Creational design pattern

Use Case 1: Document Generation System
This system allows users to generate different types of documents (e.g., PDF, Word) and manage document templates. The creational design patterns demonstrated here are Factory Method and Singleton.

Creational Design Patterns:
Factory Method: Dynamically creates different types of documents (PDF, Word, etc.) based on user input.
Singleton: Ensures that only one instance of the TemplateManager exists to handle document templates.


Use Case 2: Car Rental System
In this system, customers can rent different types of cars (e.g., SUVs, Sedans), and the system maintains a pool of frequently requested cars to optimize resource management. The creational design patterns used here are Abstract Factory and Object Pool.

Creational Design Patterns:
Abstract Factory: Allows the creation of different families of cars (SUV, Sedan) and their features.
Object Pool: Manages a pool of cars that are frequently requested, avoiding creating and destroying car objects repeatedly.




## Structural design pattern

Use Case 1: Media Player System
This system allows users to play different types of media (e.g., MP4, VLC). The structural design patterns demonstrated are Adapter and Decorator.

Structural Design Patterns:
Adapter: Allows the MediaPlayer interface to adapt different types of media players (e.g., VLCPlayer, MP4Player) into a single interface.
Decorator: Extends the functionality of a media player by adding features such as logging and buffering, without modifying the original media player classes.


Use Case 2: E-Commerce Discount System
This system allows users to apply different discounts to their cart (e.g., seasonal, loyalty), and it also enables combining multiple discounts. The structural design patterns demonstrated are Composite and Bridge.

Structural Design Patterns:
Composite: Combines multiple discount types, allowing for hierarchical combinations of discounts (e.g., seasonal + loyalty).
Bridge: Decouples the abstraction of the discount from its implementation, enabling different discount structures to work independently.
