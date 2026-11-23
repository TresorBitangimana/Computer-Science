# Tresor Bitangimana

# Assignment 2 — Interacting with the Bash Shell

## Purpose

Practice using Bash as an interactive command-line environment. This assignment emphasizes command discovery, command lookup, the command search path, input and output redirection, command history, job control, quoting, parameter expansion, shell startup files, and basic system identification.

## Learning objectives

After completing this assignment, you should be able to:

- distinguish Bash built-ins from external programs;
- locate documentation for built-in and external commands;
- explain how Bash uses `PATH` to locate commands;
- redirect standard input, standard output, and standard error;
- use command history and command-line editing to correct and repeat commands;
- manage foreground, background, and suspended jobs;
- apply quoting and parameter expansion correctly; and
- identify Bash startup files and basic Linux system information.

## Prerequisites

- Read Chapter 3, “Interacting with the Bash Shell.”
- Complete the Chapter 3 class examples and notes.
- Use babbage.cs.tcu.edu

## Safety and rules

- Work only in a directory that you own. Create and use `~/cosc30503/assignment02`.
- Do not modify system files, shell startup files, or files outside your assignment workspace.
- You may inspect `.bashrc` and `.bash_profile`, but do not edit them for this assignment.
- Show the command used and the relevant output for every practical question.
- Explain answers in your own words. A command or screenshot without an explanation is incomplete.
- Bash functions are not required and must not be used in this assignment.

## Tasks

### Part 1 — Commands and documentation

1. Explain why `cd` must be implemented as a shell built-in rather than only as an external program. Include a short demonstration or example in your explanation.

```
cd has to be a shell built-in command because it needs to be able to make changes to the parent shell, external commands run in a separent child process when extercuted and returns the results, then the process returns back to the parent shell, in this case the parent shell would not modified becausee everything happened in an external process. If the `cd` command was an exteral program, after running the command it would launch the external process, make the directory changes there and the process would return back the the parent shell but it would not have any modification because the changes happened in the child process. for example running `cd assignment02 &` this takes the process to a subshell where the command is exercuted and the process returns back to the parent shell but parent is not affected by the command.
```

2. Use a command to search manual-page names and descriptions for the keyword `archive`. Record the command and identify two relevant results.

```
apropos archive -> serches for commands thats maches or have the keyword archive in its description

relavant results:
tar (1)              - an archiving utility
```

3. Show how to obtain help for the Bash built-in `history`. Then show how to open the manual page for the external command `ls`. Explain why the documentation methods differ.

```
`help history` -> to obtain help for the built-in history command

`man ls` - to open the manual page for `ls`

These two commands differs because `history` is a built in command and `ls` is an external command. External commands have their own dedicated manual page so they can be access with `man (command)`, but build it command do not, so to get help for build it commands you have to run `help (command)` or `man bash` where all the build it commands are documented.
```

4. Identify two commands that are Bash built-ins and two commands that are external executable files. Show how you verified each classification.

```
built in commands:
pwd
cd

external commands:
find
grep

To verify what type of command a command is you run `type (command)`, the output tell you whether the command is build it or external
```

### Part 2 — The command search path

5. Display your current `PATH` with one directory per line. Identify the first directory in which Bash finds `ls`.

```
echo $PATH | tr `:` '\n' -> `echo $PATH` displays the current PATH and the resuts is piped into the translate command `tr `:` `\n`` which reparate the path by the `:` with a new line.

Bash find the `ls` command in `/usr/bin/ls` it can be found by running the command `which ls`.
```

6. Explain the risk of including `.` in `PATH`. If it were included, explain why its position relative to trusted system directories matters. Do not change your actual `PATH`.

```
Including `.` in `PATH` means that bash will also search your current directory for any executable files since `.` represents your current position in a directory.
If it were included, its position would matter because bash searches for commands in `PATH` in order, if the position of `.` was at the beginning of `PATH` bash would search your directory first for any exercutable files, but if it was last bash would search your current directory last also.
If your current directory was first and you happen to have any executable file with the same name as any trusted command like `cd`, bash would run the command found in your directory instead of the actual command you wanted, this could cause risk to security if you had a mallicious command in your current directory named `cd` and you tried to change directories, because the mallicous `cd` would run instead of the actual trusted `cd`.
```

7. Create an executable script named `hello` in your assignment directory. The script should contain only a shebang and one `echo` command. Run it using a relative pathname, and explain why typing only `hello` may not run it.

