# Effective Software Testing Lab (Assignment 3)

- Deliverable:
  - One single zip file containing all the folders that you find attached to
    this assignment, but where you also have implemented the tests / `answer.md`, as required
    in the `README.md` file of each folder.
- Deadline: January 01, 2022 at 17:00 (Zurich, CH, time).


## Evaluation
Each student is expected to carefully work on this assignment, according to
the instruction given in each exercise (see `README.md` file within each
exercise folder). An assignment is considered as *valid* and counted for the
bonus points if it shows clear evidence of careful and substantial work.

Please note that the lab assignments are propaedeutic to a proper preparation
for the final exam, which will also include exercises similar to those done in
the lab assignments. Therefore, the lab work should be considered as important
not only for the bonus points, but also for preparing the final exam.


## Overall instructions
The folders that you find for this assignment are structured somewhat similarly
to what you find [here](https://github.com/cse1110/assignments). In the
following, you find instructions inspired by the ones available in that
website; feel free to use that website for training purposes.

The task in the `quality` folder requires only an `answer.md` file.

### Importing an Exercise
To open an exercise, you have to choose a folder which corresponds to a
category of an exercise. In that folder, there is a `README.md` file explaining
the exercise and a `pom.xml` file, which contains the full project structure.
To work on an exercise, you have to import this `pom.xml` file into your
preferred IDE (recommended: IntelliJ IDEA CE).

For the task in the `quality` folder, you may want to clone the given repository for 
reviewing and running the tests locally.

### Structure of an Exercise
Every exercise contains a `src` folder, which contains at least two files,
`ExerciseName.java` and `ExerciseNameTest.java`. The file without `Test` suffix
is the file that you need to test, the file with the `Test` suffix is the file
where you have to write your solution.

Make sure, you **do not** include the project folder in the `quality` task in the zip file
for submission, but only the `answer.md`

## Solving an Exercise
The only thing you have to do is write your tests inside the `ExerciseNameTest.java`
file inside the `src` folder resp. the answers to the questions into the `answer.md`.

## Requirements
Java 15 is used for all the exercises and in the grading tool. There is no
guarantee things will work in other versions.

