#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"
#include <string.h>
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>

int main ()
{
  printf("****************************\n");
  printf("Unittest4 for updateCoins()\n");
  printf("****************************\n");

  struct gameState state;
	int i = 0;
  int feedAmount = 5;
  int runningAmount = 0;

	//Add Copper
	printf("Add copper coins\n");
	for (i = 0; i < feedAmount; i++)
		state.hand[0][i] = copper;

	updateCoins(0,&state, 0);
  runningAmount += feedAmount;

	if(state.coins == runningAmount)
		printf("Passed: Expected: %d, Actual: %d\n", runningAmount, state.coins);
	else
		printf("Failed: Expected: %d, Actual: %d\n", runningAmount, state.coins);


	//Add Silver
	printf("Add silver coins\n");
	for (i = 0; i < feedAmount; i++)
		state.hand[0][i] = silver;

	updateCoins(0,&state, 0);
  runningAmount += feedAmount;

  if(state.coins == runningAmount)
		printf("Passed: Expected: %d, Actual: %d\n", runningAmount, state.coins);
	else
		printf("Failed: Expected: %d, Actual: %d\n", runningAmount, state.coins);


	//Add Gold
	printf("Add gold coins\n");
	for (i = 0; i < feedAmount; i++)
		state.hand[0][i] = gold;

	updateCoins(0,&state, 0);
  runningAmount += feedAmount;

  if(state.coins == runningAmount)
    printf("Passed: Expected: %d, Actual: %d\n", runningAmount, state.coins);
  else
    printf("Failed: Expected: %d, Actual: %d\n", runningAmount, state.coins);
}
