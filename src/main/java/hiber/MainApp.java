package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("jay", "jack", "jj@mail.ru");
        User user2 = new User("michael", "strange", "ms@mail.ru");
        User user3 = new User("kate", "fox", "kf@mail.ru");
        User user4 = new User("olga", "ginger", "og@mail.ru");

        Car car1 = new Car("Mercedes-Benz", 204);
        Car car2 = new Car("Toyota", 2);
        Car car3 = new Car("Nissan", 180);
        Car car4 = new Car("Lexus", 320);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(userService.getByCar("Nissan", 180));
        context.close();
    }
}
