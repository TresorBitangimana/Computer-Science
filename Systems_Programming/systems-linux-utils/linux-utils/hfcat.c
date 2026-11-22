#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int cat(char *f, FILE *destination, int multi);

int main(int argc, char *argv[]){

    int exist_status = 0;

    if(argc == 1){ // if no input file or output file is given
        char *line = NULL;
        size_t cap = 0;
        while(getline(&line, &cap, stdin) != -1){
            line[strcspn(line, "\n")] = '\0';   // strip the trailing newline
            fprintf(stdout,"%s\n", line);
        }
        free(line);
    }
    else if (argc == 2){ //if we only have to print out a single file to stdout
        exist_status = cat(argv[1], stdout, 0);
    }
    else if(argc == 3 && (strcmp(argv[1], ">") == 0 || strcmp(argv[1], ">>") == 0)){ // if no input file is given but only a
                                                                                    //redirection to an output file
        FILE *destination;
        if(strcmp(argv[1], ">") == 0){
            destination = fopen(argv[argc-1], "w"); //attempts to open the output file.
            if(destination == NULL){
                fprintf(stderr, "could not open file %s\n", argv[argc-1]);
                return(1);
            }
            char *line = NULL;
            size_t cap = 0;
            while(getline(&line, &cap, stdin) != -1){
                line[strcspn(line, "\n")] = '\0';   // strip the trailing newline
                fprintf(destination,"%s\n", line);
            }
            free(line);
        }else if(strcmp(argv[1], ">>") == 0){
            destination = fopen(argv[argc-1], "a"); //attempts to open the output file with append.
            if(destination == NULL){
                fprintf(stderr, "could not open file %s\n", argv[argc-1]);
                return(1);
            }
            char *line = NULL;
            size_t cap = 0;
            while(getline(&line, &cap, stdin) != -1){
                line[strcspn(line, "\n")] = '\0';   // strip the trailing newline
                fprintf(destination,"%s\n", line);
            }
            free(line);
        }
        fclose(destination);
    }

    else{ //multi file print or with redirection
        int cat_all = 1;
        for(int i = 1; i < argc; i++){ //checks if we have a specified output file to add or append
            if( strcmp(argv[i], ">") == 0 || strcmp(argv[i], ">>") == 0){
                cat_all = 0;
            }
        }

        if(cat_all){ //if we do not have to cancaticate the files into a another file
            for(int i = 1; i < argc; i++){
                if (cat(argv[i], stdout, 1)) exist_status = 1;
            }
        }else{ // we have to cancaticate into another file

            if(strcmp(argv[argc-2], ">") != 0 && strcmp(argv[argc-2], ">>") != 0){
                fprintf(stderr, "error: redirection must be second to last argument\n");
                return(1);
            }

            FILE *destination = fopen(argv[argc-1], strcmp(argv[argc-2], ">") == 0 ? "w" : "a");
            if(destination == NULL){
                fprintf(stderr, "could not open file %s\n", argv[argc-1]);
                return(1);
            }

            int multi = 0;
            if(argc > 4){
                multi = 1;
            }
            for(int i = 1; i < argc-2; i++){ 
               if (cat(argv[i], destination, multi)) exist_status = 1;
            }

            fclose(destination);
        }
    }
    return(exist_status);
}

int cat(char *f, FILE *destination, int multi){
    FILE *file = fopen(f, "r");
    if(file == NULL){
        fflush(stdout); //makes sure stdout is completely printed out before stderr
        // fprintf(stdout, "%c", '\n');
        fprintf(stderr, "could not open file %s\n", f);
        return(1);
    }

    char line[256];
    while((fgets(line, sizeof line, file)) != NULL){ //loops through the file line by line and prints each line.

        if(feof(file) && !multi){   // if we have reached the end of a file print the last line with a newline 
                                    // and we are only printing a single file
            fprintf(destination, "%s\n", line);
        }
        else{
            fprintf(destination, "%s", line);
        }
    }

    fclose(file);
    return(0);
}