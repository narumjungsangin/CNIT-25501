import java.util.*;
import java.text.NumberFormat;
// A sample input/output exchange for a correctly completed version of
// this program is listed as a separate attachment.
public class FountainLab
{
public static void main(String args[])
{
// Create a Scanner to read from user input
Scanner in = new Scanner(System.in);
// TODO - delete this section - it simply shows you how you might
// keep asking the user for an input.

double ignoredVariable = 0.0;
//while(ignoredVariable < 3.0 || ignoredVariable > 7.0)
//{
//System.out.print("Enter a number between 3.0 and 7.0: ");
//ignoredVariable = in.nextDouble();
//}

// TODO - ask for each of ‘radius‘, ‘width1‘, ‘width2‘, ‘depth‘.
// Remember to keep asking if the value is out of range, and to
// tell the user that they’ve entered an invalid value.
// TODO - print the calculated statistics specified in
// "What To Do, And How"
// You can print dollar amounts with the following code. Note that
// if you just print a double, it may not print two decimal places
// worth of pennies (e.g. "$8.80" would appear as "$8.8").
double radius = 0.0;
while(radius < 10.0 || radius > 15.0)
{
System.out.print("Enter a radius between 10.0 and 15.0: ");
radius = in.nextDouble();
if(radius < 10.0 || radius > 15.0){System.out.println("INCORRECT VALUE DECTECTED");}
}
double width1 = 0.0;
while(width1 < 2.0 || width1 > 8.0)
{
System.out.print("Enter a width1 between 2.0 and 8.0: ");
width1 = in.nextDouble();
if(width1 < 2.0 || width1 > 8.0){System.out.println("INCORRECT VALUE DECTECTED");}
}
double width2 = 0.0;
while(width2 < 2.0 || width2 > 8.0)
{
System.out.print("Enter a number between 2.0 and 8.0: ");
width2 = in.nextDouble();
if(width2 < 2.0 || width2 > 8.0){System.out.println("INCORRECT VALUE DECTECTED");}
}
double depth = 0.0;
while(depth < 1.0 || depth > 3.0)
{
System.out.print("Enter a depth between 1.0 and 3.0: ");
depth = in.nextDouble();
if(depth < 1.0 || depth > 3.0){System.out.println("INCORRECT VALUE DECTECTED");}
}

double volume_fountain = radius * radius * Math.PI * depth;
double volume_prism = width1 * width2 * depth;

double volume_water = volume_fountain - volume_prism;
double water_gallon = volume_water * 7.481;
double water_price = 0.1;

double cost = water_gallon * water_price;
Math.ceil(cost);
System.out.println("Water Volume in cubic feet:" + volume_water);
System.out.println("Water Volume in gallons:" + water_gallon);
System.out.println("That amount of water will cost: " +
NumberFormat.getCurrencyInstance().format(cost));
}
}
