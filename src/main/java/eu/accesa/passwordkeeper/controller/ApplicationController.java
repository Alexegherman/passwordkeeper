package eu.accesa.passwordkeeper.controller;

import eu.accesa.passwordkeeper.model.ApplicationModel;
import eu.accesa.passwordkeeper.model.ApplicationRequest;
import eu.accesa.passwordkeeper.service.ApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Api(value = "Application Controller API")
@RequestMapping("/pk/v1/applications")
@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @ApiOperation(value = "Returns a list of all applications")
    @GetMapping
    public Set<ApplicationModel> getApplications() {
        return applicationService.getApplications();
    }

    @ApiOperation(value = "Create application")
    @PostMapping
    public ApplicationModel createApplication(@RequestBody ApplicationRequest applicationRequest) {
        return applicationService.createApplication(applicationRequest);
    }

    @ApiOperation(value = "Update application")
    @PutMapping("/{applicationName}")
    public ApplicationModel updateApplication(@ApiParam(value = "Unique identifier - application name", example = "outlook")
                                              @PathVariable String applicationName,
                                              @RequestBody ApplicationRequest applicationRequest) {
        return applicationService.updateApplication(applicationName, applicationRequest);
    }

}
