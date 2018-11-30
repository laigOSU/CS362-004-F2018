#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>
#include<time.h>

#define NUM_TESTS 25

int main()
{
	int handpos = 0, bonus = 0;
  // int seed = 1000;
  // int numPlayers = 2;
  // int thisPlayer = 0;

	struct gameState G, test;
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
			sea_hag, tribute, smithy, council_room};

	srand(time(NULL));

  SelectStream(2);
  PutSeed(3);

	for(int n = 0; n < NUM_TESTS; n++){
		printf("***********************************************\n");
		printf("Random Test Card 1 for Outpost Card, Test# %d\n", n+1);
		printf("***********************************************\n");

		int numPlayers = (rand() % 256);
		int seed = (rand() % 256);
		int choice1 = (rand() % 2);
		int choice2 = (rand() % 2);
		int choice3 = (rand() % 2);

		// initialize a game state and player cards
		initializeGame(numPlayers, k, seed, &G);

		// copy the game state to a test case
		memcpy(&test, &G, sizeof(struct gameState));
		cardEffect(outpost, choice1, choice2, choice3, &G, handpos, &bonus);

		int thisPlayer = whoseTurn(&test);

		// Check for outpost flag
	  if(test.outpostPlayed + 1 == G.outpostPlayed)
	    printf("Passed: Outpost flag in struct gameState successfully set\n");
	  else
	    printf("Failed: Failed to set outpost flag\n");

		// Check if properly discarded
		if(test.discardCount[thisPlayer] == G.discardCount[thisPlayer])
			printf("Passed: Properly discarded Outpost card.\n");
		else
			printf("Failed: Did not properly discard Outpost card.\n");

		// Check no improper actions were taken
		if(test.numActions == G.numActions)
			printf("Passed: Did not take extra or improper actions\n");
		else
			printf("Failed: Improperly made an action(s)\n");

		printf("\n");
	}
	return 0;
}
