package hello.infrastructure;

import hello.domain.GuestRepository;
import hello.domain.GuestRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.stream.Collectors.joining;

@WebServlet(name = "GuestServlet", urlPatterns = {"guests"})
public class GuestServlet extends HttpServlet {
    private GuestRepository guestRepository = new GuestRepositoryInMemory();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guestList = guestRepository.listGuests().stream().collect(joining("\n"));
        response.getWriter().print(guestList);
    }
}
