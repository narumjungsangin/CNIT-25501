package amazbay;

public class Website
{
    private Person[] users;

    public Website()
    {
        users = new Person[0];
    }

    public void addPerson(Person p)
    {
        // We will need to create a new Person[] array that is 1 more in size
        // than what `users` used to be, and copy the contents of `users`
        // into it.
        Person newArray[] = new Person[users.length+1];
        for(int i = 0; i < users.length; i+=1)
        {
            newArray[i] = users[i];
        }

        // TODO - add p to newUsers, and update `users`
    }

    public Person getPersonByUID(int uid)
    {
        // TODO - loop through `users`, and return the first person whose uid
        // matches.  Otherwise, return null as below.

        return null;
    }

    void addMessage(Message m)
    {
        // TODO - decide how to store m, so that you can later retrieve the
        // right ones in getMessagesFor().
    }

    public Message[] getMessagesFor(int uid)
    {
        // TODO - return all messages added on the Website where either
        // the sender or the receiver was the person with uid `uid`, in
        // the order they were sent.
        return new Message[0];
    }
}
