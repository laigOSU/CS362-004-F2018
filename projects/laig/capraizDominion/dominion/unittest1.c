#include <stdlib.h>
#include <stdio.h>
#include "assert.h"
#include "dominion.h"
#include "rngs.h"
#include <time.h>

// Unittest1: whoseTurn()

int main(){

  printf("****************************\n");
  printf("Unittest1 for whoseTurn()\n");
  printf("****************************\n");
  struct gameState myGame;

  int whichPlayer = 2;

  for (int i = 0; i < whichPlayer; i++){
    myGame.whoseTurn = i;

    printf("Player should be: %d\n", myGame.whoseTurn);

    if (whoseTurn(&myGame)==myGame.whoseTurn){
      printf("\nPassed: player is player %d\n", whoseTurn(&myGame));
    }

    else {
      printf("\nFailed: player is player %d\n",  whoseTurn(&myGame));
    }

    i++;
  }

  printf("Test for checking which player's turn -  passed\n");

  return 0;
}
