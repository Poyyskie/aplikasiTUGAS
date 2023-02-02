using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    public class Komik
    {


        public Komik(string kodebuku, string judul, string dalamnegri)

        {
            Kodebuku = kodebuku;
            Judul = judul;
            Dalamnegri = dalamnegri;

        }


        public string Kodebuku { get; set; }
        public string Judul { get; set; }
        public string Dalamnegri { get; set; }



        public string rens => "kode : " + Kodebuku + "\nJudulBuku : " + Judul + "\nProduk : " + Dalamnegri;
    }
}