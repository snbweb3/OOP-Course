package WhatsApp;

import java.util.ArrayList;

public class WhatsAppChat implements Chat {

    private String send, receive, lastM;
    private int sentCount = 0;
    private boolean chatActive = true;
    private boolean blocked = false;
    protected static final int maxL = 120;
    private ArrayList<String> history = new ArrayList<>();

    public WhatsAppChat(String sender, String receive) {
        this.send = sender;
        this.receive = receive;
    }

    public void setChatActive(boolean status) {
        chatActive = status;
    }

    public void setBlocked(boolean status) {
        blocked = status;
    }

    public final int getSent() {
        return sentCount;
    }

    public String getLastM() {
        return lastM;
    }

    protected boolean validateMsg(String text) {
        return text != null && !text.trim().isEmpty() && text.length() <= maxL;
    }

    @Override
    public boolean sendM(String text) {
        if (blocked) {
            System.out.println("User is Blocked");
            return false;
        }
        if (!chatActive || !validateMsg(text)) {
            System.out.println("Message Not Sent");
            return false;
        }
        lastM = text;
        sentCount++;
        history.add(send + ": " + text);
        System.out.println(send + "...." + receive + "...." + text);
        return true;
    }

    public boolean sendM(String text, String reply) {
        if (!validateMsg(reply)) {
            System.out.println("Reply Not Sent");
            return false;
        }
        boolean sentM = sendM(text);
        if (sentM) {
            history.add(receive + ": " + reply);
            System.out.println("Reply: " + reply);
        }
        return sentM;
    }

    @Override
    public void showHistory() {
        System.out.println("Chat History");
        for (String m : history) {
            System.out.println(m);
        }
    }

    @Override
    public void display() {
        System.out.println("Chat: " + send + " and " + receive);
        System.out.println("Active: " + chatActive);
        System.out.println("Messages Sent: " + sentCount);
    }

    @Override
    public String toString() {
        return send + " to " + receive + ", messages: " + sentCount;
    }
}