```
nano hello -> opens hello file in the editor.
content:
#!/bin/bash
echo "Hello World!!!"

save and exit nano

chmod +x hello -> gives all users exectube access to hello, making it an executable.

./hello -> runs the hello executable find using the relative path.

typing only `hello` does not execute the file because bash treats it as a regular command and it goes into the `PATH` to look for the command, and since hello is not in the `PATH` the executable file hello is not found.
```

### Part 3 — Input, output, and errors

8. Create a file named `names.txt` containing at least six unsorted names, one per line. Run `sort` so that it reads from `names.txt` and writes the sorted result to `sorted-names.txt`.

```
touch names.txt -> creates the names.txt file
nano names.txt -> opens the file with nano

content:
Marcus
Priya
Olivia
Deshawn
Yuki
Fatima

cat names.txt | sort > sorted-names.txt -> runs the print command from names.txt and sort them into sorted-names.txt
```

9. Run a command that produces normal output and a separate error. Append standard output to `out.log` and standard error to `error.log` in the same command. Show the contents of both files.

```
ls . /lab3 > out.log 2> error.log

the `ls . /lab3` command has two arguments, a valid path and a non valid parth, the valid path `.` runs and output the results in the out.log file and the `/lab3` does not exists so it throws an error and outputs the retutls in the error.log file.

the line `> out.log 2> error.log` tells bash to output standard output in the out.log file, or if it throws an error to output standard error in the error.log.
```

10. Run another command that sends both standard output and standard error to a single file named `combined.log`. Explain the order and meaning of the redirections you used.

```
ls . /lab3 > combined.log 2>&1

Similar to question 7, `ls . /lab3 > combined.log` logs the stdout into `combined.out` but `2>&1` tells bash to also direct the stderr to the same file where stdout is.
```

11. Suppose a student enters `cat first.txt >> second.txt` while intending to append `second.txt` to `first.txt`. Explain what actually happens and provide the correct command. Demonstrate with small sample files in your assignment directory.

```
the `cat first.txt >> second.txt` command concatenates the content of first.txt with the content of second.txt.

the correct command to append the content of second.txt to first.txt is `cat second.txt >> first.txt.

nano first.txt
Content: hello this is the first file.

nano second.txt
Content: hello this is the second file.

cat second.txt >> first.txt

content of first.txt turns into:
hello this is the first file.
hello this is the second file.
```

### Part 4 — History and command-line editing

12. Intentionally enter a harmless misspelled command such as `srot names.txt`. Use two different Bash history or command-line editing techniques to correct it to `sort names.txt` and run the corrected command. Record both techniques.

```
srot names.txt
fc

`fc` which means fix command, when executed will open a text editor with your last command, edit the command with the correct one, save and close the editor then bash will re-execute your last command with the right from the editor

srot names.txt
^srot^sort^

This automatically replaces your last command with the correct one, the first option is the previous misspelled command and the second option is the correct command, bash replaces the first command with the second command and re-execute it.
```

13. Display the five most recent commands in your Bash history. Explain what the history number represents and how to re-run a selected entry safely.

```
history | tail -5

The history number is the Nth number of command that was executed in the bash shell, the so command with 100 at the beginig is the 100th command that was executed.

you re-run the command you execute the command `!n` n being the history number.
```

14. Determine whether your current Bash command-line editing mode is Emacs or vi. Show the command used to inspect the setting, then show the command that would select the other mode. You do not need to make the change permanent.

```
bind -v | grep editing-mode -> find the current editing mode

my current editing mode is emacs

set -o vi -> changes the editing mode to vi
```

### Part 5 — Jobs and shell sessions

15. In your own words, distinguish a foreground job, a background job, and a suspended job.

```
- A foreground job is a visible process, that a user can interact with.

- A background job is a process running in the back, it is not visible to the user and they can not intereact with it

- A suspended job is a process that has been paused.
```

16. Start `sleep 120` in the foreground, suspend it, display the job list, resume it in the background, return it to the foreground, and terminate it safely. Record each command or keystroke and the resulting job status.

```
sleep 120 -> starts a sleep program

`^Z` | control Z -> suspends the program using the keyboard shortcut.

jobs -> outputs a list of jobs that are currently running.

bg %1 -> resumes the suspended job in the background.

fg %1 -> brings the job back to the foreground.

`^Z` then `kill %1` -> suspends the job with the keyboard shortcut `^Z` to bring back the input prompt and terminates the job with `kill %1`.

the `1` after the `%` sign can be replaced with the design job id.

```

17. Explain what Bash normally does when you try to exit an interactive shell that has stopped jobs. Do not leave unfinished jobs running after your test.

```
Bash displays the message:

