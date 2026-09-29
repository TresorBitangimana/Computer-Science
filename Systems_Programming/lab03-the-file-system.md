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

- Read Chapter 6, "The File System," in _Mastering Modern Linux, 2nd Edition_.
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

```
The Lunux file system is a hierarchy that contains files and directories arranged in a tree structure grows down from the root strucure / and branches out into everything. and an example of this is the path `/bin/bash` it is directly mounted on the linux file system.
The individual filesystem is a format for organizing and storing data on a device, the data structure depends on the device itsef for example the windows filesystem or a USB drive filesystem. and an example of this is the path `/dev/sd1` because it is mounted on `/media/usb` not the linux file system itself.

```

2. For each of `/etc`, `/home`, `/dev`, `/proc`, `/tmp`, `/usr`, and `/var`, state its usual purpose and identify one item found there on `babbage`. Do not modify any of these directories.

```
/etc -> System and application configuration, data, and maintanance, files such as the passwd, mime.types, and network service initialization and configuration are stored there. in babbage /etc does contain the sude.conf file.

/home -> Home directory for users, in babbage /home contains the directory of all the users logged in into babbage

/dev -> Stores all special files (divices) that act as interface between the OS and the hardware, in babbage this directory contains the I/O redirection files, stderr, stdin, and stdout

/proc -> Kernel run-time data files, in babbage /proc directory contains the driver directory

/tmp -> Folder that holds tempolary files for the system and the user, in babbage the /tmp folder contains the node-comple-cache

/usr -> contains all applications and their files, in babbage the /usr directory contains the bin directory

/var -> contains variables data files such as mail, printer spool folder, logs ...

```

3. Use `ls -ld` and `file` to investigate one regular file, one directory, one symbolic link, and one device file. Record the path, the file-type character shown by `ls`, and the description reported by `file` for each.

```
path: `assignment03/regular_file.txt`
A regular file, it is shown by the character `-`, and the description `regular_file.txt: ASCII text`

path: `assignment03/special_file`
A special file, a directory, it is shown by the character `d`, and the description `special_file: directory`

path: `assignment03/two.txt`
A symbolic link from file two.txt -> one.txt, it is shown by the character `l`, and the description `two.txt: symbolic link to one.txt`

path: `/dev/loop0`
A device file shown by the character `c`, and has the description `loop0: block special (7/0)`

```

4. Locate one character special file and one block special file, if both are visible on `babbage`. Record their major and minor device numbers and explain the general difference between character and block devices. If no block device is visible, document your search and explain why access may be restricted.

```
character special file
path: `/dev/ppp`
character special (108/0), the `0` is the minor and the `100` is the major device number.
The character special files stores data and can be accessed as a continuous stream of data in order, it does not allow random accessing.

block special file
path: `/dev/loop2`
block special (7/2), the `2` is the minor and the `7` is the major device number.
The block special file stores data in blocks, the data can be access in chunk or blocks of data, and in random order.

The main difference comes down to how data is stored and accessed.

```

5. Create a named pipe called `message.pipe` with `mkfifo`. Show how `ls -l` and `file` identify it, then explain how a named pipe differs from an ordinary file. Remove it when finished.

```
The named piped is shown by the character `p` with ls, and the description `message.pipe: fifo (named pipe)`,
A named pipe unlike a regular file does not store data, it is a pipe that only allows data to flow through it, it need a writer and a reader to be active and uses the first-in-first-out data flow, but it has a path like a regular file.

```

### Part 2 - Inodes and links

6. Create `original.txt` containing several lines of text. Create a hard link named `hard.txt` and a symbolic link named `symbolic.txt` that refer to it. Show the commands used.

```
`touch original.txt` -> Create the original text file

`ln original.txt hard.txt` -> Creates a hard link from the `original.txt` file to the `hard.txt` file

`ln -s original.txt symbolic.txt` -> Creates a symbolic link from the `original.txt` file to the `symbolic.txt` file

```

7. Use `ls -li` and `stat` to compare the three pathnames from Task 6. Record their inode numbers, link counts, file types, and sizes. Explain which metadata demonstrates the relationship among the files.

