package demo.web;

import demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Controller
public class Kontroler {

    @Autowired
    QueryService queryService;






    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("product",queryService.findsite());

        model.addAttribute("pageFragment", "home");

        return "index";
    }

    @RequestMapping(value = {"/kontakt"}, method = RequestMethod.GET)
    public String kontakt(Model model) {

        //   model.addAttribute("product",queryService.findsite());

          model.addAttribute("pageFragment", "kontakt");

        return "index";
    }

    @RequestMapping(value = {"/tvojpredlog"}, method = RequestMethod.GET)
    public String tvojpredlog(Model model) {

        //   model.addAttribute("product",queryService.findsite());

          model.addAttribute("pageFragment", "tvojpredlog");

        return "index";
    }





//        TmestoPicture bookPicture = queryService.getByMestoId(id);
//
//        String contentDisposition = String.format("inline;filename=\"%s\"",
//                bookPicture.picture.fileName + ".png?productId=" + id);
//
//        response.setHeader("Content-Disposition", contentDisposition);
//        response.setContentType(bookPicture.picture.contentType);
//        response.setContentLength(bookPicture.picture.size);
//
//        IOUtils.copy(bookPicture.picture.data.getBinaryStream(), out);
//
//        out.flush();
//        out.close();
//    }

//    @RequestMapping(value = {"/category/{categoryId}"}, method = RequestMethod.GET)
//    public String categoryProducts(
//            @PathVariable Long categoryId,
//         //  @RequestParam Long categoryId,
//            Model model
//    ) {
//        Page<Tmesto> page = queryService.getMestaInCategory(
//                categoryId, 0, 20
//        );
//
//        model.addAttribute("product", page);
//        model.addAttribute("pageFragment","mesta");
//        return "index";
//    }


//    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
//    public String listbyCategory(
//            // @PathVariable Long categoryId,
//            @RequestParam Long categoryId,
//            Model model
//    ) {
//        Page<Tmesto> page = queryService.getMestaInCategory(
//                categoryId, 0, 20
//        );
//
//        model.addAttribute("product", page);
//        model.addAttribute("pageFragment","mesta");
//        return "index";
//    }

//    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
//    public String search(
//            @RequestParam String query,
//            Model model
//    ) {
//        List<Tmesto> books = queryService.searchMesto(query);
//
//        model.addAttribute("pageFragment","mesta");
//        model.addAttribute("product", books);
//        model.addAttribute("query", query);
//
//        return "index";
//    }


}
