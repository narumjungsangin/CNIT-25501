package amazbay;

public class Message
{
    private Person sender;
    private Person receiver;
    private String message;
    private long whenSent;

    // TODO - add getters for all of the above (but not setters - a Message is "immutable").

    public Message(Person sender, Person receiver, String message, long whenSent)
    {
        if (sender == null)
        {
            throw new IllegalArgumentException("sender can not be null in Message.Message()");
        }
        if (receiver == null)
        {
            throw new IllegalArgumentException("receiver can not be null in Message.Message()");
        }
        if (sender.getUID() == receiver.getUID())
        {
            throw new IllegalArgumentException("sender and receiver can not be the same person in Message.Message()");
        }

        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.whenSent = whenSent;
    }

    public String getPrettyWhenSent()
    {
    // This is a fancy way of printing the day and time using java.time.* classes;
    // We have not seen this in class.
    return (java.time.LocalDateTime.ofEpochSecond(
                whenSent/1000L, 0, java.time.ZoneOffset.UTC)
            .format(java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"))); 
    }
}
