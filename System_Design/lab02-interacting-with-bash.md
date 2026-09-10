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
2. Use a command to search manual-page names and descriptions for the keyword `archive`. Record the command and identify two relevant results.
3. Show how to obtain help for the Bash built-in `history`. Then show how to open the manual page for the external command `ls`. Explain why the documentation methods differ.
4. Identify two commands that are Bash built-ins and two commands that are external executable files. Show how you verified each classification.

### Part 2 — The command search path

5. Display your current `PATH` with one directory per line. Identify the first directory in which Bash finds `ls`.
6. Explain the risk of including `.` in `PATH`. If it were included, explain why its position relative to trusted system directories matters. Do not change your actual `PATH`.
7. Create an executable script named `hello` in your assignment directory. The script should contain only a shebang and one `echo` command. Run it using a relative pathname, and explain why typing only `hello` may not run it.

### Part 3 — Input, output, and errors

8. Create a file named `names.txt` containing at least six unsorted names, one per line. Run `sort` so that it reads from `names.txt` and writes the sorted result to `sorted-names.txt`.
9. Run a command that produces normal output and a separate error. Append standard output to `out.log` and standard error to `error.log` in the same command. Show the contents of both files.
10. Run another command that sends both standard output and standard error to a single file named `combined.log`. Explain the order and meaning of the redirections you used.
11. Suppose a student enters `cat first.txt >> second.txt` while intending to append `second.txt` to `first.txt`. Explain what actually happens and provide the correct command. Demonstrate with small sample files in your assignment directory.

### Part 4 — History and command-line editing

12. Intentionally enter a harmless misspelled command such as `srot names.txt`. Use two different Bash history or command-line editing techniques to correct it to `sort names.txt` and run the corrected command. Record both techniques.
13. Display the five most recent commands in your Bash history. Explain what the history number represents and how to re-run a selected entry safely.
14. Determine whether your current Bash command-line editing mode is Emacs or vi. Show the command used to inspect the setting, then show the command that would select the other mode. You do not need to make the change permanent.

### Part 5 — Jobs and shell sessions

15. In your own words, distinguish a foreground job, a background job, and a suspended job.
16. Start `sleep 120` in the foreground, suspend it, display the job list, resume it in the background, return it to the foreground, and terminate it safely. Record each command or keystroke and the resulting job status.
17. Explain what Bash normally does when you try to exit an interactive shell that has stopped jobs. Do not leave unfinished jobs running after your test.
18. Give three different ways to exit an interactive Bash session. For each, state whether it is a command, a built-in, or a keyboard action.

### Part 6 — Quoting and parameter expansion

19. Set `animal='red fox'`. Run commands that demonstrate the difference among `$animal`, `"$animal"`, and `'$animal'`. Explain word splitting and variable expansion in your results.
20. Create files named `report1.txt`, `report2.txt`, and `report-final.txt`. Demonstrate a glob that matches all three files and a glob that matches only the two numbered files. Explain each pattern.
21. Set `country=usa` and use Bash parameter expansion to display the value in uppercase. Record the command and result.
22. Write one safe `echo` or `printf` command that displays this text exactly, including the dollar sign and asterisk: `The cost is $5 * 3`. Explain the quoting you chose.

### Part 7 — Startup files and system information

23. Explain the usual roles of `.bash_profile` and `.bashrc`. State which type of shell normally reads each file. Inspect your system and report which of these files exist in your home directory; do not modify them.
24. Display the Bash version and the Linux kernel version running on your system. Record the commands and briefly distinguish the two version numbers.

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
