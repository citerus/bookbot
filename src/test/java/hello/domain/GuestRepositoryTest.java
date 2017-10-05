package hello.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class GuestRepositoryTest {
    protected GuestRepository guests = new GuestRepositoryInMemory();

    @Test
    public void testListGuestReturnsEmptyListWhenNoGuestsHaveArrived() throws Exception {
        assertTrue(guests.listGuests().isEmpty());
    }

    @Test
    public void testOneNameInList() throws Exception {
        guests.addGuest("Erika");
        assertEquals(Collections.singletonList("Erika"), guests.listGuests());
    }

    @Test
    public void testTwoNamesInList() throws Exception {
        guests.addGuest("Johan");
        guests.addGuest("Erika");
        assertEquals(Arrays.asList("Johan", "Erika"), guests.listGuests());
    }
}
