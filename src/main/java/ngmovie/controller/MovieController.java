package ngmovie.controller;

import com.google.common.collect.Lists;
import ngmovie.domain.Movie;
import ngmovie.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping(value = "/server/api")
@Controller
public class MovieController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    private static int lastId = 9;

    Map<Integer, Movie> movies = new HashMap<Integer, Movie>();

    public MovieController() {
        
        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setTitle("Avatar");
        movie1.setReleaseYear("2010");
        movie1.setPoster("img/avatar.jpg");
        movie1.setDirectors("James Cameron");
        movie1.setActors("Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang, Michelle Rodriguez");
        movie1.setSynopsis("Sur la lointaine planète de Pandora, Jake Sully, un héros malgré lui, " +
                "se lance dans une quête de rédemption, de découverte, d'amour inattendu, dont l'issue sera un " +
                "combat héroïque pour sauver toute une civilisation.");
        movie1.setRate(3);
        movie1.setLastViewDate(new GregorianCalendar(2013, 3, 1, 12, 4, 50).getTime());
        movie1.setPrice(25.46);
        movies.put(movie1.getId(), movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setTitle("Seigneur des Anneaux (La Communauté de l'Anneau");
        movie2.setReleaseYear("2001");
        movie2.setPoster("img/seigneurdesanneaux1.jpg");
        movie2.setDirectors("Peter Jackson");
        movie2.setActors("Elijah Wood, Sean Astin, Ian McKellen, Sala Baker, Viggo Mortensen");
        movie2.setSynopsis("Frodon le Hobbit hérite de l'Anneau Unique, un instrument de pouvoir absolu" +
                "qui permettrait à Sauron, le Seigneur des ténèbres, de régner sur la Terre du Milieu." +
                " Commence alors un vaste périple visant à la destruction de l'objet.");
        movie2.setRate(5);
        movie2.setLastViewDate(new GregorianCalendar(2012, 5, 13, 9, 30, 45).getTime());
        movie2.setPrice(34.76);
        movies.put(movie2.getId(), movie2);

        Movie movie3 = new Movie();
        movie3.setId(3);
        movie3.setTitle("The Grudge");
        movie3.setReleaseYear("2004");
        movie3.setPoster("img/thegrudge.jpg");
        movie3.setDirectors("Takashi Shimizu");
        movie3.setActors("Sarah Michelle Gellar, Jason Behr, Clea DuVall, Kadee Strickland, Bill Pullman");
        movie3.setSynopsis("Dans ce qui paraît être une paisible maison de Tokyo se cache un épouvantable fléau. " +
                "Quiconque franchit le seuil de la demeure est aussitôt frappé par une malédiction qui ne tardera " +
                "pas à le tuer dans un sentiment d'indicible rage...");
        movie3.setRate(4);
        movie3.setLastViewDate(new GregorianCalendar(2006, 11, 28, 6, 3, 5).getTime());
        movie3.setPrice(15.23);
        movies.put(movie3.getId(), movie3);

        Movie movie4 = new Movie();
        movie4.setId(4);
        movie4.setTitle("Yip Man 2");
        movie4.setReleaseYear("2010");
        movie4.setPoster("img/yipman.jpg");
        movie4.setDirectors("Wilson Yip");
        movie4.setActors("Donnie Yen, Sammo Hung Kam-Bo, Simon Yam, Lynn Hung, Xiaoming Huang");
        movie4.setSynopsis("Film biographique sur la vie de Ip Man, pionnier du Wing Chun et maitre de Bruce Lee.");
        movie4.setRate(5);
        movie4.setLastViewDate(new GregorianCalendar(2011, 2, 24, 1, 2, 4).getTime());
        movie4.setPrice(23.56);
        movies.put(movie4.getId(), movie4);

        Movie movie5 = new Movie();
        movie5.setId(5);
        movie5.setTitle("[REC]");
        movie5.setReleaseYear("2008");
        movie5.setPoster("img/rec.jpg");
        movie5.setDirectors("Paco Plaza, Jaume Balagueró");
        movie5.setActors("Manuela Velasco, Ferran Terraza, Jorge Yamam, Carlos Lasarte, Pablo Rosso");
        movie5.setSynopsis("Alors qu'ils suivent des pompiers lors d'une intervention, une reporter et son caméraman " +
                "restent coincés dans un immeuble placé sous quarantaine. A l'intérieur, ils font face à d'étranges " +
                "créatures...");
        movie5.setRate(3);
        movie5.setLastViewDate(new GregorianCalendar(2009, 7, 30, 20, 30, 32).getTime());
        movie5.setPrice(12.05);
        movies.put(movie5.getId(), movie5);

        Movie movie6 = new Movie();
        movie6.setId(6);
        movie6.setTitle("Resident Evil");
        movie6.setReleaseYear("2002");
        movie6.setPoster("img/residentevil.jpg");
        movie6.setDirectors("Paul W.S. Anderson");
        movie6.setActors("Milla Jovovich, Eric Mabius, Michelle Rodriguez, James Purefoy, Liz May Brice");
        movie6.setSynopsis("Un virus mortel s'est propagé dans un laboratoire souterrain et a mis fin à toute vie humaine. " +
                "Alice et Matt doivent suivre un groupe d'intervention militaire, chargé de neutraliser le super-ordinateur " +
                "que l'on tient pour responsable du désastre.");
        movie6.setRate(4);
        movie6.setLastViewDate(new GregorianCalendar(2005, 6, 3, 8, 12, 34).getTime());
        movie6.setPrice(45.23);
        movies.put(movie6.getId(), movie6);

        Movie movie7 = new Movie();
        movie7.setId(7);
        movie7.setTitle("Seigneur des Anneaux (les deux Tours");
        movie7.setReleaseYear("2002");
        movie7.setPoster("img/seigneurdesanneaux2.jpg");
        movie7.setDirectors("Peter Jackson");
        movie7.setActors("Elijah Wood, Sean Astin, Ian McKellen, Sala Baker, Viggo Mortensen");
        movie7.setSynopsis("Frodon Sacquet, le Hobbit, doit braver de terribles dangers pour tenter de détruire " +
                "l'Anneau Unique, convoité par Sauron, le Seigneur des ténèbres. De leur côté, Gimli, Legolas et Aragorn " +
                "doivent sauver Pippin et Merry, capturés par les Orques...");
        movie7.setRate(3);
        movie7.setLastViewDate(new GregorianCalendar(2005, 11, 12, 15, 34, 34).getTime());
        movie7.setPrice(14.23);
        movies.put(movie7.getId(), movie7);

        Movie movie8 = new Movie();
        movie8.setId(8);
        movie8.setTitle("Seigneur des Anneaux (le retour du Roi");
        movie8.setReleaseYear("2003");
        movie8.setPoster("img/seigneurdesanneaux3.jpg");
        movie8.setDirectors("Peter Jackson");
        movie8.setActors("Elijah Wood, Sean Astin, Ian McKellen, Sala Baker, Viggo Mortensen");
        movie8.setSynopsis("Tandis que les ténèbres se répandent sur la Terre du Milieu, Aragorn se révèle être l'héritier " +
                "caché des rois antiques. Quant à Frodon, toujours tenté par l'Anneau, il voyage à travers les contrées " +
                "ennemies, se reposant sur Sam et Gollum...");
        movie8.setRate(4);
        movie8.setLastViewDate(new GregorianCalendar(2004, 6, 17, 15, 23, 34).getTime());
        movie8.setPrice(24.56);
        movies.put(movie8.getId(), movie8);

        Movie movie9 = new Movie();
        movie9.setId(9);
        movie9.setTitle("Crazy Kung Fu");
        movie9.setReleaseYear("2005");
        movie9.setPoster("img/crazykungfu.jpg");
        movie9.setDirectors("Stephen Chow");
        movie9.setActors("Stephen Chow, Wah Yuen, Leung Siu Lung, Dong Zhi Hua, Chiu Chi Ling");
        movie9.setSynopsis("Sing, un prétendu gangster, doit surmonter son incapacité à manier le sabre et démontrer " +
                "qu'il a toutes les qualités requises pour appartenir au prestigieux gang de Axe. Au même moment, " +
                "ce gang veut régner en maître sur une rue sacrée...");
        movie9.setRate(5);
        movie9.setLastViewDate(new GregorianCalendar(2009, 10, 20, 13, 34, 23).getTime());
        movie9.setPrice(10.50);
        movies.put(movie9.getId(), movie9);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public @ResponseBody
    List<Movie> getMovies() {
        LOGGER.info("get all Movies");
        List<Movie> movieList = Lists.newArrayList(movies.values());
        if(null == movieList) {
            movieList = new ArrayList<Movie>();
        }
        return movieList;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Movie getMovie(@PathVariable("id") Integer MovieId) throws NotFoundException {
        LOGGER.info("get a Movie by id : {}", MovieId);
        Movie Movie = movies.get(MovieId);
        if(null == Movie) {
            throw new NotFoundException("Movie not found with id "+MovieId);
        }
        LOGGER.info("Movie {} found with id : {}", Movie, MovieId);
        return Movie;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public @ResponseBody Integer createMovie(@RequestBody Movie movie) {
        lastId++;
        movie.setId(lastId);
        movies.put(movie.getId(), movie);
        LOGGER.info("movie created with id : {}", movie.getId());
        return movie.getId();
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/movies", method = RequestMethod.PUT)
    public void updateMovie(@RequestBody Movie movie) {
        LOGGER.info("update the movie with the id : {}", movie.getId());
        movies.put(movie.getId(),movie);
        LOGGER.info("movie updated with the id : {}", movie.getId());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable("id") Integer movieId) {
        LOGGER.info("delete the movie with the id : {}", movieId);
        movies.remove(movieId);
        LOGGER.info("movie deleted with the id : {}", movieId);
    }

}
