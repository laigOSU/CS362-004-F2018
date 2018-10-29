
#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"
#include <string.h>
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <assert.h>


int main (int argc, char** argv)
{
  printf("****************************\n");
  printf("Unittest3 for buyCard()\n");
  printf("****************************\n");
	struct gameState myGame;
	int supplyPos = 1;

	printf("\nTesting when player has insufficient coins\n");
  myGame.numBuys = 1;
  myGame.coins = 0;

 	if(buyCard(supplyPos, &myGame) == -1){
    printf("Passed: Correctly returns error for insufficient coins\n");
  }

	else{
    printf("Failed: buyCard() incorrectly returns true\n");
  }

  printf("\nTesting when player has sufficient coins\n");
  myGame.numBuys = 1;
  myGame.coins = 20;

  if(buyCard(supplyPos, &myGame) == 0){
    printf("Passed:  Correctly returns true (no error) for sufficient coins\n");
  }
	else
		printf("Failed: buyCard() incorreectly returns error\n");

  return 0;
}
