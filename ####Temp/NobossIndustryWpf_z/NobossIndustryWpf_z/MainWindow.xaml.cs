using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;


namespace NobossIndustryWpf_z
{
    public sealed partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            Loaded += prLoaded;
        }

        protected override void OnContentRendered(EventArgs ea)
        {
            base.OnContentRendered(ea);

            SizeToContent = SizeToContent.Manual;
            m_grdrt.Width = double.NaN;
            m_grdrt.Height = double.NaN;
        }

        private void prLoaded(object sd, RoutedEventArgs ea)
        {
            m_dtr = new DataTable("RESULT");
            m_dtr.Columns.Add("COLNM01", typeof(string));
            m_dtr.Columns.Add("COLNM02", typeof(string));
            m_dtr.Columns.Add("COLNM03", typeof(string));
            m_dtr.Columns.Add("COLNM04", typeof(string));
            m_dtr.Columns.Add("COLNM05", typeof(string));
            m_dtr.Columns.Add("COLNM06", typeof(string));
            m_dtr.Columns.Add("COLNM07", typeof(string));
            m_dtr.Columns.Add("COLNM08", typeof(string));
            m_dtr.Columns.Add("COLNM09", typeof(string));
            m_dtr.Columns.Add("COLNM10", typeof(string));
            m_dtr.Columns.Add("COLNM11", typeof(string));
            m_dtr.Columns.Add("COLNM12", typeof(string));
            m_dtr.Columns.Add("COLNM13", typeof(string));
            m_dtr.Columns.Add("COLNM14", typeof(string));
            m_dtr.Columns.Add("COLNM15", typeof(string));
            m_dtr.Columns.Add("COLNM16", typeof(string));
            m_dtr.Columns.Add("COLNM17", typeof(string));
            m_dtr.Columns.Add("COLNM18", typeof(string));
            m_dtr.Columns.Add("COLNM19", typeof(string));
            m_dtr.Columns.Add("COLNM20", typeof(string));
            m_dtr.Columns.Add("COLNM21", typeof(string));
            m_dtr.Columns.Add("COLNM22", typeof(string));
            m_dtr.Columns.Add("COLNM23", typeof(string));
            m_dtr.Columns.Add("COLNM24", typeof(string));
            m_dtr.Columns.Add("COLNM25", typeof(string));
            m_dtr.Columns.Add("COLNM26", typeof(string));
            m_dtr.Columns.Add("COLNM27", typeof(string));
            m_dtr.Columns.Add("COLNM28", typeof(string));
            m_dtr.Columns.Add("COLNM29", typeof(string));
            m_dtr.Columns.Add("COLNM30", typeof(string));

            for (int i = 0; i < 5000000; i++)
            {
                m_dtr.Rows.Add(new string[] {
                    (i + 1).ToString().PadLeft(7, '0'), "VAL02", "VAL03", "VAL04", "VAL05", "VAL06", "VAL07", "VAL08", "VAL09", "VAL10",
                    "VAL11", "VAL12", "VAL13", "VAL14", "VAL15", "VAL16", "VAL17", "VAL18", "VAL19", "VAL20",
                    "VAL21", "VAL22", "VAL23", "VAL24", "VAL25", "VAL26", "VAL27", "VAL28", "VAL29", "VAL30",
                });
            }

            m_dtgrd.ItemsSource = m_dtr.DefaultView;
        }

        private DataTable m_dtr;

        private void prPutDatas()
        {
            m_dtgrd.ItemsSource = null;

            int j = m_dtr.Rows.Count;
            for (int i = 0; i < 500000; i++)
            {
                int k = j + (i + 1);
                m_dtr.Rows.Add(new string[] {
                    k.ToString().PadLeft(7, '0'), "VAL02", "VAL03", "VAL04", "VAL05",
                    "VAL06", "VAL07", "VAL08", "VAL09", "VAL10",
                    "VAL11", "VAL12", "VAL13", "VAL14", "VAL15",
                    "VAL16", "VAL17", "VAL18", "VAL19", "VAL20",
                });
            }

            m_dtgrd.ItemsSource = m_dtr.DefaultView;
        }        

        protected override void OnKeyDown(KeyEventArgs ea)
        {
            if (ea.Key == Key.Escape)
            {
                ea.Handled = true;

                m_dtr.Clear();

                GC.WaitForPendingFinalizers();
                GC.Collect();
            }
            else if(ea.Key == Key.Right)
            {
                ea.Handled = true;

                prPutDatas();
            }

            base.OnKeyDown(ea);
        }
    }
}
