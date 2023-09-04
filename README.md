# Wordle - Puzzle Game Clone

## Authors

* Varun Pasupuleti - vjz3qz
* Sunny Chanda - ufx2ju
* Nachiket Gusani - bya8tr

## Overview
This is a Command-Line Interface (CLI) based Wordle game clone written in Java. The project aims to replicate the core functionalities of the popular Wordle puzzle game. Players attempt to guess a word within a certain number of tries, with color-coded feedback after each guess.

## Requirements
To run this program, make sure you have the following:
- Java 8 or higher
- Gradle build tool

## Getting Started

### IntelliJ:
1. Copy the .git link of this repository.
2. Open a Project From Version Control in IntelliJ and paste the GitHub link.
3. Open the Terminal tab in the newly created project and type `./gradlew build`.
4. Type `java -jar build/libs/wordle.jar` into the Terminal to run the program.

## Design

The project is structured following Object-Oriented Programming (OOP) principles and Test-Driven Development (TDD).

### Core Functionality Classes
- `GameState`: Maintains the state of a Wordle game.
- `WordleDictionary`: Handles the list of possible words for the game.
- `GuessResult`: Generates the color-coded feedback for each guess.

### Exceptions
Custom exception handling has been implemented for robust game state management and user input validation.

## Documentation

Comprehensive software documentation is provided, detailing classes, enumerated types, exceptions, and test cases. This serves as a guide for future development and debugging.

## Testing

The project includes multiple JUnit test classes to ensure functionality and robustness. Achieved 100% test coverage on critical game components.

## Usage

1. Start the program by running the compiled .jar file with the `java` command.
2. Follow the on-screen instructions to play the game.

