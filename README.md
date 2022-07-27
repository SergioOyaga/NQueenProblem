# N-Queen_Problem
A basic example and demonstration on what a Genetic Algorithm looks like. :octocat: :octocat:

This project is an example of bio-inspired optimization algorithms, where Genetic Algorithm (GA) is explored to solve the
N-Queen problem.

This problem consist in place N-Queens in a chess board of N*N in such a way they do not attack each others.

<table>
  <tr>
    <td> <b>Solution for 8-Queens </b></td>
    <td> <b>Solution for 32-Queens </b> </td>
  </tr>
  <tr>
    <td> <img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/8QueenSolution.png"  title="Solution for 8-Queens" alt="Solution for 8-Queens" width="400" height="400" /></td>
    <td> <img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/32QueenSolution.png"  title="Solution for 32-Queens" alt="Solution for 32-Queens" width="400" height="400" /></td>
  </tr>
</table>

## Table of Contents

* [Introduction](#introduction)
* [Java classes](#java-classes)
    * [NQueenProblem](#nQueenProblem)
    * [Population](#population)
      * [Candidate](#candidate)
    * [Controller](#controller)
    * [Setting](#setting)
    * [Board](#board)
    * [Pieces](#pieces)
      * [Queen](#queen)
      * [Empty](#empty)
* [R script](#r-Script)
* [Build](#build)

## Introduction

This project is an example of a Genetic Algorithm implemented in Java solving the N-Queen Problem. This problem consist 
in placing N queens in a N*N chess board, in a way that no queen attacks or is attacked by other Queen. Knowing the 
exact number of possible positions in which this situation happens has been considered as an unsolved issue. Recently 
a [paper on this problem](https://arxiv.org/abs/2109.08083) has come out with an approximation.

In this repository we do not care about the total number of solutions, we want to find a solution fast. We implement a 
Genetic Algorithm that using a bio-inspired approach can find queens distributions and focus on those more stable* solutions. 

*stable in a sense of permutations between queens.

## Java classes
Here we can see all the java classes implemented for this example.

### NQueenProblem
This is the main class here we create the treads that are running the visual objects,the class also perform the evolution of 
the population using Population/Candidate methods and also writes the files used in the R visualization. 

### Population
This class is the highest class of the GA. The population refers exactly to a population of individuals (Candidates) who
fight to survive. The candidates in the population compete to pass their genetic information to the next generation by 
fitting the problem. Two candidates would mix their genetic information to produce an offspring that will repopulate 
the population in the next generation.

As happens in real life, the best candidates are more likely to be selected as parents and their genetic information will
be preserved in time. This more probability of being selected is known as the explitatory part of the solution and 
enhance the keep of better solutions.

#### Candidate
The candidates in the population compete to pass their genetic information to the next generation by
fitting the problem. In this case Candidates with fewer Queens attacking other queens are considered better solutions.
The candidate contains in its genome codify a solution to the problem. This solution is evaluated to set how likely this
candidate would be selected to pass his information tho the next generation.

As happens in real life, new candidates produced by the crossover of two parents might or might not experiment a 
new unique mutation. The "random" mutation is the exploratory part of the solution process and allow to reach new 
solution spaces that were not contemplated in the previous solution space. 

### Controller
The controller is the class which intermediates between the graphic interface and the backend process. 
Is in charge of displaying the chess board and setting the icons of the queens.

Contains a component listener that resizes the original image to the size if the button and sets the icon to it.

### Setting
This window allows the user to select the different GA
parameters and the number of queens to place in the board.
<img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/settingWindow.png"  title="Setting Window" alt="Setting Window" width="800" height="400" />

We can see that the number of Queens, the populationSize amd the number of Generations can be selected as a common
characteristic for all GAs. Below we can select the mutation probabilities. In this example we allow to the genome of 
each candidate to mutate twice in each iteration.

### Board
In these windows the optimized solutions are displayed. The board consist in a set of JButtons placed in a grid and 
which icon is set to an image of a queen if effectively there is a queen in the solution matrix.
<img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/boardWindow.png"  title="Board Window" alt="Board Window" width="400" height="400" />

### Pieces
This class is just a parent class from which Queen and Empty will inherit.
Is just a more general class callable by the controller to create new pieces.

#### Queen
The Queen is the piece we want to place in the board. Is just an information class that contains info of where the piece
is placed. The position of the piece must be coherent with the one reflected in the controller.

#### Empty
The Empty is the piece we create to ease the process. It is equivalent to a queen, but has not associated any icon.

## R script
The R script is used to infer some information about the GA convergence.

<img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/fitnessMean.png"  title="Population Fitness Mean" alt="Population Fitness Mean" width="800" height="400" />

The first image shows how the population genome converge to a value. This gives us an idea on how good/bad is our 
selected crossover converging the genome to the best solutions, and the ratio of exploratory solutions.

<img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/bestIndividuals.png"  title="Best Individuals Fitness" alt="Best Individuals Fitness" width="800" height="400" />

The second image shows how many iterations takes to each method to find a solution to the problem.

<img src="https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/image/convergence.png"  title="Count Different Genotypes in the best population" alt="Count Different Genotypes in the best population" width="800" height="400" />

The last image shows how many genomes are presented in the last best population. We can see that most of the genome have 
converged to the minimum with the exact same genome (i.e. the same solution).

## Build
You can find a .jar executable in [out/artifacts/NQueenProblem/NQueenProblem.jar](https://github.com/SergioOyaga/N-Queen_Problem/blob/master/out/artifacts/NQueenProblem_jar/NQueenProblem.jar)
```console
cd path/to/NQueenProblem/module
java -jar path/to/JARfile/NQueenProblem.jar
```

## Disclaimer
Feel free to download, use or edit this code under your own responsibility.
