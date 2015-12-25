package by.webproject.hirs.cotrollers;

import by.webproject.hirs.BuyManager;
import by.webproject.hirs.entityes.Buy;
import by.webproject.hirs.exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/buys")
public class BuysController {

    private static Logger logger = Logger.getLogger(BuysController.class);

    @Autowired
    BuyManager buyManager;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ModelAndView getBuy(@PathVariable("id")long id,
                               ModelAndView model) {
        logger.info("*getBuy_GET*");
        Buy buy = null;
        try {
            buy = buyManager.get(id);
        } catch (PersistException e) {
            logger.error("Error in getBuy method ", e);
        }
        logger.info("***Find buy by id:  " + buy);
        model = new ModelAndView("buy");
        model.addObject("buy", buy);
        return model;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBuy(@Valid Buy buy,
                          @PathVariable("id")long id) {
        logger.info("*updateBuy_PUT*");
        logger.info("***Updating buy:  " + buy);
        try {
            //buy = buyManager.get(id); //TODO
            buyManager.update(buy);
        } catch (PersistException e) {
            logger.error("Fail Update BUY in base", e);
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView deleteBuy(@Valid Buy buy) {
        logger.info("*deleteBuy_DELETE*");
        logger.info("***Deleting buy:  " + buy);
        try {
            buyManager.delete(buy);
        } catch (PersistException e) {
            logger.error("Fail Delete BUY in base", e);
        }
        return new ModelAndView("redirect:/buys");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getBuysList() {
        logger.info("*getBuysList_GET*");
        List<Buy> buys = null;
        try {
            buys = buyManager.getAll();
        } catch (PersistException e) {
            logger.error("Error in getBuysList method ", e);
        }
        ModelAndView model = new ModelAndView("buy-list");
        model.addObject("buys", buys);
        return model;
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView addBuy(@RequestParam("name") String name,
                               @RequestParam("prise") Double prise) {
        logger.info("*saveBuy*");
        Buy buy = new Buy();
        buy.setName(name);
        buy.setPrise(prise);
        Buy addedBuy = null;
        try {
            addedBuy = buyManager.add(buy);
        } catch (PersistException e) {
            logger.error("Fail ADD BUY in base", e);
        }
        logger.info("***From Base Buy:  " + addedBuy);
        return new ModelAndView("redirect:/buys");
    }

    @RequestMapping(value="/new", method=RequestMethod.GET)
    public ModelAndView newBuy() {
        logger.info("*NewBuy_Get*");
        return new ModelAndView("buy");
    }
}