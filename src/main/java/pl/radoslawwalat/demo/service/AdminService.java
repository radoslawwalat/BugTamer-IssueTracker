package pl.radoslawwalat.demo.service;

import pl.radoslawwalat.demo.model.Admin;


public interface AdminService {

    Admin findByAdminName(String name);

    void saveAdmin(Admin admin);
}
