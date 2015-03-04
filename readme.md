Requiremenets
---------------------

Program is written in Scala and uses Maven to build, so it is required to have recent versions of both

* Scala - 2.11.2 and up
* Maven - 3.2.5 and up

How to build
---------------------

Its a standard Maven project, so build and testing can be triggered with 

    mvn clean package
    
in the main project directory.
After that, a jar file will be created in `/target` directory

Running
---------------------

Building must be performed first!

As the task requires, the program reads the input.txt file from the current directory and outputs to standard output
It is enough to run execute `run.sh` bash script to trigger the program execution.
The content of `input.txt` file may be changed accordingly to task description format
