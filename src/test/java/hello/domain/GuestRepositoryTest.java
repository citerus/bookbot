package hello.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GuestRepositoryTest {
    @Test
    public void testListGuestReturnsEmptyListWhenNoGuestsHaveArrived() {
        GuestRepository guests = new GuestRepositoryInMemory();
        assertTrue(guests.listGuests().isEmpty());
    }
}
