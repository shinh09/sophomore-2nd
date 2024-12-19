## 1. List all the branches in this repository and, for each branch, list the commits.
-Use git branch to list the branches in this repository.
```
 $ git branch
   feature-msg
 * master
```
-Use git checkout to explore each branch.
```
$ git checkout master
M	A.java
M	B.java
M	Main.java
Already on 'master'
```
-Use git log --decorate to explore the structure of commits.
```
$ git log --decorate
commit c146e374cd120f91c18ee97679cdb148d9bde6e9 (HEAD -> master)
Author: Josue Obregon <jobregon@seoultech.ac.kr>
Date:   Mon Aug 19 18:39:59 2024 +0900

    Adding class B skeleton and Main class

commit b487ec97a3f8626bf4b427df5bc73f00d334c7b9
Author: Josue Obregon <jobregon@seoultech.ac.kr>
Date:   Mon Aug 19 18:36:22 2024 +0900

    Adding class A skeleton

commit f6f58b7977bddf977c0fcc880113ef27a5740a8f
Author: Josue Obregon <jobregon@seoultech.ac.kr>
Date:   Mon Aug 19 18:35:11 2024 +0900

    Creating all files (all empty)
```



## 2. Try git log --graph --all to see the commit tree. Paste the result here and write a paragraph to provide an interpretation of what you found.
result
```
$ git log --graph --all
* commit c146e374cd120f91c18ee97679cdb148d9bde6e9 (HEAD -> master)
| Author: Josue Obregon <jobregon@seoultech.ac.kr>
| Date:   Mon Aug 19 18:39:59 2024 +0900
| 
|     Adding class B skeleton and Main class
|   
| * commit 71bcd3fc4b13ba0d4df2270259392a75025fdfa9 (feature-msg)
|/  Author: Josue Obregon <jobregon@seoultech.ac.kr>
|   Date:   Mon Aug 19 18:38:06 2024 +0900
|   
|       Adding header of method printMessage()
| 
* commit b487ec97a3f8626bf4b427df5bc73f00d334c7b9
| Author: Josue Obregon <jobregon@seoultech.ac.kr>
| Date:   Mon Aug 19 18:36:22 2024 +0900
| 
|     Adding class A skeleton
| 
* commit f6f58b7977bddf977c0fcc880113ef27a5740a8f
  Author: Josue Obregon <jobregon@seoultech.ac.kr>
  Date:   Mon Aug 19 18:35:11 2024 +0900
  
      Creating all files (all empty)
:...skipping...
* commit c146e374cd120f91c18ee97679cdb148d9bde6e9 (HEAD -> master)
| Author: Josue Obregon <jobregon@seoultech.ac.kr>
| Date:   Mon Aug 19 18:39:59 2024 +0900
| 
|     Adding class B skeleton and Main class
|   
| * commit 71bcd3fc4b13ba0d4df2270259392a75025fdfa9 (feature-msg)
|/  Author: Josue Obregon <jobregon@seoultech.ac.kr>
|   Date:   Mon Aug 19 18:38:06 2024 +0900
|   
|       Adding header of method printMessage()
| 
* commit b487ec97a3f8626bf4b427df5bc73f00d334c7b9
| Author: Josue Obregon <jobregon@seoultech.ac.kr>
| Date:   Mon Aug 19 18:36:22 2024 +0900
| 
|     Adding class A skeleton
| 
* commit f6f58b7977bddf977c0fcc880113ef27a5740a8f
  Author: Josue Obregon <jobregon@seoultech.ac.kr>
  Date:   Mon Aug 19 18:35:11 2024 +0900
  
      Creating all files (all empty)
~
```
   
   After the master and feature-msg branches diverged, the feature-msg branch had a commit that added the header for the printMessage() method. Later, on the master branch, there was a commit adding the skeleton for class B and the Main class. Overall, the master branch focused on adding skeletons for class A, class B, and the Main class, while the feature-msg branch added the header for a specific method.

