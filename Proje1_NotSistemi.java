/**
 * Ad Soyad: [Birgül Göktürk]
 * Öğrenci No: [250541094]
 * Proje: [Not Sistemi]
 * Tarih: [23.11.2025]
 */

import java.util.Scanner;

public class Proje1_NotSistemi {

    public static double calculateAverage(int vize, int finalNotu, int odev){
        return vize * 0.3 + finalNotu * 0.4 + odev * 0.3;
    }

    public static boolean isPassingGrade(double ortalama){
        return ortalama >= 50;
    }

    public static char getLetterGrade(double ortalama){
        if(ortalama >= 90 && ortalama <= 100){
            return 'A';
        } else if(ortalama >= 80){
            return 'B';
        } else if(ortalama >= 70){
            return 'C';
        } else if(ortalama >= 60){
            return 'D';
        } else {
            return 'F';
        }
    }

    public static boolean isHonorList(double ortalama, int vize, int finalNotu, int odev){
        return (ortalama >= 85 && vize >= 70 && finalNotu >= 70 && odev >= 70);
    }

    public static boolean hasRetakeRight(double ortalama){
        return (ortalama >= 40 && ortalama < 50);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Vize notunu giriniz: ");
        int vize = input.nextInt();

        System.out.print("Final notunu giriniz: ");
        int finalNotu = input.nextInt();

        System.out.print("Odev notunu giriniz: ");
        int odev = input.nextInt();

        double ortalama = calculateAverage(vize, finalNotu, odev);
        boolean gectiMi = isPassingGrade(ortalama);
        char harfNotu = getLetterGrade(ortalama);
        boolean onurListesi = isHonorList(ortalama, vize, finalNotu, odev);
        boolean butunleme = hasRetakeRight(ortalama);

        System.out.println("\n--- SONUC ---");
        System.out.println("Ortalama: " + ortalama);
        System.out.println("Harf Notu: " + harfNotu);

        if(gectiMi){
            System.out.println("Durum: GECTI");
        } else {
            System.out.println("Durum: KALDI");
        }

        if(onurListesi){
            System.out.println("Onur Listesi: EVET");
        } else {
            System.out.println("Onur Listesi: HAYIR");
        }

        if(butunleme){
            System.out.println("Butunleme Hakki: EVET");
        } else {
            System.out.println("Butunleme Hakki: HAYIR");
        }

        input.close();
    }
}


