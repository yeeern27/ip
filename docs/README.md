# Ern Chatbot User Guide

<img width="211" alt="Screenshot 2025-03-14 at 4 31 24 PM" src="https://github.com/user-attachments/assets/3d998d66-2d16-46ab-878e-80fbf9f6fdff" />

## Introduction
Welcome To Ern Chatbot. This helps you to keep track of your to-dos, deadlines and events. You can add, delete, mark, unmark and find your tasks by giving me certain keywords.

## Quick Start
### Prerequisite : 

You will need Java 17 installed

### Steps to Run : 
1. Download `ip-jar` from the GitHub Repo.

2. Navigate to the directory containing the `ip-jar` file.

3. Run the jar file using your terminal or command promopt:

   ```java
   java -jar ip.jar
   ```

4. Enter your command here.

5. If you have previously run Ern, Ern will first display your saved tasks. 
  
## Features & Commands
### 1. Add a ToDo Task

Simply add your task that need to be done here

#### Command : 
```java
todo <description of task>
```
#### Example : 
```java
todo read book
```
#### Expected Output : 
```java
Got it. I've added this task:
T | not done | read book
Now you have 1 task in the list.
```

### 2. Add a Deadline Task

Add a task that need to be completed by certain time.

#### Command : 
```java
deadline <description of task> /by <yyyy-MM-dd HH:mm>
```
#### Example : 
```java
deadline read book /by 2020-12-10 19:00
```
#### Expected Output : 
```java
Got it. I've added this task:
D | not done | read book | Dec 10 2020, 19:00
Now you have 2 tasks in the list.
```

### 3. Add a Event Task

Add a task that happen within a certain period of time.

#### Command : 
```java
event <description of task> /from <yyyy-MM-dd HH:mm> /to <yyyy-MM-dd HH:mm> 
```
#### Example : 
```java
event read book /from 2020-12-10 19:00 /to 2020-12-10 20:00
```
#### Expected Output : 
```java
Got it. I've added this task:
E | not done | read book | Dec 10 2020, 19:00 | Dec 10 2020, 20:00 
Now you have 3 tasks in the list.
```

### 4. List all tasks 

View all tasks that is saved 

#### Command : 
```java
list 
```

#### Expected Output : 
```java
Here are the tasks in your list:
1. T | not done | read book
2. D | not done | read book | Dec 10 2020, 19:00
3. E | not done | read book | Dec 10 2020, 19:00 | Dec 10 2020, 20:00 
```

### 5. Mark Task as Done

Mark a task after completed  

#### Command : 
```java
mark <index of task>
```

#### Example : 
```java
mark 2
```

#### Expected Output : 
```java
Nice! I have marked this as Done!:
[X] read book
```

### 6. Unmark a Marked Task 

Unmark a task that was marked as done

#### Command : 
```java
unmark <index of task>
```

#### Example : 
```java
unmark 2
```

#### Expected Output : 
```java
OK! I have marked this as Not Done!:
[ ] read book
```

### 7. Delete 

Delete a task that is unwanted 

#### Command : 
```java
delete <index of task>
```

#### Example : 
```java
delete 2
```

#### Expected Output : 
```java
Noted. I've deleteted this task:
 D | not done | read book | Dec 10 2020, 19:00
Now you have 2 tasks in the list 
```

### 8. Find

Find the task by inputting the keyword 

#### Command : 
```java
find <description of task>
```

#### Example : 
```java
find book
```

#### Expected Output : 
```java
Found 2 matching tasks. 
Here are the matching tasks in your list:
 T | not done | read book
 E | not done | read book | Dec 10 2020, 19:00 | Dec 10 2020, 20:00 
```

### 9. Exit

Exit the program 

#### Command : 
```java
bye
```

#### Expected Output : 
```java
Bye. Hope to see you again soon!
```

## Commands Summary
| Command | Example |
| -------- | -------- |
| todo | `todo read book`|
| deadline | `deadline read book /by 2020-10-02 19:00` |
| event | `event read book /from 2020-10-02 19:00 /to 2020-10-02 20:00` |
| list | `list` |
| mark | `mark 1` |
| unmark | `unmark 1` |
| delete | `delete 1` |
| find | `find book` |
| bye | `bye` |
