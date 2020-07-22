package eu.accesa.passwordkeeper.controller;

import eu.accesa.passwordkeeper.model.Password;
import eu.accesa.passwordkeeper.model.PasswordRequest;
import eu.accesa.passwordkeeper.service.PasswordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @ApiOperation("Get all passwords by application")
    @GetMapping("/{applicationName}/passwords")
    public List<Password> getPasswordsByApplicationName(@ApiParam("Application name for retrieving passwords") @PathVariable String applicationName, @RequestParam(value = "active", required = false) Boolean active) {
        return passwordService.getPasswordsByApplication(applicationName, active);
    }

    @PostMapping("/{applicationName}/passwords")
    public Password createPassword(@PathVariable String applicationName, @RequestBody PasswordRequest passwordRequest) {
        return passwordService.createPassword(applicationName, passwordRequest);
    }

    @PutMapping("/{applicationName}/passwords")
    public Password updatePassword(@PathVariable String applicationName, @RequestBody PasswordRequest passwordRequest) {
        return passwordService.updatePassword(applicationName, passwordRequest);
    }
}
