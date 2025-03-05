Property-based testing shines in specific scenarios that traditional example-based testing may not handle as effectively. Here are the situations where property-based testing is particularly valuable:

### When to Use Property-Based Tests

1. **Testing Pure Functions**
    - Functions that give the same output for the same input with no side effects
    - Example: Mathematical operations, string manipulations, data transformations

2. **Testing Invariants and Business Rules**
    - When you have rules that should always be true regardless of input
    - Example: "Age must always be between 19-64" or "After a fund transfer, total money in the system remains the same"

3. **Complex Input Domains**
    - When your function can accept many possible inputs with different edge cases
    - Example: Date/time calculations, pricing algorithms, text parsers

4. **Data Structure Operations**
    - When testing operations on collections, trees, graphs
    - Example: "After adding an element to a sorted list, the list should remain sorted"

5. **Bidirectional Operations**
    - When testing operations that should cancel each other out
    - Example: "Serializing and then deserializing should return the original object"

6. **Discovering Edge Cases**
    - When you want to find bugs you didn't anticipate
    - Example: Boundary conditions, integer overflow, special character handling

7. **Testing Commutative or Associative Properties**
    - When order shouldn't matter for an operation
    - Example: "Adding items to a set in different orders should produce the same set"

### Practical Examples in Java

```java
// Example: A property test for a sort function
@Property
void sortedListIsAlwaysSorted(@ForAll List<Integer> numbers) {
    List<Integer> sorted = MySort.sort(numbers);
    for (int i = 0; i < sorted.size() - 1; i++) {
        Assertions.assertThat(sorted.get(i) <= sorted.get(i + 1))
            .isTrue();
    }
}

// Example: Bidirectional property for Base64 encoding
@Property
void base64EncodingIsReversible(@ForAll byte[] data) {
    byte[] encoded = Base64.encode(data);
    byte[] decoded = Base64.decode(encoded);
    Assertions.assertThat(decoded).isEqualTo(data);
}
```

### When NOT to Use Property-Based Tests

1. **UI Testing**: Visual components are hard to verify with properties
2. **Integration Testing**: When many dependencies are involved
3. **Performance Testing**: When timing matters more than correctness
4. **Simple Functions**: When a few examples suffice and properties are hard to define
5. **Stateful Systems**: When the test outcome depends on complex state

Property tests complement example-based tests rather than replace them. A balanced approach often works best: use example tests for simple cases and edge cases you've identified, and property tests to explore the input space more broadly and verify invariants.

Remember that defining good properties requires deeper thinking about your requirements, but the investment pays off by providing more thorough testing and clearer specification of system behavior.