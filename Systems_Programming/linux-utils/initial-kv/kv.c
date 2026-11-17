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

//creates a Node object that stores a Data object as data
typedef struct Node {
    Data data;
    struct Node *next;
} Node;

typedef struct {
    Node *top;
} Stack;

void stack_init(Stack *s){
    s->top = NULL;
}

int empty_stack(Stack *s){
    return s->top == NULL;
} 

//pushes a new node
int stack_push(Stack *s, Data d){
    Node *n = malloc(sizeof(Node));
    if(n == NULL){
        return -1;
    }
    n->data.key = d.key;
    n->data.value = d.value;

    n->next = s->top; //new node points and the old top
    s->top = n;       //new node becomes the top
    return(0);
}

// pops a node from a stack and returns its value
Data *stack_pop(Stack *s){
    if(s->top == NULL) return NULL;

    Data *data = malloc(sizeof(Data));
    if(data == NULL) return NULL;

    Node *n = s->top;

    data->key = n->data.key;
    data->value = n->data.value;

    s->top = n->next;
    free(n);   // free the node only, not the string
    return data;
}

//=======================================================================================
// Function Headers
//=======================================================================================

void db_put(Data *data);
Data *db_get(char *key);
void db_delete(char *k);
void db_clear();
void db_all();
int db_kv_exists();
char *verify_tokens(char *tokens, char *request);


//=======================================================================================
// Main function
//=======================================================================================

int main(int argc, char *argv[]){

    //if the user does not provide any addition arguments then 
    //we open the database.txt and close it, if the database did not exists it is created
    //then exit with a status code of 0.
    if(argc == 1){
        FILE *database = fopen("database.txt", "r+");
        if(database == NULL){
            fprintf(stderr,"database does not exists:\n Creating database......\n");
            database = fopen("database.txt", "w");
        }
        fclose(database);
        return(1);
    }

    //will store invidual requestion, {command,{key, value}}
    char *request = malloc(sizeof(Request));

    
    for(int i = 1; i < argc; i++){ //for all arguments
        char *req = argv[i];
        char *tokens[3];
        char *token;
        int count = 0;

        while((token = strsep(&req, ",")) != NULL){ //break the arguments int individual tokens separated by ','
            tokens[count++] = token; //insert the tokens into an array of length 3 with the indivudual tokens
        }        

        request = verify_tokens(tokens, request);

        //separate individual arugments into tokens
        //check the tokens to be char, int, string
        //call approprivate functions
        //create an request Object of the command, key, and value pair
        //insert the Request Object into the array of Request objects

    }

    return(1);
}

//=======================================================================================
// Functions
//=======================================================================================

void db_put(Data *data){

}

Data *db_get(char *key){

    Data *data = malloc(sizeof(Data));

    return data;
}

void db_delete(char *k){

}

void db_clear(){

}

void db_all(){

}

int db_kv_exists(){
    return(0);
}

char *verify_tokens(char *tokens, char *request){
    char *verified_tokens = malloc(sizeof(char *));
    char valid_commands[5] = {'p','g','a','c','d'};

    char command = tokens[1];
    // char key = tokens[2];
    // int value = tokens[3];
    int k = 0;
    // int c = 0; 
    // int v = 0;

    for(int i = 0; i < 5; i++){ //checks if the command is equal to any of the valid commands
        if(command == valid_commands[i]){
            k = 1;
        }
    }

    if(k){
        //adds token the request
        return request;
    }

    char * faild_token = strcat(tokens[0], tokens[1]);
    faild_token = strcat(faild_token, tokens[3]);

    fprintf(stderr, "Error: fail token: %s", faild_token); //prints the failed token to std out.
    return request; //returns the request without the token with error
}