# Assignment 3 - The Linux File System

## Purpose

Explore how Linux organizes, identifies, protects, searches, and archives files. This assignment combines Chapter 6 concepts with hands-on investigation of the file system on `babbage.cs.tcu.edu`.

## Learning objectives

After completing this assignment, you should be able to:

- describe the Linux file hierarchy and the purposes of important top-level directories;
- identify regular files, directories, links, device files, sockets, and named pipes;
- distinguish hard links from symbolic links using inode and link-count information;
- interpret and modify file and directory permissions safely;
- explain how directory entries, inodes, and filesystems relate to pathnames;
- construct `find` expressions using names, types, times, ownership, and Boolean operators;
- create, inspect, extract, and verify compressed archives; and
- create and verify checksums for archived data.

## Prerequisites

- Read Chapter 6, "The File System," in *Mastering Modern Linux, 2nd Edition*.
- Perform the practical work on `babbage.cs.tcu.edu` using Bash.

## Safety and rules

- Work only in a directory that you own. Create and use `~/cosc30503/assignment03`.
- You may inspect readable system files and command output when a question requests it.
- Show each command and its relevant output for every practical question.
- Explain results in your own words. A command or screenshot without an explanation is incomplete.
- Before using a destructive command such as `rm`, verify your current directory with `pwd`.

## Tasks

### Part 1 - File hierarchy and file types

1. In your own words, distinguish the Linux **file system** from an individual **filesystem**. Give one example of each.

2. For each of `/etc`, `/home`, `/dev`, `/proc`, `/tmp`, `/usr`, and `/var`, state its usual purpose and identify one item found there on `babbage`. Do not modify any of these directories.

3. Use `ls -ld` and `file` to investigate one regular file, one directory, one symbolic link, and one device file. Record the path, the file-type character shown by `ls`, and the description reported by `file` for each.

4. Locate one character special file and one block special file, if both are visible on `babbage`. Record their major and minor device numbers and explain the general difference between character and block devices. If no block device is visible, document your search and explain why access may be restricted.

5. Create a named pipe called `message.pipe` with `mkfifo`. Show how `ls -l` and `file` identify it, then explain how a named pipe differs from an ordinary file. Remove it when finished.

### Part 2 - Inodes and links

6. Create `original.txt` containing several lines of text. Create a hard link named `hard.txt` and a symbolic link named `symbolic.txt` that refer to it. Show the commands used.

7. Use `ls -li` and `stat` to compare the three pathnames from Task 6. Record their inode numbers, link counts, file types, and sizes. Explain which metadata demonstrates the relationship among the files.

8. Append a line through `hard.txt`, then display the contents through all three names. Explain the results in terms of directory entries and inodes.

9. Remove `original.txt`. Test access through `hard.txt` and `symbolic.txt`, and explain why their behavior differs. Use an appropriate command to identify the dangling link.

10. Re-create `original.txt`, then make a symbolic link to a directory inside your assignment workspace. Explain two capabilities of symbolic links that hard links normally do not provide.

### Part 3 - Permissions and file status

11. Create `private.txt` and a directory named `access-test`. Record their initial modes and your current `umask`. Explain how the `umask` contributed to each initial mode.

12. Set `private.txt` to mode `640` using numeric notation. Then produce the same mode using symbolic notation, starting from mode `000`. Explain every permission granted by `640`.

13. Inside `access-test`, create `visible.txt`. Experiment safely with the directory modes `400`, `100`, `500`, and `700`. For each mode, test whether you can list the directory's names, access `visible.txt` when its name is known, and create or remove an entry. Restore mode `700` afterward and explain what `r`, `w`, and `x` mean for a directory.

14. Use `stat` on a file you created. Identify its inode number, ownership, mode, size, link count, and access, modification, and status-change timestamps. Perform one safe operation that changes the modification time and another that changes only file metadata; show the relevant timestamp changes.

15. Explain the effects of the set-user-ID bit on an executable file, the set-group-ID bit on a directory, and the sticky bit on a shared directory. Find one example of any one of these special modes on `babbage` and show how `ls -ld` represents it. Do not change the example.

16. Compare Discretionary Access Control (DAC) and Mandatory Access Control (MAC). Explain why DAC permissions might appear to allow an operation that a system using SELinux still denies.

### Part 4 - Filesystem implementation

17. Explain the roles of data blocks, inodes, the inode list, block groups, and the superblock in an ext-family filesystem. Which of these stores a file's name, and which stores its content?

### Part 5 - Searching the file tree

18. Build a directory tree named `search-tree` containing at least three subdirectories, ten regular files with varied extensions, one hidden file, and one symbolic link. Include at least three `.c` files and at least two files whose names contain a space. Show the command or commands used to create it.

19. Write `find` commands that search `search-tree` for each of the following. Explain the quoting used in each command:
    a. all regular files ending in `.c`;
    b. all directories;
    c. all files whose names contain a space;
    d. all regular files except `.c` files; and
    e. symbolic links only.

20. Create a reference file with `touch`, wait long enough to establish a clear timestamp boundary, and then create two more files. Use `find -newer` to select only files newer than the reference file. Record the commands and results.

21. Use one `find` command with Boolean OR to locate files ending in either `.c` or `.md`. Then use `find -exec` with a non-destructive command to report the line count of every `.c` file. Explain `{}`, the command terminator, and why shell quoting or escaping is necessary.

22. Compare `find` and `locate`: describe what each searches, why `locate` is often faster, and why its results may be stale. If `locate` is installed on `babbage`, demonstrate both commands while searching for one known file; otherwise, document that it is unavailable.

### Part 6 - Archives, compression, and integrity

23. Create a gzip-compressed tar archive named `search-tree.tar.gz` containing your entire `search-tree`. List the archive's contents without extracting it and explain the tar options used.

24. Create an empty directory named `restored-tree` and extract the archive there without overwriting your original tree. Compare the original and restored trees with `diff -r`. Record the result and explain what it indicates.

25. Create an xz-compressed tar archive of the same tree. Compare the byte sizes of the uncompressed data, the gzip archive, and the xz archive. Explain why the smallest result for this small sample may not establish which compression method is always best.

26. Make a copy of `search-tree.tar.gz` named `checksum-test.tar.gz`. Generate a SHA-256 checksum file for the copy and verify it successfully. Then alter `checksum-test.tar.gz` and demonstrate that verification detects the change. Explain what an integrity checksum can and cannot prove.

### Part 7 - Synthesis

27. A project directory must allow group members to create and edit shared files, make new files inherit the project's group, and prevent users from deleting files owned by other members. Propose an appropriate directory ownership and mode. Explain the purpose of every permission and special bit in your design.

28. A student deletes the original pathname of a file, but one hard link and one symbolic link to it exist elsewhere. Predict what happens to the file's data and to each remaining pathname. State the condition under which the data blocks and inode can finally be reclaimed.

## Deliverables

Submit `lab03-the-file-system.md` to TCU Online.

## Evaluation

- Conceptual accuracy and depth: 30%
- Command correctness and relevant output: 30%
- Explanations and interpretation: 20%
- Safe, reproducible investigation: 10%
- Complete and well-organized deliverables: 10%

Commands that require elevated privileges, modify system files, or operate outside the assignment workspace will not receive credit.
