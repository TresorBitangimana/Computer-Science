#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){

    if(argc == 1){
        fprintf(stdout,"hfunzip: file1 [file2 ...]\n");
        return(1);
    }

    for(int i = 1; i < argc; i++){
        char *file_name = argv[i];
        FILE *compressed_file = fopen(file_name, "rb"); //attempts to open the compressed file.
        if(compressed_file == NULL){
            fprintf(stderr,"could not open file: %s", file_name);
            return(1);
        }

        int count;
        int curr_c;

        while(fread(&count, sizeof(count), 1, compressed_file) == 1){ //while the file can be read, 
            curr_c = fgetc(compressed_file);
            if(curr_c == EOF){
                break;
            }
            for(int i = 0; i < count; i++){
                fputc(curr_c, stdout);
            }
        }
        fclose(compressed_file);
    }
    return 0;
}