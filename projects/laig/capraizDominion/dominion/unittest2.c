#include <stdlib.h>
#include <stdio.h>
#include "assert.h"
#include "dominion.h"
#include "rngs.h"
#include <time.h>

// Unit Test for isGameOver() function

int main(){
  printf("****************************\n");
  printf ("Unittest2 for isGameOver()\n");
  printf("****************************\n");

  struct gameState myGame;
  int k[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  initializeGame(2, k, 2, &myGame);

  // Province pile empty
  myGame.supplyCount[province] = 0;
  if (isGameOver(&myGame) == 1)
    printf("Passed:  Empty province pile correctly returns isGameOver() as true\n");
  else
    printf("Failed:  Empty province pile incorrectly returns isGameOver() as true\n");
  // For any three piles empty:
  for (int i = 0; i < 3; i++){
    myGame.supplyCount[i] = 0;
  }
  if (isGameOver(&myGame)== 1)
    printf("Passed:  Test three empty piles correctly returns isGameOver() as true\n");
  else
    printf("Failed:  Test three empty piles incorectly returns isGameOver() as false\n");

  return 0;
}
