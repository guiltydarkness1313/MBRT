package com.shibuyaxpress.mbrt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulf on 28-Sep-17.
 */

public class UserRepository {

    private static UserRepository _INSTANCE=null;

    private UserRepository(){

    }

    public static UserRepository getInstance(){
        if(_INSTANCE==null){
            _INSTANCE=new UserRepository();
        }
        return _INSTANCE;
    }

    private ArrayList<User> users=new ArrayList<User>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        this.users.add(user);
    }
    //String username, String password, String name, String lastName, String role
    public void setListUsers(){
        User user=new User("pedro","123","Pedro","Perez","cliente","http://mte90.github.io/Talk-FF-OWA/pictures/ffos.png");
        users.add(user);
        user=new User("jc12","123","Juan","Lory","supervisor","https://wiki.mozilla.org/images/c/c6/Papertoy-firefox-2012.jpg");
        users.add(user);
        user=new User("paul","123","Paul","Pacheco","tecnico","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Firefox_mascot_at_FISL_16.jpg/682px-Firefox_mascot_at_FISL_16.jpg");
        users.add(user);
    }
}
