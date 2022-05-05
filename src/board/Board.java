package board;
import java.util.*;
import cards.*;

public class Board{
  private static CardPile forestCardsPile;
  private static CardList forest;
  private static ArrayList<Card> decayPile;

  public static void initialisePiles(){
    forestCardsPile = new CardPile();
    forest = new CardList();
    decayPile = new ArrayList<Card>();
  }

  public static CardPile getForestCardsPile(){
    return forestCardsPile;
  }

  public static CardList getForest(){
    return forest;
  }

  public static ArrayList<Card> getDecayPile(){
    return decayPile;
  }

  public static void updateDecayPile(){
    if(decayPile.size()==4){
      decayPile.clear();
      Card c = forest.removeCardAt(7);
      decayPile.add(c);
    } else {
      Card c = forest.removeCardAt(7);
      decayPile.add(c);

    }
  }

  public static void setUpCards(){
    Card c;
    for(int i = 0; i<10; i++){
      c = new HoneyFungus(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new HoneyFungus(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<8; i++){
      c = new TreeEar(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
     c = new TreeEar(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<6; i++){
      c = new LawyersWig(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new LawyersWig(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<5; i++){
      c = new Shiitake(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new Shiitake(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<5; i++){
      c = new HenOfWoods(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new HenOfWoods(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<4; i++){
      c = new BirchBolete(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new BirchBolete(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<4; i++){
      c = new Porcini(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new Porcini(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<4; i++){
      c = new Chanterelle(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    c = new Chanterelle(CardType.NIGHTMUSHROOM);
    forestCardsPile.addCard(c);
    for(int i = 0; i<3; i++){
      c = new Morel(CardType.DAYMUSHROOM);
      forestCardsPile.addCard(c);
    }
    for(int i = 0; i<3; i++){
      c = new Butter();
      forestCardsPile.addCard(c);
    }
    for(int i = 0; i<3; i++){
      c = new Cider();
      forestCardsPile.addCard(c);
    }
    for(int i = 0; i<13; i++){
      c = new Pan();
      forestCardsPile.addCard(c);
    }
    for(int i = 0; i<3; i++){
      c = new Basket();
      forestCardsPile.addCard(c);
    }





  }



}