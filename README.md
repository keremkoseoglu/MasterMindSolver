MasterMindSolver
================

This Java project is a rough example of how to develop a brute force validation algorithm to make your computer look like "making guesses". It will take the role of a MasterMind player trying to solve the puzzle set by you.

I am sorry that I felt too lazy to make a proper GUI or a more usable user interface. My main focus was to demonstrate the development of the algorithm; therefore, I left everything else out.

The program has been developed in Netbeans on Mac OS X overnight. To run the program, type "java -jar MasterMindSolver.jar".

When the program starts, you have to set 4 colors in your mind; let's say "Red, Orange, Yellow, Green". As the program makes guesses, you have to evaluate them using "1"s and "0"s. "1" means an exact hit, and "0" indicates a misplaced correct color. For example; if the correct answer is "Red, Orange, Yellow, Green" and the program's guess is "Purple, Orange, Green, Blue", you have to reply as "10" - "1" for Red (perfect guess), "0" for Green "misplaced guess".

As I mentioned before, the main focus of this project is to demonstrate a brute force guess algorithm to programmer cubs.
