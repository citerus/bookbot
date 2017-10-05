package hello.infrastructure;

import hello.domain.Greeter;
import hello.domain.GuestRepository;
import hello.domain.GuestRepositoryInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = {"hello"})
public class HelloServlet extends HttpServlet {
    private Greeter greeter = new Greeter();
    private GuestRepository guestRepository = new GuestRepositoryInMemory();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(greeter.sayHello("Johan"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        request.setAttribute("greeting", greeter.sayHello(name));
        request.setAttribute("guests", guestRepository.listGuests());

        request.getRequestDispatcher("response.jsp").forward(request, response);
        guestRepository.addGuest(name);
    }
}