```
original.txt
inode: 154025, filetype: regular file `-`, size: 113, Links: 2

hard.txt
inode: 154025, filetype: regular file `-`, size: 113, Links 2

symbolic.txt
inode: 154024, filetype: symoblic link `l`, size: 12, Links 1

The original.txt and the hard.txt are identical, they all point to the same inode, have the same number of links and are the file size. but the symbolic link does not point to the same inode, it is a different file type and only has one link, the size is also extremely small compare to the original.txt. the inode, filetype, size and links tells the relationship between the two file. If the informaton are identical, then the files are hard link, but if they have different inodes, and the other is of type symbolic link but the two files are linked, then it is a symbolic link between the two.

```

8. Append a line through `hard.txt`, then display the contents through all three names. Explain the results in terms of directory entries and inodes.

```
`nano hard.txt` -> opens the hard.txt file in an editor - added the text `text from hard.txt`
`cat hard.txt` -> prints the text in hard.txt
`cat original.txt` -> prints the text in original.txt
`cat symbolic.txt` -> prints the text in symbolic.txt

all three files are separete directory entries, but they share links and content, any modification from one of the files applys to the other two. the original.txt and hard.txt share inode so they are identical copies of each other, and the symbolic.txt is a symbolic link that only has a path that points to the original.txt when called.

```

9. Remove `original.txt`. Test access through `hard.txt` and `symbolic.txt`, and explain why their behavior differs. Use an appropriate command to identify the dangling link.

```
`rm original.txt` -> removes the original.txt

`nano hard.txt` -> opens the hard.txt file with an editor - changed the text content
`cat hard.txt` -> prints the content of hard.txt
`cat symbolic.txt` -> prints the content of hard.txt
`ls -l` -> lists the file to verify the links

After removing the original.txt file the hard.txt fie remained the same since they shared an inode, they were not dependent on each other. but the symbolic.txt now has a dangling link since it only had the path to the orignal.txt so removing the original.txt leaves the symbolic.txt dangling. when attempting to `cat` it the error message `cat: symbolic.txt: No such file or directory` is outputed out.

```

10. Re-create `original.txt`, then make a symbolic link to a directory inside your assignment workspace. Explain two capabilities of symbolic links that hard links normally do not provide.

```
`touch original.txt` -> recreates the original.txt file
`mkdir next_dir` -> creates a new directory` -> creates a new directory inside the assignment workspace
`ln -s /home/tbitangimana/cosc30503/assignment03/next_dir next_link` -> creates a symbolic link to the `next directory`

Symbolic links are able to make a link to a directory but a hard link cannon and and hard link can not make a link if they are in different filesystem.
```

### Part 3 - Permissions and file status

11. Create `private.txt` and a directory named `access-test`. Record their initial modes and your current `umask`. Explain how the `umask` contributed to each initial mode.

```
`touch private.txt` -> creates a file named private.txt.
mode: -rw-rw-r--
`mkdir access-text` -> creates a direcotry named access-text.
mode: drwxrwxr-x
`umask` -> displays my current umask: 0002

a umask of 002 gives the user and the group automatic read and write permiissions but only gives the others only read permission, both the new file and directory created reflect this umask value, and by default files do nto have execute permission but directories do.
```

12. Set `private.txt` to mode `640` using numeric notation. Then produce the same mode using symbolic notation, starting from mode `000`. Explain every permission granted by `640`.

```
`chmod 640 private.txt` -> changes the permission of private.txt to 640.
mode: -rw-r-----
`chomd 000 private.txt` -> removes all permissions from the file.
mode: ----------
`chmod u+wr,g+r private.txt` -> recreate the 640 permissions using symbolic notation
mode: -rw-r-----

The permission 640 can be read as 110 100 000 separating each individual number and writing it in binary, each digit representing the user, group, and other in order, the 110 gives the user read and write permission, the 100 gives the group read read permission only, and 000 removes all permission from other.
```

13. Inside `access-test`, create `visible.txt`. Experiment safely with the directory modes `400`, `100`, `500`, and `700`. For each mode, test whether you can list the directory's names, access `visible.txt` when its name is known, and create or remove an entry. Restore mode `700` afterward and explain what `r`, `w`, and `x` mean for a directory.

```
`cd access-test` -> navigates to the access-text directory
`touch visible.txt` -> create the visible.txt file.

