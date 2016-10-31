
    
    /* 2. computer plays best strategy where, if possible, take the number of sticks such that after 
     * the move, the number of sticks is one more than a multiple of 4.  If it is not possible to leave 
     * one more than a multiple of 4 stocks, then take one stick. IE, if there are 18 sticks, the computer
     * should take one stick */
    
    
public class NIMStrategy {
    
  public int bestMove(Player player, SimpleNIM game) { 
    
     int sticksLeft = game.getSticksLeft();
     
     for (int i=1; i<4; i++)
    {
      if ((sticksLeft  - i) % 4 == 1)
        return i;
    }
    return (1);

}
    
}
