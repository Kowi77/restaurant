package main.web;

import main.model.Dish;
import main.model.Restaurant;
import main.repository.DishRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Андрей on 09.08.2017.
 */
public class DishServlet extends HttpServlet {

    private ClassPathXmlApplicationContext springContext;

    private DishRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml");
        repository = springContext.getBean(DishRepository.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                int id = getId(request);
                repository.delete(id, 100);
                response.sendRedirect("dishes");
                break;
            case "create":
            case "all":
            default:
                request.setAttribute("dishes", repository.getAll(100));
                request.getRequestDispatcher("/dishes.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            Dish dish = new Dish(
                    request.getParameter("description"),
                    Integer.parseInt(request.getParameter("price")),
                    new Restaurant());
        }

        /*    if (request.getParameter("id").isEmpty()) {
                mealController.create(meal);
            } else {
                mealController.update(meal, getId(request));
            }
            response.sendRedirect("meals");

        } else if ("filter".equals(action)) {
            LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
            LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
            LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
            LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
            request.setAttribute("meals", mealController.getBetween(startDate, startTime, endDate, endTime));
            request.getRequestDispatcher("/meals.jsp").forward(request, response);
        }*/
    }
    private int getId(HttpServletRequest request) {
        String paramId = request.getParameter("id");
        return Integer.parseInt(paramId);
    }
}
