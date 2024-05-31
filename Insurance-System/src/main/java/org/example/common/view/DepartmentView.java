package org.example.common;

import java.util.Scanner;
import org.example.common.usecase.Usecase;

public class DepartmentView {

    public void intro(String teamName) {
        System.out.println(teamName + "입니다. 업무를 선택해주세요.");
    }

    protected String writeString() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        scanner.close();
        return text;
    }

    protected int writeInt() {
        Scanner scanner = new Scanner(System.in);
        int text = scanner.nextInt();
        scanner.close();
        return text;
    }

    protected void println(String message) {
        System.out.println(message);
    }

    public <E extends Enum<E> & Usecase> int selectUsecase(Class<E> enumType) {
        println("아래 중 수행하실 번호를 입력해주세요.");
        for (E usecase : enumType.getEnumConstants()) {
            println(usecase.getOrder() + " : " + usecase.getDescription());
        }
        return writeInt();
    }
}