400 -> dr--------   cannot list
                    cannot access: permission denied
                    cannot list content
                    cannot create or remove entry

100 -> d--x------   can not list
                    can access directory
                    cannot list content
                    cannot create or remove an entry

500 -> dr-x------   can list
                    can access
                    can list content
                    cannon create or remove an entry

700 -> drwx------   can list
                    can access
                    can list content
                    can create and remove an entry

In a directory `r` means you can read what in the directory or list its content, `w` means you can create, delete and modify entries in the directory, and `x` makes the permissions `r` and `w` possible, without `x` you cannot read or write in the directory, you need both read and execute or write and axecute to actally read and white in the directory.

```

14. Use `stat` on a file you created. Identify its inode number, ownership, mode, size, link count, and access, modification, and status-change timestamps. Perform one safe operation that changes the modification time and another that changes only file metadata; show the relevant timestamp changes.

```
filepath: cosc30503/asssignment03/one.txt
`stat one.txt` -> show file stats

inode: 153881
ownership: tbitangimana tbitangimana
mode: -rw-rw-r--
size: 21
link count: 1
Access: (0664/-rw-rw-r--)  Uid: ( 6332/tbitangimana)   Gid: ( 6332/tbitangimana)
modification: 2026-09-27 16:15:47.447649263 -0500
change: 2026-09-27 16:15:47.447649263 -0500
Birth: 2026-09-25 12:11:57.513021044 -0500

`touch one.txt` -> makes modification to file
modification: 2026-09-27 16:21:45.743322156 -0500

`chmod 660 one.txt` -> changes file metadata
Access: (0660/-rw-rw----)  Uid: ( 6332/tbitangimana)   Gid: ( 6332/tbitangimana)
```

15. Explain the effects of the set-user-ID bit on an executable file, the set-group-ID bit on a directory, and the sticky bit on a shared directory. Find one example of any one of these special modes on `babbage` and show how `ls -ld` represents it. Do not change the example.

```
The set-user-ID bit on an executable file allows anyone who runs the file to take on the file owner's user id instead of the person running it. This allows regular users to run an executables that they woun't other wise be able to without any special previlages.
Example:

The set-group-ID bit on  a directory allows for any entries created in that directory to inherit the directory's group ID rather than the group ID of the person creating the entrie.
example: /home/tbitangimana

The stiky bit on a shared directory means that only the files or directory owner, and root can delete or rename anyname given entrie even though others have access to it.
Example:
```

16. Compare Discretionary Access Control (DAC) and Mandatory Access Control (MAC). Explain why DAC permissions might appear to allow an operation that a system using SELinux still denies.

```
The Descretionary Access Control the owner of reasource to decide who can access it, by either granting or denying access to the user, group, others with the rwx bits format. The Mandatory Access Control enforces a system wide security where every Linux system comes with its own security rules that are enforced automatically. The DAC permissions might appear to allow an operation that a system using SELinux still denies because the security systems are layers, the system first checks the DAC, and if it allows it then checks the MAC for permission, if the MAC denies then the process can not be done, or if the DAC denies then the process can not be done.
```

### Part 4 - Filesystem implementation

17. Explain the roles of data blocks, inodes, the inode list, block groups, and the superblock in an ext-family filesystem. Which of these stores a file's name, and which stores its content?

```
The `data blocks` are chunks of data with a fixed size of 4096 bytes that contains the actual content of a file including its name.

The `inode` is a record of a file's or directory's meta data exempt for the name, it points to the data blocks that hold the files information.

The `inode list` is an array of inodes.

The `block group`contains a duplicate compy of crucial filesystem control information (superblock and group descriptoers) and the block group's own block bitmap, and also i-node bitmap, i-list, and data blocks.

The `superblock`defines a filesystem, it records vital information about the configuration, organization, and operations of a file system:
    The filesystem type and a block device reference
    The overall size and block size of the filesystem
    The length of the i-node list
    Free blocks and free i-nodes
    Read, write, and other methods for i-nodes


```

### Part 5 - Searching the file tree

18. Build a directory tree named `search-tree` containing at least three subdirectories, ten regular files with varied extensions, one hidden file, and one symbolic link. Include at least three `.c` files and at least two files whose names contain a space. Show the command or commands used to create it.

```

