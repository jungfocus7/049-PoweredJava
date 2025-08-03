using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;




namespace ExpansiveListViewExample
{
    public sealed class BaseInfo : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        public Action<string> PropertyChangedCallback;
        public void OnPropertyChanged([CallerMemberName]string pnm = null)
        {
            if (string.IsNullOrWhiteSpace(pnm)) return;
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(pnm));
            PropertyChangedCallback?.Invoke(pnm);
        }        

        private bool _checked;
        public bool Checked
        {
            get { return _checked; }
            set
            {
                if (value == true)
                {

                }
                if (_checked == value) return;
                _checked = value;
                OnPropertyChanged();
            }
        }

        public string Num { get; set; }
        public string Name { get; set; }
        public string Age { get; set; }
        public string Job { get; set; }
        public string Address { get; set; }
    }


    public sealed class BaseInfoCollection : ObservableCollection<BaseInfo> { }

}
