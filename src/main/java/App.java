import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newhero.hbs");

        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());
    }
}
