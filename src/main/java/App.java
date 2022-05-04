import static spark.Spark.*;

import models.Hero;
import models.Squad;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        port(8080);
        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newhero.hbs");

        }, new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("name");
            Integer heroAge = Integer.valueOf(request.queryParams("age"));
            String heroPower = request.queryParams("superpower");
            String heroWeakness = request.queryParams("weakness");
            Hero hero = new Hero(heroName, heroAge, heroPower, heroWeakness);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getInstances();
            model.put("hero", hero);
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            return new ModelAndView(model, "allheroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getInstances();
            model.put("hero", hero);
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            return new ModelAndView(model, "squadform.hbs");

        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
           Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            String squadCause = request.queryParams("squadCause");
            Squad squad = new Squad(squadName, squadCause);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());
    }
}
