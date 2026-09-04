# Tresor Bitangimana

# Lab 1 — Linux Command Scavenger Hunt

## Purpose

Practice navigating Linux, discovering commands through local documentation, combining utilities, redirecting output, and recording reproducible work.

## Rules

- Use `man`, `info`, `apropos`, `whatis`, `--help`, and course notes.
- Record every command used and only the requested output.
- Do not modify system files or inspect directories you are not authorized to access.
- Use a dedicated `~/cosc30503/lab01` workspace.

## Part 1 — Navigation and setup

1. Display the current directory and change to your home directory.

```
pwd
cd
```

2. Create `~/cosc30503/lab01` with `practice` and `notes` subdirectories.

```
mkdir -p ~/cosc30503/lab01
cd cosc30503
cd lab01
mkdir practice && mkdir notes
```

3. Create three empty text files in `practice`.

```
cd practice
touch file1.txt file2.txt file3.txt
```

4. Display the resulting tree or recursive listing.

```
tree
```

5. Return home using `cd` with no arguments.

```
cd
```

## Part 2 — Discover the system

Find commands that display the current calendar, username, numeric user ID, hostname, system uptime, disk usage, available memory, and current shell. Record the command and a short interpretation of its output.

```
date -> shows the current calender date inlucding the time with time zone.

whoami -> displays the username name of the current user.

id -u -> id shows the user ids and -u displays the specific uid.

hostname -> displays the of the host name.

uptime -p -> timeup shows the current time, how long the system has been up, how many users are logged in and the load average. and the -p shows the uptime only in a clear readable format.

df -h  -> shows the disk useage in KG, MB, and GB when used with the -h flag for a more readable format.

free -h -> shows the free available memory in MB, and GB when used with the -h flag for a more readable format.

echo $0 -> prints the name of the current shell process
```

## Part 3 — File investigation

1. Identify the file type of `/bin/bash` (or the installed Bash path).

```
file /bin/bash -> determines the file type.

which -> located and displays a command path in the terminal.
```

2. Display the permissions of your home directory.

```
ls -ld -> ls -l shows the list of directories and files with the permission string at the beginning, and when you add -d it shows the information of the actual directory starting with the permission string.
```

3. List hidden entries in your home directory.

```
ls -a ~ | grep '^\.' -> ls lists all the files in a directory including hidden files that starts with `.` and results is fed into `grep` a command filters to only show the hidden files in a list format.
```

4. Report the space used by your lab directory.

```
du -sh ~/cosc30503/lab01 -> displays the lab01 usage information, -s makes sure subdirectory uses is not displayed and -h make the information human-readable.
```

5. Explain the difference between a file's apparent size and disk usage.

```
apparent size -> is the actual size of the file and its content.

disk usage -> is how much space the file take up in the storage when stored, which can be different from the apparent size.

```

## Part 4 — Search

- Search for regular files in the /etc directory ending in `.conf`;

```
find /etc -type f -name "*.conf" -> the find command accepts a path and a name of directories and files to find, the -type f flag specifies that only files are to be shown.
```

- Search for shell scripts (ending in .sh) in /usr/bin

```
find /usr/bin -type f -name "*.sh"
```

- Identify empty directories in your home directory

```
find ~ -type d -empty -> finds all the empty directories in from the home directory which specifies by the `~`
```

- Search for executable regular files.

```
find ~ -type f -executable
```

Suppress or explain any permission errors rather than hiding unexplained failures.

## Part 5 — Documentation

1. Find the manual-page sections that document the shell `printf` and C-library `printf`.

```
man -f printf -> shows you the manual-pages sections available
```

2. Identify the commands that search manual descriptions and display one-line descriptions.

```
apropos `keyword` -> searches for commands based on keywords.

whatis `keyword` -> shows a single line description of a command
```

3. Find the `ls` option for human-readable sizes.

```
ls -lh
```

4. Find the `cp` option that prompts before overwriting.

```
cp -i
```

## Part 6 — Pipes and redirection

1. Display the first five entries in `/etc` in a deterministic order.

```
ls /etc | head -n 5 -> display the first 5 entries of /etc
```

2. Count users currently logged in.

```
users | wc -w -> gets the users and display the number of the first fied which is the number of users loggedin.
```

3. Save a long listing of the lab directory to `listing.txt`.

```
cd cosc30503/lab01 && ls -l > listing.txt -> lavigates to the directory and saves a long listing of the lab directory to listing.txt
```

4. Append the current date.

```
date >> listing.txt
```

5. Run one successful and one failing command, saving normal output and errors separately.

```
ls > output.txt 2> errors.txt -> successful

ls /helloWorld > output2.txt 2> errors2.txt -> failed
```

## Part 7 — Permissions

Create `practice/run-me`, add owner execute permission, remove group/other write permission, and display the result. Explain every permission bit shown.

## Challenge

1. Count environment variables in the current environment.
2. Find executables in a directory on `PATH` whose names begin with `git`.
3. Identify the largest regular file within your lab workspace.
4. Find a useful command you had not previously used and cite the documentation that explains it.

## Deliverables

- `lab01-answers.md` containing each answer, command, and requested output.
- A terminal transcript captured with `script`.
- The complete `lab01` workspace.

## Evaluation

Correctness 50%, reproducibility 25%, explanations 15%, organization and safe command use 10%.
