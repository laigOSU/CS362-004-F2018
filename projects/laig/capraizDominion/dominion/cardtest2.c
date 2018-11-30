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
  printf("Cardtest2 for Smithy Card\n");
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

  cardEffect(smithy, choice1, choice2, choice3, &G, handpos, &bonus);

	//Check if played Smithy card and drew correct cards
	if(test.playedCardCount + 1 == G.playedCardCount)
		printf("Passed: Smithy correctly drew 3 cards\n");
	else
		printf("Failed: Failed to draw 3 cards\n");
    
  // Check if properly discarded
  if(test.discardCount[thisPlayer] == G.discardCount[thisPlayer])
  	printf("Passed: Smithy properly discarded from hand\n");
  else
  	printf("Failed: Failed to properly discard Smithy card.\n");

  return 0;
}