## 3.Choose an already existing branch and use git diff BRANCH_NAME to view the differences between a branch and the current branch. Summarize the difference from master to the other branch.
```
$ git diff master feature-msg
diff --git a/A.java b/A.java
index 96a276f..d2906f7 100644
--- a/A.java
+++ b/A.java
@@ -1,3 +1,7 @@
 public class A {
+
+    public void printMessage(){
+        
+    }
     
 }
\ No newline at end of file
diff --git a/B.java b/B.java
index b5952d8..e69de29 100644
--- a/B.java
+++ b/B.java
@@ -1,3 +0,0 @@
-public class B {
-
-}
diff --git a/Main.java b/Main.java
index 3d84912..e69de29 100644
--- a/Main.java
+++ b/Main.java
@@ -1,6 +0,0 @@
-public class Main {
-    public static void main(String[] args){
-        //write code here
-        
-    }
-}
\ No newline at end of file
```
In the feature-msg branch, a new method called printMessage() was added to the A.java file. This method is currently an empty method with no specific implementation yet. On the other hand, the B.java and Main.java files have been deleted in the feature-msg branch. In the master branch, both files still exist, containing an empty class and a main method, respectively, but in the feature-msg branch, they are no longer used and have been removed.

## 4.write a command sequence to merge the branch that is not the master branch into master.
```
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master|MERGING)
```

## 5.Write a command (or sequence) to (i) create a new branch called print-msg (from the master) and (ii) change to this branch.
```
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master)
$ git checkout -b print-msg
Switched to a new branch 'print-msg'
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
```

## 6.Edit A.java adding the following implementation code for the printMessage() method.

        System.out.println("This is a new message.");

        System.out.println("Git is fun, isn't it?");
```
public class A {

    public void printMessage(){
        System.out.println("This is a new message.");
        System.out.println("Git is fun, isn't it?");
    }
    
```

## 7.Write a command (or sequence) to commit your changes.
```
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
$ git add A.java
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
$ git commit -m "printMessage method"
[print-msg a9a65ba] printMessage method
 1 file changed, 6 insertions(+)
```

## 8.Change back to the master branch and change A.java adding the following implementation code for the printMessage() method (commit your change to master):

System.out.println("Hello opensource world!");
```
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
$ git checkout master
Switched to branch 'master'
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master)
$ git add A.java
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master)
$ git commit -m "pringMessage method updated in master"
[master 7750015] pringMessage method updated in master
 1 file changed, 3 insertions(+), 3 deletions(-)
```

## 9.Write a command sequence to merge the print-msg branch into master and describe what happened.
```
$ git merge print-msg
Auto-merging A.java
CONFLICT (content): Merge conflict in A.java
Automatic merge failed; fix conflicts and then commit the result.
```
Indicates that a conflict has occurred. Specifically, auto-merge failed because the two branches in the A.java file had different changes.

## 10.Write a set of commands to abort the merge.
```
$ git merge --abort
```

## 11.Now repeat item 9, but proceed with the manual merge (editing A.java). All implemented methods are needed. Explain your procedure.
```
$ git add A.java
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master)
$ git commit -m "update printMessage in master"
[master b2729ba] update printMessage in master
 1 file changed, 3 insertions(+), 1 deletion(-)
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master)
$ git checkout print-msg
Switched to branch 'print-msg'
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
$ git add A.java
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
$ git commit -m "update printMessage in print-msg"
[print-msg 036d4f3] update printMessage in print-msg
 1 file changed, 5 insertions(+), 9 deletions(-)
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (print-msg)
$ git checkout master
Switched to branch 'master'
shinhyung@bagsinhyeong-ui-MacBookAir ~/desktop/oss-git-hw2 (master)
$ git merge print-msg
```
The way to add codes for both branches in the event of a crash is to open the file where the crash occurred and manually modify the crash area marked by Git. During the crash resolution process, you must manually adjust the code to reflect the changes for both branches.

## 12.Write a command (or set of commands) to proceed with the merge and make master branch up-to-date.
Let's go back to 9
```
git push origin master
```

## 13.Complete Part 2. Then, come back here and answer the following: Report your experience of submitting the Part 2. Please, include the steps you followed, the commands you used, and the problems you faced (within the file you created for the Part 1).
I forked the repository on GitHub, then worked on it in my local environment. I committed the changes during work and pushed them to my forked repository using the git push command. I then created a pull request (PR) from GitHub to the original repository.
