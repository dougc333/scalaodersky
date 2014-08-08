there is no reliable maven plugin for scalacheck I can find
only sbt exists


SBT instructions: 

1) simplest create a project directcory with build.properties and a simple.sbt file in directory above this where pom.xml would be

2) no sbt file, everything in project directory like job server


ScalaCheck instructions: 
only source of docs are github page
not used in spark

this example only covers using scalacheck for scala datastructures 

3 components
1) define generator based on random number generator and range. default is range of positive and negative integers

2) define properties which work like an assert, return a boolean which verifies if property is true or not

scalacheck assignment uses pairs of heaps, compare vs each other. 
is easier to use 1 known good implementation like scala.collection.mutable.priorityqueue vs. class provided Heap? 

