package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {

    @Test
    public void faker() {

        /*
        Faker classindan sahte veri kullanmak icin obje olusturmamiz gwerekir
         */
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdıralım
        System.out.println("isim = " + faker.name());

        //faker objesini kullanarak bir lastName yazdıralım
        System.out.println("soyisim = " + faker.name());

        //faker objesini kullanarak bir fullName yazdıralım
        System.out.println("isim_Soyisim = " + faker.funnyName());

        //faker objesini kullanarak bir adress yazdıralım
        System.out.println("Adres = " + faker.address());

        //faker objesini kullanarak bir tel_no yazdıralım
        System.out.println("Tel_no = " + faker.phoneNumber());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Sekiz haneli bir sayi = " + faker.number().digits(8));

        //Meslek pozisyonu
        System.out.println("avatar = " + faker.avatar());

    }
}
