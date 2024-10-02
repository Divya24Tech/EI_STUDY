# EI_STUDY

## Behavioural Design Patterns

### Use Case 1: Event Notification System
- **Observer Pattern**: Users subscribe to different events (e.g., product launches, system updates) and get notified when those events occur.
- **Strategy Pattern**: The system uses different notification strategies (SMS, Email, Push) to send notifications based on the user’s preferred communication channel.

### Use Case 2: Task Management System
- **Command Pattern**: Users (managers, supervisors, employees) can assign tasks to the system processes based on their roles.
- **Chain of Responsibility Pattern**: The system will delegate tasks to the appropriate department (IT, HR, Admin) based on the user’s role and permissions. If one department cannot handle the task, it passes it to the next one in the chain.

---

## Creational Design Patterns

### Use Case 1: Document Generation System
- **Factory Method**: Dynamically creates different types of documents (PDF, Word, etc.) based on user input.
- **Singleton**: Ensures that only one instance of the `TemplateManager` exists to handle document templates.

### Use Case 2: Car Rental System
- **Abstract Factory**: Allows the creation of different families of cars (SUV, Sedan) and their features.
- **Object Pool**: Manages a pool of cars that are frequently requested, avoiding creating and destroying car objects repeatedly.

---

## Structural Design Patterns

### Use Case 1: Media Player System
- **Adapter**: Allows the `MediaPlayer` interface to adapt different types of media players (e.g., VLCPlayer, MP4Player) into a single interface.
- **Decorator**: Extends the functionality of a media player by adding features such as logging and buffering, without modifying the original media player classes.

### Use Case 2: E-Commerce Discount System
- **Composite**: Combines multiple discount types, allowing for hierarchical combinations of discounts (e.g., seasonal + loyalty).
- **Bridge**: Decouples the abstraction of the discount from its implementation, enabling different discount structures to work independently.
