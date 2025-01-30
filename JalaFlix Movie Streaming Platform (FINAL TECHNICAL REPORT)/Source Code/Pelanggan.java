package komponen;


import java.util.*; 

interface customer{
     void platinum(); 
     void gold(); 
     void uns(); 
     void regular(); 
}

public abstract class Pelanggan implements customer{
   private String kodePelanggan=""; 
   private String nama; 
   private String umur; 
   private String noTelp; 
   private String kategori = "";
   private String status_keanggotaan= ""; 
   private String Password=""; 
   private ArrayDeque<Film> histori = new ArrayDeque<Film>(); 

   Pelanggan(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String umur) throws UmurNegatifException{
     this.kodePelanggan = kodePelanggan; 
     this.nama = nama; 
     this.noTelp = noTelp; 
     this.kategori = kategori; 
     this.status_keanggotaan = status_keanggotaan;  
     if(umur.length()==0){
          this.umur = umur; 
     }else if(Character.compare(umur.charAt(0), '-')==0){
          throw new UmurNegatifException("\n\u001B[31mUmur harus positif! Gagal memperbarui umur!\u001B[0m\n"); 
     }else{
          try{
               Integer.parseInt(umur); 
               this.umur = umur; 
               System.out.println("Berhasil memperbaharui data!\n");
          }catch(Exception e){
               System.out.println("\n\u001B[31mMasukkan umur yang benar! gagal memperbarui umur!\u001B[0m\n");
          }

     }
   }

   Pelanggan(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String Password, ArrayDeque<Film> histori, String umur){
     this.kodePelanggan = kodePelanggan; 
     this.nama = nama; 
     this.noTelp = noTelp; 
     this.kategori = kategori; 
     this.status_keanggotaan = status_keanggotaan; 
     this.Password = Password;
     this.histori = histori; 
     this.umur = umur; 
   }

   Pelanggan(){

   }

   public void displayDataPelanggan(){
        System.out.println("\nData Akun:");
        System.out.printf("%-20s: %s\n", "Nama", nama);
        System.out.printf("%-20s: %s\n", "Kode Pelanggan", kodePelanggan);
        System.out.printf("%-20s: %s\n", "Umur", umur);
        System.out.printf("%-20s: %s\n", "No. Telepon", noTelp); 
        System.out.printf("%-20s: %s\n", "Kategori", kategori); 
        System.out.printf("%-20s: %s\n", "Status Keanggotaan", status_keanggotaan); 
   }

   String getKodePelanggan(){
        return this.kodePelanggan; 
   }

   String getNama(){
        return this.nama; 
   }

   String getNoTelp(){
        return this.noTelp; 
   }

   String getKategori(){
        return kategori; 
   }

   Film getHistori(int i){
     int id = 1; 
     Film a = new Film(); 
        for(Film x: histori){
          if(id == i){
               try{
                    a = new Film(x.judul, x.genre, x.tahun, x.kategori, x.sinopsis, x.batasUmur);  
               }catch(TahunTooOldException ex){
                    System.out.println(ex.getMessage());
               }
          }
        }
     return a; 
   }
   
   String getPassword(){
        return Password; 
   }

   String getStatus(){
      return status_keanggotaan; 
   }
   String getUmur(){
     return umur; 
   }

   void setNama(String nama){
        this.nama = nama; 
   }
   
   void setNoTelp(String noTelp){
        this.noTelp = noTelp; 
   }

   void setPassword(String password){
       this.Password = password; 
   }

   void setKategori(String kategori){
        this.kategori = kategori; 
   }

   void setStatus(String s){
     status_keanggotaan = s; 
   }

   void setKodePelanggan(String s){
     kodePelanggan = s; 
   }

   void setHistori(ArrayDeque<Film> histori){
     this.histori = histori; 
   }

   void setUmur(String umur){
     this.umur = umur; 
   }


   void addHistory(Film f){
        if(histori.size()<10){
            histori.addFirst(f);
        }else{
            histori.addFirst(f);
            histori.removeLast(); 
        }
   }

   void clearHistory(){
        histori.clear(); 
   }

   void isHapusHistory(){
     this.displayHistory();              
     System.out.println("\nIngin Menghapus Histori?");
     yaTidak();
   }

   void displayHistory(){
        int id = 1; 
        System.out.println("\nHistory tontonan: ");
        System.out.printf("%-4s%-40s|%-25s|%-8s|%-10s|\n", "","Judul", "Genre", "Tahun", "Kategori");
        for(Film x: histori){
            System.out.printf("%d. |%-40s|%-25s|%-8s|%-10s|\n", id, x.judul, x.genre, x.tahun, x.kategori);
            id++; 
        }
   }

   ArrayDeque<Film> dapatHistori(){
     return histori; 
   }

   int sizeHistori(){
     return histori.size(); 
   }

   void yaTidak(){
     System.out.println("1. YA");
     System.out.println("2. TIDAK");
   }

   void profil(){
     System.out.println("Informasi Akun Anda: ");
     this.displayDataPelanggan();  
     System.out.println("\nIngin mengganti/melengkapi Informasi Akun?"); 
     this.yaTidak();
   }

   public abstract void platinum(); 
   public abstract void gold(); 
   public abstract void regular(); 
   public abstract void uns();  

