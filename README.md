# CS_3345_Project_3
Name: Mirza Zubayr Baig
netID: mzb230000
Project: 3
Files:
- LazyBinarySearchTree.java
- Main.java

I used eclipse IDE to write this code
I am on Java 8 Update 421
I compiled the program on the terminal on my macbook.
I started by writing cd ~/eclipse-workspace/Project_3/src 
Then I wrote javac LazyBinarySearchTree.java Main.java
Then java Main input.txt output.txt
This should put the file output.txt in your folder.
From my tests the program worked without any problems. Granted this was after a lot of failiures.

Sample Input: 

Insert:98
Insert:67
Insert:55
Insert:45
PrintTree
Delete:84
Delete:45
Contains:45
FindMin
FindMax
PrintTree
Height
Size
Insert:84
Insert:32
Insert:132
PrintTree
Insert:980
Insert
hih

Corresponding Output:

true
true
true
true
98 67 55 45
false
true
false
55
98
98 67 55 *45
3
4
true
true
Error in Insert:132: IllegalArgumentException raised
98 67 55 *45 32 84
Error in Insert:980: IllegalArgumentException raised
Error in Line: Insert
Error in Line: hih



