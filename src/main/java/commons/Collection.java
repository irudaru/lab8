package commons;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс для хранения и обработки LinkedList
 */
public class Collection {
    public static Collection coll = Collection.start();
    /**
     * Список, в котором хранятся элементы типа program.Route
     */
    public Map<User, List<Route>> map = new ConcurrentHashMap<>();
    public int ids;
    /**
     * Дата создания списка
     */
    private Date date = new Date();
    Collection(int SEQUENCE) {
        ids = SEQUENCE;
    }

    /**
     * Метод, возвращающий список, удобный для сохранения в формат CSV
     */
    public static Collection start() {
        Collection c = new Collection(0);
        LinkedList<Route> list1 = new LinkedList<>();
        list1.add(new Route(1, "name", new Coordinates(20, (long) 10), new Location((long) 10, (long) 20, 10, "1"), new Location((long) 10, (long) 10, 20, "2"), (long) 10));
        list1.add(new Route(2, "name2", new Coordinates(-20, (long) 10), new Location((long) 10, (long) -20, 30, "1"), new Location((long) -10, (long) -10, 10, "2"), (long) 10));
        LinkedList<Route> list2 = new LinkedList<>();
        list2.add(new Route(3, "name3", new Coordinates(-20, (long) -10), new Location((long) -10, (long) 20, -30, "1"), new Location((long) 10, (long) -10, 10, "2"), (long) 10));
        list2.add(new Route(3, "name3", new Coordinates(-20, (long) -10), null, new Location((long) 20, (long) 0, 10, "2"), (long) 10));
        LinkedList<Route> list3 = new LinkedList<>();
        list3.add(new Route(4, "name4", new Coordinates(-10, (long) 0), new Location((long) 20, (long) 10, 0, "1"), new Location((long) 20, (long) -40, 5, "2"), (long) 10));
        list3.add(new Route(5, "name5", new Coordinates(-30, (long) 0), new Location((long) -10, (long) -20, 20, "1"), new Location((long) 10, (long) -10, 5, "2"), (long) 10));

        c.map.put(new User("login", "password"), list1);
        c.map.put(new User("login2", "password2"), list2);
        c.map.put(new User("Yeguar", "password3"), list3);
        return c;
    }

    public boolean isUserInMap(User user) {
        if (user.login.equals("login")) return false;
        return map.containsKey(user);
    }

    public boolean isLoginUsed(String login) {
        if (login.equals("login")) return true;
        for (User user : map.keySet()) {
            if (user.login.equals(login))
                return true;
        }
        return false;
    }

    /**
     * Метод, осуществляющий поиск элемента по id
     */
    public Route searchById(Integer id) {
        for (User user : map.keySet()) {
            for (Route r : map.get(user)) {
                if (r.getId().equals(id))
                    return r;
            }
        }
        return null;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Метод, возвращающий уникальный id
     */
    public int getNextId() {
        return ids++;
    }

}
