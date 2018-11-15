#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include <time.h>

#define NUM_TESTS 25
int main()
{
  // int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
  int handpos = 0, bonus = 0;

  struct gameState G, test;
  int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
      sea_hag, tribute, smithy, council_room};

  srand(time(NULL));

  SelectStream(2);
  PutSeed(3);

  for (int n = 0; n < NUM_TESTS; n++) {

    printf("******************************************\n");
    printf("Random Test for Adventurer Card, Test# %d\n", n+1);
    printf("******************************************\n");

    int numPlayers = (rand() % 256);
    int seed = (rand() % 256);
    int choice1 = (rand() % 2);
    int choice2 = (rand() % 2);
    int choice3 = (rand() % 2);

    // printf("numPlayers is: %d\n", numPlayers);
    // printf("seed is: %d\n", seed);

    // initialize a game state and player cards
    initializeGame(numPlayers, k, seed, &G);

    // copy the game state to a test case
    memcpy(&test, &G, sizeof(struct gameState));

    cardEffect(adventurer, choice1, choice2, choice3, &G, handpos, &bonus);

    // Check if played adventurer card draw cards
  	if(test.playedCardCount + 2 == G.playedCardCount)
  		printf("Passed: Adventurer successfully revealed two Treasure cards\n");
  	else
  		printf("Failed: Did not reveal two Treasure cards\n");

  	// Confirm that no actions added
  	if(test.numActions == G.numActions)
  		printf("Passed:  Correctly played Adventurer (no excessive actions)\n");
  	else
  		printf("Failed:  Incorrectly played Adventurer, should not use actions\n");

    printf("\n");
  }
  return 0;
}