`mkdir search-tree` -> Creates the search tree directory
`cd search-tree` -> navigates in side the earch tree
`mkdir subone subtwo subthree` -> creates subdirectores subone, subtwo, and subthre

`cd subone` -> navigate to subdirectory one
`touch helloworld.txt go.c text.txt` -> creates the files helloworld.txt, go.c, and text.txt

`cd ..` -> nagivates back to the search tree directory
`cd subtwo` -> nagivates to subtwo directory
`touch script.c .hidden "file one.txt"` creates the files script.c, .hidden, and "file one.txt"

`cd ..` -> nagivates back to the search tree directory
`cd subthree` -> nagivates to thee directory
`touch runnable.c "text file.txt" names.txt final.txt` creates the files runnable.c, "text file.txt", names.txt and final.txt
`ln -s final.txt last.txt` -> creates a new symbolic link file final.txt that link to the file final.txt

```

19. Write `find` commands that search `search-tree` for each of the following. Explain the quoting used in each command:
    a. all regular files ending in `.c`;
    b. all directories;
    c. all files whose names contain a space;
    d. all regular files except `.c` files; and
    e. symbolic links only.

```
`cd cosc30503/assignment03` -> navigates to the directory where the search-tree is located

`find search-tree -type f -name "*.c"` -> finds all regular files in search-tree with the name ending with .c using name expansion "*.c"

`find search-tree -type d` -> searches for all directories inside the search-tree

`find search-tree -type f -name "* *" -> searches for all regular files with a space in the file name using name explansion "* *" of any file that have a space in between the name.

`find search-tree -type f ! -name "*.c"` -> finds all regular files that do not have a name ending with "*.c" using name expansion

`find search-tree -type l` -> finds all symbolic link files in the tree
```

20. Create a reference file with `touch`, wait long enough to establish a clear timestamp boundary, and then create two more files. Use `find -newer` to select only files newer than the reference file. Record the commands and results.

```
`touch old.txt` -> creates a file named old.txt
Birth: 2026-09-27 23:26:31.381128888 -0500
...waits three minutes...
`touch new.txt` -> creates a file named new.txt
Birth: 2026-09-27 23:30:14.613767714 -0500

`tounch newer.txt` creates a file named newer.txt
Birth: 2026-09-27 23:31:31.218331346 -0500

`find -newer old.txt` -> finds files created after old.txt
output: ./newer.txt
        ./script.txt
        ./new.txt
```

21. Use one `find` command with Boolean OR to locate files ending in either `.c` or `.md`. Then use `find -exec` with a non-destructive command to report the line count of every `.c` file. Explain `{}`, the command terminator, and why shell quoting or escaping is necessary.

```
`find search-tree -name "*.c" -o -name "*.md"` -> locate in the search-tree all file ending with either `.c` or `.md`.

`find search-tree -name "*.c" -exec wc -l {} \;` -> located all files in the search-tree ending with "*.c" and with the line count of each file.
            The `-exec` tells the `find` command to run the command followed for every file that it finds.

            The `{}` is a place holder for each individual path that the `find` command finds. it it then replaces it with the actual path of the file ending with .c that it found then runs the word count on it. so for every file `find` locates with the condition, it replaces `{}` with the path and runs the word count command on it. return the word word along with the file found.

            The `\;` ends the command and runs it once for every file that was matched.
```

22. Compare `find` and `locate`: describe what each searches, why `locate` is often faster, and why its results may be stale. If `locate` is installed on `babbage`, demonstrate both commands while searching for one known file; otherwise, document that it is unavailable.

```
The `find` command goes through the entire tree searching each file one by one for any that match the condition.
The `locate` command seaches an index database that contains the files, the data base is updated periodically by a background process called `updatedb`.
The `locate` command is often faster because it searches through an index database rather than having to go through a whole tree, its results may be stale because the database is updated periodically so it sometimes might be out of date.

`find search-tree -name "text.txt"` -> seaches for a file named `text.txt` using the `find` command
`locate text.txt` -> seaches for a file named `text.txt` using the `locate` command
```

### Part 6 - Archives, compression, and integrity

