package quickstart.hero;

import java.util.*;

public class HeroService {
    static int id = 0;

    static public Hero create(String name){
        return new Hero(++id, name);
    }

    static public List<Hero> getInitHero(){
        return List.of(create("鋼鐵人"), create("黑寡婦"), create("美國隊長"), create("綠巨人"),
                create("雷神索爾"));
    }
}
