#include <string.h>
#include <stdio.h>
#include <stdlib.h>

//=======================================================================================
// Objects
//=======================================================================================

//creates a Data object that does the key value pair to be stored as Node data.
typedef struct{
    int key;
    char *value;
} Data;

typedef struct{
    char command;
    Data data;
} Request;

Request create_request(char command, int key, char *value){
    Data data = {key, value};
    Request request = {command, data};
    return request;
}

//=======================================================================================
// Function Headers
//=======================================================================================

void db_put(int key, char *value);
void db_get(int key);
void db_delete(int k);
void db_clear(void);
void db_all(void);
int db_key_exists(int key,int print);
Request *verify_tokens(char *tokens[]);

//=======================================================================================
// Main function
//=======================================================================================

int main(int argc, char *argv[]){
    if(argc == 1){
        return(0);
    }

    int user_arguments = argc-1;
    //will store invidual requestion, {command,{key, value}}
    Request **requests = calloc(user_arguments, sizeof *requests);
    if(requests == NULL) return(1);

    
    for(int i = 0; i < user_arguments; i++){ //for all arguments
        char *req = argv[i+1];
        char *tokens[3] = {NULL, NULL, NULL};
        char *token;
        int count = 0;

        while(count < 3 && (token = strsep(&req, ",")) != NULL){ //break the arguments int individual tokens separated by ','
            tokens[count++] = token; //insert the tokens into an array of length 3 with the indivudual tokens
        }        

        requests[i] = verify_tokens(tokens);
    }

    for(int i = 0; i < user_arguments; i++){ //for every request (command line argument) the user inputs
        if(requests[i] == NULL ) continue;

        char comm = requests[i]->command;
        int key = requests[i]->data.key;
        char *value = requests[i]->data.value;

        switch(comm){
            case 'p': db_put(key, value); break;
            case 'g': db_get(key); break;
            case 'd': db_delete(key); break;
            case 'c': db_clear(); break;
            case 'a': db_all(); break;
        }
    }

    for(int i =0; i < user_arguments; i++)
        free(requests[i]);
    free(requests);

    return(0);
}

//=======================================================================================
// Functions
//=======================================================================================

void db_put(int key, char *value){
    FILE *database = fopen("database.txt", "a");
    if(database == NULL){
        fprintf(stdout, "%d not found\n", key);
        return;
    }

    if(!db_key_exists(key, 0)){
        //write the perimeter key and value into the database file
        fprintf(database, "%d>%s\n", key, value);
    }else{ //key does already exists
        fprintf(stderr, "key already exists: %d\n", key);
    }

    if(database != NULL )fclose(database);
}

void db_get(int key){

    FILE *database = fopen("database.txt", "r");
    if(database == NULL){
        fprintf(stdout, "could not open database\n");
        return;
    }


    int found = 0;
    char line[256];
    while(fgets(line, sizeof line, database) != NULL){
        line[strcspn(line, "\n")] = '\0'; //stri the trailing newline

        char *l = line;
        char *curr_kv[2] = {NULL, NULL};
        char *token;
        int count = 0;

        while(count < 2 && (token = strsep(&l, ">")) != NULL){  //break the line into individual key 
                                                                //and value and stole them in   curr_kv
            curr_kv[count++] = token; //insert the tokens into an array of length 2 with the indivudual tokens
        }

        if(curr_kv[1] != NULL && atoi(curr_kv[0]) == key){
            fprintf(stdout, "%s,%s\n", curr_kv[0], curr_kv[1]);
            found = 1;
        }
    }
    if(!found){
        fprintf(stdout, "%d not found\n", key);
    }
    if(database != NULL) fclose(database);   
}

