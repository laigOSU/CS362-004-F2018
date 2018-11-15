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

	struct gameState G, test;
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
			sea_hag, tribute, smithy, council_room};

	srand(time(NULL));

  SelectStream(2);
  PutSeed(3);

	for(int n = 0; n < NUM_TESTS; n++){
		printf("***********************************************\n");
		printf("Random Test Card 2 for Smithy Card, Test# %d\n", n+1);
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

		cardEffect(smithy, choice1, choice2, choice3, &G, handpos, &bonus);
		int thisPlayer = whoseTurn(&test);

	 //Check if played Smithy card and drew 3 cards
	 if(test.playedCardCount + 3 == G.playedCardCount)
		 printf("Passed: Smithy correctly drew 3 cards\n");
	 else
		 printf("Failed: Failed to draw 3 cards\n");

	 // Check if properly discarded
	 if(test.discardCount[thisPlayer] == G.discardCount[thisPlayer])
		 printf("Passed: Smithy properly discarded from hand\n");
	 else
		 printf("Failed: Failed to properly discard Smithy card.\n");

		printf("\n");
	}

	return 0;
}
