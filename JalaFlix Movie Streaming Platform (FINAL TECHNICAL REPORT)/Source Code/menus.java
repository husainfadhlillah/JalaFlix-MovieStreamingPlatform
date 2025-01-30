package komponen;
import java.util.*; 

class menus {
    public Scanner input = new Scanner(System.in); 
    private Pelanggan[] pelanggan = new Pelanggan[10]; 
    public static ArrayDeque<Film> DaftarFilm = new ArrayDeque<Film>();
    int jmlPelanggan = 0; 
    int kode = 0; 

    menus(){
        Dfilm fil = new Dfilm(); 
        for(int i=0; i<15; i++){
            Film temp = new Film();
            try{
                temp = new Film(fil.judul[i], fil.genre[i], fil.tahun[i], fil.kategori[i], fil.sinopsis[i], fil.batas[i]);
                DaftarFilm.addLast(temp);
            }catch(TahunTooOldException ex){
                System.out.println(ex.getMessage());
            }
            
        }
        for(int i=0; i<10; i++){
            try{
                pelanggan[i] = new pelangganBiasa("","","","User Biasa","", ""); 
            }catch(UmurNegatifException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public void menuAwal(){
        System.out.println("Selamat datang di JalaFlix! (Angka)");
        System.out.println("1. Login");
        System.out.println("2. Buat Akun");
        System.out.println("3. Keluar dari JalaFlix"); 
    }

    public void buatAkun(){
        System.out.println("Nama: ");
        pelanggan[jmlPelanggan].setNama(input.nextLine()) ; 
        System.out.println("Password: ");
        pelanggan[jmlPelanggan].setPassword(input.nextLine()); 
        System.out.println("Akun Berhasil dibuat!"); 
        pelanggan[jmlPelanggan].setStatus("Aktif"); 
        pelanggan[jmlPelanggan].setKodePelanggan("User-0"+kode);
        kode++; 
        jmlPelanggan++; 
    }

    public boolean adaAkun(){
        if(jmlPelanggan==0){
            return false; 
        }
        return true; 
    }

    public boolean loginAkun(String nama, String pwd){ 
        for(int i=0; i<jmlPelanggan; i++){
            if(pelanggan[i].getNama().equals(nama)){
                if(pelanggan[i].getPassword().equals(pwd)){
                    return true; 
                }
            }
        }
        System.out.println("Nama/Password Salah atau tidak ditemukan!");
        return false; 
    }

    public int idLogin(String nama, String pwd){
        for(int i=0; i<jmlPelanggan; i++){
            if(pelanggan[i].getNama().equals(nama)){
                if(pelanggan[i].getPassword().equals(pwd)){
                    System.out.println("Berhasil Login!\n"); 
                    return i;
                }
            }
        }
        return -1; 
    }

    public void menuLogin(int idx){
        while(true){
            System.out.println("Selamat datang di JalaFlix! Silahkan pilih menu! (Angka)"); 
            System.out.println("1. Daftar Kategori");
            System.out.println("2. Nonton Film"); 
            System.out.println("3. Mengganti Kategori"); 
            System.out.println("4. Lihat Daftar Film"); 
            System.out.println("5. Logout");
            System.out.println("6. Profil Akun dan Lengkapi Profil"); 
            System.out.println("7. History"); 
            System.out.println("8. Menambahkan Film");
            String id = input.nextLine(); 
            switch(id){
                case"1":
                    if(pelanggan[idx].getKategori().equals("User Biasa")){
                        System.out.println("Pilih Kategori yang diinginkan! (angka)");
                        System.out.println("1. Regular"); 
                        System.out.println("2. Gold"); 
                        System.out.println("3. Platinum"); 
                        String angka = input.nextLine(); 
                        switch(angka){
                            case "1":
                                this.daftarRegular(idx);
                            break; 
                            case "2":
                                this.daftarGold(idx);
                            break; 
                            case "3":
                                this.daftarPlatinum(idx);
                            break; 
                            default: 
                                System.out.println("Input Salah!!");
                        }
                    }else{
                        System.out.println("Anda sudah terdaftar sebagai pelanggan "+pelanggan[idx].getKategori());
                    }
                break; 
                case"2":
                    String anggota = pelanggan[idx].getKategori();
                    displayFilmKategori(anggota, idx);
                break;
                case"3":
                    if(!pelanggan[idx].getKategori().equals("")){
                        System.out.println("Anda sedang terdaftar sebagai pelanggan "+pelanggan[idx].getKategori());
                        System.out.println("Ingin mengganti kategori?");
                        System.out.println("1. Regular");
                        System.out.println("2. Gold");
                        System.out.println("3. Platinum");
                        System.out.println("4. Unsubscribe");
                        String cmd = input.nextLine(); 
                        switch(cmd){
                            case "1":
                            this.upgradeRegular(idx);
                            break; 
                            case "2":
                            this.upgradeGold(idx); 
                            break; 
                            case "3":
                            this.upgradePlatinum(idx); 
                            break; 
                            case"4":
                            this.unsubs(idx); 
                            break; 
                            default: 
                            System.out.println("Gagal Mengganti Kategori");
                        }
                    }else{
                        System.out.println("Anda belum terdaftar dalam kategori manapun! Daftar terlebih dahulu");
                    }   
                        break;
                case"4":
                    System.out.println("Daftar Film JafaFlix: \n");
                    displayFilm();
                break;
                case"5": 
                    if(menuLogout()) return;
                break;
                case"6":
                    pelanggan[idx].profil(); 
                    String cmd = input.nextLine(); 
                    switch(cmd){
                        case"1":
                            isidatadiri(idx);
                        break; 
                        default:
                            System.out.println("Gagal mengganti data akun\n"); 
                    }
                break; 
                case "7":
                if(pelanggan[idx].dapatHistori().size()==0){
                    System.out.println("Tidak ada Histori\n");
                }else{   
                        pelanggan[idx].displayHistory();
                        System.out.println("\nApakah ingin menghapus History?");
                        pelanggan[idx].yaTidak();
                        String cmd2 = input.nextLine(); 
                        switch(cmd2){
                            case"1":
                            pelanggan[idx].clearHistory(); 
                            System.out.println("\nBerhasil menghapus History!");
                            break; 
                            default: 
                            System.out.println("Gagal Menghapus!");
                        }
                    }
                break;
                case "8":
                    pelanggan[idx].tambahFilm();
                break; 
                default:
                System.out.println("Input Salah!");
            }
        }
            
    }

    public void isidatadiri(int idx){
        String nama =""; 
        String noTelp=""; 
        String umur = ""; 
        System.out.println("Mengganti data akun!");
        System.out.println("Nama");
        nama = input.nextLine(); 
        System.out.println("No.Telepon:");
        noTelp = input.nextLine(); 
        System.out.println("Umur: "); 
        umur = input.nextLine(); 
        
        try{
            ArrayDeque<Film> his = pelanggan[idx].dapatHistori(); 
            String pass = pelanggan[idx].getPassword(); 
            pelanggan[idx] = new pelangganBiasa(pelanggan[idx].getKodePelanggan(), nama, noTelp, pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), umur); 
            pelanggan[idx].setHistori(his);
            pelanggan[idx].setPassword(pass);
        }catch(UmurNegatifException ex){
            System.out.println(ex.getMessage());
        }

    }

    public boolean menuLogout(){
        while(true){
            System.out.println("Anda Yakin Ingin Logout?");
            System.out.println("1.YA");
            System.out.println("2.TIDAK");
            String id = input.nextLine(); 
            switch(id){
                case"1":
                return true;
                case"2":
                return false; 
                default:
                System.out.println("Input Salah!");
            }
        }
    }

    void daftarPlatinum(int idx){
        pelanggan[idx].platinum();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Mendaftar ke kategori Platinum");
                pelanggan[idx].setKategori("Platinum"); 
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "PLT")); 
                }else if(kat.contains("REG")){
                    pelanggan[idx].setKodePelanggan(kat.replace("REG", "PLT"));
                }else if(kat.contains("GOLD")){
                    pelanggan[idx].setKodePelanggan(kat.replace("GOLD", "PLT"));
                }
                pelanggan[idx] = new pelangganPlatinum(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Mendaftar kategori"); 
        }
    }

    void daftarRegular(int idx){
        pelanggan[idx].regular();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Mendaftar ke kategori Regular");
                pelanggan[idx].setKategori("Regular"); 
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "REG")); 
                }else if(kat.contains("PLT")){
                    pelanggan[idx].setKodePelanggan(kat.replace("PLT", "REG"));
                }else if(kat.contains("GOLD")){
                    pelanggan[idx].setKodePelanggan(kat.replace("GOLD", "REG"));
                }  
                pelanggan[idx] = new pelangganRegular(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Mendaftar kategori"); 
        }
    }

    void daftarGold(int idx){
        pelanggan[idx].gold();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Mendaftar ke kategori Gold");
                pelanggan[idx].setKategori("Gold"); 
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "GOLD")); 
                }else if(kat.contains("REG")){
                    pelanggan[idx].setKodePelanggan(kat.replace("REG", "GOLD"));
                }else if(kat.contains("PLT")){
                    pelanggan[idx].setKodePelanggan(kat.replace("PLT", "GOLD"));
                } 
                pelanggan[idx] = new pelangganGold(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Mendaftar kategori"); 
        }
    }

    void upgradePlatinum(int idx){
        pelanggan[idx].platinum();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Mendaftar ke kategori Platinum");
                pelanggan[idx].setKategori("Platinum"); 
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "PLT")); 
                }else if(kat.contains("REG")){
                    pelanggan[idx].setKodePelanggan(kat.replace("REG", "PLT"));
                }else if(kat.contains("GOLD")){
                    pelanggan[idx].setKodePelanggan(kat.replace("GOLD", "PLT"));
                }
                pelanggan[idx] = new pelangganPlatinum(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Mendaftar kategori"); 
        }     
    }

    void upgradeRegular(int idx){
        pelanggan[idx].regular();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Mendaftar ke kategori Regular");
                pelanggan[idx].setKategori("Regular"); 
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "REG")); 
                }else if(kat.contains("PLT")){
                    pelanggan[idx].setKodePelanggan(kat.replace("PLT", "REG"));
                }else if(kat.contains("GOLD")){
                    pelanggan[idx].setKodePelanggan(kat.replace("GOLD", "REG"));
                }
                pelanggan[idx] = new pelangganRegular(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Mendaftar kategori"); 
        }  
    }

    void upgradeGold(int idx){
        pelanggan[idx].gold();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Mendaftar ke kategori Gold");
                pelanggan[idx].setKategori("Gold"); 
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "GOLD")); 
                }else if(kat.contains("REG")){
                    pelanggan[idx].setKodePelanggan(kat.replace("REG", "GOLD"));
                }else if(kat.contains("PLT")){
                    pelanggan[idx].setKodePelanggan(kat.replace("PLT", "GOLD"));
                } 
                pelanggan[idx] = new pelangganGold(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Mendaftar kategori"); 
        }
    }

    void unsubs(int idx){
        pelanggan[idx].uns();
        String angka3 = input.nextLine(); 
        switch(angka3){
            case"1":
                System.out.println("Berhasil Unsubscribe");
                pelanggan[idx].setKategori("User Biasa");
                String kat = pelanggan[idx].getKodePelanggan(); 
                if(kat.contains("User")){
                    pelanggan[idx].setKodePelanggan(kat.replace("User", "User")); 
                }else if(kat.contains("REG")){
                    pelanggan[idx].setKodePelanggan(kat.replace("REG", "User"));
                }else if(kat.contains("GOLD")){
                    pelanggan[idx].setKodePelanggan(kat.replace("GOLD", "User"));
                }else{
                    pelanggan[idx].setKodePelanggan(kat.replace("PLT", "User"));
                }
                pelanggan[idx] = new pelangganBiasa(pelanggan[idx].getKodePelanggan(), pelanggan[idx].getNama(), pelanggan[idx].getNoTelp(), pelanggan[idx].getKategori(), pelanggan[idx].getStatus(), pelanggan[idx].getPassword(), pelanggan[idx].dapatHistori(), pelanggan[idx].getUmur()); 
            break;
            default: 
                System.out.println("Gagal Melakukan Unsubscribe"); 
        }

    }

    void displayFilmKategori(String kategoris, int idx){
        if(kategoris.equals("User Biasa")){
            this.displayFilm();
        } else if(kategoris.equals("Regular")){
            System.out.println("\nKamu User Regular, kamu dapat mengakses film Reguler: \n");
            System.out.println("\033[38;5;94m===============================================================================================\033[0m");
            System.out.printf("%-4s%-40s|%-25s|%-8s|%-10s|%-5s|\n", "","Judul", "Genre", "Tahun", "Kategori", "Umur");
            int id = 0; 
            for(Film x: DaftarFilm){
                if(x.kategori.equals("Regular")){
                    try{
                        x = new filmReguler(x.judul, x.genre, x.tahun, x.kategori, x.batasUmur);
                    }catch(TahunTooOldException ex){
                        System.out.println(ex.getMessage());
                    }
                    x.displayFilm(id);
                }else{
                    x.displayFilm(id);
                }
                id++; 
            }
            System.out.println("\033[38;5;94m===============================================================================================\033[0m");
            System.out.println(); 
            pilihFilm(idx); 
        } else if(kategoris.equals("Gold")){
            System.out.println("\nKamu User Gold, Kamu dapat mengakses film reguler dan new:\n"); 
            System.out.println("\033[38;5;220m===============================================================================================\033[0m");
            System.out.printf("%-4s%-40s|%-25s|%-8s|%-10s|%-5s|\n", "","Judul", "Genre", "Tahun", "Kategori", "Umur");
            int id = 0; 
            for(Film x: DaftarFilm){
                if(x.kategori.equals("Regular")){
                    try{
                        x = new filmReguler(x.judul, x.genre, x.tahun, x.kategori, x.batasUmur);
                    }catch(TahunTooOldException ex){
                        System.out.println(ex.getMessage());
                    }

                    x.displayFilm(id);
                }else if(x.kategori.equals("New")){
                    try{
                        x = new filmNew(x.judul, x.genre, x.tahun, x.kategori, x.batasUmur);
                    }catch(TahunTooOldException ex){
                        System.out.println(ex.getMessage());
                    }
                    x.displayFilm(id);
                }else{
                    x.displayFilm(id);
                }
                id++; 
            }
            System.out.println("\033[38;5;220m===============================================================================================\033[0m");
            System.out.println();
            pilihFilm(idx); 
        } else if(kategoris.equals("Platinum")){
            System.out.println("\nKamu User Platinum, kamu dapat mengakses semua Film: ");
            System.out.println("\033[35m===============================================================================================\033[0m");
            System.out.printf("%-4s%-40s|%-25s|%-8s|%-10s|%-5s|\n", "","Judul", "Genre", "Tahun", "Kategori", "Umur");
            int id = 0; 
            for(Film x: DaftarFilm){
                if(x.kategori.equals("Regular")){
                    try{
                        x = new filmReguler(x.judul, x.genre, x.tahun, x.kategori, x.batasUmur);
                    }catch(TahunTooOldException ex){
                        System.out.println(ex.getMessage());
                    }
                    x.displayFilm(id);
                }else if(x.kategori.equals("New")){
                    try{
                        x = new filmNew(x.judul, x.genre, x.tahun, x.kategori, x.batasUmur);
                    }catch(TahunTooOldException ex){
                        System.out.println(ex.getMessage());
                    }
                    x.displayFilm(id);
                }else{
                    try{
                        x = new filmOri(x.judul, x.genre, x.tahun, x.kategori, x.batasUmur);
                    }catch(TahunTooOldException ex){
                        System.out.println(ex.getMessage());
                    }
                    x.displayFilm(id);
                }
                id++; 
            }
            System.out.println("\033[35m===============================================================================================\033[0m");
            System.out.println();
            pilihFilm(idx); 
        }
    }

    void displayFilm(){
        System.out.println("\nKamu User biasa, tidak dapat menonton film. Ini list daftar film yang ada: \n");
        System.out.println("================================================================================================");
        System.out.printf("%-4s%-40s|%-25s|%-8s|%-10s|%-5s|\n","", "Judul", "Genre", "Tahun", "Kategori", "Umur");
        int id = 0; 
            for(Film x: DaftarFilm){
                x.displayFilm(id);
                id++; 
            }
        System.out.println("================================================================================================");
        System.out.println(); 
    }

    void pilihFilm(int idx){
        int id = 1;
        System.out.println("Pilih Film yang ingin ditonton: \n"); 
        //String anggota = pelanggan[idx].getKategori(); 
        String cmd = input.nextLine(); 
        boolean ada = false ; 
        try{
            Integer.parseInt(cmd); 
        }catch(Exception e){
            System.out.println("Input salah!");
            return; 
        }
        if(pelanggan[idx] instanceof pelangganRegular){
            for(Film x: DaftarFilm){
                if(Integer.parseInt(cmd) == id&&!x.kategori.equals("New")&&!x.kategori.equals("Ori")){
                    if(pelanggan[idx].getUmur().equals("")){
                        System.out.println("\nIsi data diri lengkat terlebih dahulu pada menu 6!\n");
                        return; 
                    }

                    int umr = Integer.parseInt(pelanggan[idx].getUmur()); 
                    int batasan = Integer.parseInt(x.batasUmur); 
                    if(umr<batasan){
                        System.out.println("Kamu belum cukup umur!\n");
                        return; 
                    }
                    
                    x.displayFULL(); 
                    ada = true; 
                    pelanggan[idx].addHistory(x);
                }
                id++; 
            }
        }else if(pelanggan[idx] instanceof pelangganGold){
            for(Film x: DaftarFilm){
                if(Integer.parseInt(cmd) == id&&!x.kategori.equals("Ori")){
                    if(pelanggan[idx].getUmur().equals("")){
                        System.out.println("\nIsi data diri lengkat terlebih dahulu pada menu 6!\n");
                        return; 
                    }

                    int umr = Integer.parseInt(pelanggan[idx].getUmur()); 
                    int batasan = Integer.parseInt(x.batasUmur); 
                    if(umr<batasan){
                        System.out.println("Kamu belum cukup umur!\n");
                        return; 
                    }

                    x.displayFULL();
                    ada = true; 
                    pelanggan[idx].addHistory(x);
                }
                id++; 
            }
        }else{
            for(Film x: DaftarFilm){
                if(Integer.parseInt(cmd) == id){
                    if(pelanggan[idx].getUmur().equals("")){
                        System.out.println("\nIsi data diri lengkap terlebih dahulu pada menu 6!\n");
                        return; 
                    }
                    int umr = Integer.parseInt(pelanggan[idx].getUmur()); 
                    int batasan = Integer.parseInt(x.batasUmur); 
                    if(umr<batasan){
                        System.out.println("Kamu belum cukup umur!\n");
                        return; 
                    }

                    x.displayFULL(); 
                    ada = true; 
                    pelanggan[idx].addHistory(x);
                }
                id++; 
            }
        }
        if(!ada){
            System.out.println("Anda tidak dapat menonton Film ini\n");
        }else{
            System.out.println("Sedang menonton film....\n\n");
            System.out.println("Film Selesai!\n");
        }
        
    }



}