void db_delete(int key){
    FILE *database = fopen("database.txt", "r");
    if(database == NULL){
        fprintf(stderr, "could not open database\n");
        return;
    }

    if(!db_key_exists(key, 1)){
        fclose(database);
        return;
    }

    int capacity = 8;
    int capacity_count = 0;
    char **kv_db = calloc(capacity, sizeof(char *));
    if(kv_db == NULL){
        fclose(database);
        return;
    }

    char line[256];
    while(fgets(line, sizeof line, database) != NULL){ //while each line in the database is not equal to null
        line[strcspn(line,"\n")] = '\0'; // strip the trailing newline

        char *l = line;
        char *curr_kv[2] = {NULL, NULL};
        char *token;
        int count = 0;

        while(count < 2 && (token = strsep(&l, ">")) != NULL){  //break the line into individual key 
                                                                //and value and stole them in   curr_kv
            curr_kv[count++] = token; //insert the tokens into an array of length 2 with the indivudual tokens
        }   
        
        if(capacity_count == capacity){ //kv_db is full so we need to double its size
            int new_cap = capacity * 2;
            char **temp = realloc(kv_db, new_cap * sizeof(char *));
            if(temp == NULL){
                perror("realloc");

                for (int i = 0; i < capacity_count; i++) {
                    free(kv_db[i]);
                }
                free(kv_db);
                fclose(database);
                return;
            }
            kv_db = temp;
            capacity = new_cap;
        }

        if(atoi(curr_kv[0]) == key){   //if the perimeter key mateches the curr_kv key
                                       //it needs to be removed so it will not be included in the list
            continue;
        }

        // Allocate memory for the new entry
        int entry_size = strlen(curr_kv[0]) + strlen(curr_kv[1]) + 2;

        char *entry = malloc(entry_size);
        if (entry == NULL) {
            perror("malloc");
            for (int i = 0; i < capacity_count; i++) {
                free(kv_db[i]);
            }
            free(kv_db);
            fclose(database);
            return;
        }

        // Reconstruct key and value
        snprintf(entry, entry_size, "%s>%s", curr_kv[0], curr_kv[1]);

        kv_db[capacity_count] = entry;
        capacity_count++;
    }
    fclose(database);
    //after the loop that copies every entry in the 
    //database except the one that need to be deleted
    //we overide the database file to be empty and rewrite it with the entries in our kv_db array
    FILE *db_overide = fopen("database.txt", "w");
    if(db_overide == NULL){
        fprintf(stderr, "could not open database\n");
        for(int i = 0; i < capacity_count; i++){
            free(kv_db[i]);
        }
        free(kv_db);
        return;
    }

    //iterates thorugh the kv_db and copies every entry into the database.txt
    for(int i = 0; i < capacity_count; i++){
        fprintf(db_overide,"%s\n", kv_db[i]);
    }

    for(int i = 0; i < capacity_count; i++){
        free(kv_db[i]);
    }
    free(kv_db);
    fclose(db_overide);
}

void db_clear(){ //opens and closes the file, it is an operation so it clear the file.
    FILE *database = fopen("database.txt", "w");
    if(database == NULL){
        fprintf(stderr, "could not open database\n");
        return;
    }
    if(database != NULL) fclose(database);
}

void db_all(){
    FILE *database = fopen("database.txt", "r");
    if(database == NULL){
        fprintf(stderr, "could not open database\n");
        return;
    }

    char line[256];
    while(fgets(line, sizeof line, database) != NULL){
        line[strcspn(line, "\n")] = '\0'; //stri the trailing newline

        char *l = line;
        char *curr_kv[2] = {NULL, NULL};
        char *token;
        int count = 0;

        while(count < 2 && (token = strsep(&l, ">")) != NULL){  //break the line into individual key 
                                                                //and value and stole them in   curr_kv
            curr_kv[count++] = token; //insert the tokens into an array of length 2 with the indivudual tokens
        }

        if(curr_kv[1] != NULL){
            fprintf(stdout, "%s,%s\n", curr_kv[0], curr_kv[1]);
        }
    }
    if(database != NULL) fclose(database);  
}

int db_key_exists(int key, int print){

    FILE *database = fopen("database.txt", "r");
    if(database == NULL){
        fprintf(stderr, "could not open database\n");
        return(1);
    }


    int found = 0;
    char line[256];
    while(fgets(line, sizeof line, database) != NULL){ //while each line in the database is not equal to null
        line[strcspn(line,"\n")] = '\0'; // strip the trailing newline

        char *l = line;
        char *curr_kv[2] = {NULL, NULL};
        char *token;
        int count = 0;

        while(count < 2 && (token = strsep(&l, ">")) != NULL){  //break the line into individual key 
                                                                //and value and stole them in   curr_kv
            curr_kv[count++] = token; //insert the tokens into an array of length 2 with the indivudual tokens
        }      
        if(atoi(curr_kv[0]) == key){ //if the perimeter key mateches the curr_kv key
                                //a key already exists, so re return with 1
            found = 1;
            fclose(database);
            return(1); //return false
        }
    }


    if(print && !found){ //calling function chooses if it want to print not found message.
        fprintf(stdout,"%d not found\n", key); //key not found
    }

    fclose(database);
    return(0); //no matching key was found, so we exit with a status code of 0 which is true
}

//varifies the command to make sure its a valid command
Request *verify_tokens(char *tokens[]){
    char command = tokens[0][0];
    int key = 0;
    if(tokens[1] != NULL) key = atoi(tokens[1]);


    char *value = "";
    if(tokens[2] != NULL) value = tokens[2];
    int k = 0;

    if(command != '\0' && strchr("pgdca", command) != NULL){ //checks if the command char matches the valid chars
        k = 1;
    } 

    if(k){
        //adds tokens the request
        // Request req = create_request(command, key, value);

        Request *req = malloc(sizeof(Request));
        if(req == NULL) return NULL;
        *req = create_request(command, key, value);
        return req;
    }

    printf("bad command\n");
    //prints the failed token to stderr
    fprintf(stderr, "Error: fail token: %s,%s,%s\n",
            tokens[0] ? tokens[0] : "",
            tokens[1] ? tokens[1] : "",
            tokens[2] ? tokens[2] : "");

    return NULL; //returns the request without the token with error
}