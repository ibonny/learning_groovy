package personal.bonnycasi.webdemo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
public class MainController {
    Set<Testout> users;

    public MainController() {
        users = new HashSet<>();
    }

    @GetMapping("/")
    public String rootFunc() {
        return "This is a test."
    }

    @GetMapping("/testout")
    public Testout getPerson() {
        return new Testout("Ian", "Bonnycastle")
    }

    @PostMapping("/add_name")
    public boolean postPerson(@RequestBody Testout user) {
        return users.add(user)
    }

    @GetMapping("/testout_names")
    public List<String> testoutNames() {
        return users.collect { it.toString() }
    }
}

public class Testout implements Serializable {
    private String first_name
    private String last_name

    public Testout() { }

    public Testout(String first_name, String last_name) {
        this.first_name = first_name
        this.last_name = last_name
    }

    public String getFirstName() {
        return this.first_name
    }  

    public String getLastName() {
        return this.last_name
    }

    public void setFirstName(String fn) {
        this.first_name = fn
    }

    public void setLastName(String ln) {
        this.last_name = ln
    }

    public String toString() {
        return "${first_name} ${last_name}"
    }

    @Override
    public boolean equals(Object obj) {
        println "Here2."

        if (obj == null)
            return false;

        if (obj instanceof Testout) {
            Testout t = (Testout) obj;

            if (this.first_name == t.first_name && this.last_name == t.last_name) {
                return true;
            } 
        }

        return false;
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        println("Here.")

        int result = 17;
        result = 31 * result + this.toString().hashCode();
        //result = 31 * result + name.hashCode();
        return result;
    }
}