   public void tambahFilm(){
     Scanner input = new Scanner(System.in); 
     if(this.kategori.equals("User Biasa")){
          System.out.println("Anda harus daftar kategori terlebih dahulu!");
     }else{
          System.out.println("\nMasukkan data Film!"); 
          String judul,genre, tahun, kategori, umur, sinopsis; 
          Film.genreFilm gen = null;      
          System.out.print("Judul: ");
          judul = input.nextLine(); 
          while(gen == null){
               try{
                    System.out.print("Genre (SCIFI, ACTION, FANTASY, COMEDY): ");
                    genre = input.nextLine(); 
                    gen = Film.genreFilm.valueOf(genre); 
               }catch(Exception e){
                    System.out.println("Genre Salah, Masukkan Ulang! ");
               }
          }
          System.out.print("Tahun: ");
          tahun = input.nextLine(); 
          System.out.print("Kategori: ");
          kategori = input.nextLine(); 
          System.out.print("Batas Umur: ");
          umur = input.nextLine(); 
          System.out.print("Sinopsis: "); 
          sinopsis = input.nextLine(); 
          Film a = new Film();
          

          try{
               a = new Film(judul, gen, tahun, kategori, sinopsis, umur); 
               menus.DaftarFilm.addLast(a); 
          }catch(TahunTooOldException ex){
               System.out.println(ex.getMessage());
          }

          
     }

   }


}

class pelangganRegular extends Pelanggan{
     int jmlFilmTambah = 0; 
     pelangganRegular(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String Password, ArrayDeque<Film> histori, String umur){
          super(kodePelanggan, nama, noTelp, kategori, status_keanggotaan, Password, histori, umur);
     }

     public void platinum(){
          System.out.println("Ingin Upgrade ke Platinum? - Harga Rp.75000");
          yaTidak();
     }
  
     public void gold(){
          System.out.println("Ingin Upgrade ke Gold? - Harga Rp.35000");
          yaTidak();
     }
  
     public void regular(){
          System.out.println("Anda tidak akan upgrade - Harga Rp.0");
          yaTidak();
     }

     public void uns(){
          System.out.println("Yakin ingin unsubscribe?");
          yaTidak();
     }

     public void tambahFilm(){
          if(jmlFilmTambah<5){
               super.tambahFilm(); 
               jmlFilmTambah++; 
          }else{
               System.out.println("\n Tidak bisa menambah Film Lagi! \n");
          }
     }
}

class pelangganGold extends Pelanggan{
     int jmlFilmTambah = 0; 
     pelangganGold(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String Password, ArrayDeque<Film> histori, String umur){
          super(kodePelanggan, nama, noTelp, kategori, status_keanggotaan, Password, histori, umur);
     }

     public void platinum(){
          System.out.println("Ingin Upgrade ke Platinum? - Harga Rp.50000");
          yaTidak();
     }
  
     public void gold(){
          System.out.println("Anda tidak akan upgrade - Harga Rp.0");
          yaTidak();
     }
  
     public void regular(){
          System.out.println("Ingin downgrade ke Regular? - Harga Rp.0");
          yaTidak();
     }

     public void uns(){
          System.out.println("Yakin ingin unsubscribe?");
          yaTidak();
     }

     public void tambahFilm(){
          if(jmlFilmTambah<10){
               super.tambahFilm(); 
               jmlFilmTambah++; 
          }else{
               System.out.println("\n Tidak bisa menambah Film Lagi! \n");
          }
     }

}

class pelangganPlatinum extends Pelanggan{
     int jmlFilmTambah = 0; 
     pelangganPlatinum(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String Password, ArrayDeque<Film> histori, String umur){
          super(kodePelanggan, nama, noTelp, kategori, status_keanggotaan, Password, histori, umur);
     }

     public void platinum(){
          System.out.println("Anda tidak akan upgrade - Harga Rp.0");
          yaTidak();
     }
  
     public void gold(){
          System.out.println("Ingin downgrade ke Gold? - Harga Rp.0");
          yaTidak();
     }
  
     public void regular(){
          System.out.println("Ingin downgrade ke Regular? - Harga Rp.0");
          yaTidak();
     }
     
     public void uns(){
          System.out.println("Yakin ingin unsubscribe?");
          yaTidak();
     }

     public void tambahFilm(){
          super.tambahFilm(); 
          jmlFilmTambah++; 
     }
}

class pelangganBiasa extends Pelanggan{
     pelangganBiasa(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String Password, ArrayDeque<Film> histori, String umur){
          super(kodePelanggan, nama, noTelp, kategori, status_keanggotaan, Password, histori, umur);
     }
     pelangganBiasa(String kodePelanggan, String nama, String noTelp, String kategori, String status_keanggotaan, String umur)throws UmurNegatifException{
          super(kodePelanggan, nama, noTelp, kategori, status_keanggotaan, umur); 
     }
     public void platinum(){
          System.out.println("Ingin membeli Platinum - Harga Rp.100000");
          yaTidak();
     }
     public void gold(){
          System.out.println("Ingin membeli Gold - Harga Rp.50000");
          yaTidak();
     }

     public void regular(){
          System.out.println("Ingin membeli Regular - Harga Rp.15000");
          yaTidak();
     }

     public void uns(){
          System.out.println("Anda Pelanggan biasa - Unsubscribe berarti tidak ada perubahan");
     }


}
