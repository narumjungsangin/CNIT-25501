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
while(ignoredVariable < 3.0 || ignoredVariable > 7.0)
{
System.out.print("Enter a number between 3.0 and 7.0: ");
ignoredVariable = in.nextDouble();
}
// TODO - ask for each of ‘radius‘, ‘width1‘, ‘width2‘, ‘depth‘.
// Remember to keep asking if the value is out of range, and to
// tell the user that they’ve entered an invalid value.
// TODO - print the calculated statistics specified in
// "What To Do, And How"
// You can print dollar amounts with the following code. Note that
// if you just print a double, it may not print two decimal places
// worth of pennies (e.g. "$8.80" would appear as "$8.8").
double cost = 0.0;
System.out.println("That amount of water will cost: " +
NumberFormat.getCurrencyInstance().format(cost));
}
}
