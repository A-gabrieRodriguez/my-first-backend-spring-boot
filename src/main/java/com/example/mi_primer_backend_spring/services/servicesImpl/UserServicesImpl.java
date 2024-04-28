package com.example.mi_primer_backend_spring.services.servicesImpl;

import com.example.mi_primer_backend_spring.models.dtos.UserInfoDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserLoginDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserRegisterDTO;
import com.example.mi_primer_backend_spring.models.entities.User;
import com.example.mi_primer_backend_spring.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServicesImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("LKJEF","Juan Carlos","Rosales Salguero","carlosSal23@gmail.com","12345678","admin","16/7/2018",true));
        users.add(new User("POIER","Maria Rosio","Umaña Carrio","umarosa@gmail.com","0987654","normal","22/4/2016",true));
        users.add(new User("LLKFL","Clark Ken","Kal el","superman@gmail.com","qwer","admin","16/7/2018",true));
        users.add(new User("ZCHTU","Neo Mauricio","Caballero Medina","medicar@gmail.com","12345678","normal","26/2/2019",true));
        users.add(new User("MNHFD","Carla Maria","Rosario Estrada","rosies79@gmail.com","asdf","admin","12/6/2014",true));
    }


    @Override
    public void createUser(UserRegisterDTO user) {
        User new_user = new User(user.getId(), user.getNombre(), user.getApellido(),
                user.getGmail(), user.getPassword(), user.getRol(), user.getFecha_contratacion(),false);

        Stream<User> userStream = users.stream().filter(u -> !u.getId().equals(new_user.getId()));

        users = Stream.concat(userStream, Stream.of(new_user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserInfoDTO> readAllUsers() {
        List<UserInfoDTO> usersInfo = new ArrayList<>();
        users.forEach(u -> usersInfo.add(new UserInfoDTO(u.getId(),u.getNombre(),u.getApellido(), u.getRol(), false)));
        return usersInfo;
    }

    // el .stream es para convertir la lista en un stream y steam() es para recorrer la lista
    // el .filter es para filtrar los elementos de la lista
    @Override
    public User login(String id,String password) {
        return users.stream()
                .filter(u -> (u.getId().equals(id) && u.getPassword().equals(password)))
                .findAny()
                .orElse(null);
    }

    @Override
    public void changePassword(String id, String password, String newPassword) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id) )
                .findAny()
                .orElse(null);
        if (user != null) {
            //aqui se puede hacer validaciones de la informacion que se esta
            //cambiando en este caso la contraseña
            user.setPassword(newPassword);
        }else{
            System.out.println("Usuario no encontrado");
        }
    }

    @Override
    public void toggleUser(String id) {
        User user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
        if (user != null) {
            user.setActive(!user.getActive());
        }else{
            System.out.println("Usuario no encontrado");
        }
    }
}
