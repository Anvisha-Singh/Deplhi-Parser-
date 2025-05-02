


# Pascal to LLVM Compiler

----------------
### Divyam Dubey :  				45227758
### Anvisha Singh :	82255326

This project extends a prior Pascal interpreter to a compiler that generates **LLVM Intermediate Representation (IR)** code from a subset of Pascal/Delphi syntax. The goal is to translate a custom Pascal program into valid `.ll` code executable through the LLVM toolchain.

---

## Features Implemented

 Language Construct       
--------------------------
Variable Declarations    
Assignments              
Arithmetic Expressions   
`writeln(...)` (Output)  
`if`, `if-else`          
`while` Loop             
`for` Loop  
`break` Statement     
`continue` Statement  
 Nested Blocks & Scoping 

---

## How to Compile and Run

### Step 1: Generate ANTLR Java files
```bash
java -jar antlr-4.13.2-complete.jar pascal.g4 -Dlanguage=Java -visitor

```

### Step 2: Compile all Java files

```bash
javac -cp ".;antlr-4.13.2-complete.jar" *.java

```

### Step 3: Run the compiler on a Pascal source file

```bash
java -cp ".;antlr-4.13.2-complete.jar" ScopeChecker test1.pas

```


### For MAC

Generate ANTLR Lexer and Parser

java -jar < -path to the antlr jar file > Delphi.g4 -Dlanguage=Java -visitor

java -jar /usr/local/lib/antlr-4.13.2-complete.jar pascal.g4 -Dlanguage=Java -visitor

Compile the files

javac -cp ".:/usr/local/lib/antlr-4.13.2-complete.jar" *.java

Run the interpreter with the testcase file

java -cp ".:/usr/local/lib/antlr-4.13.2-complete.jar" ScopeChecker < -test case file name>

java -cp ".:/usr/local/lib/antlr-4.13.2-complete.jar" ScopeChecker test2.pas



This will generate `output.ll` in the current directory.

----------

##  ~~LLVM to WASM~~ ( We did not go for the extra credits)



## Sample Test Cases

  



### `test1.pas`

```pascal
program Test;
var x: integer;
begin
  x := 42;
  writeln(x);
end.
```

Verifies variable declarations, direct assignments, and correct value transfer between variables.



----------

### `test2.pas`

```pascal
program Test;
var x, y: integer;
begin
  x := 5;
  y := (x + 2) * 3 - 4;
  writeln(y);
end.
```

Validates operator precedence, parentheses, and nested arithmetic in assignments.

----------

### `test3.pas`

```pascal
program Test;
var x: integer;
begin
  x := 5;
  if x > 3 then
    writeln(x);
end.
```

Verifies nested `if` logic and proper branching without ambiguity.

----------

### `test4.pas`

```pascal
program Test;
var x: integer;
begin
  x := 1;
  while x < 4 do
    writeln(x);
end.


```

Verifies while loops with proper decrement and loop control.

----------


### `test6.pas`

```pascal
program Test;
var x: integer;
begin
  for x := 1 to 3 do
    writeln(x);
end.
```

Verifies for loop

----------


###  `test5.pas`

```pascal
program Test;
var x: integer;
begin
  x := 1;
  while x < 6 do
  begin
    if x = 4 then
      break;
    writeln(x);
    x := x + 1;
  end;
end.
```

 Ensures loop exits early with `break`.

----------

###  `test7.pas`

```pascal
program Test;
var x: integer;
begin
  x := 1;
  while x < 6 do
  begin
    x := x + 1;
    if x = 4 then
      continue;
    writeln(x);
  end;
end.
```

 Ensures rest of loop body is skipped when `continue` hits.

----------

##  File Structure

```
├── ScopeVisitor.java
├── ScopeChecker.java
├── SymbolTable.java
├── pascal.g4
├── test1.pas (and other .pas test files)
├── output.ll (generated output)
└── README.md

```

----------

##  Notes

-   Only **integer type** is tested for variables although our grammar has support for other data type as worked in previous project as well.
    
-   The grammar is a simplified Pascal subset (taken forward from our custom grammar from previous projects)

##  Sample Output for test case 1

<img width="1050" alt="Screenshot 2025-05-02 at 12 42 48 PM" src="https://github.com/user-attachments/assets/09a040be-8f3a-4cd8-8cab-8634fea7be00" />


<img width="518" alt="Screenshot 2025-05-02 at 12 42 11 PM" src="https://github.com/user-attachments/assets/d1523417-610f-4bd3-a955-7fe3f97674ba" />

## Output for test case 7

![image](https://github.com/user-attachments/assets/600cf526-3a69-4869-b9a2-605f80fe01c9)




    

    

----------


    

  
