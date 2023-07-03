package it.unicam.cs.ids.loyaltyplatform.models;

public interface IUser {

    String getEmail();
    String getPassword();
    void setEmail(String email);
    void setPassword(String password);
}
