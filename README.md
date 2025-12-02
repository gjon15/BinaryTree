# BinaryTree (Java)

This project implements a simple **Binary Tree visualizer** in Java.  
The program builds a **balanced binary tree** from values `1..n` and draws it using different traversal orders.  
Visualization is done using the **Princeton StdDraw** graphics library.

---

## How to Run

### Requirements
- **Java 17+**
- **Princeton StdDraw library** (`stdlib.jar`)
- Works with:
  - **Visual Studio Code** (Java extensions required)
  - **IntelliJ IDEA**

### Running the Program

You can run the program in two ways:

#### 1. From the terminal:
```sh
javac -cp lib/stdlib.jar src/BinaryTree.java
java -cp lib/stdlib.jar:src BinaryTree 25
```
Where 25 is the number of nodes (optional, default = 13).

#### 2. From VS Code or IntelliJ:
Make sure stdlib.jar is added to the classpath.

Open BinaryTree.java and click Run.

## Libraries Used
This project uses:
- StdDraw
- StdOut
Both come from Princeton's standard library (stdlib.jar).

### Place the file in:
```bash
/lib/stdlib.jar
```
and ensure the project points to it.

## Tree Drawing Modes
The program supports four visualization modes, already included in the code.

Uncomment one of these in the main method:

**1. In-Order** (Left → Root → Right)
```java
tree.drawTreeInO();
```
**2. Pre-Order** (Root → Left → Right)
```java
tree.drawTreePreO();
```
**3. Post-Order** (Left → Right → Root)
```java
tree.drawTreePostO();
```
**4. Level-Order** (Breadth-First)
```java
tree.drawTreeLevelO();
```
Each mode draws:
- the full tree structure,
- nodes in traversal order,
- numbers showing the visit sequence.
