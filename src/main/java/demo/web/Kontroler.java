package demo.web;

import demo.model.Pet;
import demo.model.PetPicture;
import demo.repository.PetRepository;
import demo.service.PetService;
import demo.service.QueryService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Controller
public class Kontroler {

    @Autowired
    QueryService queryService;

    @Autowired
    PetRepository petRepository;

  @Autowired
  PetService petService;



    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("product",queryService.findsite());

        model.addAttribute("pageFragment", "home");

        return "index";
    }


    @RequestMapping(value = {"/pets"}, method = RequestMethod.GET)
    public String pets(Model model) {

        model.addAttribute("product",queryService.findsite());

        model.addAttribute("pageFragment", "pets");

        return "index";
    }


    @RequestMapping(value = {"/kontakt"}, method = RequestMethod.GET)
    public String kontakt(Model model) {


          model.addAttribute("pageFragment", "kontakt");

        return "index";
    }

    @RequestMapping(value = {"/yourpet"}, method = RequestMethod.GET)
    public String tvojpredlog(Model model) {


          model.addAttribute("pageFragment", "yourpet");

        return "index";
    }




    @RequestMapping(value = {"/pet"}, method=RequestMethod.GET)
    public String showpets(Model model){

        model.addAttribute("product",queryService.findsite());
        model.addAttribute("pageFragment", "pets");
        return "index";
    }


    @RequestMapping(value = {"/pet"}, method = RequestMethod.POST)
    public String createPet(Model model,
                                @RequestParam String name,
                                @RequestParam String description,
                                @RequestParam String gender,
                                @RequestParam String age,
                                @RequestParam String category,
                                @RequestParam String email,
                                MultipartFile picture
    ) throws IOException, SQLException {


        Pet pet = petService.createPet(

                name,
                description,
                gender,
                age,
                category,
                email
       );



        petService.addPetPicture(pet.id, picture.getBytes(), picture.getContentType());


        model.addAttribute("product", pet);
      //  model.addAttribute("pageFragment", "pets");
        return "index";
    }


    @RequestMapping(value = {"/pet/{id}/picture"}, method = RequestMethod.GET)
    @ResponseBody
    public void image(@PathVariable Integer id, HttpServletResponse response) throws IOException, SQLException {
        OutputStream out = response.getOutputStream();

        PetPicture petPicture = queryService.getByMestoId(id);

        String contentDisposition = String.format("inline;filename=\"%s\" ",
                petPicture.picture.fileName + ".png?productId=" + id);

        response.setHeader("Content-Disposition", contentDisposition);
        response.setContentType(petPicture.picture.contentType);
        response.setContentLength(petPicture.picture.size);

        IOUtils.copy(petPicture.picture.data.getBinaryStream(), out);

        out.flush();
        out.close();
    }

}
