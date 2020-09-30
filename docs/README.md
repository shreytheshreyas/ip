# Duke Application User Guide
Duke is an application that helps you manage tasks that go on in your day to day life . These tasks may include normal todo activites that need to be done, deadlines which need to be settled soon and events that occur on a particular date.

- [Quick start](#quick-start) 
- Features 
    - [Adding a Todo task : ``` todo ```](#adding-a-todo-task-todo)
    - [Adding a Deadline task : ``` deadline ```](#adding-a-deadline-task-deadline)
    - [Adding a Event task : ``` event ```](#adding-a-deadline-task-deadline)
    - [List all tasks in tasklist: ``` list ```](#list-all-tasks-in-tasklist-list)
    - [Mark task as completed ``` done ```](#mark-task-as-completed-done)
    - [Delete a task from the task list: ``` delete ```](#delete-a-task-from-the-tasklist-delete)
    - [Find a task with a keyword: ``` find ```](#find-a-task-with-a-keyword-find)
    - [Exiting the application: ``` bye ```](#exiting-the-application-bye)
    - [Saving task list data](#saving-tasklist-data)
- [Command Summary](#command-summary)

### Quick Start
    1. Ensure that you are using Java 11 on your computer.
    2. Download the latest version of Duke.jar.
    3. Save the file into a folder where you want to run the program from.
    4. Using the command line navigate to the directory of where Duke.jar is stored in.
    5. Run the command java -jar Duke.jar.
    6. If you followed the steps correctly the application should run properly.

## Adding a Todo task: ``` todo ```
This command adds a todo task to the tasklist.

Command-syntax: ```todo TASK_DESCRIPTION```

Example: ```todo Buy groceries in the evening```

Example output:
```
Got it. I've added this task: 
	1. [T][✘]  Buy groceries in the evening
Now you have 1 tasks in the list.
```
## Adding a Deadline task: ``` deadline ```
This command adds a deadline task to the tasklist.

Command-syntax: ```deadline TASK_DESCRIPTION /by DEADLINE_DATE```

Example: ```deadline Submit Software engineering project /by friday```

Example output:
```
Got it. I've added this task: 
	2. [D][✘]  submit Software engineering project (by: friday)
Now you have 2 tasks in the list.
```
## Adding a Event task: ``` event ```
This command adds a event to the tasklist.

Command-syntax: ```event TASK_DESCRIPTION /at EVENT_DATE```

Example: ```event Meet friends for dinner /at clarke quay```

Example output:
```
Got it. I've added this task: 
	3. [E][✘]  Meet friends for dinner (at: clarke quay)
Now you have 3 tasks in the list.
```
## List all tasks in tasklist: ``` list ```
This command lists all the tasks that are present in the task list.

Command-syntax: ```list```

Example: ```list```

Example-output: 
```
1. [T][✘]  Buy groceries in the evening
2. [D][✘]  submit Software engineering project (by: friday)
3. [E][✘]  Meet friends for dinner (at: clarke quay)
```
## Mark task as complete ``` done ```
This comnmand marks a task as in the task list as complete.

Command-synatx: ```done TASK_NUMBER```

Example: ```done 1```

Example output:
```
Nice! I've marked this task as done: 
1. [T][✓]  Buy groceries in the evening
```

## Delete a task from the task list: ``` delete ```
This command deletes a task from the task list.

Command-Syntax:```delete TASK_NUMBER```

Example: ```delete 2```

Example-output:
```
Got it. I've removed this task: 
	2. [D][✘]  submit Software engineering project (by: friday)
Now you have 2 tasks in the list.
```

## Find a task with a keyword: ``` find ```
This command finds all tasks which contains the inputted keyword.

Command-Syntax: ```find KEYWORD```

Example: ```find evening```

Example-output:
```
Here are the matching tasks in your list: 
1. [T][✓]  Buy groceries in the evening
3. [T][✓]  go for evening walk 
```
## Exiting the application: ``` bye ```
This command stops the running of the application.

Command-syntax: ```bye```

Example: ```bye```

Example-output:
```
Bye. Hope to see you again soon!
```
## Saving tasklist data 

Duke saves the data entered into a text file so that you can retrieve it later even after you have closed the application.

The application stores the data in the following format:
```
T | 1 |  Buy groceries in the evening
E | 0 |  Meet friends for dinner | clarke quay
T | 1 |  go for evening walk 
D | 0 |  finish assignment | friday
```
### Representation of Tasks
- T: Represents a Todo task
- D: Represents a Deadline task 
- E: Represents a Event tasl

### Representation of Task Completion 
- 1: Task is completed
- 0: Task is not completed

## Command Summary
|Command  |Syntax and Examples       |
|---------|--------------------------|
|todo| `todo TASK_DESCRIPTION` <br> Example: `todo Collect Project itemms from lab`|
|deadline|`deadline TASK_DESCRIPTION /by TASK_DATE` <br> Example: `Book flight tickets by sunday`|
|event|`event TASK_DESCRIPTION /at TASK_DATE` <br> Example: `Spider-man: far from home /at Shaw Theaters`|
|list|`list`|
|done|`done TASK_NUMBER` <br> Example: `done 1`|
|delete|`delete TASK_NUMBER` <br> Example: `delete 1`|
|find|`find KEYWORD` <br> Example: `find cake`|
|bye|`bye`|
