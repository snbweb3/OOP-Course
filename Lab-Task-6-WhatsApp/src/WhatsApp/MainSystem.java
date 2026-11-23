package WhatsApp;

public class MainSystem {

    public static void main(String[] args) {
        WhatsAppChat p1 = new WhatsAppChat("Ali A", "Ali B");
        p1.sendM("Oi");
        p1.sendM("Assignment done?", "Not yet");
        p1.sendM("");
        p1.setBlocked(true);
        p1.sendM("Hello?");
        p1.display();
        p1.showHistory();

        System.out.println();

        GroupChat g1 = new GroupChat("Irtiza", "BSCS");
        g1.sendM("Hello everyone");
        g1.addM("Ali");
        g1.addM("Sara");
        g1.addM("Ali");
        g1.addM("Hamza");
        g1.addM("Zain");
        g1.addM("Usman");
        g1.sendM("Project for both Class and Lab");
        g1.setAdminOnly(true);
        g1.sendM("Project to be on Github");
        g1.setSenderIsAdmin(true);
        g1.sendM("Project to be on Github");
        g1.removeM("Zain");
        g1.removeM("Irtiza");

        System.out.println();

        Chat[] chats = {p1, g1};
        for (Chat c : chats) {
            c.display();
            System.out.println();
        }

        g1.showHistory();
        System.out.println("Last Message: " + g1.getLastM());
        System.out.println(p1);
        System.out.println(g1);
    }
}
