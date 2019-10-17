package behavioral.mediator;

public class User {
    ChatRoom room;
    private String name;

    public User(String name, ChatRoom room) {
        this.name = name;
        this.room = room;
        room.register(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayTo(String name, String message) {
        room.sayTo(this, name, message);
    }

    public void show(User from, String message) {
        System.out.println("[" + from + "] -> [" +this + "]: " + message);
    }

    public void toGroup(String message) {
        room.broadcast(this, message);
    }
    @Override
    public String toString() {
        return name;
    }
}
