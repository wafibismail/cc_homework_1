# Homework 1
This assignment corresponds to chapter 2 (Names) and 3 (Functions) of the Clean Code textbook, applying concepts introduced in said chapters to an example code.

## Example source
The file was part of my Programming Fundamentals module project last semester, which was to program in Java a Command-Line based game of blocks demolition. The file does not comprise all of the game logic.

### About the game
The game starts with a meandering line-up 20 blocks with randomly generated colors.<br>
The rule for demolition trigger is, with a new block of a randomly generated color, either:<br>
- replace an existing block, or,
- insert between two existing blocks
<br>
...so that after its placement, if one or more of its adjacent blocks have the same color as it, they will be discarded from the existing line-up a.k.a. demolished.<br>
<br>
However, if no block is demolished, another extra block with a random color will be appended to the line-up.<br>
<br>
The challenge comes from the shape of the line-up. Because it is not a straight line, not all blocks are accessible from the start i.e. not all can be selected to be replaced or to represent valid spots of insertion.

## Changes summary
- Renamed variables, arguments, and functions to better represent what they actually are.
- Broke down large functions into smaller functions, so that
  - each only do one thing and do exactly what their names describe
  - each represent only one level of abstraction.
- Created a small class, ColorFactory,
  - to replace the class variable char colorChoices[] = {'Y', 'R', 'G'}, and
  - to contain methods related to generating a new random color
