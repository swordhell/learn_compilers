# Recursive Descent Parser Experiment

## Overview
This project is a simple **recursive descent parser** implemented in Java, based on the example from *Compilers: Principles, Techniques, and Tools (2nd Edition), Section 2.5.5*. The parser performs **syntactic analysis** of arithmetic expressions containing integers, parentheses, and basic operators (`+`, `-`, `*`, `/`).

---

## Features
- Parses integer arithmetic expressions
- Supports parentheses and operator precedence
- Reports syntax errors if the input is invalid
- Demonstrates the concepts of **lexical analysis** and **syntax analysis**

---

## Project Structure

```txt
project/
│── Main.java        # Entry point and test examples
│── Parser.java      # Recursive descent parser implementation
│── Lookahead.java   # Token scanner (lexer)
│── Token.java       # Token definitions
│── SyntaxError.java # Exception class for syntax errors
```

> Optionally, all classes can be combined into a single `Main.java` file for simplicity.

---

## How to Run

1. **Compile all Java files**:

```bash
javac *.java
```

2.	**Run the program:**

```java
java Main
```

3.	**Example output:**

```txt
Parsing successful!
```

If there is a syntax error in the input expression, the program will display:


```txt
Syntax error: ...
```
