package javaInterview;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

enum Roles {
    ADMIN, USER
}

enum AccessLevel {
    READ, WRITE
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AccessLevelRequired {
    Roles[] role();

    AccessLevel[] accessLevels();
}

class BankUser {
    private int userId;
    private String accountNo;

    public BankUser(final int userId, final String accountNo) {
        this.userId = userId;
        this.accountNo = accountNo;
    }

    @AccessLevelRequired(role = Roles.ADMIN, accessLevels = AccessLevel.WRITE)
    public void showDetails() {
        System.out.println("User Id" + userId);
        System.out.println("Bank Account No." + accountNo);
    }

    @AccessLevelRequired(role = {Roles.USER, Roles.ADMIN}, accessLevels = AccessLevel.READ)
    public void showUserName() {
        System.out.println("User Id" + userId);
    }
}

public class CreatingCustomAnnotation {
    public static void main(String[] args) {
        BankUser user = new BankUser(1, "1234-2222-9898");

        Class c = user.getClass();
        List<Method> methods = Arrays.asList(c.getMethods());

        methods.forEach(m -> {
            if (m.isAnnotationPresent(AccessLevelRequired.class)) {
                AccessLevelRequired ac = m.getAnnotation(AccessLevelRequired.class);
                System.out.println(Arrays.toString(ac.role()));
                System.out.println(Arrays.toString(ac.accessLevels()));
            }
        });
    }
}
