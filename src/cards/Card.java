package cards;
public abstract class Card{
  protected CardType type;
  protected String cardName;


  public Card(CardType type, String cardname){
    this.type = type;
    this.cardName = cardname;
  }

  public CardType getType(){
    return type;
  }

  public String getName(){
    return cardName;
  }




}