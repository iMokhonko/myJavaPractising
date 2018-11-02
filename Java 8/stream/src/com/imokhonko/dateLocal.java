package com.imokhonko;

import java.time.LocalDate;
import java.util.Scanner;

public class dateLocal {

    public static void main(String[] args) {

        String rate = "";

        Scanner rateScanner = new Scanner(System.in);

        while(true) {
            System.out.print("Введите зирочки: ");
            rate = rateScanner.nextLine();

            boolean correct = true;

            if(rate.length() > 0 && rate.length() < 6) // проверяем шо количество симоволов яки я ввив от 1 до 5
            {
                for(int i = 0; i < rate.length(); i++) // запускаэмо цикл
                {
                    if(rate.charAt(i) != '*') // проверяэмо шо символ це звездочка, если не звездочка, делаем выход из цикла
                    {
                        correct = false;
                        break;
                    }
                }
                if(correct) // если все правильно, и в строке тильки зирочки то добавляэмо пробели в конец
                {
                    for(int i = 0; i < 6 - rate.length(); i++)
                        rate = rate + " ";
                    break;
                }
            }
        }

        System.out.println("[" + rate + "]");
    }

}
