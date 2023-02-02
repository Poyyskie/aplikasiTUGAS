using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    public class Buku
    {

        public Buku(string kodebuku, string judul, string barang, decimal edisi)
        {
            Kodebuku = kodebuku;
            Judul = judul;
            Barang = barang;
            Edisi = edisi;
        }

        public string Kodebuku { get; set; }
        public string Judul { get; set; }
        public string Barang { get; set; }
        public decimal Edisi { get; set; }


        public string bookcode => "nama : " + Kodebuku + "\nJudulBuku : " + Judul + "\nBarang : "+ Barang + "\nBarang : "+ Edisi;

    }

}
