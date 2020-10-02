import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackjackV1 {

	ArrayList deck = new ArrayList();
	ArrayList playerCards = new ArrayList();
	ArrayList dealerCards = new ArrayList();
	Scanner scan = new Scanner(System.in);
	int dealer_sum=0;
	int player_sum=0;

	public void play() {
		System.out.println("Welcome to the game!");
		createDeck();
		showDeck();
		Collections.shuffle(deck);
		showDeck();
		dealToPlayer();
		dealToPlayer();
		dealToDealer();
		dealToDealer();
		showPlayerCards();
		showDealerCards();
		playerChoice();
		dealerChoice();
		checkWinner();
	}



	public void showDealerCards() {
		System.out.println("Dealer has the following cards: ");
		for(int i = 0;i<dealerCards.size();i++)
		{
			Card c = (Card) dealerCards.get(i);
			System.out.println(c.suit + c.rank);
		}
		System.out.println("Sum of dealer cards: "+ dealer_sum);
	}
	public void showPlayerCards() {
		System.out.println("Player has the following cards: ");
		for(int i = 0;i<playerCards.size();i++)
		{
			Card c = (Card) playerCards.get(i);
			System.out.println(c.suit + c.rank);

		}
		System.out.println("Sum of player cards: "+ player_sum);
	}






	public void dealToDealer() {
		Card c = (Card) deck.remove(0); //casting
		dealerCards.add(c);
		dealer_sum+= c.rank;
		if(dealer_sum > 21) {
			System.out.println("Dealer Lost!");
			System.exit(0);
		}
	}




	public void dealToPlayer() {
		Card c = (Card) deck.remove(0); //casting
		playerCards.add(c);
		player_sum+=c.rank;
	}


	public void createDeck() {
		// Create a deck of 52 cards
		String[] suits = new String[] { "H", "D", "C", "S" }; // Heart, Diamond, Club, Spade
		for (int j = 0; j < 4; j++) {

			for (int i = 1; i <= 13; i++) {
				Card card = new Card();
				card.suit = suits[j]; // suits[0]=H, suits[1]=D, suits[2]=C, suits[3]=S
				card.rank = i;
				deck.add(card);
			}
		}
	}
	public void showDeck() {

		for(int i = 0;i<deck.size();i++)
		{
			Card c = (Card) deck.get(i);
			System.out.println(i + ": " + c.suit + c.rank);
		}
	}

	public void playerChoice() {

		int userAction;

		do
		{

			System.out.println("Player turn! \nPress 1 to Hit or 2 to Stand ");
			userAction = scan.nextInt();
			if(userAction==1) {
				dealToPlayer();
				showPlayerCards();
			}

			else if(userAction==2){
				break;
			}
			if(player_sum > 21) {
				System.out.println("Player Lost!");
				System.exit(0);
			}
		}  while(true);
	}


	public void dealerChoice() {

		do {
			System.out.println("Dealer turn!");		
			dealToDealer();
			showDealerCards();
			if(dealer_sum > 16) {
				break;
			}


		} while(true);

	}
	public void checkWinner() {
		if(dealer_sum >21) {
			System.out.println("Dealer busted!");
			System.out.println("Player wins!");
			System.exit(0);
		}
		else if(player_sum >21) {
			System.out.println("Player busted!");
			System.out.println("Dealer wins!");
			System.exit(0);
		}
		if (dealer_sum == player_sum) {
			System.out.println("Dealer wins in a tie!");
			System.exit(0);
		}
		if(dealer_sum > player_sum) {
			System.out.println("Dealer wins!");
			System.exit(0);
		}
		if(dealer_sum < player_sum) {
			System.out.println("Player wins!");
			System.exit(0);
		}
		
	}
}




