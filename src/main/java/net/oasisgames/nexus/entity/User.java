package net.oasisgames.nexus.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nexus_users")
public class User {

    @Id
    private String authId;

    private String username;

    private String email;

    private String picture;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PlayerCard card;

    @Override
    public String toString() {
        return "USER: " + username + "\nEMAIL: " + email + "\nPICTURE: " + picture + "\nAUTH ID: " + authId +
                "\nCARD: " + card.toString();
    }

    public User update(User user) {
        this.username = user.getUsername() == null ? this.getUsername() : user.getUsername();
        this.email = user.getEmail() == null ? this.getEmail() : user.getEmail();
        this.picture = user.getPicture() == null ? this.getPicture() : user.getPicture();
        this.authId = user.getAuthId() == null ? this.getAuthId() : user.getAuthId();
        this.card = this.card.update(user.getCard());
        return this;
    }

}
