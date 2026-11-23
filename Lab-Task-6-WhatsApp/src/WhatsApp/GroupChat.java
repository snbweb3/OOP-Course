package WhatsApp;

import java.util.ArrayList;

public final class GroupChat extends WhatsAppChat {
    private String admin;
    private boolean adminOnly = false;
    private boolean senderA = false;
    private final int maxM = 5;
    private ArrayList<String> members = new ArrayList<>();

    public GroupChat(String admin, String gName) {
        super(admin, gName);
        this.admin = admin;
        members.add(admin);
    }

    public void addM(String name) {
        if (members.size() >= maxM) {
            System.out.println("Group is Full");
            return;
        }
        if (members.contains(name)) {
            System.out.println(name + " is already in the group");
            return;
        }
        members.add(name);
        System.out.println(name + " Added, members: " + members.size());
    }

    public void removeM(String name) {
        if (name.equals(admin)) {
            System.out.println("Admin cannot be removed");
            return;
        }
        if (members.remove(name)) {
            System.out.println(name + " Removed, members: " + members.size());
        } else {
            System.out.println(name + " not found");
        }
    }

    public void setAdminOnly(boolean status) {
        adminOnly = status;
    }

    public void setSenderIsAdmin(boolean status) {
        senderA = status;
    }

    @Override
    public boolean sendM(String text) {
        if (members.size() < 2) {
            System.out.println("Atleast 2 members");
            return false;
        }
        if (adminOnly && !senderA) {
            System.out.println("Only Admin Can Send Message");
            return false;
        }
        return super.sendM(text);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Admin: " + admin);
        System.out.println("Members: " + members);
    }

    @Override
    public String toString() {
        return "Group " + super.toString() + ", members: " + members.size();
    }
}