23. Create a gzip-compressed tar archive named `search-tree.tar.gz` containing your entire `search-tree`. List the archive's contents without extracting it and explain the tar options used.

```
`tar -czvf search-tree.tar.gz search-tree` -> creates an archive of the search tree
options:
        -c  creates new artchive
        -z  compress the archive using gzip
        -v  print each file and directory name thats added
        -f  specifies the archive file name.
```

24. Create an empty directory named `restored-tree` and extract the archive there without overwriting your original tree. Compare the original and restored trees with `diff -r`. Record the result and explain what it indicates.

```
`mkdir restored-tree` -> creates a new directory named restored-tree.
`cp search-tree.tar.gz restored-tree` -> copies the compress search-tree into the restored-tree directory.
`cd restored-tree` -> navigates to the restored-tree directory
`tar -xzvf search-tree.tar.gz` -> de-compresses the search-tree
`cd ..` -> navigates back to the assignemnt03 directory
`diff -r search-tree restored-tree/search-tree` compares the two trees. the command did not output anythign which indicates that the trees were identical.

```

25. Create an xz-compressed tar archive of the same tree. Compare the byte sizes of the uncompressed data, the gzip archive, and the xz archive. Explain why the smallest result for this small sample may not establish which compression method is always best.

```
`tar -cJvf search-tree.tar.xz search-tree` compresses the seach-tree using xz-cpmpression
`ls -li search-tree.tar.gz search-tree.tar.xz` -> lists the two compressed search-trees the xz and gz.

search-tree.tar.gz size: 412
search-tree.tar.xz size: 420

The compretion ratio is highly dependent on the data size.

```

26. Make a copy of `search-tree.tar.gz` named `checksum-test.tar.gz`. Generate a SHA-256 checksum file for the copy and verify it successfully. Then alter `checksum-test.tar.gz` and demonstrate that verification detects the change. Explain what an integrity checksum can and cannot prove.

```
`cp search-tree.tar.gz checksum-test.tar.gz` -> copies the search-tree.tar.gz to checksum-test.tar.gz
`sha256sum checksum-test.tar.gz > checksum-test.tar.gz.sha256` -> generate a SHA-256 checksum file of the copy
`sha256sum -c checksum-test.tar.gz.sha256` verifify
`cat checksum-test.tar.gz.sha256` -> prints the content of the SHA-256 checksum file
`echo "bad data" >> checksum-test.tar.gz` -> alters the checksum file
`sha256sum -c checksum-test.tar.gz.sha256` -> verify

```

### Part 7 - Synthesis

27. A project directory must allow group members to create and edit shared files, make new files inherit the project's group, and prevent users from deleting files owned by other members. Propose an appropriate directory ownership and mode. Explain the purpose of every permission and special bit in your design.

```
`mkdir project` -> creates a new directory
`chown tbitangimana:project-users project` -> gives the directory an owner and group
`chmod 3775 project` -> sets the gid and sticky bit and also gives the appropriate permissions

In the chmod command the first digit 3 sets both the gid and the stick bit allowing every file created in the directory to inherite the directory's group id rather than the user id, and also restricts user from deleting or re-naming other users files.

The following 775 sets the permissions for the directory to `rwx rwx r-x` giving the owner and group read write and execute permissions.
```

28. A student deletes the original pathname of a file, but one hard link and one symbolic link to it exist elsewhere. Predict what happens to the file's data and to each remaining pathname. State the condition under which the data blocks and inode can finally be reclaimed.

```
When the student deletes the original pathname, the data from the original path can still be accessed through the hard link because hard links points to the same inode, so the information of the hard link will always be the same as the original file. But the deletion of the original filepath will leave the symbolic link as a danglink link where it points to a path but the path does not exists, so when the user tries to access the symbolic link it will through a file not does not exists error.
```

## Deliverables

Submit `lab03-the-file-system.md` to TCU Online.

## Evaluation

- Conceptual accuracy and depth: 30%
- Command correctness and relevant output: 30%
- Explanations and interpretation: 20%
- Safe, reproducible investigation: 10%
- Complete and well-organized deliverables: 10%

Commands that require elevated privileges, modify system files, or operate outside the assignment workspace will not receive credit.
