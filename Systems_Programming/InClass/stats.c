//************************************
// Includes and defines
//************************************

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//************************************
// Function prototypes
//************************************

int min(int arr[], int size);
int max(int arr[], int size);
int sum(int arr[], int size);
int average(int arr[], int size);
int *bubble_sort(int arr[], int size);

//************************************
// Main function
//************************************

int MAX = 30;

int main(int argc, char *args[]){

	//local variables
	int arr[MAX];

	//initialize the array
	for(int ii=0; ii<MAX; ii++)
		arr[ii] = 0;

	//fill the array with random numbers in the range [1-99]
	srand(time(NULL)); //makes it actaully generate random numbers
	for(int ii=0; ii<MAX; ii++){
		arr[ii] = rand()%99 +1;
	}

	//prints all the numbers in the array in a list
	for(int ii=0; ii<MAX; ii++){
		printf("%d ", arr[ii]);
	}
	printf("\n");
	printf("\n");


	// compute and print the minimun
	int minVal = min(arr, MAX);
	printf(" The minimum value is : %d\n", minVal);

        printf("\n");
        printf("\n");


        // compute and print the maximun
        int maxVal = max(arr, MAX);
        printf(" The minimum value is : %d\n", maxVal);

	// compute the average
	int ave = average(arr , MAX);
	printf("The average value is: %d\n ",ave);

	// sorts an array
	int *newArr = bubble_sort(arr, MAX);
	//prints all the numbers in the array in a list
        for(int ii=0; ii<MAX; ii++){
                printf("%d ", newArr[ii]);
        }

	printf("\n");
        printf("\n");

	return(0);
}


//************************************
// min function
//************************************

int min(int arr[], int size){

	int minVal = 1000;

	for(int ii=0; ii<size; ii++){
		if(arr[ii] < minVal)
			minVal = arr[ii];
	}
	return (minVal);
}


//************************************
// max function
//************************************

int max(int arr[], int size){

        int maxVal = 0;

        for(int ii=0; ii<size; ii++){
               if(arr[ii] > maxVal)
                        maxVal = arr[ii];
        }
        return (maxVal);
}

//************************************
// sum function
//************************************

int sum(int arr[], int size){

	int sum = 0;

	for(int ii=0; ii<size; ii++)
		sum += arr[ii];
	return(sum);
}


//************************************
// average function
//************************************

int  average(int arr[], int size){
	return(sum(arr, size)/size);
}

//************************************
// bubble sort
//***********************************

// Sorts arr in place (ascending) and returns the same pointer.
int *bubble_sort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int swapped = 0;
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
                swapped = 1;
            }
        }
        if (!swapped) break;  // already sorted, stop early
    }
    return arr;
}
