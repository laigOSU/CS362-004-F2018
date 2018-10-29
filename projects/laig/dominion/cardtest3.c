#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

int main()
{
  printf("****************************\n");
  printf("Cardtest3 for Salvager Card\n");
  printf("****************************\n");

  int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
  int seed = 1000;
  int numPlayers = 2;
  int thisPlayer=0;
	struct gameState G, test;
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
			sea_hag, tribute, smithy, council_room};

	// initialize a game state and player cards
	initializeGame(numPlayers, k, seed, &G);

	// copy the game state to a test case
	memcpy(&test, &G, sizeof(struct gameState));
  thisPlayer = whoseTurn(&test);

	cardEffect(salvager, choice1, choice2, choice3, &G, handpos, &bonus);

  // Check if numBuys increased
  if(test.numBuys + 1 == G.numBuys)
    printf("Passed: Successfully performed +1 buy\n");
  else
    printf("Failed: Failed to perform +1 buy\n");

	// Check if properly discarded
	if(test.discardCount[thisPlayer] == G.discardCount[thisPlayer])
		printf("Passed where the Salvager was discarded\n");
	else
		printf("Failed where the Salvager was not discarded.\n");

  return 0;
}
