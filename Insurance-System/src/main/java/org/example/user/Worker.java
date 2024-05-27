package org.example.user;

import java.util.Map;
import org.example.common.AuthGuideMessage;

public class Worker extends User {

    public Worker() {

    }

    public Worker(String name, String age, String sex, String phoneNumber, String id,
        String password) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.password = password;
        this.role = Role.worker;
    }

    public static Worker create(Map<String, String> authInfo) {
        String name = authInfo.get(AuthGuideMessage.AUTH_NAME_KEY);
        String age = authInfo.get(AuthGuideMessage.AUTH_AGE_KEY);
        String sex = authInfo.get(AuthGuideMessage.AUTH_SEX_KEY);
        String phoneNumber = authInfo.get(AuthGuideMessage.AUTH_PHONE_NUMBER_KEY);
        String id = authInfo.get(AuthGuideMessage.AUTH_ID_KEY);
        String password = authInfo.get(AuthGuideMessage.AUTH_PASSWORD_KEY);

        return new Worker(name, age, sex, phoneNumber, id, password);
    }
}
