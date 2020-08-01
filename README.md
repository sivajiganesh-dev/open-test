## open-test

This repo has two tests
1. Sort
    - Sorting the input data based on the no of occurrences
2. Tree 
    - Finding the least/min time to burn the tree
    
## Details
Two programs are simple java 8 based console applications, which supports custom data, and hard-coded input modes.
Default mode is hard-coded, to enable custom input provide single argument with value 1


## Compiling & Execution
### Sort
```
$ cd sort/
$ javac SortByOccurrences.java
$ java SortByOccurrences [1]

```
[1] is optional and if provided program asks for user input. 
Input should be in the format of 
```
x,y,z,...
```
Example: ref below image

![Image of sort execution](https://user-images.githubusercontent.com/22338008/89009439-2c16cb80-d32a-11ea-800f-e6574ff45d40.png)


### Tree
```
$ cd tree/
$ javac BinaryTreeTraversal.java 
$ java BinaryTreeTraversal [1]

```
[1] is optional and if provided program asks for user input. 
Input should be in the format of 
```
N
N-1 entries of [parent, child] one per each line
L leaf node
```

Example: ref the image

![Image of tree execution](https://user-images.githubusercontent.com/22338008/89009533-58324c80-d32a-11ea-9aad-4bab7d8a4380.png)
  
