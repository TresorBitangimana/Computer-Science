#include <string.h>
#include <stdio.h>
#include <stdlib.h>

void grep(FILE *f, char *pattern);

int main(int argc, char *argv[]){

    if(argc == 1){
        printf("hfgrep: searchterm [file ...]\n");
        return(1);
    }
    if(argc == 2){
        char *pattern = argv[1];
        grep(stdin, pattern);
        return(0);
    }
    else if(argc == 3){
        char *file_name = argv[argc-1];
        char *pattern = argv[1];
        FILE *file = fopen(file_name, "r");
        if(file == NULL){
            fprintf(stdout, "hfgrep: cannot open file\n");
            return(1);
        }
        grep(file, pattern);
        fclose(file);
    }
    else if(argc > 3){
        char *pattern = argv[1];

        for(int i = 2; i < argc; i++){
            
            char *file_name = argv[i];
            FILE *file = fopen(file_name, "r");
            if(file == NULL){
                fprintf(stdout, "hfgrep: cannot open file\n");
                return(1);
            }
            grep(file, pattern);
            fclose(file);
        }
    }

    return(0);
}

void grep(FILE *f, char *pattern){

    char line[256];
    while(fgets(line, sizeof line, f) != NULL){

        if(feof(f)){
            if(strstr(line, pattern) != NULL){
                fprintf(stdout, "%s\n", line);
            }
        }else{
            if(strstr(line, pattern) != NULL){
                fprintf(stdout, "%s", line);
            }
        }
    }
}