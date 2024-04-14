package Tablecreation.picobranchpico.PicoBranchDetails.Controller;



import Tablecreation.picobranchpico.PicoBranchDetails.Model.PicoBranchDetails;
import Tablecreation.picobranchpico.PicoBranchDetails.Response.PicoBranchDetailsResponse;
import Tablecreation.picobranchpico.PicoBranchDetails.Service.PicoBranchDetailsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@Controller
@RestController
@RequestMapping(value = "picobranchdetail")
public class PicoBranchDetailsController {
    private final static Logger logger = LoggerFactory.getLogger(PicoBranchDetailsController.class);
    @Autowired
    PicoBranchDetailsService picoBranchDetailsService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PicoBranchDetailsResponse save(@Valid @RequestBody PicoBranchDetails picoBranchDetails) {
        logger.trace("entering");
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.savePicoBranch(picoBranchDetails);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setSuccess(false);
            picoBranchDetailsResponse.setError(ex.getMessage());
        }
        return picoBranchDetailsResponse;
    }

    @RequestMapping(value = "/movetotash", method = RequestMethod.POST)
    public PicoBranchDetailsResponse movetotash(@RequestBody Map<String, String> formatdata) {
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.moveToTrash(formatdata);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public PicoBranchDetailsResponse get(@RequestBody Map<String, String> formatdata) {
        logger.trace("entering");
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.get(formatdata);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }

    @RequestMapping(value = "/getdelete", method = RequestMethod.POST)
    public PicoBranchDetailsResponse getDelete() {
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.getDeleted();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public PicoBranchDetailsResponse getAll() {
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.getAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }

    @RequestMapping(value = "/getPaginated", method = RequestMethod.POST)
    public PicoBranchDetailsResponse getPaginated(Map<String, String> formData) {
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.getPaginated(formData);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }

    @RequestMapping(value = "/searchPaginated", method = RequestMethod.POST)
    public PicoBranchDetailsResponse searchPaginated(Map<String, String> formData) {
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.searchPaginated(formData);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }
    @RequestMapping(value = "/searchPaginatedRepository",method = RequestMethod.POST)
    public PicoBranchDetailsResponse searchPaginatedThroughRepository(Map<String, String> formData){
        PicoBranchDetailsResponse picoBranchDetailsResponse = new PicoBranchDetailsResponse();
        try {
            picoBranchDetailsResponse = picoBranchDetailsService.searchPaginatedThroughRepository(formData);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchDetailsResponse.setError(ex.getMessage());
            picoBranchDetailsResponse.setSuccess(false);
        }
        return picoBranchDetailsResponse;
    }
}
