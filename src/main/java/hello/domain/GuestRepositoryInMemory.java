package hello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GuestRepositoryInMemory implements GuestRepository {
    private static List<String> guestList = Collections.synchronizedList(new ArrayList<>());

    public static void emptyList() {
        guestList.clear();
    }

    @Override
    public List<String> listGuests() {
        return guestList;
    }

    @Override
    public void addGuest(String guest) {
        if (guest == null || guest.isEmpty()) {
            return;
        }
        guestList.add(guest);
    }
}
