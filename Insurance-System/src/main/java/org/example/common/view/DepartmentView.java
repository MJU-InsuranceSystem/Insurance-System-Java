package org.example.common.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;
import org.example.common.usecase.Usecase;

public class DepartmentView {

    public void intro(String teamName) {
        System.out.println(teamName + "입니다. 업무를 선택해주세요.");
    }

    protected String writeString() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못 입력하였습니다.");
        }
    }

    protected int writeInt() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String writeIntToString(int length) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = Integer.parseInt(br.readLine());
            if (input > length) {
                throw new IllegalArgumentException("정해진 범위내에서 선택해주세요.");
            }
            return Integer.toString(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    protected void println(String message) {
        System.out.println(message);
    }

    protected void print(String message) {
        System.out.print(message);
    }

    public <E extends Enum<E> & Usecase> int selectUsecase(Class<E> enumType) {
        println("아래 중 수행하실 번호를 입력해주세요.");
        for (E usecase : enumType.getEnumConstants()) {
            println(usecase.getOrder() + " : " + usecase.getDescription());
        }
        return writeInt();
    }

}
