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
  printf("Cardtest1 for Adventurer Card\n");
  printf("****************************\n");

  int handpos = 0, choice1 = 0, choice2 = 0, choice3 = 0, bonus = 0;
  int seed = 1000;
  int numPlayers = 2;
	struct gameState G, test;
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
			sea_hag, tribute, smithy, council_room};

	// initialize a game state and player cards
	initializeGame(numPlayers, k, seed, &G);

	// copy the game state to a test case
	memcpy(&test, &G, sizeof(struct gameState));

	cardEffect(adventurer, choice1, choice2, choice3, &G, handpos, &bonus);

	//Check if played adventurer card draw cards
	if(test.playedCardCount + 2 == G.playedCardCount)
		printf("Passed: Adventurer successfully revealed two Treasure cards\n");
	else
		printf("Failed: Did not reveal two Treasure cards\n");

	//Confirm that no actions added
	if(test.numActions == G.numActions)
		printf("Passed:  Correctly played Adventurer (no excessive actions)\n");
	else
		printf("Failed:  Incorrectly played Adventurer, should not use actions\n");

  return 0;
}
