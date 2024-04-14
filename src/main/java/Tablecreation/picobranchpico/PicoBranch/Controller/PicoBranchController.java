package Tablecreation.picobranchpico.PicoBranch.Controller;

import Tablecreation.picobranchpico.PicoBranch.Model.PicoBranch;
import Tablecreation.picobranchpico.PicoBranch.Response.PicoBranchResponse;
import Tablecreation.picobranchpico.PicoBranch.Service.PicoBranchService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping(value = "/picobranch")
public class PicoBranchController {
    private final static Logger logger = LoggerFactory.getLogger(PicoBranchController.class);
    @Autowired
    PicoBranchService picoBranchService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public PicoBranchResponse save(@Valid @RequestBody PicoBranch picoBranch) {
        logger.trace("entering");
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.savePicoBranch(picoBranch);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setSuccess(false);
            picoBranchResponse.setError(ex.getMessage());
        }
        return picoBranchResponse;
    }

    @RequestMapping(value = "/movetotash", method = RequestMethod.POST)
    public PicoBranchResponse movetotash(@RequestBody Map<String, String> formatdata) {
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.moveToTrash(formatdata);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setError(ex.getMessage());
            picoBranchResponse.setSuccess(false);
        }
        return picoBranchResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public PicoBranchResponse get(@RequestBody Map<String, String> formatdata) {
        logger.trace("entering");
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.get(formatdata);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setError(ex.getMessage());
            picoBranchResponse.setSuccess(false);
        }
        return picoBranchResponse;
    }

    @RequestMapping(value = "/getdelete", method = RequestMethod.POST)
    public PicoBranchResponse getDelete() {
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.getDeleted();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setError(ex.getMessage());
            picoBranchResponse.setSuccess(false);
        }
        return picoBranchResponse;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public PicoBranchResponse getAll() {
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.getAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setError(ex.getMessage());
            picoBranchResponse.setSuccess(false);
        }
        return picoBranchResponse;
    }

    @RequestMapping(value = "/getpaginated", method = RequestMethod.POST)
    public PicoBranchResponse getPaginated(Map<String, String> formData) {
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.getPaginated(formData);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setError(ex.getMessage());
            picoBranchResponse.setSuccess(false);
        }
        return picoBranchResponse;
    }

    @RequestMapping(value = "/searchPaginated", method = RequestMethod.POST)
    public PicoBranchResponse searchPaginated(Map<String, String> formData) {
        PicoBranchResponse picoBranchResponse = new PicoBranchResponse();
        try {
            picoBranchResponse = picoBranchService.searchPaginated(formData);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            picoBranchResponse.setError(ex.getMessage());
            picoBranchResponse.setSuccess(false);
        }
        return picoBranchResponse;
    }

}
