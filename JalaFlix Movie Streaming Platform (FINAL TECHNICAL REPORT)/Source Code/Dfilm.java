package komponen;
public class Dfilm {
    String[] judul = new String[15]; 
    Film.genreFilm[] genre = new Film.genreFilm[15];
    String[] tahun = new String[15];
    String[] kategori = new String[15]; 
    String[] sinopsis = new String[15]; 
    String[] batas = new String[15]; 
    Dfilm(){
        this.initialize(); 
    }
    void initialize(){
        judul[0] = "Spirited Away";
        judul[1] = "My Neigbor Totoro";
        judul[2] = "Princess Mononoke";
        judul[3] = "Avengers: End Game";
        judul[4] = "Spider-Man: No Way Home"; 
        judul[5] = "Parasite";
        judul[6] = "Black Panther: Wakanda Forever";
        judul[7] = "Attack on Titan";
        judul[8] = "Boku no Hero";
        judul[9] = "Wednesday";
        judul[10] = "Papa Frangku";
        judul[11] = "Mobu";
        judul[12] = "Manusia Ikan";
        judul[13] = "Zanite";
        judul[14] = "Avatar: The Way of Water";

        genre[0] = Film.genreFilm.FANTASY; 
        genre[1] = Film.genreFilm.FANTASY;
        genre[2] = Film.genreFilm.FANTASY; 
        genre[3] = Film.genreFilm.SCIFI; 
        genre[4] = Film.genreFilm.SCIFI;
        genre[5] = Film.genreFilm.THRILLER;
        genre[6] = Film.genreFilm.SCIFI;
        genre[7] = Film.genreFilm.FANTASY; 
        genre[8] = Film.genreFilm.ACTION; 
        genre[9] = Film.genreFilm.MYSTERY; 
        genre[10] = Film.genreFilm.COMEDY;
        genre[11] = Film.genreFilm.FANTASY; 
        genre[12] = Film.genreFilm.FANTASY; 
        genre[13] = Film.genreFilm.ADVENTURE; 
        genre[14] = Film.genreFilm.ADVENTURE; 
        
        tahun[0] = "2001";
        tahun[1] = "1988";
        tahun[2] = "1997";
        tahun[3] = "2019";
        tahun[4] = "2021"; 
        tahun[5] = "2019";
        tahun[6] = "2022";
        tahun[7] = "2013";
        tahun[8] = "2016";
        tahun[9] = "2022";
        tahun[10] = "2003";
        tahun[11] = "2005";
        tahun[12] = "2018";
        tahun[13] = "2022";
        tahun[14] = "2022";

        sinopsis[0] = "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.";
        sinopsis[1] = "When two girls move to the country to be near their ailing mother, they have adventures with the wondrous forest spirits who live nearby.";
        sinopsis[2] = "On a journey to find the cure for a Tatarigami's curse, Ashitaka finds himself in the middle of a war between the forest gods and Tatara, a mining colony. In this quest he also meets San, the Mononoke Hime.";
        sinopsis[3] = "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.";
        sinopsis[4] = "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man."; 
        sinopsis[5] = "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.";
        sinopsis[6] = "The people of Wakanda fight to protect their home from intervening world powers as they mourn the death of King T'Challa.";
        sinopsis[7] = "After his hometown is destroyed and his mother is killed, young Eren Jaeger vows to cleanse the earth of the giant humanoid Titans that have brought humanity to the brink of extinction.";
        sinopsis[8] = "Deku si pahlawan desa konoha";
        sinopsis[9] = "Follows Wednesday Addams' years as a student, when she attempts to master her emerging psychic ability, thwart a killing spree, and solve the mystery that embroiled her parents.";
        sinopsis[10] = "Papa frangku adalah orang jepang yang memberikan edukasi dari sudut pandang yang berbeda. Ternyata komedi hanyalah sebuah tragedi dari sudut pandang berbeda";
        sinopsis[11] = "Mobu adalah seorang anak wibu di filkom yang tidak punya teman. Akankah dia punya teman sebelum lulus?"; 
        sinopsis[12] = "Legenda manusia ikan di sungai di bawah jembatan Suhat. Konon katanya iya hidup di sekitar mahasiswa UB dan hendak mencari mangsa";
        sinopsis[13] = "Zanite adalah anak lugu yang sekarang menjadi Seorang mahasiswa. FILKOM sebagai tempat untuk berproses akan memberikan petualangan tak terduga dan pengalaman yang sarat makna";
        sinopsis[14] = "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home.";

        kategori[0] = "Regular";
        kategori[1] = "Regular";
        kategori[2] = "Regular";
        kategori[3] = "New";
        kategori[4] = "New"; 
        kategori[5] = "New";
        kategori[6] = "New";
        kategori[7] = "Regular";
        kategori[8] = "Regular";
        kategori[9] = "Ori";
        kategori[10] = "Regular";
        kategori[11] = "Ori";
        kategori[12] = "Ori";
        kategori[13] = "Ori";
        kategori[14] = "New";

        batas[0] = "13";
        batas[1] = "13";
        batas[2] = "13";
        batas[3] = "17";
        batas[4] = "17"; 
        batas[5] = "18";
        batas[6] = "17";
        batas[7] = "15";
        batas[8] = "13";
        batas[9] = "18";
        batas[10] = "18";
        batas[11] = "15";
        batas[12] = "18";
        batas[13] = "17";
        batas[14] = "18";
    }

}
