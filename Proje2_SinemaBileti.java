/**
 * Ad Soyad: [Birgül Göktürk]
 * Öğrenci No: [250541094]
 * Proje: [Sinema Bileti]
 * Tarih: [23.11.2025]
 */

import java.util.Scanner;

public class Proje2_SinemaBileti {

    // 1) Hafta sonu kontrolü
    public static boolean isWeekend(int gun){
        return (gun == 6 || gun == 7); // Cumartesi - Pazar
    }

    // 2) Matine kontrolü
    public static boolean isMatinee(int saat){
        return saat < 12;
    }

    // 3) Temel fiyat hesaplama
    public static double calculateBasePrice(int gun, int saat){
        boolean haftaSonu = isWeekend(gun);
        boolean matine = isMatinee(saat);

        if(!haftaSonu && matine){
            return 45;
        }
        else if(!haftaSonu){
            return 65;
        }
        else if(haftaSonu && matine){
            return 55;
        }
        else {
            return 85;
        }
    }

    // 4) İndirim oranı hesaplama
    public static double calculateDiscount(int yas, int meslek, int gun){

        // 12 yaş altı
        if(yas < 12){
            return 0.25;
        }

        // 65+ yaş
        if(yas >= 65){
            return 0.30;
        }

        switch(meslek){
            case 1: // Öğrenci
                if(gun >= 1 && gun <= 4) return 0.20;
                else return 0.15;

            case 2: // Öğretmen
                if(gun == 3) return 0.35; // Sadece Çarşamba
                break;

            case 3: // Diğer
                return 0;
        }

        return 0;
    }

    // 5) Film türü ekstra fiyat
    public static double getFormatExtra(int filmTuru){

        switch(filmTuru){
            case 1: return 0;   // 2D
            case 2: return 25;  // 3D
            case 3: return 35;  // IMAX
            case 4: return 50;  // 4DX
            default: return 0;
        }
    }

    // 6) Final fiyat hesaplama
    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru){

        double temelFiyat = calculateBasePrice(gun, saat);
        double indirimOrani = calculateDiscount(yas, meslek, gun);
        double formatEkstra = getFormatExtra(filmTuru);

        double indirimliTutar = temelFiyat - (temelFiyat * indirimOrani);

        return indirimliTutar + formatEkstra;
    }

    // 7) Bilet bilgisi yazdırma
    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru){

        double temelFiyat = calculateBasePrice(gun, saat);
        double indirimOrani = calculateDiscount(yas, meslek, gun);
        double indirimliTutar = temelFiyat - (temelFiyat * indirimOrani);
        double formatEkstra = getFormatExtra(filmTuru);
        double finalFiyat = indirimliTutar + formatEkstra;

        System.out.println("\n--- BILET BILGILERI ---");
        System.out.println("Temel Fiyat: " + temelFiyat + " TL");
        System.out.println("Indirim Orani: %" + (indirimOrani * 100));
        System.out.println("Indirimli Fiyat: " + indirimliTutar + " TL");
        System.out.println("Film Tur Ekstrasi: " + formatEkstra + " TL");
        System.out.println("Toplam Fiyat: " + finalFiyat + " TL");
    }

    // MAIN
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Gun seciniz (1=Pzt ... 7=Paz): ");
        int gun = input.nextInt();

        System.out.print("Saat giriniz (0-23): ");
        int saat = input.nextInt();

        System.out.print("Yas giriniz: ");
        int yas = input.nextInt();

        System.out.print("Meslek (1=Ogrenci, 2=Ogretmen, 3=Diger): ");
        int meslek = input.nextInt();

        System.out.print("Film turu (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int filmTuru = input.nextInt();

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);

        input.close();
    }
}
