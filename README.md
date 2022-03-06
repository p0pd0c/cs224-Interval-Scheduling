# cs224-Interval-Scheduling
Implement a greedy algorithm to find the optimum schedule for a set of intervals

Interval: has a start and finish time
RequestSet: stores a collection of intervals and has functionality for determining the optimal schedule
Main: set up and evaluate best schedule
# Compile the program
```
javac Main.java
```

# Run the program
```
java Main
```

## How it works
By ordering the set of intervals first by finish time, and then we pick them in this order, rejected any conflicting intervals as we go

TODO: 
Show proof of why this approach generates the optimal solution
