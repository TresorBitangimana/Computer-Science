
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]){

    //checks if the program has arguments less than 2 or greater than 3, returns
    //a status code of 1 with usage message is so.
    if(argc < 2 || argc > 3){
        fprintf(stderr, "usage: hfreverse <input> [output]\n");
        return(1);
    }
    //checks if the program has 3 argument, then checks if the two files are the same
    //returns an error and status code of 1 of the two argument files are the same
    if(argc == 3){
        if(strcmp(argv[1], argv[2]) == 0){ //strcmp compares two files
            fprintf(stderr, "error: input and output file must differ\n");
            return(1);
        }
    }

    // size_t capacity = 8;
    // size_t line_count = 0;
    // char **lines = malloc(capacity * sizeof(char *));
    // if(lines == NULL){
    //     perror("malloc");
    //     return(1);
    // }

    // char *line = NULL; // getline will allocate this
    // size_t len = 0;  // current size of the buffer
    // ssize_t nread;

    //initializes the pointer to the input and output files
    FILE *input_file;
    FILE *output_file;

    //tries to open the file and check if the file was able to open
    //if not return an error and exists with an exit status of 1
    input_file = fopen(argv[1], "r");
    if(input_file == NULL){
        fprintf(stderr, "error: cannot open file '%s'\n", argv[1]);
        return(1); 
    }

    fseek(input_file, 0, SEEK_END);
    long end = ftell(input_file);
    long line_end = end;

    for(long position = end -1; position >= -1; position--){
        int is_start = position -1;
        if(!is_start){
            fseek(input_file, position, SEEK_SET);
            int c = fgetc(input_file); 
            is_start = (c == '\n' && position != end - 1);  // a '\n' ends the previous line, except the file's final newline
        }
        else{
            fseek(input_file, 0, SEEK_SET);
                    for (long k = position + 1; k < line_end; k++) {
            int c = fgetc(input_file);
            if (c == '\n') break;
            fputc(c, stdout);
        }
        fputc('\n', stdout);
        line_end = position + 1;
        }
    }

    //if the program has 2 arguments then, reads the output into standard out
    if(argc == 2){

        

        // while((nread = getline(&line, &len, input_file)) != -1){    //while the file has a next line, read the line and 
        //                                                             //insert it into the lines array
        //     if(line_count == capacity){
        //         capacity *= 2;
        //         char **temp = realloc(lines, capacity * sizeof(char *));
        //         if(temp == NULL){
        //             perror("realloc");
        //             free(lines);
        //             return(1);
        //         }
        //         lines = temp;
        //     }
        //     lines[line_count++] = strdup(line);   // copy, since getline reuses its buffer
        // }

        // //iterates through the lines array that stores the individual lines and prints them from the end to start
        // for(size_t i = line_count; i > 0; i--){
        //     //checks if the line ends with a '\n', usually the last line of a files does not end with a trailing '\n'
        //     size_t n = strlen(lines[i - 1]);
        //     if(n > 0 && lines[i - 1][n - 1] == '\n'){
        //         fprintf(stdout,"%s", lines[i-1]);
        //         free(lines[i-1]);
        //     }else{
        //         fprintf(stdout,"%s\n", lines[i-1]);
        //         free(lines[i-1]);
        //     }
        // }
    }else if(argc == 3){ //it it has 3 arguments, then reads the output into output file

        output_file = fopen(argv[2], "w");  //tries to open the output file
        if(output_file == NULL){            //checks if the output file was opened successfully
            fprintf(stderr, "error: cannot open file '%s'\n", argv[2]);
            if (input_file) fclose(input_file);
            return(1); 
        }

        // while((nread = getline(&line, &len, input_file)) != -1){    //while the file has a next line, read the line and 
        //                                                             //insert it into the lines array
        //     if(line_count == capacity){
        //         capacity *= 2;
        //         char **temp = realloc(lines, capacity * sizeof(char *));
        //         if(temp == NULL){
        //             perror("realloc");
        //             free(lines);
        //             return(1);
        //         }
        //         lines = temp;
        //     }
        //     lines[line_count++] = strdup(line);   // copy, since getline reuses its buffer
        // }

        // //iterates through the lines array that stores the individual lines and prints them from the end to start
        // for(size_t i = line_count; i > 0; i--){
        //     //checks if the line ends with a '\n', usually the last line of a files does not end with a trailing '\n'
        //     size_t n = strlen(lines[i - 1]);
        //     if(n > 0 && lines[i - 1][n - 1] == '\n'){
        //         fprintf(output_file,"%s", lines[i-1]);
        //         free(lines[i-1]);
        //     }else{
        //         fprintf(output_file,"%s\n", lines[i-1]);
        //         free(lines[i-1]);
        //     }
        // }
    }

    // free(line);
    // free(lines);
    //close the files if they were opened
    if (input_file) fclose(input_file);
    if (output_file) fclose(output_file);

    
    return(0);
}