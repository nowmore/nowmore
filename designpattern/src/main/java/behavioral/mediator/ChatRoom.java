package behavioral.mediator;

import java.util.HashMap;

public class ChatRoom {

    HashMap<String, User> member = new HashMap<>();

    public void register(User u) {
        member.put(u.getName(), u);
    }

    public void sayTo(User from, String name, String message) {
        User u = member.get(name);
        if(null != u) {
            u.show(from, message);
        }
    }

    public void broadcast(User u, String message) {
        for (User user : member.values()) {
            user.show(u, message);
        }
    }

    public static void main(String[] args) {
       ChatRoom room = new ChatRoom();

       User x = new User("x", room);
       User y = new User("y", room);

       x.sayTo("y", "Hello");
       y.toGroup("is it right");
    }
}
