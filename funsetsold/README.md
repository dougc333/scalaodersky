solutions for week 2 funsets

1) this assignment introduces the functional type which is written in the form (x)=>(y) where => represents a function. 
There is confusion in this topic relating to the different domain models, a programming model and a math model relating to first order logic. 
In first order logic we have existential quantifiers which refer to a universe and you create proofs to form statements about this universe. In the programming model we refer to basic types like Ints. We are trying to blend a math model to a programming model where the universe is some native type like Ints. 

2) Start with a small set, print out the set, apply a functional type to the set and verify you get expected behavior
Add more unit tests and write test cases, the hw does not include a complete list of tests

exists/foreach use function currying and an internal tail recursive function to minimize code duplication. This is not in the current version

3) map returns a new Set, a function type does not modify the elements in place


