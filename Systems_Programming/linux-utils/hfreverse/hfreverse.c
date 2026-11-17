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

    //initializes the pointer to the input and output files
    FILE *input_file = NULL;
    FILE *output_file = NULL;

    //tries to open the file and check if the file was able to open
    //if not return an error and exists with an exit status of 1
    input_file = fopen(argv[1], "r");
    if(input_file == NULL){
        fprintf(stderr, "error: cannot open file '%s'\n", argv[1]);
        return(1); 
    }

    fseek(input_file, 0, SEEK_END); //sets the file position indicator to the end of the file
    long end = ftell(input_file);   //gets the current value of the files position
    long line_end = end; 


    int output_to_file = 0;
    if(argc == 3){ //if program has 3 arguments
        output_to_file = 1;
        //attempts to open the outout file
        output_file = fopen(argv[2], "w"); //try to open output file
        if(output_file == NULL){ //if output file is null, return status code 1 with error
            fprintf(stderr, "error: cannot open file '%s'\n", argv[2]);
            fclose(input_file);
            return(1); 
        }
    }
    
    if(end == 0){ //is the file is empty
        fclose(input_file);
        if(output_file != NULL) fclose(output_file);
        return(0);
    }

    //if the program has 2 arguments then, reads the output into standard out
    for(long position = end -1; position >= -1; position--){  //for position = end of the file
        int is_start = (position == -1); //is position nonzero?
        if(!is_start){ //if we have not passed the start of the file
            fseek(input_file, position, SEEK_SET); 
            int c = fgetc(input_file);  //gets the current character
            is_start = (c == '\n' && position != end - 1);  // if c is a the line character '\n' 
                                                            // and we have not reached the end of the file, then is_start = true
        }
        if(output_to_file){ //if output has to be read in output file
            if(is_start){
                fseek(input_file, position +1, SEEK_SET); //moves the read position to the beginning
                for (long k = position + 1; k < line_end; k++) { //for line of text
                    int c = fgetc(input_file); //gets current char
                    if (c == '\n') break;  
                        fputc(c, output_file);
                }
                fputc('\n', output_file);
                line_end = position + 1;
            }
        }else{ //if output has to go to stdout
            if(is_start){
                fseek(input_file, position +1, SEEK_SET); //moves the read position to the beginning
                for (long k = position + 1; k < line_end; k++) { //for line of text
                    int c = fgetc(input_file); //gets current char
                    if (c == '\n') break;  
                        fputc(c, stdout);
                }
                fputc('\n', stdout);
                line_end = position + 1;
            }
        }
    }

    if (input_file) fclose(input_file);
    if (output_file) fclose(output_file);

    
    return(0);
}