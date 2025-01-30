package komponen;
import java.util.*; 

public class JalaFlix {

    static Scanner input = new Scanner(System.in); 
    public static void main(String[] args) {
        
        menus mn = new menus(); 
        while(true){
            mn.menuAwal();
            String cmd = input.nextLine(); 
            switch(cmd){
                case "1":
                    if(!mn.adaAkun()){
                        System.out.println("\nTidak ada akun yang terdaftar");
                        break;
                    }
                    System.out.println("\nLogin ke Akun Yang Sudah ada!"); 
                    System.out.println("Nama: ");
                    String nama = input.nextLine(); 
                    System.out.println("Password: "); 
                    String pwd = input.nextLine();
                    boolean test = mn.loginAkun(nama, pwd); 
                    if(test){
                        int xi = mn.idLogin(nama, pwd); 
                        if(xi!=-1){
                            mn.menuLogin(xi); 
                        }else{
                            System.out.println("Gagal Masuk!\n2");
                        }
                    }
                break; 
                case "2":
                    mn.buatAkun(); 
                break;
                case"3":
                    System.out.println("\nKeluar JalaFlix. Terima Kasih");
                    return; 
                default:
                System.out.println("Input salah!"); 
            }
        }
    }
}
