package eu.accesa.passwordkeeper.controller;

import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.service.PasswordService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Password Controller API")
@RequestMapping("/pk/v1/applications")
@RestController
public class PasswordController {

    private PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @ApiOperation("Get all passwords by application")
    @GetMapping("/{applicationName}/passwords")
    public List<Password> getPasswordByApplicationName(@ApiParam("Application name for retrieving passwords")
                                                           @PathVariable String applicationName,
                                                       @RequestParam(value = "active", required = false) Boolean active) {
        return passwordService.getPasswordsByApplication(applicationName, active);

    }

    @ApiOperation("Create password")
    @PostMapping("/{applicationName}/passwords")
    public Password createPassword(@PathVariable String applicationName, @RequestBody Password password) {
        return passwordService.createPassword(applicationName, password);
    }

    @ApiOperation("Update password")
    @PutMapping("/{applicationName}/passwords/{username}")
    public Password createPassword(@PathVariable String applicationName, @PathVariable String username, @RequestBody Password password) {
        return passwordService.updatePassword(applicationName, password);
    }

}
