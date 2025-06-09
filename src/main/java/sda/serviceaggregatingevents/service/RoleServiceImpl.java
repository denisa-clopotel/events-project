package sda.serviceaggregatingevents.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.serviceaggregatingevents.DTO.RoleRequest;
import sda.serviceaggregatingevents.DTO.RoleResponse;
import sda.serviceaggregatingevents.entity.Role;
import sda.serviceaggregatingevents.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public void createRole(RoleRequest request) {
        Role role = new Role();
        role.setName(request.getName());
        roleRepository.save(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleResponse(role.getId(), role.getName()))
                .collect(Collectors.toList());
    }
}
