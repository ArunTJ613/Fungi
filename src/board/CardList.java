package board;
import java.util.ArrayList;
import cards.*;

public class CardList{
  private ArrayList<Card> cList;

public CardList(){
  cList = new ArrayList<Card>();
}

public int size(){
  return cList.size();
}

public void add(Card card){
  cList.add(0,card);
}

public Card getElementAt(int i){
  return cList.get(i);
}

public Card removeCardAt(int i){
  return cList.remove(8-i);
}



}




