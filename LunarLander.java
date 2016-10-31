/**
 *
 * <p>Title: LunarLander</p>
 *
 * <p>Description: This Class models the Lunar Lander State second by second.
 * It keeps track of the lander's altitude, velocity, and available fuel.
 * It allows the GUI portion of the simulation to obtain the lander state.
 *
 * The GUI is responsible for showing the graphic image position in the window.
 *  </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: UMASS-Boston</p>
 *
 * @author Bob Wilson (based on Lander Project by Stuart Reges)
 * @version 1.0
 */

public class LunarLander {
  public static final int INITIAL_VELOCITY = 2;
  public static final int INITIAL_ALTITUDE = 1000;
  public static final int INITIAL_FUEL = 500;
  public static final int GRAVITY = 2;
  public static final int THRUST = 4;
  public static final int SAFE_LANDING = 4;
  private int myVelocity;
  private int myAltitude;
  private int myFuel;
  private int myThrust;

  /**
   * Constructor Method - no code needed
   */
  public LunarLander() {
  }

  /**
   *
   * @return int The current altitude above the moon's surface
   */
  public int getAltitude() {
    return myAltitude;
  }

  /**
   *
   * @return int The current available fuel
   */
  public int getFuel() {
    return myFuel;
  }

  /**
   *
   * @return int The current velocity toward the moon
   */
  public int getVelocity() {
    return myVelocity;
  }

  /**
   * Resets the state of the lander to re-start the landing sequence
   */
  public void reset() {
    myVelocity = INITIAL_VELOCITY;
    myAltitude = INITIAL_ALTITUDE;
    myFuel = INITIAL_FUEL;
    myThrust = 0;
  }

  /**
   * Records that one more unit of thrust has been requested this second
   */
  public void thrust() {
    myThrust++;
  }

  /** the tick method is called each second and does the work of updating
   * the state of the lunar lander for each second of simulated time.
   *
   * As explained in the assignment sheet, this method must perform the
   * following five calculations each time it is called:
   * 1. determine the minimum of the thrust requested and remaining fuel
   * 2. update the lander's current velocity toward the moon as follows:
   *    add the effect of gravity accelerating the lander and
   *    subtract the effect of the min of thrust/fuel deccelerating the lander
   * 3. subtract the new current velocity from the current altitude
   * 4. subtract the amount of thrust requested from the fuel available
   * 5. reset the amount of thrust requested for the next second to zero
   */
  public void tick() {

// write your code here

    int min = Math.min(myThrust, myFuel);
    myVelocity = myVelocity + GRAVITY - min;
    myAltitude = myAltitude - myVelocity;
    myFuel = myFuel - min;
    myThrust = 0;
  }
}