package hello.domain;

import java.util.ArrayList;
import java.util.List;

public class GuestRepositoryInMemory implements GuestRepository {
    private List<String> guestList = new ArrayList<>();

    @Override
    public List<String> listGuests() {
        return guestList;
    }

    @Override
    public void addGuest(String guest) {
        guestList.add(guest);
    }
}
