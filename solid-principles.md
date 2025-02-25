# SOLID Principles

## S - Single Responsibility Principle

**A class should have only one reason to change**

![SRP](https://miro.medium.com/max/720/1*P3oONz9Da3Tc1w97fMV73Q.webp)

**Key Points:**
- Each class should focus on doing one thing well
- "One reason to change" means one responsibility
- Makes code more maintainable and easier to understand
- Promotes high cohesion

**Example:** A Report class should not handle both report generation and database access.

**Benefits:**
- Easier testing
- Simplified maintenance
- Reduced coupling

---

## O - Open/Closed Principle

**Software entities should be open for extension but closed for modification**

![OCP](https://miro.medium.com/max/720/1*0MtFBmm6L2WVM04qCJOZPQ.webp)

**Key Points:**
- Extend functionality by adding new code, not by changing existing code
- Achieved through abstractions and polymorphism
- Changes should require the extension of abstractions, not modification

**Example:** Create a PaymentProcessor interface and implement new payment methods without changing existing code.

**Benefits:**
- Reduces risk when making changes
- Promotes code reuse
- Establishes stable abstractions

---

## L - Liskov Substitution Principle

**Subtypes must be substitutable for their base types**

![LSP](https://miro.medium.com/max/720/1*yKk2XKJaCLNlDxQMx1r55Q.webp)

**Key Points:**
- Derived classes must be usable through the base class interface
- Subclasses should extend without replacing base class behavior
- Ensures "is-a" relationships are truly valid

**Example:** If your code works with birds that can fly, a penguin subclass (which can't fly) would violate LSP.

**Benefits:**
- Improves code reusability
- Makes hierarchies more intuitive
- Prevents unexpected behavior

---

## I - Interface Segregation Principle

**Clients should not be forced to depend on methods they do not use**

![ISP](https://miro.medium.com/max/720/1*2hmyR9L43Vm64MYxj4Y89w.webp)

**Key Points:**
- Keep interfaces small, focused, and specific
- Better to have many specific interfaces than one general-purpose interface
- Prevents classes from implementing unnecessary methods

**Example:** Split a large Worker interface into specialized Workable and Eatable interfaces.

**Benefits:**
- Reduces impact of changes
- Creates more focused designs
- Makes implementations simpler

---

## D - Dependency Inversion Principle

**High-level modules should not depend on low-level modules. Both should depend on abstractions.**

![DIP](/api/placeholder/720/400)

**Key Points:**
- Depend on abstractions, not concretions
- Abstractions should not depend on details
- Details should depend on abstractions
- Often implemented through dependency injection

**Example:** NotificationService depends on MessageSender interface, not directly on EmailSender.

**Benefits:**
- Decouples components
- Facilitates testing through mocking
- Makes systems more flexible