package amazbay;

import java.util.Scanner;

public class Driver
{
    public static void addPeopleTo(Website w)
    {
        // Add one person to the Website.  You will likely have to change this
        // if you update the Person constructor.
        // Person TA = new Person(1001, "255", "TA");
        Person TA = new Person(1001);
        w.addPerson(TA);

        // Add several other people to the website.
        w.addPerson(new Person(1002));
        w.addPerson(new Person(1003));
        w.addPerson(new Person(1004));
    }

    public static void handlePrintMessages(Website w, int firstUID, int secondUID)
    {
        // Using w.getMessagesFor(), prints the messaging history between
        // the Person with firstUID and the Person with secondUID, in the order
        // those messages were sent.
        Person a = w.getPersonByUID(firstUID);
        if (a == null)
        {
            System.out.println("Person with uid "+firstUID+" not found, can't print message history");
        }

        Person b = w.getPersonByUID(secondUID);
        if (b == null)
        {
            System.out.println("Person with uid "+secondUID+" not found, can't print message history");
        }

        System.out.println("Showing chat history between ["+a.getFirstName()+"] and ["+b.getFirstName()+"]");
        boolean any = false;

        Message[] messages = w.getMessagesFor(firstUID);
        for(int i = 0; i < messages.length; i+=1)
        {
            // TODO - once you have implemented the code in Message.java, uncomment
            // this - it will not compile until then.  You may need to change
            // some of the method names used here.

            // if (messages[i].getSender().getUID() != secondUID &&
            //     messages[i].getReceiver().getUID() != secondUID)
            // {
            //     continue;
            // }
            //
            // any = true;
            // System.out.println("At (" + messages[i].getPrettyWhenSent()+"), "+
            //                    messages[i].getSender().getFullName()+" said: \"" +
            //                    messages[i].getMessageText() + "\"");
        }
        if (!any)
        {
            System.out.println("NO MESSAGE HISTORY FOUND FOR THESE TWO USERS.");
        }
    }

    public static void printChatHistory(Scanner s, Website w)
    {
        System.out.print("Enter the first person's UID: ");
        int firstUID = s.nextInt();
        s.nextLine();  // clear the carriage return

        System.out.print("Enter the second person's UID: ");
        int secondUID = s.nextInt();
        s.nextLine();  // clear the carriage return

        handlePrintMessages(w, firstUID, secondUID);
    }

    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);

        Website w = new Website();
        addPeopleTo(w);

        while(true)
        {
            // First: support for typing something to end the program naturally,
            // instead of looping forever.
            System.out.print("Type 'quit' to exit, anything else to keep going: ");
            if ("quit".equals(s.nextLine()))
            {
                break;
            }

            // Main Prompt and input handling.
            System.out.print("Enter the sender's UID, or -1 to view chat history: ");
            int uid = s.nextInt();
            s.nextLine();  // clear the carriage return
            if (uid == -1)
            {
                printChatHistory(s, w);
                continue;
            }

            Person sender = w.getPersonByUID(uid);
            if (sender == null)
            {
                System.out.println("Person with UID == " + uid + " not found.");
                continue;
            }

            // Ask for the receiver's uid, look them up, and handle the
            // case where they are not found.
            System.out.print("Enter the receiver's UID: ");
            uid = s.nextInt();
            s.nextLine();  // clear the carriage return
            Person receiver = w.getPersonByUID(uid);
            if (receiver == null)
            {
                System.out.println("Person with UID == " + uid + " not found.");
                continue;
            }

            // Get the message and the timestamp
            System.out.print("Enter the message text being sent: ");
            String message = s.nextLine();
            long whenSent = System.currentTimeMillis();

            sender.sendMessageTo(receiver, message, whenSent, w);
        }
    }
}
