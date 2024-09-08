package amazbay;

public class Person
{
    // TODO - add the other fields mentioned in the handout, and create
    // getters and setters for each.
    private int uid;
    private String lastName;
//    private String firstName;
//    private int uid;
//    private String message;
    
    public Person(int uid)
    {
        setUID(uid);
    }

    public int getUID()
    {
        return uid;
    }

    public void setUID(int uid)
    {
        this.uid = uid;
    }

    public void sendMessageTo(Person receiver, String message, long when,
                              Website website)
    {
        Message m = new Message(this, receiver, message, when);
        website.addMessage(m);
    }

    public String getFirstName()
    {
        // TODO - this is one of the getters, but it doesn't
        // do the right thing currently...
        return "(Unimplemented Method)";
    }
}
