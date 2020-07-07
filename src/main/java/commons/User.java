package commons;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User implements Serializable {
    public String login;
    public String hashPassword;
    private transient String password; // нужен ли

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        hashPassword = sha1(password);
    }

    public static User userFromHashPassword(String login, String hashPassword) {
        User user = new User(login, "password");
        user.hashPassword = hashPassword;
        return user;
    }

    public static String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes(StandardCharsets.UTF_8));
            sha1 = bytesToHex(msdDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }

    public void changeUser(String login, String password) {
        this.login = login;
        this.password = password;
        hashPassword = sha1(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(hashPassword, user.hashPassword);
    }

    @Override
    public String toString() {
        return "User{" + "login='" + login + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, hashPassword);
    }

}
