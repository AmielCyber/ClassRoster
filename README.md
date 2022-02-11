# Class Roster Software

### Description
The Class Roster software is made for a professor to view and edit a class roster. This user will have the ability to add, remove, and list students in the user's class. In addition, the software will allow the user to lock the class roster so no new changes are made. 

### Team
This projected was developed by [Shane Moro](https://github.com/ShaneSDSU), [Amiel Nava](https://github.com/Amiel-cyber), and [Anoodnya Sangam](https://github.com/asangam99). 

### Documentation
This repository's top level will contain the **Software Design Specification** which is the design plan for the software and is intended for the development team.The rest of the files in this repository are shown in this tree directory: 
```bash
SDSU-CS496-S21-G2
├── ClassRoster.jar
├── ClassRosterSoftware
│   ├── Account.java
│   ├── ClassRoster.java
│   ├── Course.java
│   ├── Driver.java
│   ├── Student.java
│   └── User.java
├── class-roster.txt
├── README.md
└── SoftwareDesignSpecification.pdf
```
A class roster file named *class-roster.txt* will be added to the ClassRosterSoftware directory if you installed the software by source or in the main directory if you just ran the jar file. This will only be added when you save a class roster through the main menu. This file will contain all data related to your class roster so when you start the program again, your data will still be there. 

The rest of this **README** file will be the user **manual** which will describe instructions on how to install the software and how to run the program. 

# User Manual

## System Requirements
You will need to have a Java Runtime Environment (JRE) version 8 or higher.  You can meet this requirement by downloading and installing the latest Java software. Instructions for your operating system are found at [Java's website](https://java.com/en/download/help/download_options.html). 

## Installing Class Roster Software

### Build From Source
Go to the ClassRosterSoftware directory and go inside the source directory label 'src' on your terminal. Then enter the following commands:
```bash
$ javac *.java
```
Then to run the program you just run the following command:
```bash
$ java ClassRoster
```
### Run the Jar File
Go to the main directory for this project and you will see a file named ClassRoster.jar. On your terminal you type the following command to run it on your computer:
```bash
$ java -jar ClassRoster.jar
```

## Starting the Program
Go to your folder containing the JRE file and open it. The Class Roster Software will prompt you to enter your username(admin) and password(password).  Upon a successful login, you will be welcome with a *Class Roster* logo and a main menu. The main menu will give you a list of options numbered 1-7 in which you can select in order to perform a task.

## Main Menu

### Add Student
Entering **1** in the main menu will prompt you to enter a student's information for which you will like to add to the roster. You will be prompted sequentially the following way:
* Enter Student First Name
	* The student's first name who you will add to the course
* Enter Student Last Name
	* The student's last name who you will add to the course
* Enter Student Major
	* The student's major who you will add to the course
*  Enter Student Year
	* The student's expected graduation year
	* The system will ask you to add a valid year if you enter a year not within the range of valid years
	* The system will also display a range of valid years you can enter
*  Enter Student ID
	* The student's unique school ID number
	* The system will prompt you again if you enter an invalid ID number and will display a valid range of numbers you can enter
	

After you add the student, the student will remain in the system until you remove this student. If you add a student with ID number already in the class roster, then the system will not add the student and will display a message that no student was added. The student's information will be stored in the *class-roster.txt* file in the ClassRosterSoftware directory if you ran by source or in main directory if you ran the program by the jar file.

### Remove Student
Entering **2** in the main menu will prompt you to enter a student's information for which you will like to remove from the roster. You will be prompted sequentially the following way:
* Enter Student ID Number
	* The student's unique school ID number
	* The system will prompt you again if you enter an invalid ID number and will display a valid range of numbers you can enter
Upon successful removal of a student, the system will remove that particular student from the file use to read all students in your class. The student will not be displayed again unless added to the system again. After removing a student, this process will not be able to undo the removal unless you add the student back to roster.

### Display Class Roster sorted by Name
Selecting **3** in the main menu will display the class roster sorted by last name. If two students have the same last name, then those two will be sorted by first name. If two students have the same first name and last name, then those two students will be sorted by student ID number, since the ID numbers are unique.

### Display Class Roster sorted by ID
Selecting **4** in the main menu will display the class roster sorted by ID number. This method takes the fact that no student has the same student ID number. 

### Save Roster
Selecting **5** in the main menu will save all changes you have done in the class roster. Those changes include adding and removing a student. 

### Lock/Unlock Class Roster
Selecting **6** in the main menu locks the class roster so no new changes can be made.

### Exit 
Selecting **7** in the main menu will close the program.

## Features 
The system is persistent between sessions. When close the program and log back in, you will have your class roster as you had it in the presious session.
Another feauture is that the system will check if an invalid input will enter, so your data stays consistent through every student's information. 
