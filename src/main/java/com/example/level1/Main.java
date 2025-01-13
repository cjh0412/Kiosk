package com.example.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> menuList = new ArrayList<>();
        System.out.println("[ SHAKESHACK MENU ]");

        while(true){
            menuList.add(scanner.nextLine());

            if(menuList.contains("0")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}