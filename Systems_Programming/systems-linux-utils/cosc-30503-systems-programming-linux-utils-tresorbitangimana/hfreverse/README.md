# Printing the Lines of Text File in Reverse Order 

Write a program called `hfreverse`. This program should be invoked in one of the following ways:
```
prompt> ./hfreverse input.txt
prompt> ./hfreverse input.txt output.txt
```

An input file might look like this: 
```
hello
this
is 
a file
```

The goal of the `hfreverse` program is to read in the data from the specified input file and print the lines in reverse order.  Thus, for the aforementioned example, the output should be:

```
a file
is
this
hello
```

When invoked with just one command-line argument, the user supplies the input file, and the output will be printed to **standard output**, or `stdout` for short.

When invoked with two command-line arguments, the program should read from the input file the and the output will go to the output file.

# Details
There are several ways to write this program.
* Read all the lines into a dynamic array (aka std::vector) and then traverse the array backwards.
* Push each line of text on to a stack (aka std::stack) and then pop each string off the stack.
* Use the run-time stack and recursion similar to the previous suggestion.
* Use an dynamic array (aka std::vector) to store index positions.  Then seek and print the lines in reverse index order.
* Start from the end of the file and seek backwards, character by character looking for newlines.
* Start at the end of the file and break the file into chunks (4KB blocks) and reverse the lines in each chunk.

## Assumptions and Error Checking
- **Algorithmic Complexity:** To receive full credit for this project:
  - Your solution must not be recursive (10 pts)
  - Your solution must have $O(n)$ time complexity where $n$ is the length of the file (10 pts)
  - Your solution must have $O(1)$ space complexity.  Your local functions may not create any local arrays, strings, files, etc.  You may not use any dynamic memory allocation functions (i.e. `malloc()`) (15 pts).
  
- **Input is the same as output:** If the input file and output file are the same file, you should print out an error message `error: input and output file must differ` and exit with return code 1.

- **String length:** You may not assume anything about how long a line should be. Thus, you may have to read in a very long input line.

- **File length:** You may not assume anything about the length of the file, i.e., it may be **VERY** long.

- **Invalid files:** If the user specifies an input file or output file, and for some reason, when you try to open said file (e.g., `input.txt`) and fail, you should print out the following exact error message: `error: cannot open file 'input.txt'` and then exit with return code 1 (i.e., call `exit(1);`).

- **Too many or too few arguments passed to program:** If the user runs `hfreverse` with too many or too few  arguments, print `usage: hfreverse <input> [output]` and exit with return code 1. 

- **How to print error messages:** On any error, you should print the error to the screen using `fprintf()`, and send the error message to `stderr` (standard error) and not `stdout` (standard output). This is accomplished in your C code as follows: `fprintf(stderr, "whatever the error message is\n");`


## Useful Routines

To exit, call `exit(1)`. The number you pass to `exit()`, in this case 1, is then available to the user to see if the program returned an error (i.e., return a non-zero) or exited cleanly (i.e., returned 0).

For reading in the input file, the following routines will make your life easy: `fopen()`, `getline()` (hint, hint, read the man page closely, hint), `fgetc()`, and `fclose()`.

For moving around in a file, the following routines will make your life easy: `fseek()`, `ftell`, `fsetpos()`, and `fgetpos()`.

For printing (to screen, or to a file), use `fprintf()`.  Note that it is easy to write to standard output by passing `stdout` to `fprintf()`; it is also easy to write to a file by passing in the `FILE *` returned by `fopen`, e.g., `fp=fopen(...); fprintf(fp, ...);`.


## Tips

**Start small, and get things working incrementally.** For example, first get a program that simply reads in the input file, one line at a time, and prints out what it reads in. Then, slowly add features and test them as you
go.

**Testing is critical.** A great programmer once said you have to write five to ten lines of test code for every line of code you produce. Testing your code to make sure it works is crucial. Write tests to see if your code handles all the cases you think it should. Be as comprehensive as you can be. Of course, when grading your projects, I will be. Thus, it is better if you find your bugs first, before I do.


