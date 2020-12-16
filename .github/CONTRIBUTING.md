## Contributing Guidelines
If you have any data strucutres or algorithms you want to add to the library, feel free to open a pull request! Please make sure you follow the guidelines below.

### General Guidelines
* Check to see if a data structure or algorithm is on the list to be implemented. Those will be given priorities on merge.
* Comment your code thoroughly, this is meant to be a teaching tool and resource so it should be human readable.
* Make sure function and variable names are human readable and have meaningful names. Nobody likes to see functions with names like 'a1' or 'a2'!
* Please write a simple test for your commit in the appropriate test files (`AlgorithmsTest.java` and `DataStructuresTest.java`).

### Specific Guidelines
For data strucutre contributions:
* When contributing a data structure, make sure it already hasn't been comitted already in the form you're attempting to add. 
* Try to work in generics as often as possible.
  * For data structures that are sorted (AVL trees, sorted array lists, etc.) use an integer key and generics for the stored data.
  * For data structures that involve hashing, use a `string` key with a generic for the stored data.
  
For algorithm contributions:
* When contributing an algorithm, make sure it hasn't already been commited already in the form you're attempting to add.
* Try to keep your code reasonably generic and avoid implementations that require a static input. 
