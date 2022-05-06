package board;
import cards.*;
import java.util.ArrayList;
public class Player{
  private Hand h;
  private Display d;
  private int score;
  private int handlimit;
  private int sticks;


  public Player(){
     h = new Hand();
     d = new Display();
     score = 0;
     handlimit = 8;
     sticks = 0;
     Card c = new Pan();
     d.add(c);
  }
  public int getScore(){
    return score;
  }
  public int getHandLimit(){
    return handlimit;
  }
  public int getStickNumber(){
    return sticks;
  }
  public void addSticks(int i){
    Card c = new Stick();
    for (int j = 0;j < i; j++){
      c = new Stick();
      d.add(c);
    }
    sticks = sticks + i;
  }
  public void removeSticks(int i){
    sticks = sticks - i;
  }
  public Hand getHand(){
    return h;
  }
  public Display getDisplay(){
    return d;
  }
  public void addCardtoHand(Card card){
    if (card.getName().equals("basket")){
      d.add(card);
      handlimit = handlimit + 2;
    } else {
      h.add(card);
    }

  }
  public void addCardtoDisplay(Card card){
    d.add(card);
  }
  public boolean putPanDown(){
    boolean check_pan = false;
    int length = h.size();
    Card c = new Stick();
    for (int i = 0; i<length; i++){
      c = h.getElementAt(i);
      if (c.getName().equals("pan")){
        c = h.removeElement(i);
        i = i-1;
        check_pan = true;
        break;
      }
      length = h.size();
    }
    if (check_pan){
      d.add(c);
      return true;
    } else {
      return false;
    }
  }

  public boolean sellMushrooms(String s,int num){
    s = s.replaceAll("\\s+","");
    s = s.toLowerCase();
    if (s.equals("honeyfungus")||s.equals("treeear")||s.equals("porcini")||s.equals("shiitake")||s.equals("morel")||s.equals("lawyerswig")||s.equals("henofwoods")||s.equals("chanterelle")||s.equals("birchbolete")){
      int r = 3;
    } else {
      return false;
    }
    if (num < 2){
      return false;
    }
    int length = h.size();
    Card c = new Stick();
    int count = 0;
    boolean not_okay = true;
    for (int i = 0; i<length; i++){
        c = h.getElementAt(i);
        if (c.getName().equals(s)){
          if (c.getType()==CardType.DAYMUSHROOM){
            count = count + 1;
          } else {
            count = count + 2;
          }
          if(count==num){
            not_okay = false;
            break;
          }
        }
    }

    if (not_okay){
      return false;
      }

      int num_mushrooms = 0;
      int stacks = 0;
      for (int i = 0; i<length; i++){
          c = h.getElementAt(i);
          if (c.getName().equals(s)){
            stacks = ((Mushroom) c).getSticksPerMushroom();
            c = h.removeElement(i);
            i = i-1;
            if (c.getType()==CardType.NIGHTMUSHROOM){
              num_mushrooms = num_mushrooms + 2;
              count = count - 2;
            } else {
              num_mushrooms = num_mushrooms + 1;
              count = count - 1;
            }

            if(num_mushrooms==num){
              break;
            }
            length = h.size();
          }
      }

      stacks = num*stacks;
      sticks = sticks + stacks;

      for (int j=0; j<stacks; j++){
        c = new Stick();
        d.add(c);
      }
      return true;




}

public boolean takeCardFromTheForest(int pos){
  if (pos < 1||pos > 8){
    return false;
  }
  if (h.size()==handlimit){
    Card c = Board.getForest().getElementAt(8-pos);
    if (c.getName().equals("basket")){
      int r = 3;

    } else {
      return false;
    }

  }
  int num_of_sticks = 0;
  if (pos>2){
    num_of_sticks = pos-2;
    if (num_of_sticks>sticks){
      return false;
    } else{
      sticks = sticks - num_of_sticks;
    }
  }

  Card c = Board.getForest().removeCardAt(pos);
  if (c.getName().equals("basket")){
    d.add(c);
    handlimit = handlimit+2;
  } else {
    h.add(c);
  }

  int length = d.size();
  if (num_of_sticks>0){
    for (int j=0; j<length; j++){
      c = d.getElementAt(j);
      if (c.getName().equals("stick")){
        c = d.removeElement(j);
        num_of_sticks = num_of_sticks - 1;
        length = d.size();
        j = j-1;
      }
      if (num_of_sticks==0){
        break;
      }
    }
  }
  return true;

}


public boolean takeFromDecay(){
  int currentlim = h.size();
  int len = Board.getDecayPile().size();
  int could_add = 0;
  for(Card card: Board.getDecayPile()){
    if (card.getName().equals("basket")){
      could_add = could_add+2;
      len = len-1;
    }
  }

  if (currentlim + len > handlimit + could_add){
    return false;
  }




  for (Card c: Board.getDecayPile()){
    if (c.getName().equals("basket")){
      d.add(c);
      handlimit = handlimit+2;
    } else {
        h.add(c);
    }
  }



  return true;

}


public boolean cookMushrooms(ArrayList<Card> arr){

  int length = arr.size();
  boolean first = true;
  boolean no_pan_array = true;
  boolean no_pan_display = true;
  int butter = 0;
  int cider = 0;
  int mushroom = 0;
  int flavor = 0;
  int mushroom_flavor = 0;
  String mushroom_name="";
  Card c;
  for (int i=0; i<length; i++){
    c = arr.get(i);
    if (c.getName().equals("pan")){
      no_pan_array = false;
    } else if (c.getName().equals("butter")){
      butter = butter+1;
    } else if (c.getName().equals("stick")||c.getName().equals("basket")){
      return false;
    } else if (first){
      mushroom_name = c.getName();
      first = false;
      mushroom_flavor = ((EdibleItem) c).getFlavourPoints();
      if (c.getType()==CardType.DAYMUSHROOM){
        mushroom = mushroom + 1;
      } else {
        mushroom = mushroom + 2;
      }
    } else if (!first){
      if (!(c.getName().equals(mushroom_name))){
        return false;
      }
      if (c.getType()==CardType.DAYMUSHROOM){
        mushroom = mushroom + 1;
      } else {
        mushroom = mushroom + 2;
      }

      } else if (c.getName().equals("cider")){
        cider = cider+1;
      } else {
        int p =3;
      }

    }



  if (mushroom < 3){
    return false;
  }

  if(mushroom < butter*4){
    return false;
  }

  if (mushroom < cider*5){
    return false;
  }

  if (no_pan_array){
    int len_display = d.size();;
    int pan_index = 0;
    for (int i=0; i<len_display; i++){
      if (d.getElementAt(i).getName().equals("pan")){
        no_pan_display = false;
        pan_index = i;
        break;
      }
    }
  }

if (no_pan_array||no_pan_display){
  return false;
}

flavor = (mushroom*mushroom_flavor) + (butter*3) + (cider*5);
score = score +flavor;




return true;



}








}