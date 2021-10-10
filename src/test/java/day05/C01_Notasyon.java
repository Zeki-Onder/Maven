package day05;

import org.junit.Test;

public class C01_Notasyon {

    //Java daki gibi Seleniumda da Methodlar belirli islevleri yapan
    //Methodlar olusturabiliriz.Ancak bu Methodlar çağrılmadıkça
    // çalışmazlar.

    public void ilkTestMethodu(){
        System.out.println("ilk test methodumuz.");
    }
    //JUnit ile notasyon kullanarak sıradan methodları test methoduna
    //dönüstürebilriz.
    //Bir test method'u bağımsız olarak calisabilem test yapmamiza imkan
    //verir.
    //Test notasyonu sayesinde main method mecburiyeti ortadan kalkar.
    @Test
    public void notasyonluIlkTestMethodu(){
        System.out.println("notasyonlu ilk test methodumuz.");
    }

}
