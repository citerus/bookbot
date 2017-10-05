package hello.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class GuestRepositoryTest {
    private GuestRepository guests = new GuestRepositoryInMemory();

    @Before
    public void setUp() throws Exception {
        GuestRepositoryInMemory.emptyList();
    }

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

    @Test
    public void testNoGuestName() throws Exception {
        guests.addGuest("");
        assertTrue(guests.listGuests().isEmpty());
    }

    @Test
    public void testNullAsGuestName() throws Exception {
        guests.addGuest(null);
        assertTrue(guests.listGuests().isEmpty());
    }
}
