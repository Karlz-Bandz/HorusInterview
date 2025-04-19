#Description
This projects implements a simple structure for a digital file cabinet using Java, where folders (SimpleFolder) can be 
nested inside complex folders (ComplexFolder).

The main class, FileCabinet, allows you to:
* search for a folder by its name (findFolderByName)
* search for all folders by size (findFoldersBySize)
* count all folders in the entire structure

#Structure
* Folder - a basic interface representing a folder
* Multifolder - an interface extending Folder that can contains nested folders
* FileCabinet - a class implementing core operations

#How to run
This project uses Java 21 and Maven for building and testing
Before running the project, make sure that:
* JDK 21(or newer) is installed on your system.
* Maven is installed and available in the PATH

To run all test cases use the followig command:
* mvn test
