/**
 * Ad Soyad: [Birgül Göktürk]
 * Öğrenci No: [250542094]
 * Proje: [Restoran Sipariş]
 * Tarih: [23.11.2025]
 */


import java.util.Scanner;

public class Proje3_RestoranSiparis {

    static double currentDrinkPrice = 0;

    // ANA YEMEK
    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            case 0: return 0;
            default: return 0;
        }
    }

    // BAŞLANGIÇ
    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            case 0: return 0;
            default: return 0;
        }
    }

    // İÇECEK
    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: currentDrinkPrice = 15; return 15;
            case 2: currentDrinkPrice = 12; return 12;
            case 3: currentDrinkPrice = 35; return 35;
            case 4: currentDrinkPrice = 25; return 25;
            case 0: currentDrinkPrice = 0; return 0;
            default: currentDrinkPrice = 0; return 0;
        }
    }

    // TATLI
    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            case 0: return 0;
            default: return 0;
        }
    }

    // COMBO KONTROL
    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli) {
        return ana && icecek && tatli;
    }

    // HAPPY HOUR
    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    // HAFTA İÇİ KONTROLÜ (1-5)
    public static boolean isWeekday(int gun) {
        return gun >= 1 && gun <= 5;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== AKILLI RESTORAN SISTEMI ===");

        // GÜN SEÇİMİ
        System.out.println("\nGün seçiniz:");
        System.out.println("1-Pazartesi  2-Salı  3-Çarşamba  4-Perşembe  5-Cuma  6-Cumartesi  7-Pazar");
        System.out.print("Gün: ");
        int gun = input.nextInt();

        // ANA YEMEK
        System.out.println("\nAna Yemekler:");
        System.out.println("1- Izgara Tavuk (85₺)");
        System.out.println("2- Adana Kebap (120₺)");
        System.out.println("3- Levrek (110₺)");
        System.out.println("4- Mantı (65₺)");
        System.out.println("0- Almayacağım");
        System.out.print("Seçimin: ");
        int anaSecim = input.nextInt();

        // BAŞLANGIÇ
        System.out.println("\nBaşlangıçlar:");
        System.out.println("1- Çorba (25₺)");
        System.out.println("2- Humus (45₺)");
        System.out.println("3- Sigara Böreği (55₺)");
        System.out.println("0- Almayacağım");
        System.out.print("Seçimin: ");
        int basSecim = input.nextInt();

        // İÇECEK
        System.out.println("\nİçecekler:");
        System.out.println("1- Kola (15₺)");
        System.out.println("2- Ayran (12₺)");
        System.out.println("3- Meyve Suyu (35₺)");
        System.out.println("4- Limonata (25₺)");
        System.out.println("0- Almayacağım");
        System.out.print("Seçimin: ");
        int icecekSecim = input.nextInt();

        // TATLI
        System.out.println("\nTatlılar:");
        System.out.println("1- Künefe (65₺)");
        System.out.println("2- Baklava (55₺)");
        System.out.println("3- Sütlaç (35₺)");
        System.out.println("0- Almayacağım");
        System.out.print("Seçimin: ");
        int tatliSecim = input.nextInt();

        // SAAT
        System.out.print("\nSaat (0-23): ");
        int saat = input.nextInt();

        // ÖĞRENCİ
        System.out.print("Öğrenci misiniz? (1=Evet, 0=Hayır): ");
        int ogr = input.nextInt();
        boolean ogrenci = (ogr == 1);

        double ana = getMainDishPrice(anaSecim);
        double bas = getAppetizerPrice(basSecim);
        double icecek = getDrinkPrice(icecekSecim);
        double tatli = getDessertPrice(tatliSecim);

        boolean combo = isComboOrder(ana > 0, icecek > 0, tatli > 0);

        double araToplam = ana + bas + icecek + tatli;

        // -------------------------
        double comboIndirim = 0;
        double happyIndirim = 0;
        double ogrenciIndirim = 0;

        double kalan = araToplam;

        if(combo){
            comboIndirim = kalan * 0.15;
            kalan -= comboIndirim;
        }

        if(isHappyHour(saat)) {
            happyIndirim = currentDrinkPrice * 0.20;
        }

        if(ogrenci && isWeekday(gun)) {
            ogrenciIndirim = kalan * 0.10;
        }

        double toplamIndirim = comboIndirim + happyIndirim + ogrenciIndirim;
        double finalTutar = araToplam - toplamIndirim;
        double bahsis = finalTutar * 0.10;

        // ----------- ÇIKTI -----------

        System.out.println("\n=== SİPARİŞ ÖZETİ ===");
        System.out.println("Ara Toplam: " + araToplam + "₺");

        if(combo)
            System.out.println("Combo -15%: -" + String.format("%.2f", comboIndirim) + "₺");

        if(isHappyHour(saat))
            System.out.println("Happy Hour (içecek) -20%: -" + String.format("%.2f", happyIndirim) + "₺");

        if(ogrenci && isWeekday(gun))
            System.out.println("Öğrenci -10%: -" + String.format("%.2f", ogrenciIndirim) + "₺");

        System.out.println("Toplam: " + String.format("%.2f", finalTutar) + "₺");
        System.out.println("Bahşiş önerisi: " + String.format("%.2f", bahsis) + "₺");
    }
}
