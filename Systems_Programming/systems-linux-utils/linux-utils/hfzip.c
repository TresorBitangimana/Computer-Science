#include <string.h>
#include <stdio.h>
#include <stdlib.h>

void compress(FILE *f, char *f_name);

int main(int argc, char *argv[]){

    if(argc == 2){
        char *file_name = argv[1]; 
        FILE *file = fopen(file_name, "r"); //attemps to open the file
        if(file == NULL){
            fprintf(stdout, "could not open file: %s\n", file_name);
            return(1);
        }

        compress(file, file_name);
        fclose(file);
    }else{
        fprintf(stdout, "Usage: ./hfzip [file ...]\n");
    }
    return(0);
}

void compress(FILE *f, char *f_name){
    char *output_file_name = strcat(f_name, ".zip");
    FILE *output_file = fopen(output_file_name, "w");
    if(output_file == NULL){
        fprintf(stdout,"could not open output file: %s\n", output_file_name);
        return;
    }

    int c;
    while ((c = fgetc(f)) != EOF) {
        // putchar(c);
        fputc(c, output_file);
    }


    fclose(output_file);
}