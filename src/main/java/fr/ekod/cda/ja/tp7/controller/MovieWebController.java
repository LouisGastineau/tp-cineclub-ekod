package fr.ekod.cda.ja.tp7.controller;

import fr.ekod.cda.ja.tp7.service.DirectorService;
import fr.ekod.cda.ja.tp7.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovieWebController {
    private final MovieService movieService;
    private final DirectorService directorService;
    public MovieWebController(
            MovieService movieService,
            DirectorService directorService
    ) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model){
        model.addAttribute("movies", movieService.findAll());
        return "movies/list";
    }

    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable Integer id, Model model){
        model.addAttribute("movie", movieService.findById(id));
        return "movies/detail";
    }

    @GetMapping("/directors")
    public String directors(Model model){
        model.addAttribute("directors", directorService.findAll());
        return "directors/list";
    }
}
