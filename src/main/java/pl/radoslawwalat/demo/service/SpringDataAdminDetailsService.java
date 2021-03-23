package pl.radoslawwalat.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.radoslawwalat.demo.model.Admin;

import java.util.HashSet;
import java.util.Set;

public class SpringDataAdminDetailsService implements UserDetailsService {

    private AdminService adminService;

    @Autowired
    public void setUserRepository(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public UserDetails loadUserByUsername(String username){

        Admin admin = adminService.findByAdminName(username);

        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(admin.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(
                admin.getUsername(), admin.getPassword(), grantedAuthorities);

    }
}
