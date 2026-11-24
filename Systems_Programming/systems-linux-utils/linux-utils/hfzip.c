#include <string.h>
#include <stdio.h>
#include <stdlib.h>

void compress(FILE *f, FILE *f_out, int *cur, int *count);

int main(int argc, char *argv[]){
    if(argc >= 2){ // if there are multiple files 
        // char *output_file_name = "out.zip";
        // FILE *output_file = fopen(output_file_name, "wb"); //attempts to open the output .zip file wb = read binary
        // if(output_file == NULL){
        //     fprintf(stderr,"could not open output file: %s\n", output_file_name);
        //     return(1);
        // }

        int char_check = EOF;
        int count = 1;

        for(int i = 1; i < argc; i++){ //we iterate n number of times and compress every file. n = number of files
            char *file_name = argv[i]; 
            FILE *file = fopen(file_name, "rb"); //attemps to open the file, rb = write binary
            if(file == NULL){
                fprintf(stderr, "could not open file: %s\n", file_name);
                return(1);
            }

            FILE *output_file = stdout;
            compress(file, output_file, &char_check, &count); //call the compress function
            fclose(file);
        }

        if(char_check != EOF){                                  // final run
            // fwrite(&count, sizeof(count), 1, output_file);
            // fputc(char_check, output_file);
            fwrite(&count, sizeof(count), 1, stdout);  //copies raw bytes from memory to the output.
            fputc(char_check, stdout); //writes one character as a single byte.
        }

        // fclose(output_file);
    }
    else{
        fprintf(stdout, "hfzip: file1 [file2 ...]\n");
        return(1);
    }
    return(0);
}

void compress(FILE *f_in, FILE *f_out,int *char_check, int *count){

    int curr_c;
    while ((curr_c = fgetc(f_in)) != EOF) {

        if (curr_c == *char_check) { //if current char = same char as current checking char
            (*count)++;
        }
        else{
            if(*char_check != EOF){
                fwrite(count, sizeof(*count), 1, f_out);
                fputc(*char_check, f_out);
            }
            *char_check = curr_c;
            *count = 1;
        } 
    }
}