package hello.domain;

import java.util.Collections;
import java.util.List;

public class GuestRepositoryInMemory implements GuestRepository {
    @Override
    public List<String> listGuests() {
        return Collections.emptyList();
    }
}
