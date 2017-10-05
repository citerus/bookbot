package hello.domain;

import java.util.List;

public interface GuestRepository {
    List<String> listGuests();

    void addGuest(String guest);
}
