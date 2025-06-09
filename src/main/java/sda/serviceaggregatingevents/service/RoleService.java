package sda.serviceaggregatingevents.service;


import sda.serviceaggregatingevents.DTO.RoleRequest;
import sda.serviceaggregatingevents.DTO.RoleResponse;

import java.util.List;


public interface RoleService {
    void createRole(RoleRequest request);
    List<RoleResponse> getAllRoles();
}

