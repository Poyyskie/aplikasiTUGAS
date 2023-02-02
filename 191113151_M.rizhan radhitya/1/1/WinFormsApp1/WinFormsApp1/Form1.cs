namespace WinFormsApp1
{
    public partial class Form1 : Form
    {

        string produk;


        public Form1()
        {
            InitializeComponent();
        }

        private void groupBox2_Enter(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
          
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
          
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            
            listBox1.Items.Add(textBox1.Text);
            listBox1.Items.Add(radioButton2.Text);
            if (textBox1.Created) ;
            {
                comboBox1.Items.Add(textBox1.Text);



            }
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
          
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {
            produk = "Luarnegri";
            listBox1.Text = produk;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked == true)
            {

                Buku s = new Buku(textBox1.Text, textBox2.Text,radioButton2.Text,numericUpDown1.Value);
                MessageBox.Show(s.bookcode);
            }
            else
            {
                Komik a = new Komik(textBox1.Text, textBox2.Text, produk);
                MessageBox.Show(a.rens);
            }
            {
            }

        }
    }
    }
