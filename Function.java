// Lab 4, March 21, 2013; CS 110
// James Lantos

// class Function

public class Function
{
  private final double A = 1.0;
  private final double B = 0.0;
  private final double C = -1.0;
  
  public double f(double x)
  {
    return A * Math.pow(x, 2) + B * x + C;
  }
  
  public double fprime(double x)
  {
    return 2.0 * A * x + B;
  }
}