logout
There are stopped jobs.

stopping you from exiting, then shows another input prompt, it does not allow you to exit while you have a job that has not completed, but when you exit a second time after the warning it allows you but the job remains active, bash kills the job.
```

18. Give three different ways to exit an interactive Bash session. For each, state whether it is a command, a built-in, or a keyboard action.

```
exit - shell build in command
logout - shell build in command
ctrl+D - keyboard shortcut
```

### Part 6 — Quoting and parameter expansion

19. Set `animal='red fox'`. Run commands that demonstrate the difference among `$animal`, `"$animal"`, and `'$animal'`. Explain word splitting and variable expansion in your results.

```
$animal -> outputs the actual value of the variable animal
output: red fox

"$animal" -> also outputs the actual value of the variable animal
outpit: red fox

'$animal' -> output the word inside the single quatation mark as it is, so the output would be `$animal`
output: $animal

No quatiation and double quatiation allows for variable expansion which outputs the value of the variable, but single quatation outputs everything inside the quatation as it is.

```

20. Create files named `report1.txt`, `report2.txt`, and `report-final.txt`. Demonstrate a glob that matches all three files and a glob that matches only the two numbered files. Explain each pattern.

```
ls report*.txt
output:
report1.txt  report2.txt  report-final.txt

ls report[1-2].txt
output:
report1.txt  report2.txt

the first glob matches all file starting with `report` and have any characters in between and ending with `.txt` which all files qualifies.

the second glob only matches files starting with `report` and have either the number 1 or 2 in between and ending with `.txt` which only the two numbered files qualifies.
```

21. Set `country=usa` and use Bash parameter expansion to display the value in uppercase. Record the command and result.

```
country=usa -> sets the value of `coutnry` to `usa`

echo $country
output: usa

echo ${country^^} echo's the output in uppercase
output: USA

```

22. Write one safe `echo` or `printf` command that displays this text exactly, including the dollar sign and asterisk: `The cost is $5 * 3`. Explain the quoting you chose.

```
echo 'The cost is $5 * 3'

single quataion allows for printing message with special characters as they are, any characters that have some function such as /, *, or $ do not take effect in single quatiatin marks.
```

### Part 7 — Startup files and system information

23. Explain the usual roles of `.bash_profile` and `.bashrc`. State which type of shell normally reads each file. Inspect your system and report which of these files exist in your home directory; do not modify them.

```
- the `.bash_profile` is read when a user first SSH into a remote machine to set the profile and program.
- the `.bashrc` is read everytime a user enters a new shell, everytime a new shell starts like a subshell; the `.bashrc` is read to set up the shell functions, aliases, and customizations.

ls -la ~ | grep -E '\.bash_profile|\.bashrc' -> searchs for the `.bash_profiles` and `.bashrc`.

output:
-rw-------   1 tbitangimana tbitangimana 3.7K Sep  8 13:26 .bashrc
-rw-rw-r--   1 tbitangimana tbitangimana 3.8K Sep  8 13:34 .bashrce
```

24. Display the Bash version and the Linux kernel version running on your system. Record the commands and briefly distinguish the two version numbers.

```
bash --version -> Bash version
GNU bash, version 5.2.21(1)-release (x86_64-pc-linux-gnu)

uname -a -> Linux Kernel version
Linux babbage 6.8.0-137-generic #137-Ubuntu SMP PREEMPT_DYNAMIC Fri Jul 17 20:28:23 UTC 2026 x86_64 x86_64 x86_64 GNU/Linux

- The Bash version is the version of the shell program that the user interacts with, it receives all the commands and provides the interactive environment.
- The Linux Kernel is what the Bash program runs on, it manages the hardware, interacts with the file systems, memory, and handles system calls.
```

## Deliverables

Submit one compressed archive named `lastname-firstname-assignment01.tar.gz` containing:

- `assignment01-answers.md`, with numbered answers matching Tasks 1–24;
- all files created for the practical tasks;
- `transcript.txt`, captured with `script`, showing the practical work; and
- `README.md`, containing your name, the date, the Linux distribution used, and instructions for extracting the archive.

Before submitting, extract the archive into a temporary directory and verify that every required file is present and readable. Do not include unrelated files, credentials, shell startup files, or your complete home-directory history.

## Evaluation

- Conceptual accuracy: 30%
- Command correctness and relevant output: 35%
- Explanations and interpretation: 20%
- Reproducibility and complete deliverables: 10%
- Organization and safe command use: 5%

Answers that use Bash functions will not receive credit for the affected task.
